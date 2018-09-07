/**
 * Decimal Class
 *
 * @author Drew Theis
 * @date 9/5/2018
 */

import java.util.*;
import java.io.*;

public class Decimal {

    private final static int MAXNUM = 2147483647;
    private final static int MINNUM = 0;
    private PrintWriter pw;
    private Scanner scan;
    private boolean valid = false;
    private int dec;
    private StringBuilder bin;
    private String hex;

    /**
     * Constructor
     * @param pw PrintWriter will be used to write output to file
     */
    public Decimal(PrintWriter pw) {
        this.pw = pw;
        scan = new Scanner(System.in);
        dec = 0;
    }
    /**
     * Executes the conversion between Decimal and Binary
     */
    void decToBin() {
        inputDec();
        toBin();
        outBin();
    }
    /**
     * Prompts user for a Decimal value and reads the user input
     */
    private void inputDec() {
        do {
            System.out.println("Enter a valid integer to convert: ");
            pw.println("Enter a valid integer to convert: ");
            dec = scan.nextInt();
            if (dec > MINNUM && dec < MAXNUM) {
                System.out.println("User inputted: " + dec + "\n");
                pw.println("User inputted: " + dec + "\n");
                valid = true;
            }
            else if (hex.matches("exit")) {
                break;
            }
            else {
                System.out.println("Invalid entry please reenter a decimal number" +
                        " or type \"exit\" to go back to the main menu\n");
                pw.println("Invalid entry please reenter a decimal number" +
                        " or type \"exit\" to go back to the main menu\n");
                valid = false;
            }
        } while (valid == false);
    }
    /**
     * Contains the logic for Decimal to Binary conversion
     * Prints out the resulting decimal value to the console
     */
    private void toBin() {
        bin = new StringBuilder("");

        int binValue, holdValue;
        int value = dec;

        while (value != 0) {
            holdValue = value / 2;
            binValue = value % 2;
            bin.insert(0, binValue);
            value = holdValue;
        }
    }
    /**
     * Writes the resulting binary value to the file "csis.txt"
     */
    private void outBin() {
        System.out.println("Your binary value is: " + bin + "\n");
        pw.println("Your binary value is: " + bin + "\n");
    }
    /**
     * Executes the conversion between Decimal and Hexadecimal
     */
    void decToHex() {
        inputDec();
        toHex();
        outHex();
    }
    /**
     * Contains the logic for Decimal to Hexadecimal conversion
     * Prints out the resulting binary value to the console
     */
    private void toHex() {
        hex = "";
        while (dec != 0) {
            int hexValue = dec % 16;
            char hexVal;

            if (hexValue <= 9 && hexValue >= 0) {
                hexVal = (char) (hexValue + '0');
            }
            else {
                hexVal = (char) (hexValue - 10 + 'A');
            }
            hex = hexVal + hex;
            dec /= 16;
        }
    }
    /**
     * Writes the resulting hexadecimal value to the file "csis.txt"
     */
    private void outHex() {
        System.out.println("Your hexadecimal value is: 0x" + hex + "\n");
        pw.println("Your hexadecimal value is: 0x" + hex + "\n");
    }
}