package Calculator;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class Calc implements ActionListener {

    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] funcButtons = new JButton[9];
    JButton add, sub, div, mul;
    JButton equ, dec, del, clr, neg;
    JPanel panel;
    Font font = new Font("Comic Sans MS", Font.BOLD, 30);
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calc() {
        frame = new JFrame("Casio");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(font);
        textfield.setEditable(false);

        // Define custom background color for the frame
        Color backgroundColor = new Color(255, 240, 210); // Custom light peach color
        frame.getContentPane().setBackground(backgroundColor);

        add = new JButton("+");
        sub = new JButton("-");
        div = new JButton("/");
        mul = new JButton("x");
        equ = new JButton("=");
        dec = new JButton(".");
        del = new JButton("delete");
        neg = new JButton("Neg");
        clr = new JButton("Clear");

        funcButtons[0] = add;
        funcButtons[1] = sub;
        funcButtons[2] = div;
        funcButtons[3] = mul;
        funcButtons[4] = equ;
        funcButtons[5] = dec;
        funcButtons[6] = del;
        funcButtons[7] = clr;
        funcButtons[8] = neg;
        
        for (int i = 0; i < funcButtons.length; i++) {
            funcButtons[i].addActionListener(this);
            funcButtons[i].setFont(font);
            funcButtons[i].setFocusable(false);
            funcButtons[i].setBackground(new Color(255, 192, 203)); // Custom pink color
            funcButtons[i].setBorder(new LineBorder(new Color(255, 105, 180), 2)); // Pink border
        }

        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(font);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(new Color(173, 216, 230)); // Custom light blue color
            numberButtons[i].setBorder(new LineBorder(new Color(0, 0, 128), 2)); // Blue border
        }
        
        neg.setBounds(50,430,100,50);
        del.setBounds(150, 430, 100, 50);
        clr.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setBackground(new Color(255, 223, 186)); // Custom beige color
        panel.setLayout(new GridLayout(4, 4, 10, 10));


        
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(add);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(sub);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mul);
        panel.add(dec);
        panel.add(numberButtons[0]);
        panel.add(equ);
        panel.add(div);
        
        // Apply a shadow border to the panel
        Border shadowBorder = BorderFactory.createCompoundBorder(
            new LineBorder(Color.LIGHT_GRAY, 5), // Outer border (light gray)
            new LineBorder(backgroundColor, 10) // Inner border (background color)
        );
        panel.setBorder(shadowBorder);

        frame.add(panel);
        frame.add(del);
        frame.add(clr);
        frame.add(neg);
        frame.add(textfield);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calc cal = new Calc();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	for (int i = 0; i < 10; i++) {
			if(e.getSource()==numberButtons[i])
			{
				textfield.setText
				(textfield.getText().concat(String.valueOf(i)));
			}
		}
    	if(e.getSource()==add)
    	{
    		num1 = Double.parseDouble(textfield.getText());
    		operator = '+';
    		textfield.setText("");
    	}
    	if(e.getSource()==sub)
    	{
    		num1 = Double.parseDouble(textfield.getText());
    		operator = '-';
    		textfield.setText("");
    	}
    	if(e.getSource()==mul)
    	{
    		num1 = Double.parseDouble(textfield.getText());
    		operator = 'x';
    		textfield.setText("");
    	}
    	if(e.getSource()==dec) {
			textfield.setText(textfield.getText().concat("."));
		}
    	if(e.getSource()==div)
    	{
    		num1 = Double.parseDouble(textfield.getText());
    		operator = '/';
    		textfield.setText("");
    	}
    	if(e.getSource()==equ)
    	{
    		double result = 0;
    		num2 = Double.parseDouble(textfield.getText());
    		switch (operator) {
			case '+': 
				result = num1 + num2;
				break;
			
			case '-': 
				result = num1 - num2;
				break;
			
			case 'x': 
				result = num1 * num2;
				break;
			
			case '/': 
				result = num1 / num2;
				break;
			}
    		textfield.setText(String.valueOf(result));
    		num1 = result;
    	}
    	if(e.getSource()==clr)
    	{
    		textfield.setText("");
    	}
    	if(e.getSource()==del)
    	{
    		String str = textfield.getText();
    		textfield.setText("");
    		for (int i = 0; i < str.length()-1; i++) {
				textfield.setText(textfield.getText() + str.charAt(i));
			}
    	}
    	if(e.getSource()==neg)
    	{
    		double input = Double.parseDouble(textfield.getText());
    		input = -1* input;
    		textfield.setText(String.valueOf(input));
    	}
    }
}
