/**
 * Radiobuttons.java 
 *
 * Class to represent radio buttons
 *
 * @author aca14he
 */


package uk.ac.sheffield.aca14he;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class Radiobuttons extends JPanel
implements ActionListener {

	//creating radio buttons for choosing the player types
	protected JComponent RadioButtons() {
		//Create the radio buttons.
		JRadioButton human = new JRadioButton("Human");
		human.setActionCommand("Human");
		human.setSelected(true);

		JRadioButton random = new JRadioButton("Random");
		random.setActionCommand("Random");

		JRadioButton aggressive = new JRadioButton("Aggressive");
		aggressive.setActionCommand("Aggressive");

		//Group the radio buttons.
		ButtonGroup group = new ButtonGroup();
		group.add(human);
		group.add(random);
		group.add(aggressive);    

		//Add a listener for the radio buttons.
		human.addActionListener(this);
		random.addActionListener(this);
		aggressive.addActionListener(this);

		//Put the radio buttons in a column in a panel.
		JPanel radioPanel = new JPanel(new GridLayout(0, 1));
		radioPanel.add(human);
		radioPanel.add(random);
		radioPanel.add(aggressive);

		add(radioPanel, BorderLayout.EAST);
		setBorder(BorderFactory.createEmptyBorder(50,50,50,50));

		return null;
	}
	// Listens to the radio buttons
	public void actionPerformed(ActionEvent e) {

	}

	private static void showGUI(){
		//Create and set up the window.
		JFrame window = new JFrame("Choosing the type of player");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Create and set up the content pane.
		JComponent newContentPane = new Radiobuttons();
		newContentPane.setOpaque(true); 
		window.setContentPane(newContentPane);

		//Display the window.
		window.pack();
		window.setVisible(true);
	}

	//testing graphical display alone
	public static void main(String[] arg) {
		Board b = new Board();
		Pieces white = new Pieces(b, 1);
		Pieces black = new Pieces(b,0);
		GraphicalDisplay userInterface = new GraphicalDisplay();
		userInterface.showPiecesOnBoard(b.getData());
		//show the radio buttons
		showGUI();

	}
}
