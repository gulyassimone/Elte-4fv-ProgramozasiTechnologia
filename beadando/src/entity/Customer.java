package entity;


public class Customer implements Runnable {

    private BarberShop barberShop;
    private long start;

    public Customer(BarberShop barberShop) {
        this.barberShop = barberShop;

        this.start = System.currentTimeMillis();
    }

    public long getWaitingTime() {
        long end = System.currentTimeMillis();
        return end - start;
    }

    @Override
    public void run() {
        hairCut();
    }

    private synchronized void hairCut() {
        if (barberShop.isOpen()) {
            barberShop.add(this);
        }
    }
}
