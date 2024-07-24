package com.temperatureconverter;

import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get the temperature value from the user
        System.out.print("Enter the temperature value: ");
        double temperature = getValidDouble(scanner);
        
        // Get the source scale from the user
        System.out.print("Enter the source scale (C, F, K): ");
        char sourceScale = getValidScale(scanner);
        
        // Get the target scale from the user
        System.out.print("Enter the target scale (C, F, K): ");
        char targetScale = getValidScale(scanner);
        
        // Perform the conversion
        double convertedTemperature = TemperatureConversionUtils.convertTemperature(temperature, sourceScale, targetScale);
        
        // Display the result
        System.out.printf("The converted temperature is: %.2f %c\n", convertedTemperature, targetScale);
        
        // Close the scanner
        scanner.close();
    }
    
    private static double getValidDouble(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }
    
    private static char getValidScale(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().toUpperCase();
            if (input.length() == 1 && "CFK".contains(input)) {
                return input.charAt(0);
            } else {
                System.out.print("Invalid input. Please enter a valid scale (C, F, K): ");
            }
        }
    }
}
