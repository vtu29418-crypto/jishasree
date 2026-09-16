import java.util.*;

class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}

class Rider {
    String name;

    Rider(String name) {
        this.name = name;
    }
}

class Driver {
    String name;

    Driver(String name) {
        this.name = name;
    }
}

abstract class Vehicle {
    Driver driver;

    Vehicle(Driver driver) {
        this.driver = driver;
    }

    abstract double calculateFare(double distance);
}

class Bike extends Vehicle {
    Bike(Driver driver) {
        super(driver);
    }

    double calculateFare(double distance) {
        return distance * 5;
    }
}

class Auto extends Vehicle {
    Auto(Driver driver) {
        super(driver);
    }

    double calculateFare(double distance) {
        return distance * 12;
    }
}

class Cab extends Vehicle {
    Cab(Driver driver) {
        super(driver);
    }

    double calculateFare(double distance) {
        return distance * 12;
    }
}

class Trip {
    Rider rider;
    Vehicle vehicle;
    double distance;

    Trip(Rider rider, Vehicle vehicle, double distance)
            throws InvalidBookingException {

        if (distance <= 0) {
            throw new InvalidBookingException("Invalid distance");
        }

        this.rider = rider;
        this.vehicle = vehicle;
        this.distance = distance;
    }

    double getFare() {
        return vehicle.calculateFare(distance);
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Rider rider = new Rider("Rider");
        Driver driver = new Driver("Driver");

        for (int i = 0; i < N; i++) {

            String type = sc.next();
            double distance = sc.nextDouble();

            try {
                Vehicle vehicle;

                if (type.equalsIgnoreCase("Bike")) {
                    vehicle = new Bike(driver);
                } 
                else if (type.equalsIgnoreCase("Auto")) {
                    vehicle = new Auto(driver);
                } 
                else if (type.equalsIgnoreCase("Cab")) {
                    vehicle = new Cab(driver);
                } 
                else {
                    throw new InvalidBookingException("Invalid ride type");
                }

                Trip trip = new Trip(rider, vehicle, distance);

                double fare = trip.getFare();

                if (fare == (int) fare) {
                    System.out.println((int) fare);
                } else {
                    System.out.println(fare);
                }

            } catch (InvalidBookingException e) {
                System.out.println("Invalid Booking");
            }
        }

        sc.close();
    }
}