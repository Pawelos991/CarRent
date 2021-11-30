package pl.polsl.lab;

import java.util.Scanner;

/**
 * Application reads a text from the console and prints it on the screen.
 * 
 * @author Gall Anonim
 * @version 1.1
 */
public class ConsoleUserInterface {

    /**
     * Gets a string from standard input using the scanner objet, then prints the text on standard output.
     *
     * @param args command line parameters
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String login = scanner.next();
        System.out.println("Hello " + login);
    }
}
