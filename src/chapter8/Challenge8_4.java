package chapter8;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by asus on 8/26/17.
 * Design a parking lot using OOP.
 *
 * Assumptions:
 * - multiple levels
 * - each level has multiple rows of spots
 * - motorcycles, cars, buses
 * - motorcycle spots, compact spots, large spots
 * - motorcycle can park in any spot
 * - car can park in a single compact or single large spot
 * - bus can park in five large spots that are consecutive and within the same row (no small spots)
 */

enum VehicleSize {Motorcycle, Compact, Large}

abstract class Vehicle{
    protected List<ParkingSpot> parkingSpots = new ArrayList();
    protected String licencePlate;
    protected int spotsNeeded;
    protected VehicleSize size;

    public int getSpotsNeeded(){return spotsNeeded;}
    public VehicleSize getSize(){return size;}

    // Park vehicle in this spot (and maybe others)
    public void parkInSpot(ParkingSpot s){
        parkingSpots.add(s);
    }

    // Remove car from spot, and notify that it is available
    public void clearSpots(){}

    // Check if the spot is big enough for the vehicle.
    public abstract boolean canFitInSpot(ParkingSpot spot);
}

class Bus extends Vehicle{
    public Bus() {
        spotsNeeded = 5;
        size = VehicleSize.Large;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return false;
    }
}

class Car extends Vehicle{

    public Car() {
        spotsNeeded = 1;
        size = VehicleSize.Compact;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return false;
    }
}

class Motorcycle extends Vehicle{
    public Motorcycle() {
        spotsNeeded = 1;
        size = VehicleSize.Motorcycle;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return false;
    }
}

class ParkingLot{
    private Level[] levels;
    private final int NUM_LEVELS = 5;

    public ParkingLot() {
    }

    public boolean parkVehicle(Vehicle vehicle){
        return false;
    }
}

class Level{
    private int floor;
    private ParkingSpot[] spots;
    private int availableSpots = 0;  // number of free spots
    private static final int SPOTS_PER_ROW = 10;

    public Level(int flr, int numberSpots){}
    public int availableSpots(){return availableSpots;}
    public boolean parkVehicle(Vehicle vehicle){return false;}
    private boolean parkStartingAtSpot(int num, Vehicle vehicle){ return  false;}
    private int findAvailableSpots(Vehicle vehicle){return -1;}
    public void spotFreed(){availableSpots++;}
}

class ParkingSpot{
    private Vehicle vehicle;
    private VehicleSize spotSize;
    private int row;
    private int spotNumber;
    private int level;

    public ParkingSpot(VehicleSize spotSize, int row, int spotNumber, int level) {
        this.spotSize = spotSize;
        this.row = row;
        this.spotNumber = spotNumber;
        this.level = level;
    }

    public boolean isAvailable(){
        return vehicle == null;
    }

    public boolean canFitVehicle(Vehicle vehicle){ return  false;}

    public boolean park(Vehicle vehicle) {return false; }

    public int getRow(){ return row; }

    public int getSpotNumber() { return spotNumber; }

    public void removeVehicle(){}
}
public class Challenge8_4 {
}
