import javax.swing.JFrame;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import org.w3c.dom.Text;

import javax.swing.JTextField;
import javax.swing.JLabel;
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
	private TextFieldValidator textFieldValidator;
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
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		this.setResizable(false);
		
		// create random numbers and store in the array
		numberOne = 8;
		numberOneStr = Integer.toString(numberOne);
		numberTwo = 4;
		numberTwoStr = Integer.toString(numberTwo);
		numberThree = 5;
		numberThreeStr = Integer.toString(numberThree);
		
		numberArray = new String[]{numberOneStr, numberTwoStr, numberThreeStr};


		JLabel lblTitle = new JLabel("Fermi Guessing Game");
		
		
		txtInputOne = new JTextField();
		txtInputOne.setColumns(10);
		txtInputOne.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				textFieldValidator = new TextFieldValidator(txtInputOne);
				textFieldValidator.check();
			}
		});
		

		txtInputTwo = new JTextField();
		txtInputTwo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				textFieldValidator = new TextFieldValidator(txtInputTwo);
				textFieldValidator.check();
			}
		});
		
		txtInputThree = new JTextField();
		txtInputThree.setColumns(10);
		txtInputThree.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				textFieldValidator = new TextFieldValidator(txtInputThree);
				textFieldValidator.check();
			}
		});
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onSubmit(e);
			}
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onReset(e);
			}
		});
		
		txtOutput = new JTextArea();
		
		JLabel lblSubtitle = new JLabel("Enter your three guesses (0-9):");
		
		JLabel lblHint = new JLabel("Hints");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnOk)
								.addComponent(txtInputThree, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSubtitle, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(txtInputTwo, Alignment.LEADING)
									.addComponent(txtInputOne, Alignment.LEADING)))
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblHint, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtOutput, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)))
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
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
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
						.addComponent(txtOutput))
					.addContainerGap(65, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
	
	// ------------------------------------------- event handlers for Ok button
    private void onSubmit(ActionEvent e) {
    	inputArray = new String[]{txtInputOne.getText(), txtInputTwo.getText(), txtInputThree.getText()};
    	ArrayList<String> duplicateArray = new ArrayList<String>();
    	hint = "";
    	
    	for (int i = 0; i < 3; i++) {
    		if (numberArray[i].equals(inputArray[i])) {
    			hint = hint + "Fermi" + " ";
        	}
    	}
    	
    	System.out.println(hint);
    	
//    	if (inputArray[0].equals(inputArray[1]) && !(numberArray[0].equals(inputArray[0]))){
//    		hint = hint + "Nano" + " ";
//    	}
//    	
//    	if (inputArray[0].equals(inputArray[2]) && !(numberArray[0].equals(inputArray[0]))){
//    		hint = hint + "Nano" + " ";
//    	}
//    	
//    	if (inputArray[1].equals(inputArray[0]) && !(numberArray[0].equals(inputArray[0]))){
//    		hint = hint + "Nano" + " ";
//    	}
//    	
//    	if (inputArray[1].equals(inputArray[2]) && !(numberArray[0].equals(inputArray[0]))){
//    		hint = hint + "Nano" + " ";
//    	}
//    	
//    	if (inputArray[2].equals(inputArray[0]) && !(numberArray[0].equals(inputArray[0]))){
//    		hint = hint + "Nano" + " ";
//    	}
//    	
//    	if (inputArray[2].equals(inputArray[1]) && !(numberArray[0].equals(inputArray[0]))){
//    		hint = hint + "Nano" + " ";
//    	}

//    	for (int i = 0; i < 3; i++) {
//    		if (Arrays.asList(numberArray).contains(inputArray[i]) == true && !(numberArray[i].equals(inputArray[i]))){
//    			hint = hint + "Pico" + " ";
//        	}
//    	}
    	
    	for (int i = 0; i < 3; i++) {
    		if (!(Arrays.asList(numberArray).contains(inputArray[i])) == true && !(numberArray[i].equals(inputArray[i]))){
    			hint = hint + "Nano" + " ";
        	}
    	}
    	

//    	for (int i = 0; i < 3; i++) {
//    		if (numberArray[i].equals(inputArray[i])) {
//    			hint = hint + "Fermi" + " ";
//        	}else if (Arrays.asList(numberArray).contains(inputArray[i]) == true) {
//        		if (duplicateArray.contains(inputArray[i]) == true) {
//            		hint = hint + "Nano" + " ";
//            	// check for the first case
//            	}else if (inputArray[0].equals(inputArray[1])) {
//            		hint = hint + "Nano" + " ";
//            	}else {
//            		hint = hint + "Pico" + " ";
//            	}
//        	}else {
//        		hint = hint + "Nano" + " ";
//        	}
//    		// the element is added after checking to the first input
//    		duplicateArray.add(inputArray[i]);
//    	}

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
