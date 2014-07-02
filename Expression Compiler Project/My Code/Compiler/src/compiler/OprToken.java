package compiler;

/**
 *
 * @author Sameer Anand
 * 
 */

public class OprToken extends Token {

    char operator;

    public OprToken(char operator) {
     
        this.operator = operator;
    
    }

    @Override
    public int eval() {
    
        return operator;
    
    }

    @Override
    public String toString() {
    
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    
    }

    public static void main(String[] args) {
        
        OprToken oprToken = new OprToken('<');

        if (oprToken.eval() == (int) '<') {
        
            System.out.println("TEST PASSED");
        
        } else {
        
            System.out.println("TEST FAILED");
        }
        
    }

}
