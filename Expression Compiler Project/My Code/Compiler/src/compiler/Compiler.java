package compiler;

/**
 *
 * @author Sameer Anand
 * 
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Compiler {

    private static boolean DEBUG = false;

    public static final Map<Character, Integer> OPR_PRIO;

    static {
        OPR_PRIO = new HashMap<>();
        OPR_PRIO.put(')', 5);
        OPR_PRIO.put('^', 4);
        OPR_PRIO.put('*', 3);
        OPR_PRIO.put('/', 3);
        OPR_PRIO.put('%', 3);
        OPR_PRIO.put('+', 2);
        OPR_PRIO.put('-', 2);
        OPR_PRIO.put('=', 1);
        OPR_PRIO.put('(', 0);
    }

    // Stacks for processing infix operands and operators.
    
    Stack<Token> operands = new Stack<>();
    
    Stack<OprToken> operators = new Stack<>();

    private void start() {

        Scanner inp = new Scanner(System.in);

        String orig, line;

        while (inp.hasNextLine()) {
            
            orig = inp.nextLine();

            if (orig.length() < 1) {
              
                continue;
            
            }
            
            line = orig.replaceAll("([-+*/%^()=])", " $1 ");

            // System.out.println("Line: " + line);
            
            String[] tokens = line.split("\\s+");

            // System.out.println("Tokens: ");
            
            for (String token : tokens) {

                // System.out.println(token);
                
                char first = token.charAt(0);

                if ("-+*/%^(=".contains(first + "")) {
                
                    // System.out.println("OPERATOR--------------------------------");

                    OprToken oprToken = new OprToken(first);

                    char topOpr = '\0';

                    if (!operators.empty()) {
                    
                        topOpr = (char) operators.peek().eval();
                    
                    }

                    if (topOpr == '\0') {
                     
                        operators.push(new OprToken(first));
                    
                    } else {
                        
                        if (OPR_PRIO.get(first) > OPR_PRIO.get(topOpr)) {

                            // System.out.println(first + ">" + topOpr);

                            // System.out.println("ADDING TO THE STACK");
                            
                            operators.add(oprToken);
                        
                        } else {

                            // System.out.println(first + "<=" + topOpr);
                            
                            if (first == '(') {

                                // System.out.println("( found");
                                
                                operators.add(oprToken);
                            
                            } else {

                                if (topOpr == '=') {

                                    // System.out.println("topOpr == '='");
                                    
                                    Token top = operands.pop();
                                    
                                    VarToken varToken = ((VarToken) operands.pop());
                                    
                                    varToken.assign(top.eval());

                                    // System.out.println("VarToken: " + varToken);
                                    
                                    operands.push(varToken);
                                    
                                    operators.pop();
                                
                                } else {

                                    // System.out.println("topOpr == '='");

                                    Token secondToken = operands.pop();
                                    
                                    Token firstToken = operands.pop();

                                    operators.pop();

                                    // System.out.println("PERFORM CALCULATION");
                                    
                                    ExprToken exprToken = new ExprToken(firstToken, topOpr, secondToken);

                                    // System.out.println("EXPRESSION: " + exprToken);
                                    
                                    int value = exprToken.eval();

                                    // System.out.println("TEMP VALUE: " + value);
                                    
                                    LitToken litToken = new LitToken(value);
                                    
                                    operands.push(litToken);
                                    
                                    operators.push(new OprToken(first));
                                
                                }

                            }

                            // System.out.println("<");
                        
                        }
                    
                    }

                } else if (first == ')') {

                    // System.out.println("OPERATOR )------------------------------");

                    char topOpr = (char) operators.pop().eval();

                    while (topOpr != '(') {

                        // System.out.println("CALCULATING THE VALUE IN ( ) ");

                        // char topOpr = (char) operators.pop().eval();
                        
                        if (topOpr == '=') {
                        
                            Token top = operands.pop();
                            
                            VarToken varToken = ((VarToken) operands.pop());
                            
                            varToken.assign(top.eval());

                            // System.out.println("VarToken: " + varToken);
                            
                            operands.push(varToken);
                        
                        } else {
                        
                            Token secondToken = operands.pop();
                            
                            Token firstToken = operands.pop();

                            // System.out.println("PERFORM CALCULATION");
                            
                            ExprToken exprToken = new ExprToken(firstToken, topOpr, secondToken);

                            // System.out.println("EXPRESSION: " + exprToken);
                            
                            int value = exprToken.eval();

                            // System.out.println("TEMP VALUE: " + value);
                            
                            LitToken litToken = new LitToken(value);
                            
                            operands.push(litToken);
                        
                        }

                        // if(operators.isEmpty()){
                        //                            
                        // } else {
                        topOpr = (char) operators.pop().eval();
                        // }
                    
                    }

                } else if (Character.isDigit(first)) {

                    // System.out.println("DIGIT-----------------------------------");
                    
                    LitToken litToken = new LitToken(Integer.parseInt(token));
                    
                    operands.add(litToken);

                } else {
                    
                    // Variable
                    
                    // System.out.println("VARIABLE--------------------------------");
                    
                    VarToken varToken = new VarToken(first + "");
                    
                    operands.add(varToken);
                
                }
                
                // System.out.println("Operands: ");
                // print(operands);
                //
                // System.out.println("Operators: ");
                // print(operators);
                // System.out.println("----------------------");
            
            }

            while (!operators.isEmpty()) {

                // System.out.println("OPERANDS LEFT");
                
                char topOpr = (char) operators.pop().eval();

                if (topOpr == '=') {
                
                    Token top = operands.pop();
                    
                    VarToken varToken = ((VarToken) operands.pop());
                    
                    varToken.assign(top.eval());
                    
                    // System.out.println("VarToken: " + varToken);
                    
                    operands.push(varToken);
                
                } else {
                    
                    Token secondToken = operands.pop();
                    
                    Token firstToken = operands.pop();

                    // System.out.println("PERFORM CALCULATION");
                    
                    ExprToken exprToken = new ExprToken(firstToken, topOpr, secondToken);
                    
                    // System.out.println("EXPRESSION: " + exprToken);
                    
                    int value = exprToken.eval();
                    
                    // System.out.println("TEMP VALUE: " + value);
                    
                    LitToken litToken = new LitToken(value);
                    
                    operands.push(litToken);
                
                }
            
            }
            
            //  if (operands.isEmpty() || (operands.size() > 1) || (!operators.isEmpty())) {
            
            if (operands.isEmpty()) {
            
                System.out.println("ERROR 1");
            
            } else if ((operands.size() > 1)) {
            
                System.out.println("ERROR 2");
            
            } else if (!operators.isEmpty()) {
            
                System.out.println("ERROR 3");
            
            } else {

                // System.out.println("VALUE: " + operands.pop().eval());
                
                System.out.println("> " + orig + " => " + operands.pop().eval());
            
            }
            
            // System.out.println("------------------------------------");
        
        }

        // for (OprToken op : operators) {
        //      System.out.println("OP: " + op);      
        // }
    
    }

    //  private void print(Stack stack) {
    //        for (Object o : stack) {
    //            try {
    //                System.out.print(o.toString() + ",");
    //            } catch (Exception e) {
    //                System.out.print("null,");
    //            }
    //
    //        }
    //        System.out.println("");
    //    }
    
    private static void DEBUG(String fmt, Object... args) {
        
        if (DEBUG) {
        
            System.err.printf(fmt, args);
    
        }
    
    }

    private static void REPORT(String fmt, Object... args) {
    
        System.out.printf(fmt, args);
    
    }

    public static void main(String[] args) {

        Compiler compiler = new Compiler();
        
        compiler.start();
    
    }

}