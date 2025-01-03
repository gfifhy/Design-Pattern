package creational;

class Car {
    private final String engineType;
    private final String wheelType;
    private final String seatType;
    private final String color;

    // Constructor is private so it cannot be directly instantiated
    private Car(CarBuilder builder) {
        this.engineType = builder.engineType;
        this.wheelType = builder.wheelType;
        this.seatType = builder.seatType;
        this.color = builder.color;
    }

    @Override
    public String toString() {
        return "Car [Engine: " + engineType + ", Wheels: " + wheelType + ", Seats: " + seatType + ", Color: " + color + "]";
    }

    // Static Builder Class
    public static class CarBuilder {
        private final String engineType;
        private String wheelType;
        private String seatType;
        private String color;

        // Setter methods for mandatory fields
        public CarBuilder(String engineType) {
            this.engineType = engineType;
        }

        // Setter methods for optional fields
        public CarBuilder setWheelType(String wheelType) {
            this.wheelType = wheelType;
            return this;
        }

        // Setter methods for optional fields
        public CarBuilder setSeatType(String seatType) {
            this.seatType = seatType;
            return this;
        }

        // Setter methods for optional fields
        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
public class BuilderPattern {
    public static void main(String[] args) {
        // Build a car using the builder
        Car car = new Car.CarBuilder("Electric")
                .setWheelType("Alloy")
                .setSeatType("Leather")
                .setColor("Red")
                .build();

        // Output the created car
        System.out.println(car);
    }
}
