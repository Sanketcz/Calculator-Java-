import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.FontUIResource;

public class Calculator implements ActionListener{

	public JFrame f=new JFrame("Calculator");
	public JTextField tf=new JTextField();
	public JButton[] numbtn=new JButton[10];
	public JButton[] funcbtn=new JButton[9];
	public JButton add,sub,mul,div;
	public JButton decimal,equ,del,clr,negative;
	public JPanel panel;
		
	Font myFont=new FontUIResource("Ink Free",Font.BOLD,30);
		
	double n1=0,n2=0,res=0;
	char opr;
	
	public Calculator() {
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(325,500);
		f.setLayout(null);
		f.setVisible(true);
		
		
		tf.setBounds(5,5,300,90);
		tf.setFont(myFont);
		f.add(tf);
		tf.setEditable(false);
		tf.setBackground(Color.white);
		
		add=new JButton("+");
		sub=new JButton("-");
		mul=new JButton("*");
		div=new JButton("/");
		decimal=new JButton(".");
		equ=new JButton("=");
		del=new JButton("del");
		clr=new JButton("clr");
		negative=new JButton("(-)");
		
		funcbtn[0]=add;
		funcbtn[1]=sub;
		funcbtn[2]=mul;
		funcbtn[3]=div;
		funcbtn[4]=decimal;
		funcbtn[5]=equ;
		funcbtn[6]=del;
		funcbtn[7]=clr;
		funcbtn[8]=negative;

		for(int i=0;i<9;i++) {
			funcbtn[i].addActionListener(this);
			funcbtn[i].setFont(myFont);
			funcbtn[i].setFocusable(false);
			funcbtn[i].setBackground(Color.white);
			
		}
		for(int i=0;i<10;i++) {
			numbtn[i]=new JButton(String.valueOf(i));
			numbtn[i].addActionListener(this);
			numbtn[i].setFont(myFont);
			numbtn[i].setFocusable(false);
			numbtn[i].setBackground(Color.white);
		}
		
		negative.setBounds(5,405,75,50);
		del.setBounds(85,405,112,50);
		clr.setBounds(202,405,102,50);
		
		panel=new JPanel();
		panel.setBounds(5,100,300,300);
		panel.setLayout(new GridLayout(4,4,5,5));
		//panel.setBackground(Color.gray);
		
		panel.add(numbtn[1]);
		panel.add(numbtn[2]);
		panel.add(numbtn[3]);
		panel.add(add);
		
		panel.add(numbtn[4]);
		panel.add(numbtn[5]);
		panel.add(numbtn[6]);
		panel.add(sub);
		
		panel.add(numbtn[7]);
		panel.add(numbtn[8]);
		panel.add(numbtn[9]);
		panel.add(mul);
		panel.add(decimal);
		panel.add(decimal);
		panel.add(decimal);
		panel.add(numbtn[0]);
		panel.add(equ);
		panel.add(div);
		
		f.add(panel);
		f.add(negative);
		f.add(del);
		f.add(clr);
	}
	
	
	
	public static void main(String[] args) {
		
		Calculator c=new Calculator();
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {

		for(int i=0;i<10;i++) {
			if(e.getSource()== numbtn[i]) {
				tf.setText(tf.getText().concat(String.valueOf(i)));
			}
		}
		if (e.getSource()== decimal) {
			tf.setText(tf.getText().concat("."));
			
		}
		if (e.getSource()== add) {
			n1=Double.parseDouble(tf.getText());
			opr='+';
			tf.setText("");
		}
		if (e.getSource()== sub) {
			n1=Double.parseDouble(tf.getText());
			opr='-';
			tf.setText("");
		}
		if (e.getSource()== mul) {
			n1=Double.parseDouble(tf.getText());
			opr='*';
			tf.setText("");
		}
		if (e.getSource()== div) {
			n1=Double.parseDouble(tf.getText());
			opr='/';
			tf.setText("");
		}
		if(e.getSource()==equ) {
			n2=Double.parseDouble(tf.getText());
			
			switch(opr) {
			case'+':
				res=n1+n2;
				break;
			case'-':
				res=n1-n2;
				break;
			case'*':
				res=n1*n2;
				break;
			case'/':
				res=n1/n2;
				break;
			}
			tf.setText(String.valueOf(res));
			n1=res;
		}
		if (e.getSource()== clr) {
			tf.setText("");
		}
		if (e.getSource()== del) {
			String s=tf.getText();
			tf.setText("");
			for(int i=0;i<s.length()-1;i++) {
				tf.setText(tf.getText()+s.charAt(i));
			}
		}
		if (e.getSource()== negative) {

			double temp=Double.parseDouble(tf.getText());
			temp*=-1;
			tf.setText(String.valueOf(temp));
		
		
		}
		
	}

}
