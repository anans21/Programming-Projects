/**
 *
 * @author Sameer Anand
 * 
 */

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;

public class TopN {

    int n;
    
    LinkedList<File> files;
    
    FileComparator fileComparator;

    public TopN(int n, FileComparator fileComparator) {

        this.n = n;
    
        this.fileComparator = fileComparator;
        
        files = new LinkedList<File>();
    
    }

    public void addFile(File file) {
    
        files.add(file);
        
        Collections.sort(files, fileComparator);
        
        if (files.size() > n) {
        
            files.removeLast();
        
        }
    
    }

    public int getN() {
    
        return n;
    
    }

    public void setN(int n) {
    
        this.n = n;
    
    }

    LinkedList<File> getTopNFiles() {
    
        return files;
    
    }

}