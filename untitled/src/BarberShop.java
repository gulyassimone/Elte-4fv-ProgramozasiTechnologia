import java.util.concurrent.ThreadLocalRandom;
//import java.util.stream.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicBoolean;

public class BarberShop {

    private static int getRandom(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    private static void timeFragment(int ms) {
        try {Thread.sleep(ms);}
        catch (InterruptedException ie) {ie.printStackTrace();}
    }

    private static class Barber{
        private Shop shop;
        private Thread barber;
        public Barber(Shop shop){
            this.shop = shop;
            this.barber = new Thread(() -> {working();});
            this.barber.start();
        }

        private void working() {
            synchronized(this){
                try {wait();}
                catch (InterruptedException ie) {ie.printStackTrace();}
            }
            Client client;
            while(!shop.isEnd()){
                client = shop.nextClient();
                while(client != null){
                    int hairCutInterval = getRandom((int)(shop.getHour()/20.0),(int)(shop.getHour()/2.0));
                    timeFragment(hairCutInterval);
                    synchronized(client){
                        client.notify();
                    }
                    shop.addToWaitTime(hairCutInterval);
                    client = shop.nextClient();
                }
                synchronized(this){
                    try {wait();}
                    catch (InterruptedException ie) {ie.printStackTrace();}
                }
            }
        }

    }

    private static class Client {
        private Shop shop;
        private Thread enter;
        private Barber barber;
        public Client(Shop shop,Barber barber){
            this.shop = shop;
            this.barber = barber;
            this.enter = new Thread(() -> {enterBarberShop();});
            this.enter.start();
        }

        private void enterBarberShop() {
            if(shop.isOpen()){
                if(shop.takeAChair(this)){
                    synchronized(barber){
                        barber.notify();
                    }
                    synchronized(this){
                        try {wait();}
                        catch (InterruptedException ie) {ie.printStackTrace();}
                    }
                    //shop.served.incrementAndGet();
                    //System.out.println("De jo az uj frizkom!");
                    System.out.println("De jo az uj frizkom! ("+shop.incrementServed()+")");
                }else{
                    //shop.notServedBecausePlace.incrementAndGet();
                    //System.out.println("Sajnos nincs eleg hely!");
                    System.out.println("Sajnos nincs eleg hely! (" + shop.incrementNServedBP()+")");
                }
            }else{
                //shop.notServedBecauseClosed.incrementAndGet();
                //System.out.println("Zarva van? Nem is tudtam!");
                System.out.println("Zarva van? Nem is tudtam! ("+shop.incrementNServedBC()+")");
            }
        }
    }

    private static class Shop {
        private ArrayList<Client> chairs = new ArrayList<>();
        private ArrayList<AtomicInteger> served = new ArrayList<>();
        private Barber barber;
        private Integer day;
        private Boolean open;
        private Thread shop;
        private Integer hour;
        private AtomicInteger sumOfWaitTime = new AtomicInteger(0);
        private AtomicInteger notServedBecauseClosed = new AtomicInteger(0);
        private AtomicInteger notServedBecausePlace = new AtomicInteger(0);
        //private AtomicInteger served = new AtomicInteger(0);
        //private Boolean end;
        private AtomicBoolean end = new AtomicBoolean(false);

        public Shop(){
            this.day = 0;
            this.open = false;
            this.hour = 400;
            //this.end = false;
            this.barber = new Barber(this);
            this.shop = new Thread(() -> {autoTimeMovement();});
            this.shop.start();
            new Thread(() -> {generateClients();}).start();
        }

        private void generateClients() {
            while(!end.get()) {
                new Client(this,barber);
                timeFragment(getRandom(0,(int)(getHour()/2.0)));
            }
        }

        public synchronized Client nextClient(){
            if(chairs.size()!=0) {
                Client client = chairs.get(0);
                chairs.remove(client);
                return client;
            }
            return null;
        }

        public synchronized Boolean takeAChair(Client client){
            if(chairs.size() < 5){
                chairs.add(client);
                return true;
            }
            return false;
        }

        public int addToWaitTime(int time){
            return sumOfWaitTime.addAndGet(time);
        }

        public int incrementServed(){
            return served.get(served.size()-1).incrementAndGet();
        }

        public int incrementNServedBP(){
            return notServedBecausePlace.incrementAndGet();
        }

        public int incrementNServedBC(){
            return notServedBecauseClosed.incrementAndGet();
        }

        public Integer getHour(){
            return hour;
        }

        private void nextDay(){
            ++day;
        }

        public Integer getDay(){
            return day;
        }

        public Boolean isOpen(){
            return open;
        }

        private void toggleOpen(){
            open = !open;
        }

        public Boolean isEnd(){
            return this.end.get();
        }

        public void autoTimeMovement(){
            while(getDay() != 5){
                synchronized(this.day){
                    nextDay();
                }
                //synchronized(served){
                served.add(new AtomicInteger(0));
                //}
                System.out.println(getDay() + ". nap");
                timeFragment(this.hour * 9);
                synchronized(this.open){
                    toggleOpen();
                }
                System.out.println("9 ora nyitas!");
                timeFragment(this.hour * 8);
                synchronized(this.open){
                    toggleOpen();
                }
                System.out.println("17 ora zaras!");
                timeFragment(this.hour * 7);
                if(getDay()==5) {this.end.set(true); synchronized(barber){ barber.notify();}}
            }
            int sumOfServed = 0;
            int num = 0;
            System.out.println("A vendegek szama naponta:");
            for(AtomicInteger day : served){
                ++num;
                sumOfServed += day.intValue();
                System.out.println(num+". nap "+day.intValue());
            }
            System.out.println(sumOfServed + " vendeg lett kiszolgalva osszesen.");
            System.out.println("Nem lett kiszolgalva mert, zarva volt ("+notServedBecauseClosed.intValue()+") / megtelt az uzlet ("+notServedBecausePlace.intValue()+").");
            System.out.println((sumOfWaitTime.floatValue()/sumOfServed)/getHour()*60 + " perc az atlagos varakozasi ido.");
        }

    }

    public static void main(String[] args) {
        Shop shop = new Shop();
    }
}