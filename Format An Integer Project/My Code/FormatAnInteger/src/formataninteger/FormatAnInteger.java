package formataninteger;

/**
 *
 * @author Sameer Anand
 * 
 */

public class FormatAnInteger {
    
    public static void main(String[] args) {
        
        format(9, 10);

    }
    
    /* 
     * The method returns a string for the number with one or more prefix 0s. The
     * size of the string is the width. For example, format(34, 4) returns 0034 and
     * format(34, 5) returns 00034. If the number is longer than the width, the
     * method returns the string representation for the number. For example,
     * format(34, 1) returns 34.
     * 
     */
    
    public static String format(int number, int width) {
        
        // Get the number of digits of the parameter 'number' and save this value.
        
        int length = String.valueOf(number).length();
        
        // Initalize the variable zeros.
        
        int zeros;
        
        /* 
         * If the width parameter is greater than the length of the number 
         * parameter then set zeros equal to the difference of the two. Otherwise
         * set zeros equal to 0 since we don't have any leading zeros to report.
         * 
         */
        
        if (width > length) {
            
            zeros = width - length;
            
        } else zeros = 0;
        
        /* 
         * Create a new StringBuilder instance. We use StringBuilder since it is
         * easier to append objects to strings.
         */
        
        StringBuilder stringBuilder = new StringBuilder();
        
        // Append a new 0 to the string for when i < zeros.
        
        for (int i = 0; i < zeros; i++) {
            
            stringBuilder.append("0");
            
        }
        
        /* 
         * Create the variable finalString and set it equal to the appended 0's
         * string concatenated with the number parameter at the end.
         */
        
        String finalString = stringBuilder.toString() + number;
        
        /* 
         * Finally print the finalString to the console window and return the 
         * finalString.
         */
        
        System.out.println(finalString);
        
        return finalString;
        
    }

}