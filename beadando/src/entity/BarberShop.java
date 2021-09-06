package entity;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class BarberShop {

    private final int simulationTime;
    private final int waitingPlace;
    private final int hour;
    private final long minHairCutTime;
    private final long maxHairCutTime;
    private final int workTime;
    private final int openTime;
    private final int closeTime;


    private AtomicInteger costumerCount;
    private AtomicInteger missedOpen;
    private AtomicInteger missedClosed;
    private AtomicInteger waitingTime;

    private Barber barber;
    private Generator generator;
    private TimeLine timeLine;

    private LinkedList<Customer> customers;
    private boolean open;
    private Thread generatorTh;

    public BarberShop(int simulationTime) {
        System.out.println("Megnyitottunk!");
        this.hour = 400;
        this.simulationTime = simulationTime;
        this.waitingPlace = 5;


        this.minHairCutTime=this.hour/20;
        this.maxHairCutTime=this.hour/2;
        this.workTime = this.hour * 8;
        this.openTime = this.hour * 9;
        this.closeTime = this.hour *17;

        open = true;


        costumerCount = new AtomicInteger(0);
        missedOpen= new AtomicInteger(0);
        missedClosed= new AtomicInteger(0);
        waitingTime= new AtomicInteger(0);

        customers = new LinkedList<>();

        this.barber = new Barber(this);
        generator = new Generator(this);
        timeLine = new TimeLine(this);
        barber = new Barber(this);

        generatorTh = new Thread(generator,"Generator");
        generatorTh.start();
    }

    public void cutHair(){
        System.out.println("Szabad vagyok, kérem a következőt! "+ System.currentTimeMillis());
        System.out.println("Várakozók: " + customers.size());
        synchronized (customers){
            while (customers.size() == 0 ){
                try {
                    customers.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            Customer pulledCustomer = customers.getFirst();
            customers.remove(0);
            costumerCount.incrementAndGet();
            waitingTime.addAndGet((int) pulledCustomer.getWaitingTime());
            System.out.println("Várakozási idő" + waitingTime);

        }
        try {
            long cuttingDuration = (long) (Math.random()  * (maxHairCutTime-minHairCutTime) + minHairCutTime);
            TimeUnit.MILLISECONDS.sleep(cuttingDuration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("A hajvágás kész. "+ System.currentTimeMillis());
    }

    public void add(Customer costumer) {
        synchronized (customers) {
            if(customers.size() == waitingPlace){
                missedOpen.incrementAndGet();
                System.out.println("Nem tudjuk fogadni "+ System.currentTimeMillis());
            } else if (barber.isWorking()) {
                    customers.offer(new Customer(this));
                }
                if (customers.size() == 1) {
                    System.out.println(customers.size());
                    customers.notify();

            }else {
                missedClosed.incrementAndGet();
                System.out.println("Zárva vagyunk "+ System.currentTimeMillis());
            }
        }

    }

    public int getWorkTime() {
        return workTime;
    }

    public int getSimulationTime() {
        return simulationTime;
    }

    public int getOpenTime() {
        return openTime;
    }


    public Barber getBarber() {
        return barber;
    }

    public TimeLine getTimeLine() {
        return timeLine;
    }

    public LinkedList<Customer> getCustomers() {
        return customers;
    }


    public boolean isOpen() {
        return open;
    }
    public void closed(){
        open = false;
    }
    public void result(){

        System.out.println("-----------------------------------------");
        System.out.println( "EREDMÉNY");
        System.out.println("-----------------------------------------");

        System.out.println("Kiszolgált vendég: " + costumerCount.toString());
        System.out.println("NAzoknak a száma, akik nem lettek kiszolgálva, mert be voltunk zárva: "+missedClosed);
        System.out.println("NAzoknak a száma, akik nem lettek kiszolgálva, mert nem volt több hely: "+missedOpen);
        System.out.println("Naponta mennyi embert szolgált ki: " + (simulationTime > 0 ? (costumerCount.get() / simulationTime) :0));
        System.out.println("Átlagos várakozási idő: " + (costumerCount.get() > 0 ? ( waitingTime.get() / costumerCount.get() ) :0));
    }

    public Thread getGeneratorTh() {
        return generatorTh;
    }
}
