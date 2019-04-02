import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JTextField;
import javax.swing.JFrame;

public class Calculator implements ActionListener{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Calculator(); }

	double num1, num2;
	boolean add, subtract, multiply, divide;
	String sScreen = "0";
	String[] sKey = {
			"1","2","3","C","4","5","6","+","7","8","9","-","0","*","/","=", ","
	};
	Color[] colorKey = {
			Color.black, Color.black, Color.black, Color.red, Color.black, Color.black, Color.black, Color.green, 
			Color.black, Color.black, Color.black, Color.GREEN, Color.black, Color.GREEN, Color.GREEN, Color.cyan
	};
	JFrame okno = new JFrame("Calculator");
	JTextField text = new JTextField(sScreen);	
	JButton[] bKey = new JButton[17];
	Font font = new Font("Verdana", Font.PLAIN, 14);	
	// konstruktor
		Calculator(){
			for (byte i = 0; i<17; i++) 
			{
				bKey[i] = new JButton(sKey[i]);
				okno.add(bKey[i]); 
				bKey[i].addActionListener(this);
			}
			byte j = 0;
			for (byte y = 0; y<4; y++)
				for (byte x = 0; x<4; x++)
				{
					bKey[j].setBounds(10+(x*50), 70+(y*50), 50, 50);
					bKey[j].setFont(font);
					bKey[j].setForeground(colorKey[j]);
					j++;
				}
				
			
			text.setBounds(10, 10, 480, 40);
			text.setFont(new Font("Calibri",Font.PLAIN,25));
			text.setEditable(false);
			text.setHorizontalAlignment(JTextField.RIGHT);
			
			okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			okno.setSize(500,400);
			okno.setLocationRelativeTo(null);
			okno.setResizable(false);
			okno.setLayout(null);
			okno.setVisible(true);
			okno.add(text);
			
		
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		Object cel = e.getSource();
		for (byte i=0; i<16; i++)
		{
			if (cel == bKey[i]) oblicz(i);
		}			
		}
 
		private void reset()
		{
			add = false;
			subtract = false;
			multiply = false;
			divide = false;
		}
		
		private void oblicz(int i)
		{
			// TODO Auto-generated method stub
			if(colorKey[i]==Color.black && sScreen.length()<17)
			{
				if(sScreen == "0") sScreen = bKey[i].getText();
				else
					sScreen+=sScreen=bKey[i].getText();
				text.setText(sScreen);
			}
			if (i == 3)
			{
				sScreen = "0"; reset(); text.setText(sScreen);
			}
			else if (i == 7)
			{
				if (add) 
				{
					num2 = Double.parseDouble(sScreen);
					num1 += num2;
					sScreen = String.valueOf(num1);
					text.setText(sScreen);
					sScreen = "0";
				}
				else
				{
					reset();
					add = true;
					num1 = Double.parseDouble(sScreen);
					sScreen = "0";
				}
			}
			else if (i == 11)
			{
				if (subtract) 
				{
					num2 = Double.parseDouble(sScreen);
					num1 -= num2;
					sScreen = String.valueOf(num1);
					text.setText(sScreen);
					sScreen = "0";
				}
				else
				{
					reset();
					subtract = true;
					num1 = Double.parseDouble(sScreen);
					sScreen = "0";
				}
			}
			else if (i == 13)
			{
				if (multiply) 
				{
					num2 = Double.parseDouble(sScreen);
					num1 *= num2;
					sScreen = String.valueOf(num1);
					text.setText(sScreen);
					sScreen = "0";
				}
				else
				{
					reset();
					multiply = true;
					num1 = Double.parseDouble(sScreen);
					sScreen = "0";
				}
			}
			else if (i == 14)
			{
				if (divide) 
				{
					num2 = Double.parseDouble(sScreen);
					num1 /= num2;
					sScreen = String.valueOf(num1);
					text.setText(sScreen);
					sScreen = "0";
				}
				else
				{
					reset();
					divide = true;
					num1 = Double.parseDouble(sScreen);
					sScreen = "0";
				}
			}
			else if (i == 15)
			{
				if (add)
				{
					num2 = Double.parseDouble(sScreen);
					num1 += num2;
				}
				
				else if (subtract)
				{
					num2 = Double.parseDouble(sScreen);
					num1 -= num2;
				}
				
				else if (multiply)
				{
					num2 = Double.parseDouble(sScreen);
					num1 *= num2;
				}
				
				if (divide)
				{
					num2 = Double.parseDouble(sScreen);
					num1 /= num2;
				}
				sScreen = String.valueOf(num1);
				reset();
				text.setText(sScreen);
			
			}
		}
			
		}
			
		
	


