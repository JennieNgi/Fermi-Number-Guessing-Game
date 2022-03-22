import javax.swing.JFrame;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import org.w3c.dom.Text;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.util.Arrays;
import java.util.ArrayList;

public class MainFrame extends JFrame{
	private JTextField txtInputOne;
	private TextFieldValidator textFieldValidator1;
	private TextFieldValidator textFieldValidator2;
	private TextFieldValidator textFieldValidator3;
	private JTextField txtInputTwo;
	private JTextField txtInputThree;
	private JTextArea txtOutput;
	private int numberOne;
	private String numberOneStr;
	private int numberTwo;
	private String numberTwoStr;
	private int numberThree;
	private String numberThreeStr;
	private String[] numberArray;
	private String[] inputArray;
	private String hint;
	private int counter = 0;
	private JButton btnOk;
	private JScrollPane scrollPane;
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		this.setResizable(false);
		
		// create random numbers and store in the array
		numberOne = 9;
		numberOneStr = Integer.toString(numberOne);
		numberTwo = 4;
		numberTwoStr = Integer.toString(numberTwo);
		numberThree = 0;
		numberThreeStr = Integer.toString(numberThree);
		
		numberArray = new String[]{numberOneStr, numberTwoStr, numberThreeStr};


		JLabel lblTitle = new JLabel("Fermi Guessing Game");
		
		// -------------------------------------------------------------------------- Input
		txtInputOne = new JTextField();
		txtInputOne.setColumns(10);
	

		txtInputTwo = new JTextField();
		
		txtInputThree = new JTextField();
		txtInputThree.setColumns(10);

		
		// -------------------------------------------------------------------------- Ok Button
		btnOk = new JButton("Ok");
		textFieldValidator1 = new TextFieldValidator(txtInputOne);
		textFieldValidator2 = new TextFieldValidator(txtInputTwo);
		textFieldValidator3 = new TextFieldValidator(txtInputThree);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textFieldValidator1.check();
				if (textFieldValidator1.getErrorStatus() == true) {
					textFieldValidator1.reset();
				}
				
				textFieldValidator2.check();
				if (textFieldValidator2.getErrorStatus() == true) {
					textFieldValidator2.reset();
				}
				
				textFieldValidator3.check();
				if (textFieldValidator3.getErrorStatus() == true) {
					textFieldValidator1.reset();
				}
				
