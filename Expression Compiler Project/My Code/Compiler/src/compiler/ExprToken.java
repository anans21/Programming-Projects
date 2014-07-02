package compiler;

/**
 *
 * @author Sameer Anand
 * 
 */

public class ExprToken extends Token {

    Token left;
    
    char opr;
    
    Token right;

    public ExprToken(Token left, char opr, Token right) {
    
        this.left = left;
        
        this.opr = opr;
        
        this.right = right;
    
    }

    int apply(int left, char opr, int right) {

        switch (opr) {
    
            case '+':
            
                return left + right;
            
            case '-':
            
                return left - right;
            
            case '*':
            
                return left * right;
            
            case '/':
            
                return left / right;
            
            case '%':
            
                return left % right;
            
            case '^':
            
                return ipow(left, right);
            
            default:
            
                return 0;
        
        }
    
    }

    // Integer power function (not supplied in library).
    
    private int ipow(int base, int exp) {
        
        int result = 1;
    
        while (exp > 0) {
        
            if ((exp & 1) == 1) {
            
                result *= base;
            
            }
            
            exp >>= 1;
            
            base *= base;
        
        }
        
        return result;
    
    }

    @Override
    public int eval() {
    
        return apply(left.eval(), opr, right.eval());
    
    }

    @Override
    public String toString() {
    
        return "EXPR: " + left + " " + opr + " " + right;
    
    }

    public static void main(String[] args) {
    
        LitToken left = new LitToken(5);
        
        LitToken right = new LitToken(8);

        OprToken operator = new OprToken('+');

        ExprToken exprToken = new ExprToken(left, (char) operator.eval(), right);

        if (exprToken.eval() == 13) {
        
            System.out.println("TEST PASSED");
        
        } else {
        
            System.out.println("TEST FAILED");
        
        }
        
    }

}