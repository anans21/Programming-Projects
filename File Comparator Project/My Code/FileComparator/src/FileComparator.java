/**
 *
 * @author Sameer Anand
 * 
 */

import java.io.File;
import java.util.Comparator;

public class FileComparator implements Comparator<Object> {

    @Override
    public int compare(Object o1, Object o2) {

        File f1 = (File) o1;
        
        File f2 = (File) o2;

        // Files are sorted in descending order of the file sizes
        
        if (f1.length() < f2.length()) {
        
            return 1;
        
        } else if (f1.length() > f2.length()) {
        
            return -1;
        
        } else {
        
            return 0;
        
        }
    
    }

}