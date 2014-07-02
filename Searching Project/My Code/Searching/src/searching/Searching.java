package searching;

/**
 *
 * @author Sameer Anand
 * 
 */

import java.util.Arrays;

public class Searching {

    public static int binarySearchRec(int[] arr, int from, int to, int key) {
        
        int mid = (from + to) / 2;

        if (from > to) {
        
            return -1;
        
        } else if (arr[mid] == key) {
            
            return mid;
        
        } else if (arr[mid] < key) {
        
            return binarySearchRec(arr, mid + 1, to, key);
        
        } else if (arr[mid] > key) {
        
            return binarySearchRec(arr, from, mid - 1, key);
        
        } else {
        
            return -1;
        
        }
    
    }

    public static int binarySearchIter(int[] arr, int from, int to, int key) {
      
        int mid;
        
        while (from <= to) {
        
            mid = (from + to) / 2;
            
            if (arr[mid] == key) {
            
                return mid;
            
            } else if (arr[mid] < key) {
            
                from = mid + 1;
            
            } else if (arr[mid] > key) {
            
                to = mid - 1;
            
            }
        
        }
        
        return -1;
    
    }

    public static void main(String[] args) {

        int[] arr = new int[100];

        for (int i = 0; i < arr.length; i++) {
       
            arr[i] = (int) (Math.random() * 500 + 1);
        
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
        
            System.out.print(arr[i] + " ");
        
        }
        
        System.out.println("");

        int[] keys = new int[20];

        for (int i = 0; i < keys.length; i++) {
        
            keys[i] = (int) (Math.random() * 500 + 1);
            
            System.out.print(keys[i] + " ");
        
        }
        
        System.out.println("\n");

        for (int i = 0; i < keys.length; i++) {
        
            int index = binarySearchRec(arr, 0, arr.length - 1, keys[i]);

            System.out.printf("%3d", keys[i]);
            
            if (index == -1) {
            
                System.out.println(" - Not Found");
            
            } else {
            
                System.out.println(" - Found");
            
            }
            
            index = binarySearchIter(arr, 0, arr.length - 1, keys[i]);
            
            System.out.printf("%3d", keys[i]);
            
            if (index == -1) {
            
                System.out.println(" - Not Found");
            
            } else {
            
                System.out.println(" - Found");
            
            }
            
            System.out.println("");
        
        }

        
        
//        for (int i = 0; i < keys.length; i++) {
//            int index = binarySearchIter(arr, 0, arr.length - 1, keys[i]);
//
//            System.out.printf("%3d", keys[i]);
//            if (index == -1) {
//                System.out.println(" - Not Found");
//            } else {
//                System.out.println(" - Found");
//            }
//        }
        
    }
}
