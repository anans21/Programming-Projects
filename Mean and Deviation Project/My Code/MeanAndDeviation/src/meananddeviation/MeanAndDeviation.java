package meananddeviation;

import java.util.Scanner;

/**
 *
 * @author Sameer Anand
 * 
 */

public class MeanAndDeviation {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a list of numbers (separated by spaces): ");
        
        String inputList = scanner.nextLine();
        
        String numbersStringList[] = inputList.split(" ");
        
        double[] numbersList = new double[numbersStringList.length];

        for (int i = 0; i < numbersStringList.length; i++) {
        
            try {
            
                numbersList[i] = Double.parseDouble(numbersStringList[i]);
            
            } catch (NumberFormatException nfe) {};
        
        }
        
        System.out.println("The mean is " + getMean(numbersList));
        
        System.out.println("The standard deviation is " + getDeviation(numbersList));
        
    }
    
    public static double getMean(double[] numbers) {
        
        double sum = 0;
        
        for (int i = 0; i < numbers.length; i++) {
            
            sum += numbers[i];
            
        }
        
        double mean = sum / numbers.length;
        
        return mean;
        
    }
    
    public static double getVariance(double[] numbers) {
        
        double mean = getMean(numbers);
        
        double temp = 0;
        
        for(double i :numbers)
        
            temp += (mean - i) * (mean - i);
        
        return temp/numbers.length;
    }
    
    public static double getDeviation(double[] numbers) {
        
        return Math.sqrt(getVariance(numbers));
        
    }
    
}
