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
    private final static String HEXREF = "0123456789ABCDEF";
    private PrintWriter pw;
    private Scanner scan;
    private boolean valid = true;
    private String hex = "";
    private StringBuilder bin;
    private int dec = 0;

    /**
     * Constructor
     * @param pw used to write output to file csis.txt
     */
    public Hexadecimal(PrintWriter pw) {
        this.pw = pw;
        scan = new Scanner(System.in);
    }
    /**
     * Method hexToDec
     * converts hex to dec and call respected methods for operation
     */
    public void hexToDec() {
        inputHex();
        toDec();
        outDec();
    }
    /**
     * Method inputHex
     * @param prompts user for hex input and requires valid input
     * prints repsonses to console and csis.txt
     */
    private void inputHex() {
        do {
            System.out.println("Enter a 8 character Hexadecimal number to convert: ");
            pw.println("Enter a 8 character Hexadecimal number to convert: ");
            hex = scan.next();
            hex = hex.toUpperCase();
            if (hex.length() == BITS && hex.matches("[0-9A-F]+")) {
                System.out.println("User inputted: " + hex + "\n");
                pw.println("User inputted: " + hex + "\n");
                valid = false;
            }
            else if (hex.matches("exit")) {
                break;
            }
            else {
                System.out.println("Invalid entry please reenter a 8 character hexadecimal number" +
                        " or type \"exit\" to go back to the main menu\n");
                pw.println("Invalid entry please reenter a 8 character hexadecimal number" +
                        " or type \"exit\" to go back to the main menu\n");
            }
        } while (valid);
    }
    /**
     * Method toDec
     * @param convert hex and dec
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
     * Method outDec
     * @param prints result of conversion to console and csis.txt
     */
    private void outDec() {
        System.out.println("Decimal value is: " + dec + "\n");
        pw.println("Decimal value is: " + dec + "\n");
    }
    /**
     * Method hexToBin
     * converts hex to bin and call respected methods for operation
     */
    public void hexToBin() {
        inputHex();
        toBin();
        outBin();
    }
    /**
     * Method toBin
     * @param convert hex and bin
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
     * Method outBin
     * @param prints result of conversion to console and csis.txt
     */
    private void outBin() {
        System.out.println("Your binary value is: " + bin + "\n");
        pw.println("Your binary value is: " + bin + "\n");
    }
}