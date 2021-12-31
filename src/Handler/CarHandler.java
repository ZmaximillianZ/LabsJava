package Handler;

import AppException.CarValidationException;
import Helper.StringHelper;
import Model.Car;
import Repository.CarRepository;
import Validator.CarValidator;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class CarHandler extends Handler {
    protected static final int addCar = 1;
    protected static final int showCars = 2;

    protected static CarRepository carRepository;
    protected static CarValidator carValidator;

    public CarHandler() {
        carRepository = new CarRepository();
        carValidator = new CarValidator();
    }

    protected int[] points() { return new int[]{addCar, showCars}; }

    protected void run(int point, Scanner scanner) throws Exception {
        switch (point) {
            case addCar:
                System.out.println("input car fields:");
                addCarAction(scanner);
                break;
            case showCars:
                showCarsAction();
        }
    }

    private static void addCarAction(Scanner scanner) throws Exception {
        Car car = new Car(0, "", "", 0, 0.00f, "", "");
        scanner.nextLine();
        for (Field field : car.getClass().getFields()) {
            field.setAccessible(true);
            boolean isValid = true;
            while (isValid) {
                System.out.print(field.getName() + ": ");
                String s = scanner.nextLine();
                Method method = carValidator.getClass().getDeclaredMethod("validate" + StringHelper.capitalize(field.getName()), String.class);
                method.setAccessible(true);
                try {
                    method.invoke(carValidator, s);
                    isValid = false;
                } catch (Exception e) {
                    if (((InvocationTargetException) e).getTargetException() instanceof CarValidationException) {
                        System.out.println(e.getCause().getMessage());
                    } else {
                        throw e;
                    }
                }
                if (field.getType() == String.class) {
                    field.set(car, s);
                }
                if (field.getType() == Integer.class) {
                    field.set(car, Integer.parseUnsignedInt(s));
                }
            }

        }
        carRepository.addCar(car);
        System.out.println("Car successfully added");
    }

    private static void showCarsAction() {
        for (Car car: carRepository.getCars()) {
            System.out.println(car.toString());
        }
    }
}
