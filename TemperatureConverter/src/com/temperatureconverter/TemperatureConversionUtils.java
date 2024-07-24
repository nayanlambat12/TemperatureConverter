package com.temperatureconverter;

public class TemperatureConversionUtils {
    
    public static double convertTemperature(double temperature, char sourceScale, char targetScale) {
        if (sourceScale == targetScale) {
            return temperature;
        }
        
        double tempInCelsius;
        
        // Convert source temperature to Celsius
        switch (sourceScale) {
            case 'C':
                tempInCelsius = temperature;
                break;
            case 'F':
                tempInCelsius = (temperature - 32) * 5 / 9;
                break;
            case 'K':
                tempInCelsius = temperature - 273.15;
                break;
            default:
                throw new IllegalArgumentException("Invalid source scale: " + sourceScale);
        }
        
        // Convert Celsius to target scale
        switch (targetScale) {
            case 'C':
                return tempInCelsius;
            case 'F':
                return (tempInCelsius * 9 / 5) + 32;
            case 'K':
                return tempInCelsius + 273.15;
            default:
                throw new IllegalArgumentException("Invalid target scale: " + targetScale);
        }
    }
}