				if (textFieldValidator1.getErrorStatus() == true && textFieldValidator2.getErrorStatus() == true && textFieldValidator3.getErrorStatus() == true) {
					onSubmit(e);
				}
			}
		});
		
		// -------------------------------------------------------------------------- Reset Button
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onReset(e);
			}
		});

		
		JLabel lblSubtitle = new JLabel("Enter your three guesses (0-9):");
		
		JLabel lblHint = new JLabel("Hints");
		
		scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSubtitle, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnOk)
										.addComponent(txtInputThree, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(txtInputTwo, Alignment.LEADING)
											.addComponent(txtInputOne, Alignment.LEADING)))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHint, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
							.addGap(35))
						.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(7)
					.addComponent(lblTitle)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSubtitle)
						.addComponent(lblHint))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtInputOne, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtInputTwo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtInputThree, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnOk)
							.addGap(58)
							.addComponent(btnReset))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
					.addGap(65))
		);
		
		// -------------------------------------------------------------------------- Output
		
		txtOutput = new JTextArea();
		scrollPane.setViewportView(txtOutput);
		getContentPane().setLayout(groupLayout);
	}
	
	// ------------------------------------------- event handlers for Ok button
    private void onSubmit(ActionEvent e) {
    	inputArray = new String[]{txtInputOne.getText(), txtInputTwo.getText(), txtInputThree.getText()};
//    	ArrayList<String> duplicateArray = new ArrayList<String>();
    	hint = "";
    	
    	
    	
    	for (int i = 0; i < 3; i++) {
    		if (numberArray[i].equals(inputArray[i])) {
    			hint = hint + "Fermi" + " ";
    			// do the validation for duplicate input 
    			if (inputArray[i] == inputArray[1]) {
    				if (inputArray[i].equals(inputArray[i-1])) {
    					inputArray[i-1] = "duplicate";
    				}if (inputArray[i].equals(inputArray[i+1])) {
    					inputArray[i+1] = "duplicate";
    				}
    			}
				else if (inputArray[i] == inputArray[0]) {
    				if (inputArray[i].equals(inputArray[i+1])) {
    					inputArray[i+1] = "duplicate";
    				}if (inputArray[i].equals(inputArray[i+2])) {
    					inputArray[i+2] = "duplicate";
    				}
				}
			
				else if (inputArray[i] == inputArray[2]) {
    				if (inputArray[i].equals(inputArray[i-1])) {
    					inputArray[i-1] = "duplicate";
    				}if (inputArray[i].equals(inputArray[i-2])) {
    					inputArray[i-2] = "duplicate";
    				}
				}
    		}
    	}
   
 
    	System.out.println(inputArray[0]);
    	System.out.println(inputArray[1]);
    	System.out.println(inputArray[2]);
    	
    	
    	for (int j = 0; j < 3; j++) {
    		if (!(numberArray[j].equals(inputArray[j])) && 
    				Arrays.asList(numberArray).contains(inputArray[j]) ) {
    			hint = hint + "Pico" + " ";	
    			// do the validation for duplicate input 
    			if (inputArray[j] == inputArray[1]) {
    				if (inputArray[j].equals(inputArray[j-1])) {
    					inputArray[j-1] = "duplicate";
    				}if (inputArray[j].equals(inputArray[j+1])) {
    					inputArray[j+1] = "duplicate";
    				}
    			}
				else if (inputArray[j] == inputArray[0]) {
    				if (inputArray[j].equals(inputArray[j+1])) {
    					inputArray[j+1] = "duplicate";
    				}if (inputArray[j].equals(inputArray[j+2])) {
    					inputArray[j+2] = "duplicate";
    				}
				}
			
				else if (inputArray[j] == inputArray[2]) {
    				if (inputArray[j].equals(inputArray[j-1])) {
    					inputArray[j-1] = "duplicate";
    				}if (inputArray[j].equals(inputArray[j-2])) {
    					inputArray[j-2] = "duplicate";
    				}
				}
        	}
    	}

    	for (int k = 0; k < 3; k++) {
    		if (!(Arrays.asList(numberArray).contains(inputArray[k])) == true && !(numberArray[k].equals(inputArray[k])) ){
    			hint = hint + "Nano" + " ";
        	}
    	}
    	
    	counter = counter + 1;
    	String counterStr = String.valueOf(counter);  
    	if (numberArray[0].equals(inputArray[0]) && numberArray[1].equals(inputArray[1]) && numberArray[2].equals(inputArray[2])){
    		txtOutput.append(txtInputOne.getText() + " " + txtInputTwo.getText() + " " + txtInputThree.getText() + " : " + hint + "\n");
    		txtOutput.append("Congratulations! Guesses: " + counterStr);
    		txtInputOne.setEnabled(false); 
    		txtInputTwo.setEnabled(false); 
    		txtInputThree.setEnabled(false); 
    		btnOk.setEnabled(false); 
    	}else {
    		txtOutput.append(txtInputOne.getText() + " " + txtInputTwo.getText() + " " + txtInputThree.getText() + " : " + hint + "\n");
    	}
    }
    
    // ------------------------------------------- event handlers for Reset button
    private void onReset(ActionEvent e) {
    	counter = 0;
    	txtInputOne.setEnabled(true); 
		txtInputTwo.setEnabled(true); 
		txtInputThree.setEnabled(true); 
		btnOk.setEnabled(true); 
    	txtInputOne.setText("");
    	txtInputTwo.setText("");      
    	txtInputThree.setText("");
       	txtOutput.setText("");
       	txtInputOne.requestFocusInWindow();
    }
	
    //-------------------------------------------- main method
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
