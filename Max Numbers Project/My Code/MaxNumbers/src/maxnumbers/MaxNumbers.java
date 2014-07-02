package maxnumbers;

import java.util.Scanner;

/**
 *
 * @author Sameer Anand
 * 
 */

public class MaxNumbers {

    /**
     * Write a program that reads integers, finds the largest of them, and
     * counts its occurrences. Assume that the input ends with the number 0.
     */
    
    /*
     * max stores the current max number
     * count stores the max's occurrence count
     */
    
    static int max;
    static int count;
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        // Take the line of input as a String
        
        System.out.print("Type in a list of numbers (separated by spaces): ");
        
        String numbersInput = input.nextLine();
        
        // Convert the input String into a String array
        
        String[] numbersString = numbersInput.split(" ");
        
        // Create a new int array with the length of the String array
        
        int[] numbers = new int[numbersString.length];
        
        // Iterate through the String array and parse each interget.
        // Assign each integer to a position in the Int array
        
        for (int i=0; i < numbersString.length; i++) {
        
            numbers[i] = Integer.parseInt(numbersString[i]);
        
        }
        
        // Create a variable called lastElement which holds the value of the
        // last element in the array.
        
        int lastElement = numbers[numbers.length - 1];
        
        max = getMaxValue(numbers);
        
        // Get the occurrence count of the max number in the array
        
        for (int i = 0; i < numbers.length; i++) {
            
            if (numbers[i] == max) {
                
                count++;
                
            }
            
        }
        
        System.out.println("The Max Number is: " + max);
        
        System.out.println("The Occurrence Count is: " + count);
        
    }
    
    
    /*
     * Return the max value of an int array
     */
    
    public static int getMaxValue(int[] numbers){
        
        int maxValue = numbers[0];
        
        for(int i=1; i < numbers.length; i++){
        
            if(numbers[i] > maxValue){
            
                maxValue = numbers[i];
            
            }
        
        }
        
        return maxValue;
    
    }
    
}