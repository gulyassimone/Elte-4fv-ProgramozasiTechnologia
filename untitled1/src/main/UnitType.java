package main;

public enum UnitType {
    FARM(80,20,0, 2000),

    LUMBERMILL(120,0,0,4000),

    BLACKSMITH(140,60,0, 5000),

    PEASANT(75,0,1, 1000);

    int goldCost;
    int foodCost;
    int woodCost;
    int buildTime;

    UnitType(int goldCost, int foodCost, int woodCost, int buildTime) {
        this.goldCost = goldCost;
        this.foodCost = foodCost;
        this.woodCost = woodCost;
        this.buildTime = buildTime;
    }
}