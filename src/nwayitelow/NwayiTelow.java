/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nwayitelow;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class NwayiTelow {
    static String MessageID;
    static String RecipientCell;

    private static void chat() {
        String message = JOptionPane.showInputDialog("Type a message:");
        JOptionPane.showMessageDialog(null, "Recipient Cell: " + RecipientCell + "\nTyped: " + message);
        Object[] options = {"Discard", "Store", "Exit"};
        int choice = JOptionPane.showOptionDialog(null, "What would you like to do with this message?", "Message Options", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        switch (choice) {
            case 0:
                JOptionPane.showMessageDialog(null, "Message discarded.");
                // Code to discard the message
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Message stored.");
                // Code to store the message
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Exiting...");
                // Code to exit
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid choice.");
        }
    }

    public static void main(String[] args) {
        String regex = "^\\+27\\d{9}$";


        Pattern pattern = Pattern.compile(regex);

        MessageID = JOptionPane.showInputDialog("Enter your MessageID");
        RecipientCell = JOptionPane.showInputDialog("Enter your RecipientCell");

        while (true) {
            if (RecipientCell.equals("")) {
                // Show error message for Recipient Cell
                JOptionPane.showMessageDialog(null, "Recipient Cell is required.");
                RecipientCell = JOptionPane.showInputDialog("Enter Recipient Cell:");
            } else if (!pattern.matcher(RecipientCell).matches()) {
                // Show error message for invalid Recipient Cell format
                JOptionPane.showMessageDialog(null, "Invalid Recipient Cell format. Please use the format +27 followed by 9 digits.");
                RecipientCell = JOptionPane.showInputDialog("Enter Recipient Cell:");
            } else if (MessageID.equals("")) {
                // Show error message for Message ID
                JOptionPane.showMessageDialog(null, "Message ID is required.");
                MessageID = JOptionPane.showInputDialog("Enter Message ID:");
            } else if (!MessageID.matches("[a-zA-Z]+")) {
                // Show error message for invalid Message ID (should be alphabets only)
                JOptionPane.showMessageDialog(null, "Invalid Message ID. Please enter alphabets only.");
                MessageID = JOptionPane.showInputDialog("Enter Message ID:");
            } else {
                // Both conditions are true, call chat method
                chat();
                break;
            }
        }
    }
}