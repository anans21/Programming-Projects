package compiler;

/**
 *
 * @author Sameer Anand
 * 
 */

public class LitToken extends Token {

    int value;

    public LitToken(int value) {

        this.value = value;
    
    }

    @Override
    public int eval() {
    
        return value;
    
    }

    @Override
    public String toString() {
    
        return "LIT: " + eval();
    
    }

    public static void main(String[] args) {
        
        LitToken litToken= new LitToken(10);
        
        if(litToken.eval()==10){
        
            System.out.println("TEST PASSED");
        
        } else {
        
            System.out.println("TEST FAILED");
        
        }
        
    }

}