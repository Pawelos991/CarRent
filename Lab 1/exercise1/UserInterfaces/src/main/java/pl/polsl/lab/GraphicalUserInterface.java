package pl.polsl.lab;

import javax.swing.JOptionPane;

/**
 * Application reads a text from the graphical window and shows it on the screen.
 *
 * @author Gall Anonim
 * @version 1.1
 */
public class GraphicalUserInterface {

    /**
     * Creates two windows: first is the input dialog, second - the message dialog.
     * 
     * @param args command line parameters not used in the application
     */
    public static void main(String[] args) {
      
        String login = JOptionPane.showInputDialog(null, "What is your name?", 
                "Login", JOptionPane.QUESTION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Hello "+login + "!", 
                "Welcome Message", JOptionPane.INFORMATION_MESSAGE);
    }
}
