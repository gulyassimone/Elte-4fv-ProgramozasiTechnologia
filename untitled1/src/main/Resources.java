package main;



public class Resources {
    private Integer gold;
    private Integer wood;
    private Integer capacity;
    private Integer capacityLimit;

    public Resources() {

        this.gold = 0;
        this.wood = 0;
        this.capacity = 0;
        this.capacityLimit = 5;
    }

    public void setGold(Integer gold) {
        this.gold += gold;
        System.out.println("Gold ennyi: " + gold);
    }

    public void setWood(Integer wood) {
        this.wood += wood;
        System.out.println("Gold ennyi: " + wood);
    }

    public boolean setCapacity() {
        if(this.capacity + capacity < capacityLimit ){
            this.capacity += 1;
            return true;
        }else{
            this.capacity = capacityLimit;
            return false;
        }
    }

    public void setCapacityLimit(Integer capacityLimit) {
        this.capacityLimit = capacityLimit;
    }

    public Integer getGold() {
        return gold;
    }

    public Integer getWood() {
        return wood;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Integer getCapacityLimit() {
        return capacityLimit;
    }

    public void cost(UnitType buildingUnit) {
        gold -= buildingUnit.goldCost;
        wood -= buildingUnit.woodCost;
    }
}
