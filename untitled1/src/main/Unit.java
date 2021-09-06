package main;

public abstract class Unit {
    Base owner;
    UnitType unitType;

    public Unit(Base owner, UnitType unitType) {
        this.owner = owner;
        this.unitType = unitType;
    }
}
