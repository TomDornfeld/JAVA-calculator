package tom.dornfeld;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorApp implements ActionListener {

	Calculator myCalculator;
	
	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, equButton, delButton, clrButton, negButton;
	JPanel panel;

	Font myFont = new Font("monospaced", Font.BOLD, 30);

	CalculatorApp() {

		myCalculator = new Calculator();
		
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);

		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myFont);
		textfield.setEditable(false);

		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Delete");
		clrButton = new JButton("Clear");
		negButton = new JButton("(-)");

		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;

		for (int i = 0; i < 9; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}

		for (int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
		
		delButton.setBounds(100, 430, 150, 50);
		clrButton.setBounds(250, 430, 150, 50);
		negButton.setBounds(0,430,100,50);

		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		panel.setBackground(Color.GRAY);

		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);

		frame.add(panel);
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield);
		frame.setVisible(true);
	}

	public static void main(String[] args) {

		CalculatorApp calc = new CalculatorApp();

	}

	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i < 10; i++) {
			if (e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}

		if (e.getSource() == decButton) {
			textfield.setText(textfield.getText().concat("."));
		}

		if (e.getSource() == addButton) {
			myCalculator.operand(Double.parseDouble(textfield.getText()));
			myCalculator.operator('+');
			textfield.setText("");
		}

		if (e.getSource() == subButton) {
			myCalculator.operand(Double.parseDouble(textfield.getText()));
			myCalculator.operator('-');
			textfield.setText("");
		}

		if (e.getSource() == mulButton) {
			myCalculator.operand(Double.parseDouble(textfield.getText()));
			myCalculator.operator('*');
			textfield.setText("");
		}

		if (e.getSource() == divButton) {
			myCalculator.operand(Double.parseDouble(textfield.getText()));
			myCalculator.operator('/');
			textfield.setText("");
		}

		if (e.getSource() == equButton) {					
			myCalculator.operand(Double.parseDouble(textfield.getText()));
			textfield.setText(String.valueOf(myCalculator.equals()));
		}

		if (e.getSource() == clrButton) {
			textfield.setText("");
			myCalculator.clear();
		}
		
		if (e.getSource() == delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for (int i = 0; i < string.length() - 1; i++) {
				textfield.setText(textfield.getText() + string.charAt(i));
			}
		}
		
		if (e.getSource() == negButton && !textfield.getText().isEmpty()) {
			double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
		}
	}
}
