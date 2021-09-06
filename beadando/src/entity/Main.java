package entity;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        BarberShop barberShop = new BarberShop(5);


        Thread t1 = new Thread(barberShop.getTimeLine(),"BarbershopThread");
        t1.setDaemon(true);
        t1.start();
        t1.join();
        Thread.sleep(1_000);
        barberShop.result();
    }
}
