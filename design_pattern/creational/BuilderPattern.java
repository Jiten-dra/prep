package design_pattern.creational;

public class BuilderPattern {
    public static void main(String[] args) {
        CarBuilder carBuilder = new CarBuilderImpl();
        Director director = new Director(carBuilder);
        director.constructSedanCar();
        Car car = carBuilder.getCar();
        System.out.println(car);
        director.constructSUVCar();
        car = carBuilder.getCar();
        System.out.println(car);
        director.constructHatchbackCar();
        car = carBuilder.getCar();
        System.out.println(car);
    }

}

class Director {
    private CarBuilder carBuilder;

    public Director(CarBuilder carBuilder) {
        this.carBuilder = carBuilder;
    }

    public void setCarBuilder(CarBuilder carBuilder) {
        this.carBuilder = carBuilder;
    }

    public void constructSedanCar() {
        carBuilder.reset();
        carBuilder.setCarType(CarType.SEDAN);
        carBuilder.buildEngine("1.6L");
        carBuilder.buildWheels("16 inch");
        carBuilder.buildBody("Sedan");
        carBuilder.paint("Red");
    }

    public void constructSUVCar() {
        carBuilder.reset();
        carBuilder.setCarType(CarType.SUV);
        carBuilder.buildEngine("2.0L");
        carBuilder.buildWheels("18 inch");
        carBuilder.buildBody("SUV");
        carBuilder.paint("Black");
    }

    public void constructHatchbackCar() {
        carBuilder.reset();
        carBuilder.setCarType(CarType.HATCHBACK);
        carBuilder.buildEngine("1.2L");
        carBuilder.buildWheels("14 inch");
        carBuilder.buildBody("Hatchback");
        carBuilder.paint("White");
    }
}

interface CarBuilder {
    public void buildEngine(String engine);
    public void buildWheels(String wheels);
    public void buildBody(String body);
    public void paint(String color);
    public void setCarType(CarType carType);
    public void reset();
    public Car getCar();
}

class CarBuilderImpl implements CarBuilder {
    private String engine;
    private String wheels;
    private String body;
    private String color;
    private CarType carType;

    public void reset() {
        engine = null;
        wheels = null;
        body = null;
        color = null;
        carType = null;
    }

    public void buildEngine(String engine) {
        this.engine = engine;
    }

    public void buildWheels(String wheels) {
        this.wheels = wheels;
    }

    public void buildBody(String body) {
        this.body = body;
    }

    public void paint(String color) {
        this.color = color;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public Car getCar() {
        return new Car(engine, wheels, body, color, carType.name());
    }
}

enum CarType {
    SEDAN, SUV, HATCHBACK
}

class Car {
    private String engine;
    private String wheels;
    private String body;
    private String color;
    private CarType carType;

    public Car(String engine, String wheels, String body, String color, String carType) {
        this.engine = engine;
        this.wheels = wheels;
        this.body = body;
        this.color = color;
        this.carType = CarType.valueOf(carType);
    }

    public String getEngine() {
        return engine;
    }

    public String getWheels() {
        return wheels;
    }

    public String getBody() {
        return body;
    }

    public String getColor() {
        return color;
    }

    public CarType getCarType() {
        return carType;
    }

    public String toString() {
        return "Car: "+carType+" Engine: "+engine+" Wheels: "+wheels+" Body: "+body+" Color: "+color;
    }
}