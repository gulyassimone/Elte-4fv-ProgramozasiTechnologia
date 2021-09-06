package main;

public class Building extends Unit{
    public Building(Base owner, UnitType unitType) {
        super( owner,  unitType);

        if(unitType == UnitType.FARM){
            for(int i = 0; i<10; ++i){
                super.owner.getResources().setCapacity();
            }
        }
    }
}
