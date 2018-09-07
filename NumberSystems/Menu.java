/**
 * Menu Class
 *
 * @author Drew Theis
 * @date 9/5/2018
 */

import java.util.*;
import java.io.*;

public class Menu {
    
    private final static int MIN = 1;
    private final static int MAX = 7;
    private Scanner scan;
    private PrintWriter pw;
    private int choiceNum;
    private boolean valid = false;

    /**
     * Constructor
     * @param pw PrintWriter will be used to write output to file
     */
    public Menu(PrintWriter pw) {
        this.pw = pw;
    }
    /**
     * Displays the menu screen to the user on the console.
     * Also writes the menu screen to the file "csis.txt".
     */
    protected void display() {
        System.out.println("Select one of the following operations: \n\n" +
                "1) Decimal to Binary \n" +
                "2) Decimal to Hexadecimal \n" +
                "3) Binary to Decimal \n" +
                "4) Binary to Hexadecimal \n" +
                "5) Hexadecimal to Decimal \n" +
                "6) Hexadecimal to Binary \n" +
                "7) Quit Program");
        pw.println("Select one of the following operations: \n\n" +
                "1) Decimal to Binary \n" +
                "2) Decimal to Hexadecimal \n" +
                "3) Binary to Decimal \n" +
                "4) Binary to Hexadecimal \n" +
                "5) Hexadecimal to Decimal \n" +
                "6) Hexadecimal to Binary \n" +
                "7) Quit Program");
    }
    /**
     * Reads the users selection as to which operation they would like to execute.
     */
    int getSelection() {
        do {
            scan = new Scanner(System.in);
            choiceNum = scan.nextInt();
            if (choiceNum >= MIN && choiceNum <= MAX){
                System.out.println("User executed operation: " + choiceNum + "\n");
                pw.println("User executed operation: " + choiceNum + "\n");
                valid = true;
            } 
            else {
                System.out.println("Invalid entry please reenter option number");
                pw.println("Invalid entry please reenter option number");
            }
        } while (valid == false);
        return choiceNum;
    }
}