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
    private boolean valid = true;
    private int dec = 0;
    private StringBuilder bin;
    private String hex;

    /**
     * Constructor
     * @param pw used to write output to file csis.txt
     */
    public Decimal(PrintWriter pw) {
        this.pw = pw;
        scan = new Scanner(System.in);
    }
    /**
     * Method decToBin
     * converts dec to bin and call respected methods for operation
     */
    public void decToBin() {
        inputDec();
        toBin();
        outBin();
    }
    /**
     * Method inputDec
     * @param prompts user for dec input and requires valid input
     * prints repsonses to console and csis.txt
     */
    private void inputDec() {
        do {
            System.out.println("Enter a valid integer to convert: ");
            pw.println("Enter a valid integer to convert: ");
            dec = scan.nextInt();
            if (dec > MINNUM && dec < MAXNUM) {
                System.out.println("User inputted: " + dec + "\n");
                pw.println("User inputted: " + dec + "\n");
                valid = false;
            }
            else if (hex.matches("exit")) {
                break;
            }
            else {
                System.out.println("Invalid entry please reenter a decimal number" +
                        " or type \"exit\" to go back to the main menu\n");
                pw.println("Invalid entry please reenter a decimal number" +
                        " or type \"exit\" to go back to the main menu\n");
            }
        } while (valid);
    }
    /**
     * Method toBin
     * @param convert dec to bin
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
     * Method outBin
     * @param prints result of conversion to console and csis.txt
     */
    private void outBin() {
        System.out.println("Your binary value is: " + bin + "\n");
        pw.println("Your binary value is: " + bin + "\n");
    }
    /**
     * Method decToHex
     * converts dec to bin and call respected methods for operation
     */
    public void decToHex() {
        inputDec();
        toHex();
        outHex();
    }
    /**
     * Method toHex
     * @param convert dec to hex
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
     * Method outHex
     * @param prints result of conversion to console and csis.txt
     */
    private void outHex() {
        System.out.println("Your hexadecimal value is: 0x" + hex + "\n");
        pw.println("Your hexadecimal value is: 0x" + hex + "\n");
    }
}