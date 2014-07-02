package compiler;

/**
 *
 * @author Sameer Anand
 * 
 */

import java.util.HashMap;
import java.util.Map;

public class VarToken extends Token {

    String name;

    public static final Map<String, Integer> SYMTAB = new HashMap<>();

    public VarToken(String name) {
    
        this.name = name;
    
    }

    void assign(int value) {
    
        SYMTAB.put(this.name, value);
    
    }

    @Override
    public int eval() {
    
        return SYMTAB.get(this.name);
    
    }

    @Override
    public String toString() {
    
        return "VAR:" + name + "->" + eval();
    
    }

    public static void main(String[] args) {
        
        VarToken varToken = new VarToken("a");
    
        varToken.assign(10);

        if (varToken.eval() == 10) {
        
            System.out.println("TEST PASSED");
        
        } else {
        
            System.out.println("TEST FAILED");
        
        }
    
    }

}