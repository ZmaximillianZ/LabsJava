import Handler.CarHandler;

import org.jetbrains.annotations.NotNull;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CarConsoleApp {
    private static final int exit = 3;

    public static void main(String[] args) {
        CarHandler carHandler = new CarHandler();

        String[] options = {"1- Add car", "2- Show cars", "3- Exit"};
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (option != exit) {
            printMenu(options);
            try {
                option = scanner.nextInt();
                carHandler.handle(option, scanner);
            }
            catch (InputMismatchException ex) {
                System.out.println("enter integer between 1 and " + options.length);
                scanner.next();
            }
            catch (Exception ex) {
                System.out.println("An unexpected error happened. Please try again");
                scanner.next();
            }
        }
    }

    private static void printMenu(String @NotNull [] options) {
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Please choose option:");
    }
}
