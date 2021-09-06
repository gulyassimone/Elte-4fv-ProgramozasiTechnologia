package entity;

import java.util.concurrent.TimeUnit;

public class Generator implements Runnable{
    final BarberShop barberShop;

    public Generator(BarberShop barberShop) {
        this.barberShop = barberShop;
    }

    @Override
    public void run() {
            try
            {
                synchronized (barberShop){
                while(barberShop.isOpen()) {
                    TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 300));
                    Customer customer = new Customer(barberShop);
                    Thread t1 = new Thread(customer,"CustomerThread");
                    t1.start();
                    System.out.println("Jött egy új vendég " + System.currentTimeMillis());
                }}
            }
            catch(InterruptedException iex)
            {
                iex.printStackTrace();
            }
    }
}
