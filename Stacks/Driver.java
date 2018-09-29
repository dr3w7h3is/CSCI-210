/**
 * CSCI 210 - Lab 2 - Stacks
 * @author Drew Theis
 * Palomar ID: 011701349
 * @date 9/27/2018
 */

import java.io.*;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws IOException {
        /**
         * main expression
         * for setting variables and converting InfixToPostfix solving EvalPostfix
         * to give solution
         */
        Scanner sc = new Scanner(new File("infix.txt"));
        PrintWriter fw = new PrintWriter(new FileWriter("csis.txt"));
        InfixToPostfix inToPost = new InfixToPostfix();
        EvalPostfix eval = new EvalPostfix();
        // Loop to operate scanning infix.txt
        while (sc.hasNext()) {
            String input = sc.nextLine();
            // Prints the expression scanned to console
            System.out.println("The given expression: " + input);
            // Prints the expression scanned to text file csis.txt
            fw.println("The given expression: " + input);
            // Sets String eval to the input
            String toEval = inToPost.infixToPostfix(input);
            // Prints the postfix expression to console
            System.out.println("Postfix notation for expression " + " is: " + toEval);
            // Prints the postfix expression to text file csis.txt
            fw.println("Postfix notation for expression " + " is: " + toEval);
            // Declares integer evaluated
            int evaluated = eval.evaluate(toEval);
            // Prints the solved solution to console
            System.out.println("Its corresponding evaluation is: " + evaluated + "\n");
            // Prints the solved solution to text file csis.txt
            fw.println("Its corresponding evaluation is: " + evaluated + "\n");
        }
        // closes scanner and file writer
        sc.close();
        fw.close();
    }
}