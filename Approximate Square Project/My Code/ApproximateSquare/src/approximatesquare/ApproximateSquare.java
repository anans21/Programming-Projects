package approximatesquare;

/**
 *
 * @author Sameer Anand
 * 
 */

public class ApproximateSquare {
    
    public static void main(String[] args) {
        
        // Take the square roots of: 49, 64, 101, 0
        
        sqrt(49);       // Should return 7.0
        
        sqrt(64);       // Should return 8.0
        
        sqrt(101);      // Should return 10.0498756211
        
        sqrt(0);        // Should return 0

    }

    public static double sqrt(long n) {
        
        double nextGuess = n, lastGuess = 0;
        
        /* 
         * If the difference between nextGuess and lastGuess is less than a very
         * small number, then nextGuess is the approximated square root of
         * parameter n. If not, then nextGuess becomes lastGuess + nextGuess / 2
         * and lastGuess becomes n / nextGuess.
         * 
         */

        while (Math.abs(nextGuess - lastGuess) > 0.000000000001) {
            
            nextGuess = (lastGuess + nextGuess) / 2;
            
            lastGuess = n / nextGuess;
        
        }
        
        System.out.println("The square root of " + n + " is: " + nextGuess);
        
        return nextGuess;

    }

}