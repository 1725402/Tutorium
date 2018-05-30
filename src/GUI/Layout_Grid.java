package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;

public class Layout_Grid extends JFrame {
	public Layout_Grid() {
		Color c = new Color(255,0,0);
		
		JLabel jl = new JLabel ("Mein erstes Label");
		JButton jb1 = new JButton ("1");
		JButton jb2 = new JButton ("2");
		JButton jb3 = new JButton ("3");
		JButton jb4 = new JButton ("2");
		JButton jb5 = new JButton ("3");
		
		this.setLayout(new GridLayout (1,3));
		this.add(jb1);
		this.add(jb2);
		
		Container c1 = new Container ();
		c1.setLayout(new GridLayout(3,1));
		c1.add(jb4);
		c1.add(jb5);
		c1.add(jl);
		
		jl.setBackground(c);
		jl.setOpaque(true);
		this.add(c1);
		
		jl.setBackground(c);
		jl.setVisible(true);
		this.setSize(300,40);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setDefaultLookAndFeelDecorated(true);
	}
	
	@Override
	public void dispose () {
		System.exit(0);
	}
	
}
