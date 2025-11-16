import java.util.InputMismatchException;
import java.util.Scanner;

public class TempConvProgramRefactored {

    public static double celsiusToFahrenheit(double celsius){
        return celsius*9/5+32;
    }
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit-32)*5/9;

    }
    public static double celsiusToKelvin(double celsius) {
        return celsius+273.15;
    }

    public static void printMenu(){
        System.out.println("1 convert Celsius to Fahrenheit");
        System.out.println("2 convert Fahrenheit to Celsius");
        System.out.println("3 convert Celsius to Kelvin");
        System.out.println("4 exit the program");
    }

    // Provides double value input reading from the user with error handling built-in.
    public static double getConversionInput(Scanner scanner, String inputRequired) {
        Double input = null;

        while (input == null) {
            System.out.printf("Please provide your %s value:", inputRequired);
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
        program: while(true){
            printMenu();
            int input;

            try {
                input = inputScanner.nextInt();
            } catch (InputMismatchException exception) {
                System.out.println("Please provide an integer value.");
                inputScanner.next(); // Remove the invalid input from the scanner.
                continue;
            }
            double temperature;

            switch (input) {
                case 1:
                    temperature = getConversionInput(inputScanner, "celsius");
                    System.out.printf("%s celsius is %s fahrenheit%n", temperature, celsiusToFahrenheit(temperature));
                    break;
                case 2:
                    temperature = getConversionInput(inputScanner, "fahrenheit");
                    System.out.printf("%s fahrenheit is %s celsius%n", temperature, fahrenheitToCelsius(temperature));
                    break;
                case 3:
                    temperature = getConversionInput(inputScanner, "celsius");
                    System.out.printf("%s celsius is %s kelvin%n", temperature, celsiusToKelvin(temperature));
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    break program;
                default:
                    System.out.println("Input not found, try another one!");
                    break;
            }

        }
        inputScanner.close();
    }

}
