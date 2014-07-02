package bubblesort;

/**
 *
 * @author Sameer Anand
 * 
 */

public class Main {

    public static void main(String[] args) {
      
        Main main = new Main();
        
        main.start();
    
    }

    private void start() {

        int[] numbers = new int[100];

        for (int i = 0; i < numbers.length; i++) {
    
            numbers[i] = (int) (Math.random() * 500) + 1;
        
        }
        
        printArray(numbers);
        
        System.out.println("Original Array - Sorted? " + checkSorted(numbers, 0, numbers.length));
        
        System.out.println("");
        
        //Copying the original array to another array to sort
        
        int[] copy = new int[numbers.length];
        
        System.arraycopy(numbers, 0, copy, 0, numbers.length);

        //Iterative
        
        BubbleSort.bubbleIter(copy);
        
        printArray(copy);
        
        System.out.println("Iterative Sort - Sorted? " + checkSorted(copy, 0, copy.length));
        
        System.out.println("");
        
        //Creating a new copy
        
        copy = new int[numbers.length];
        
        System.arraycopy(numbers, 0, copy, 0, numbers.length);

        //Recursive sort
        
        BubbleSort.bubbleRec(copy, 1);
        
        printArray(copy);
        
        System.out.println("Recursive Sort - Sorted? " + checkSorted(copy, 0, copy.length));
        
        System.out.println("");
        
        //Creating a new copy
        
        copy = new int[numbers.length];
        
        System.arraycopy(numbers, 0, copy, 0, numbers.length);

        //Iterative Modified sort
        
        BubbleSort.BubbleIterMod(copy);
        
        printArray(copy);
        
        System.out.println("Iterative Modified Sort - Sorted? " + checkSorted(copy, 0, copy.length));
        
        System.out.println("");
        
        //Creating a new copy
        
        copy = new int[numbers.length];
        
        System.arraycopy(numbers, 0, copy, 0, numbers.length);

        //Recursive Modified sort
        
        BubbleSort.BubbleRecMod(copy, 1);
        
        printArray(copy);
        
        System.out.println("Recursive Modified Sort - Sorted? " + checkSorted(copy, 0, copy.length));

    }

    //Method to print the array if necessary
    
    private void printArray(int[] array) {
    
        for (int i = 0; i < array.length; i++) {
        
            System.out.print(array[i] + "  ");
        
        }
        
        System.out.println("");
    
    }

    private boolean checkSorted(int[] a, int from, int to) {
        
        for (int i = from; i < to - 1; i++) {
        
            if (a[i] > a[i + 1]) {
            
                return false;
            
            }
        
        }
        
        return true;
    
    }

}
