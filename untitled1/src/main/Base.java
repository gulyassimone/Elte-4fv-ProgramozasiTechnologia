package main;

import java.util.ArrayList;
import java.util.List;

public class Base {
    protected  String name;
    protected Resources resources;
    protected List<Peasant> peasants;
    protected List<Building> buildings;
    protected int startNumber = 5;

    public Base(String name) {
        resources = new Resources();
        peasants = new ArrayList<>();
        buildings = new ArrayList<>();
        this.name = name;
        for(int i = 0; i<startNumber; ++i ){
            peasants.add(new Peasant(this));
            if(i<3){
                peasants.get(peasants.size()-1).startMinnig();
            }else if(i<4){
                peasants.get(peasants.size()-1).startCuttingWood();
            }
        }
    }

    public void startPreparation(){
        new Thread(() ->{
            while( peasants.size() != 10 ){
            }
        });
    }

    public String getName() {
        return name;
    }

    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public void costBuild(UnitType buildingUnit) {
        resources.cost(buildingUnit);
    }

    public boolean canBuild(UnitType buildingUnit) {
        if(resources.getGold() > buildingUnit.goldCost && resources.getWood()> buildingUnit.woodCost){
            return true;
        }else{
            return false;
        }
    }
}
