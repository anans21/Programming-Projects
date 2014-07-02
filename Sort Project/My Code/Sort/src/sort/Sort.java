package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Sameer Anand
 */

public class Sort {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        String listAsString = scanner.nextLine();
        
        String numbersStringList[] = listAsString.split(" ");
        
        int[] list = new int[numbersStringList.length];

        for (int i = 0; i < numbersStringList.length; i++) {
        
            try {
            
                list[i] = Integer.parseInt(numbersStringList[i]);
            
            } catch (NumberFormatException nfe) {};
        
        }
        
        int numElementsInList = list[0];
        
        //System.out.println(numElementsInList);
        
        isSorted(list);
        
    }
    
    public static boolean isSorted(int[] list) {
        
        list[0] = 0;
        
        String listAsString = Arrays.toString(list);
        
        Arrays.sort(list);
        
        String listAsSortedString = Arrays.toString(list);
        
        //System.out.println(listAsString);
        
        //System.out.println(listAsSortedString);
        
        if (!listAsString.equals(listAsSortedString)) {
            
            System.out.println("The list is not sorted");
            
            return false;
            
        }
        
        System.out.println("The list is already sorted");
        
        return true;
        
    }

}