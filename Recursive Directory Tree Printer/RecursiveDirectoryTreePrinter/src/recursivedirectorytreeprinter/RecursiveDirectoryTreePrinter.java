// Prints the contents of an entire directory tree.

package recursivedirectorytreeprinter;

import java.io.File;

/**
 *
 * @author      Sameer Anand
 * @created     May 21, 2014
 * @modified    May 21, 2014
 * 
 */

public final class RecursiveDirectoryTreePrinter {
    
    // Two spaces will be used for indentiation and formatting.
    
    private static final String SPACES = "  ";

    public static void main(String[] args) {
        
        assert args != null : "args can't be null";
        
        if (args.length != 1) {
            
            // Requires the name of a single directory or file to be passed on the command line.
            
            System.err.println("Usage: RecursiveDirectoryTreePrinter <dir>");
            
            System.exit(4);
            
        }
        
        print(new File(args[0]), "");
        
    }
    
    // Accepts a single File and a String that will be used when indenting the output.
    
    public static void print(File file, String indent) {
        
        assert file     != null     : "file can't be null";
        assert indent   != null     : "indent can't be null";
        
        // Print the first indentation, followed by the name of the file and a new line.
        
        System.out.print(indent);
        System.out.println(file.getName());
        
        // If the file represents a directory, call the other print method to process the list
        // of files contained within and the indentation.
        
        if (file.isDirectory()) {
        
            print(file.listFiles(), indent + SPACES);
        
        }
        
    }
    
    public static void print(File[] files, String indent) {
        
        assert files != null : "files can't be null";
        
        for (int i = 0; i < files.length; ++i) {
            
            // This method iterates over the array, calling the original print() method for each file.
            
            print(files[i], indent);
            
        }
        
    }
    
}