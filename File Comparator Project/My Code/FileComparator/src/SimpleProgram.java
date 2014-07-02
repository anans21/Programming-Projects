/**
 *
 * @author Sameer Anand
 * 
 */

import java.io.File;
import java.io.FileFilter;

public class SimpleProgram {

    //To test the FileComparator and TopN classess
    public static void main(String[] args) {

        FileComparator comparator = new FileComparator();
    
        TopN topN = new TopN(2, comparator);

        File path = new File("src");

        File[] files = path.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
        
                if (pathname.isDirectory()) {
                
                    return false;
                
                } else {
                
                    return true;
                
                }
            
            }
        
        });

        for (File file : files) {

            topN.addFile(file);
        
        }

        System.out.println("\nLargest 2 files:\n");

        for (File file : topN.getTopNFiles()) {
        
            System.out.println(file.getName() + " : " + file.length() + " bytes");
        
        }
        
        System.out.println("");

    }

}