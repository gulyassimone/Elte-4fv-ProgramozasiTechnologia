package entity;

public class Barber implements Runnable{

    private final BarberShop barberShop;
    private boolean working;

    public Barber(BarberShop barberShop) {
        this.barberShop = barberShop;
    }

    @Override
    public void run() {
        System.out.println("Elkezdtem dolgozni" + System.currentTimeMillis());
        working=true;

        while (barberShop.isOpen() ) {
            barberShop.cutHair();
        }
        System.out.println("Levágtam a hajakat" + working);
        synchronized (barberShop.getCustomers()){
            while ( barberShop.getCustomers().size() !=0){
                barberShop.cutHair();
            }
        }
        System.out.println("Befejeztem mára" + System.currentTimeMillis());
    }
    public void stop(){
        System.out.println("Vége a munkaidőnek" + System.currentTimeMillis());
        working = false;
    }

    public boolean isWorking() {
        return working;
    }
}
