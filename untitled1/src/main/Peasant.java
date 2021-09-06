package main;

public class Peasant extends Unit {
    private Integer isDoing ;

    public Peasant(Base owner) {
        super(owner, UnitType.PEASANT);
        owner.getResources().setCapacity();
    }


    public void startCuttingWood() {
        System.out.println("Elmentem fát vágni");
        isDoing = 1;
        new Thread(() -> {
            while (isDoing == 1) {
                synchronized (super.owner.getResources().getWood()){
                    super.owner.getResources().setWood(10);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void tryBuilding(UnitType buildingUnit) {
        System.out.println("Elmentem fát építeni");
        isDoing = 2;
        if(super.owner.canBuild(buildingUnit)){
            super.owner.costBuild(buildingUnit);
            super.owner.buildings.add(new Building(super.owner, buildingUnit));
            new Thread(() -> {
                try {
                    Thread.sleep(buildingUnit.buildTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public void startMinnig(){
        System.out.println("Elmentem fát bányászni");
        isDoing = 3;
        System.out.println("isDoing");
        new Thread( ()->{
            while(isDoing == 2){
                System.out.println("..");
                synchronized (super.owner.getResources().getGold()){
                    super.owner.getResources().setGold(10);
                }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
    }

    public void stop(){
        isDoing = null;
    }

}
