package Validator;

import AppException.CarValidationException;

import java.util.Calendar;
import java.util.Objects;

public class CarValidator {

    /**
     * release data a Ford Model T
     */
    private static final int minYear = 1908;

    private void validateId(String Id) throws CarValidationException {
        try {
            checkIsEmpty(Id);
            int number = Integer.parseUnsignedInt(Id);
            if (number <= 0 ) {
                throw new Exception();
            }
        } catch (Exception ex) {
            throw new CarValidationException("Id must be an integer");
        }
    }

    private void validateMake(String make) throws CarValidationException {
        checkIsEmpty(make);
        if (!isStringInRange(2, 15, make)) {
            throw new CarValidationException("Make must be string min 3 characters and max 20 characters");
        }
    }

    private void validateModel(String model) throws CarValidationException {
        checkIsEmpty(model);
        if (!isStringInRange(3, 20, model)) {
            throw new CarValidationException("Model must be string min 3 characters and max 20 characters");
        }
    }

    private void validateYear(String date) throws CarValidationException {
        checkIsEmpty(date);
        try {
            int number = Integer.parseUnsignedInt(date);
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            if (!isIntegerInRange(minYear, currentYear, number)) {
                throw new CarValidationException("Year must contain year in range between " + minYear + " and " + currentYear);
            }
        } catch (NumberFormatException e) {
            throw new CarValidationException("Year must contain an integer");
        }
    }

    private void validatePrice(String price) throws CarValidationException {
        try {
            checkIsEmpty(price);
            float number = Float.parseFloat(price);
        } catch (Exception e) {
            throw new CarValidationException("Price must be in format 123.45");
        }
    }

    private void validateColor(String color) throws CarValidationException {
        checkIsEmpty(color);
        for (String colorType : AppType.Color.colors() ) {
            if (Objects.equals(color, colorType)) {
                return;
            }
        }
        throw new CarValidationException("Color must be correct color");
    }

    private void validateVinCode(String vinCode) throws CarValidationException {
        checkIsEmpty(vinCode);
        if (!isStringInRange(10, 10, vinCode)) {
            throw new CarValidationException("VinCode must contain exactly 10 characters");
        }
        //if (!isStringUpperCase(vinCode)) {
        //    throw new CarValidationException("VinCode must contain characters in upper case");
        //}
    }

    private static boolean isStringInRange(int min, int max, String s) {
        return s.length() >= min && s.length() <= max;
    }

    private static boolean isIntegerInRange(int min, int max, int i) {
        return i >= min && i <= max;
    }

    //private static boolean isStringUpperCase(String str) {
    //    char[] charArray = str.toCharArray();
    //    for (char c : charArray) {
    //        if (!Character.isUpperCase(c))
    //            return false;
    //    }
    //
    //    return true;
    //}

    private static void checkIsEmpty(String s) throws CarValidationException {
        if (Objects.equals(s, "")) {
            throw new CarValidationException("cannot be empty");
        }
    }
}
