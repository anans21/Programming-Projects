/**
 *
 * @author Sameer Anand
 * 
 */

import java.io.File;

public class ScanFolders {

    public void scan(File f, TopN t) {
        
        if (f.isDirectory()) {
        
            File[] files = f.listFiles();
            
            for (File file : files) {
                
                // System.out.println("Adding Folder: " + file.getName());
                
                scan(file, t);
            
            }
        
        } else {

            // System.out.println("Adding File: " + f.getName());

            t.addFile(f);
        
        }
    
    }

    //For testing
    
    public static void main(String[] args) {
    
        ScanFolders main = new ScanFolders();
        
        File file = new File("src");//Enter a file path
        
        TopN topN = new TopN(5, new FileComparator());

        main.scan(file, topN);

        System.out.println("---------Top Files-----------");
        
        for (File temp : topN.getTopNFiles()) {
        
            System.out.println(temp.getName() + " : " + temp.length());
        
        }
    
    }

}