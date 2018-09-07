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
    private String bin = "";
    private int dec = 0;
    private StringBuilder hex;

    /**
     * Constructor
     * @param pw used to write output to file csis.txt
     */
    public Binary(PrintWriter pw) {
        this.pw = pw;
        scan = new Scanner(System.in);
    }
    /**
     * Method binToDec
     * converts bin to dec and call respected methods for operation
     */
    public void binToDec() {
        inputBin();
        toDec();
        outDec();
    }
    /**
     * Method inputBin
     * @param prompts user for bin input and requires valid input
     * prints repsonses to console and csis.txt
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
     * Method toDec
     * @param convert bin to dec
     */
    private void toDec() {
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) == '1')
                dec += Math.pow(2, bin.length() - 1 - i);
        }
    }
    /**
     * Method outDec
     * @param prints result of conversion to console and csis.txt
     */
    private void outDec() {
        System.out.println("Your decimal value is: " + dec + "\n");
        pw.println("Your decimal value is: " + dec + "\n");
    }
    /**
     * Method binToHex
     * converts bin to hex and call respected methods for operation
     */
    public void binToHex() {
        inputBin();
        toHex();
        outHex();
    }
    /**
     * Method toHex
     * @param convert bin to dec
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
     * Method outHex
     * @param prints result of conversion to console and csis.txt
     */
    private void outHex() {
        System.out.println("Your hexadecimal value is: 0x" + hex.toString() + "\n");
        pw.println("Your hexadecimal value is: 0x" + hex.toString() + "\n");
    }
}