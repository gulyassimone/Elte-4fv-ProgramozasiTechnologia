package entity;

import java.util.concurrent.TimeUnit;

public class TimeLine implements Runnable{
    private final BarberShop barberShop;


    public TimeLine(BarberShop barberShop) {
        this.barberShop = barberShop;
    }

    @Override
    public void run() {
        try {
            for (int i =0; i <  barberShop.getSimulationTime(); ++i){

                if(i == 0) {
                    TimeUnit.MILLISECONDS.sleep(barberShop.getOpenTime());
                }

                System.out.println("-----------------------------------------");
                System.out.println(i+1 + ". NAP");
                System.out.println("-----------------------------------------");

                Thread t1 = new Thread(barberShop.getBarber(),"BarberThread");
                t1.start();


                TimeUnit.MILLISECONDS.sleep(barberShop.getWorkTime());
                barberShop.getBarber().stop();
                System.out.println("-----------------------------------------");
                System.out.println( i+1 + ". Nap vége");
                System.out.println("-----------------------------------------");
                TimeUnit.MILLISECONDS.sleep(barberShop.getOpenTime()*2);
            }
            barberShop.closed();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
