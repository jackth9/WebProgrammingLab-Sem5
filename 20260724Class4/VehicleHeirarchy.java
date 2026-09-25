class Vehicle {

    String make;
    String model;
    int year;
    String fuelType;

    Vehicle(String make,String model,int year,String fuelType){
        this.make=make;
        this.model=model;
        this.year=year;
        this.fuelType=fuelType;
    }

    void fuelEfficiency(){}
    void distanceTravelled(){}
    void maxSpeed(){}
}

class Truck extends Vehicle{

    Truck(String make,String model,int year,String fuel){
        super(make,model,year,fuel);
    }

    void fuelEfficiency(){
        System.out.println("Truck Mileage : 8 km/l");
    }

    void distanceTravelled(){
        System.out.println("Distance : 500 km");
    }

    void maxSpeed(){
        System.out.println("Max Speed : 100 km/h");
    }
}

class Car extends Vehicle{

    Car(String make,String model,int year,String fuel){
        super(make,model,year,fuel);
    }

    void fuelEfficiency(){
        System.out.println("Car Mileage : 18 km/l");
    }

    void distanceTravelled(){
        System.out.println("Distance : 350 km");
    }

    void maxSpeed(){
        System.out.println("Max Speed : 180 km/h");
    }
}

class Motorcycle extends Vehicle{

    Motorcycle(String make,String model,int year,String fuel){
        super(make,model,year,fuel);
    }

    void fuelEfficiency(){
        System.out.println("Bike Mileage : 45 km/l");
    }

    void distanceTravelled(){
        System.out.println("Distance : 150 km");
    }

    void maxSpeed(){
        System.out.println("Max Speed : 140 km/h");
    }
}

public class VehicleHeirarchy {

    public static void main(String args[]){

        Vehicle v1=new Truck("Tata","LPT",2022,"Diesel");
        Vehicle v2=new Car("Honda","City",2023,"Petrol");
        Vehicle v3=new Motorcycle("Yamaha","R15",2024,"Petrol");

        v1.fuelEfficiency();
        v2.fuelEfficiency();
        v3.fuelEfficiency();
    }
}
