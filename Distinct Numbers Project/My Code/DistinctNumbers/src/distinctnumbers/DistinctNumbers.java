package distinctnumbers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author Sameer Anand
 * 
 */

public class DistinctNumbers {

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
        
        getDistinctNumbers(numbersStringList);
    
    }
    
    public static String getDistinctNumbers(String[] numbers) {
        
        String[] unique = new HashSet<String>(Arrays.asList(numbers)).toArray(new String[numbers.length]);
        
        StringBuilder builder = new StringBuilder();
        
        for(String n : unique) {
        
            if ((n != null) && isInteger(n))
            
                builder.append(n + " ");
        
        }
        
        String finalString = builder.toString();
        
        System.out.println(finalString);
        
        return finalString;
        
    }
    
    public static boolean isInteger(String str) {
        
        if (str == null) {
            
            return false;
        
        }
        
        int length = str.length();
        
        if (length == 0) {
        
            return false;
        
        }
        
        int i = 0;
        
        if (str.charAt(0) == '-') {
            
            if (length == 1) {
            
                return false;
            
            }
            
            i = 1;
        
        }
        
        for (; i < length; i++) {
        
            char c = str.charAt(i);
            
            if (c <= '/' || c >= ':') {
            
                return false;
            
            }
        
        }
        
        return true;
    
    }
    
}
