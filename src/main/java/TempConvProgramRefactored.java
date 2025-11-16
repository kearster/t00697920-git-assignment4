import conversions.CelsiusToFahrenheitConverter;
import conversions.CelsiusToKelvinConverter;
import conversions.FahrenheitToCelsiusConverter;
import conversions.TemperatureConverter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TempConvProgramRefactored {

    // List of converters to display to the user
    private final static TemperatureConverter[] MENU = {
            new CelsiusToFahrenheitConverter(),
            new FahrenheitToCelsiusConverter(),
            new CelsiusToKelvinConverter()
    };
    private static final int instructionLength = MENU.length + 1;

    public static void printMenu(){
        System.out.println("Provide an integer to choose from the list below: ");
        for(int i = 0; i < MENU.length; i++) {
            System.out.printf("%s - %s%n", i + 1, MENU[i].getDescription()); // Add each converter
        }
        System.out.printf("%s - %s%n", instructionLength, "Exit the program"); // Include the exit instruction after
    }

    // Provides double value input reading from the user with error handling built-in.
    public static double getConversionInput(Scanner scanner, String inputRequired) {
        Double input = null;

        while (input == null) {
            System.out.printf("Please provide your %s value:%n", inputRequired);
            try {
                input = scanner.nextDouble();
            } catch (InputMismatchException exception) {
                System.out.println("Invalid input, try again!");
                scanner.next(); // Clears the invalid value from the scanner.
            }
        }
        return input;
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("-- Temperature Conversion App -------");
        System.out.println("Welcome!");
        while(true){
            printMenu();
            int input;

            try {
                input = inputScanner.nextInt();
            } catch (InputMismatchException exception) {
                System.out.println("Not a valid integer value!");
                inputScanner.next(); // Remove the invalid input from the scanner.
                continue;
            }

            if(input == instructionLength) {
                System.out.println("Exiting the program...");
                break;
            } else if(input > instructionLength || input < 1) {
                System.out.println("Input not found!");
                continue;
            }

            TemperatureConverter converter = MENU[input + 1];
            double temperature = getConversionInput(inputScanner, converter.getConvertsFrom().name().toLowerCase());
            System.out.printf("%s %s converts to %s %s%n", temperature, converter.getConvertsFrom(),
                    converter.convert(temperature), converter.getConvertsTo());

        }
        inputScanner.close();
    }

}
