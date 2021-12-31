package Repository;

import Model.Car;
import Model.Model;

import java.util.ArrayList;
import java.util.List;

public class CarRepository implements Model {
    private List<Car> cars;

    public CarRepository() {
        cars = new ArrayList<>();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void addCar(Car car) {
        this.cars.add(car.id, car);
    }
}
