/**
 * Binary Class
 *
 * @author Drew Theis
 * @date 9/5/2018
 */

import java.util.*;
import java.io.*;

public class Binary {
    private final static int BITS = 32;
    private PrintWriter pw;
    private Scanner scan;
    private boolean valid = false;
    private String bin;
    private int dec;
    private StringBuilder hex;

    /**
     * Constructor
     * @param pw will be used to write output to file
     */
    public Binary(PrintWriter pw) {
        this.pw = pw;
        scan = new Scanner(System.in);
        bin = "";
    }
    /**
     * Executes the conversion between Binary and Decimal
     */
    void binToDec() {
        inputBin();
        toDec();
        outDec();
    }
    /**
     * Prompts user for a Binary value and reads the user inpu
     */
    private void inputBin() {
        do {
            System.out.println("Enter a 32-bit binary number to convert: ");
            pw.println("Enter a 32-bit binary number to convert: ");
            bin = scan.next();
            if (bin.length() == BITS && bin.matches("[01]+")) {
                System.out.println("User inputted: " + bin + "\n");
                pw.println("User inputted: " + bin + "\n");
                valid = true;
            }
            else if (bin.matches("exit")) {
                break;
            }
            else {
                System.out.println("Invalid entry please reenter a 32-bit binary number" +
                    " or type \"exit\" to go back to the main menu\n");
                pw.println("Invalid entry please reenter a 32-bit binary number" +
                    " or type \"exit\" to go back to the main menu\n");
                valid = false;
            }
        } while (valid == false);
    }
    /**
     * Contains the logic for Binary to Decimal conversion
     * Prints out the resulting decimal value to the console
     */
    private void toDec() {
        dec = 0;
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) == '1')
                dec += Math.pow(2, bin.length() - 1 - i);
        }
    }
    /**
     * Writes the resulting decimal value to the file "csis.txt"
     */
    private void outDec() {
        System.out.println("Your decimal value is: " + dec + "\n");
        pw.println("Your decimal value is: " + dec + "\n");
    }
    /**
     * Executes the conversion between Binary and Hexadecimal
     */
    void binToHex() {
        inputBin();
        toHex();
        outHex();
    }
    /**
     * Contains the logic for Binary to Hexadecimal conversion
     * Prints out the resulting decimal value to the console
     */
    private void toHex() {
        hex = new StringBuilder("00000000");
        for (int i = 0, j = 0; i < bin.length() - 3; i += 4 , j++) {
            if (bin.substring(i, i + 4).equals("0000"))
                hex.setCharAt(j,'0');
            else if (bin.substring(i, i + 4).equals("0001"))
                hex.setCharAt(j,'1');
            else if (bin.substring(i, i + 4).equals("0010"))
                hex.setCharAt(j,'2');
            else if (bin.substring(i, i + 4).equals("0011"))
                hex.setCharAt(j,'3');
            else if (bin.substring(i, i + 4).equals("0100"))
                hex.setCharAt(j,'4');
            else if (bin.substring(i, i + 4).equals("0101"))
                hex.setCharAt(j,'5');
            else if (bin.substring(i, i + 4).equals("0110"))
                hex.setCharAt(j,'6');
            else if (bin.substring(i, i + 4).equals("0111"))
                hex.setCharAt(j,'7');
            else if (bin.substring(i, i + 4).equals("1000"))
                hex.setCharAt(j,'8');
            else if (bin.substring(i, i + 4).equals("1001"))
                hex.setCharAt(j,'9');
            else if (bin.substring(i, i + 4).equals("1010"))
                hex.setCharAt(j,'A');
            else if (bin.substring(i, i + 4).equals("1011"))
                hex.setCharAt(j,'B');
            else if (bin.substring(i, i + 4).equals("1100"))
                hex.setCharAt(j,'C');
            else if (bin.substring(i, i + 4).equals("1101"))
                hex.setCharAt(j,'D');
            else if (bin.substring(i, i + 4).equals("1110"))
                hex.setCharAt(j,'E');
            else if (bin.substring(i, i + 4).equals("1111"))
                hex.setCharAt(j,'F');
        }
    }
    /**
     * Writes the resulting hexadecimal value to the file "csis.txt
     */
    private void outHex() {
        System.out.println("Your hexadecimal value is: 0x" + hex.toString() + "\n");
        pw.println("Your hexadecimal value is: 0x" + hex.toString() + "\n");
    }
}