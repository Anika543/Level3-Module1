package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
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
	
	
	JFrame frame = new JFrame(); 
	JPanel panel = new JPanel(); 
	JButton addEntry = new JButton("Add Entry"); 
	JButton searchById = new JButton("Search by ID"); 
	JButton viewList = new JButton("View List"); 
	JButton removeEntry = new JButton("Remove Entry"); 

	HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
	
	void run() {
		frame.setVisible(true);
		frame.add(panel); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(addEntry); 
		panel.add(searchById); 
		panel.add(viewList); 
		panel.add(removeEntry); 
		
		addEntry.addActionListener(this); 
		searchById.addActionListener(this);
		viewList.addActionListener(this);
		removeEntry.addActionListener(this);
		
		frame.pack(); 
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == addEntry ) {
			String i = JOptionPane.showInputDialog(null, "Enter an ID number");
			int idNum = Integer.parseInt(i); 
			String name = JOptionPane.showInputDialog(null, "Enter your name"); 
			hashmap.put(idNum, name); 
		}
		if(e.getSource() == searchById) {
			String i = JOptionPane.showInputDialog(null, "Enter an ID number"); 
			int x = Integer.parseInt(i); 
			if(hashmap.containsKey(x)) {
				JOptionPane.showMessageDialog(null, hashmap.get(x));
			}
			else{
				JOptionPane.showMessageDialog(null, "This ID does not exist");
			}
		}
		if(e.getSource() == viewList) {
			String s = ""; 
	        for(Integer i : hashmap.keySet()){
	        	s = s + " \n" + "ID: " + i + "  Name: " + hashmap.get(i); 
	        }
	        JOptionPane.showMessageDialog(null, s);
		}
		if(e.getSource() == removeEntry) {
			String s =JOptionPane.showInputDialog(null, "Enter an ID number"); 
			int x = Integer.parseInt(s); 
			if(hashmap.containsKey(x)) {
				hashmap.remove(x); 
			}else {
				JOptionPane.showMessageDialog(null, "This ID does not exist"); 
			}
		}
		
	}
	

}
