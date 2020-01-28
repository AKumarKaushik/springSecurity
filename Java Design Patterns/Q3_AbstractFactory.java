/*Q4) Implement Abstract Factory Pattern to create cars of different categories from different countries.*/
package java6_Assgnmnt;

enum CarType{
    MICRO, MINI, LUXURY;
}
enum Location{
    JAPAN, USA, INDIA;
}

abstract class Car{
    CarType carType;
    Location location;

    public  Car(CarType carType, Location location){
        this.carType = carType;
        this.location = location;
    }

    abstract void construct();

    @Override
    public String toString() {
        return "Car = { "+
                "Car type = "+carType+
                " Location = "+location+
                " }";
    }
}

class Luxury extends Car{

    public Luxury(Location location) {
        super(CarType.LUXURY, location);
    }

    @Override
    void construct() {
        System.out.println("Constructing Luxury Car");
    }
}

class Mini extends Car{

    public Mini(Location location){
        super(CarType.MINI,location);
    }
    @Override
    void construct() {
        System.out.println("Constructing Mini Car");
    }
}

class Micro extends Car{

    public Micro(Location location) {
        super(CarType.MICRO, location);
    }

    @Override
    void construct() {
        System.out.println("Constructing Micro Car");
    }
}

class IndianFactory{
    static Car builder(CarType carType){
        Car car = null;
        switch (carType){
            case MICRO :
                car = new Micro(Location.INDIA);
                break;
            case MINI:
                car = new Mini(Location.INDIA);
                break;
            case LUXURY:
                car = new Luxury(Location.INDIA);
                break;
        }
        return car;
    }
}

class USAFactory{
    static Car builder(CarType carType){
        Car car = null;
        switch (carType){
            case MICRO :
                car = new Micro(Location.USA);
                break;
            case MINI:
                car = new Mini(Location.USA);
                break;
            case LUXURY:
                car = new Luxury(Location.USA);
                break;
        }
        return car;
    }
}

class JapanFactory{
    static Car builder(CarType carType){
        Car car = null;
        switch (carType){
            case MICRO :
                car = new Micro(Location.JAPAN);
                break;
            case MINI:
                car = new Mini(Location.JAPAN);
                break;
            case LUXURY:
                car = new Luxury(Location.JAPAN);
                break;
        }
        return car;
    }
}

class CarFactory{
    static Car builder(CarType carType, Location location){
         Car car = null;
         switch (location){
             case INDIA:
                 car = IndianFactory.builder(carType);
                 break;
             case USA:
                 car = USAFactory.builder(carType);
                 break;
             case JAPAN:
                 car = JapanFactory.builder(carType);
                 break;
         }
         return car;
    }
}

public class Q3_AbstractFactory {
    public static void main(String[] args) {
        System.out.println(CarFactory.builder(CarType.MICRO,Location.INDIA));
        System.out.println(CarFactory.builder(CarType.MINI,Location.JAPAN));
        System.out.println(CarFactory.builder(CarType.LUXURY,Location.USA));

    }
}
