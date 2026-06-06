package _06_Intro_To_Hash_Maps;

import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class _02_LogSearch {
    /*
     * Crate a HashMap of Integers for the keys and Strings for the values.
     * Create a GUI with three buttons.
     * Button 1: Add Entry
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      After an ID is entered, use another input dialog to ask the user
     *      to enter a name. Add this information as a new entry to your
     *      HashMap.
     * 
     * Button 2: Search by ID
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      If that ID exists, display that name to the user.
     *      Otherwise, tell the user that that entry does not exist.
     * 
     * Button 3: View List
     *      When this button is clicked, display the entire list in a message
     *      dialog in the following format:
     *      ID: 123  Name: Harry Howard
     *      ID: 245  Name: Polly Powers
     *      ID: 433  Name: Oliver Ortega
     *      etc...
     * 
     * When this is complete, add a fourth button to your window.
     * Button 4: Remove Entry
     *      When this button is clicked, prompt the user to enter an ID using
     *      an input dialog.
     *      If this ID exists in the HashMap, remove it. Otherwise, notify the
     *      user that the ID is not in the list.
     */
	public static void main(String[] args) {
		
	}
	
	JFrame frame = new JFrame(); 
	JPanel panel = new JPanel(); 
	JButton buttonOne = new JButton("Add Entry"); 
	JButton buttonTwo = new JButton("Search by ID"); 
	JButton buttonThree = new JButton("View List"); 
	JButton buttonFour = new JButton("Remove Entry"); 

	HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
	
	void run() {
		frame.setVisible(true);
		frame.add(panel); 
		panel.add(buttonOne); 
		panel.add(buttonTwo); 
		panel.add(buttonThree); 
		panel.add(buttonFour); 
		
		frame.pack(); 
		
		

	}
	

}
