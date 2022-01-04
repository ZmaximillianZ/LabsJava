import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final int input = 1;
    private static final int exit = 2;

    public static void main(String[] args) {
        String[] options = {"1- input set of natural numbers", "2- Exit"};
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (option != exit) {
            printMenu(options);
            try {
                option = scanner.nextInt();
                if (option == input) {
                    intInput(scanner);
                    break;
                }
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

    private static void intInput(Scanner scanner) {
        int nextInt = 0;
        scanner.nextLine();
        System.out.println("input numbers:");
        while (true) {
            String s = scanner.nextLine();
            if (Objects.equals(s, "")) {
                continue;
            }
            StringBuilder resultString = new StringBuilder("Natural numbers that are divisible by 3 or 9 without remainder:");
            System.out.println();
            for (String el : filterIntegers(findIntegers(s))) {
                resultString.append(" ").append(el);
            }
            System.out.println(resultString);
            String[] options = {"1- input another one", "2- Exit"};
            printMenu(options);
            nextInt = scanner.nextInt();
            if (nextInt == exit) {
                break;
            }
        }
    }

    private static String[] findIntegers(String s) {
        Pattern integerPattern = Pattern.compile("\\d+");
        Matcher matcher = integerPattern.matcher(s);

        List<String> integerList = new ArrayList<>();
        while (matcher.find()) {
            integerList.add(matcher.group());
        }

        return integerList.toArray(new String[integerList.size()]);
    }

    private static String[] filterIntegers(String[] sArr) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < sArr.length; i++) {
            int n = Integer.parseInt(sArr[i]);
            if (n % 3 == 0) {
                result.add(sArr[i]);
            }
        }

        return result.toArray(new String[result.size()]);
    }
}
