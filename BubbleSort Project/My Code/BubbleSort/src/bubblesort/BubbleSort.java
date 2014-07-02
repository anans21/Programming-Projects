package bubblesort;

/**
 *
 * @author Sameer Anand
 * 
 */

public class BubbleSort {

    public static void bubbleIter(int[] data) {
        
        int n = data.length;
        
        for (int pass = 1; pass < n; pass++) {
        
            for (int i = 0; i < n - pass; i++) {
            
                if (data[i] > data[i + 1]) {
                
                    int temp = data[i];
                    
                    data[i] = data[i + 1];
                    
                    data[i + 1] = temp;
                
                }
            
            }
        
        }
    
    }

    public static void bubbleRec(int[] data, int pass) {
     
        int n = data.length;
        
        if (pass < data.length) {
        
            for (int i = 0; i < n - pass; i++) {
            
                if (data[i] > data[i + 1]) {
                
                    int temp = data[i];
                    
                    data[i] = data[i + 1];
                    
                    data[i + 1] = temp;
                
                }
            
            }
            
            bubbleRec(data, pass + 1);
        
        }
    
    }

    public static void BubbleIterMod(int[] data) {
    
        int n = data.length;
        
        boolean swapped;
        
        for (int pass = 1; pass < n; pass++) {
        
            swapped = false;
            
            for (int i = 0; i < n - pass; i++) {
            
                if (data[i] > data[i + 1]) {
                
                    swapped = true;
                    
                    int temp = data[i];
                    
                    data[i] = data[i + 1];
                    
                    data[i + 1] = temp;
                
                }
            
            }
            
            if (!swapped) {
            
                break;
            
            }
        
        }
    
    }

    public static void BubbleRecMod(int[] data, int pass) {
    
        int n = data.length;
        
        boolean swapped = false;
        
        if (pass < data.length) {
        
            for (int i = 0; i < n - pass; i++) {
            
                if (data[i] > data[i + 1]) {
                
                    swapped = true;
                    
                    int temp = data[i];
                    
                    data[i] = data[i + 1];
                    
                    data[i + 1] = temp;
                
                }
            
            }
            
            if (swapped) {
            
                bubbleRec(data, pass + 1);
            
            }
        
        }
    
    }

}