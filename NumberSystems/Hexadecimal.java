 /**
 * Hexadecimal Class
 *
 * @author Drew Theis
 * @date 9/5/2018
 */

import java.util.*;
import java.io.*;

public class Hexadecimal {

    private final static int BITS = 8;
    private PrintWriter pw;
    private Scanner scan;
    private boolean valid = false;
    private String hex;
    private StringBuilder bin;
    private int dec = 0;
    private String HEXREF = "0123456789ABCDEF";

    /**
     * Constructor
     * @param pw PrintWriter will be used to write output to file
     */
    public Hexadecimal(PrintWriter pw) {
        this.pw = pw;
        scan = new Scanner(System.in);
        hex = "";

    }
    /**
     * Executes the conversion between Hexadecimal and Decimal
     */
    void hexToDec() {
        inputHex();
        toDec();
        outDec();
    }
    /**
     * Prompts user for a Hexadecimal value and reads the user input
     */
    private void inputHex() {
        do {
            System.out.println("Enter a 8 character Hexadecimal number to convert: ");
            pw.println("Enter a 8 character Hexadecimal number to convert: ");
            hex = scan.next();
            hex.toUpperCase();
            if (hex.length() == BITS && hex.matches("[0-9A-F]+")) {
                System.out.println("User inputted: " + hex + "\n");
                pw.println("User inputted: " + hex + "\n");
                valid = true;
            }
            else if (hex.matches("exit")) {
                break;
            }
            else {
                System.out.println("Invalid entry please reenter a 8 character hexadecimal number" +
                        " or type \"exit\" to go back to the main menu\n");
                pw.println("Invalid entry please reenter a 8 character hexadecimal number" +
                        " or type \"exit\" to go back to the main menu\n");
                valid = false;
            }
        } while (valid == false);
    }
    /**
     * Contains the logic for Hexadecimal to Decimal conversion
     * Prints out the resulting decimal value to the console
     */
    private void toDec() {
        int expo = 0;
        char hexValue;
        for (int i = 0; i < hex.length(); i++) {
            hexValue = hex.charAt(hex.length() - i - 1);
            dec += HEXREF.indexOf(hexValue) * (int) Math.pow(16, expo);
            expo++;
        }
    }
    /**
     * Writes the resulting decimal value to the file "csis.txt"
     */
    private void outDec() {
        System.out.println("Decimal value is: " + dec + "\n");
        pw.println("Decimal value is: " + dec + "\n");
    }
    /**
     * Executes the conversion between Hexadecimal and Binary
     */
    void hexToBin() {
        inputHex();
        toBin();
        outBin();
    }
    /**
     * Contains the logic for Hexadecimal to Binary conversion
     * Prints out the resulting binary value to the console
     */
    private void toBin() {
        bin = new StringBuilder("");

        for (int i = 0; i < hex.length(); i++) {
            if (hex.substring(i, i + 1).equals("0"))
                bin.append("0000");
            else if (hex.substring(i, i + 1).equals("1"))
                bin.append("0001");
            else if (hex.substring(i, i + 1).equals("2"))
                bin.append("0010");
            else if (hex.substring(i, i + 1).equals("3"))
                bin.append("0011");
            else if (hex.substring(i, i + 1).equals("4"))
                bin.append("0100");
            else if (hex.substring(i, i + 1).equals("5"))
                bin.append("0101");
            else if (hex.substring(i, i + 1).equals("6"))
                bin.append("0110");
            else if (hex.substring(i, i + 1).equals("7"))
                bin.append("0111");
            else if (hex.substring(i, i + 1).equals("8"))
                bin.append("1000");
            else if (hex.substring(i, i + 1).equals("9"))
                bin.append("1001");
            else if (hex.substring(i, i + 1).equals("A"))
                bin.append("1010");
            else if (hex.substring(i, i + 1).equals("B"))
                bin.append("1011");
            else if (hex.substring(i, i + 1).equals("C"))
                bin.append("1100");
            else if (hex.substring(i, i + 1).equals("D"))
                bin.append("1101");
            else if (hex.substring(i, i + 1).equals("E"))
                bin.append("1110");
            else if (hex.substring(i, i + 1).equals("F"))
                bin.append("1111");
        }
    }
    /**
     * Writes the resulting binary value to the file "csis.txt"
     */
    private void outBin() {
        System.out.println("Your binary value is: " + bin + "\n");
        pw.println("Your binary value is: " + bin + "\n");
    }
}