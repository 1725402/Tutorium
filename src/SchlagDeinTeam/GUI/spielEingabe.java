package SchlagDeinTeam.GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class spielEingabe extends JFrame{
	JFrame frm;
	JPanel pn;
	JLabel lb;
	JTextArea b;
	JLabel lt;
	JTextArea t;
	private JTextField textField;
	
	
	
	
	public spielEingabe() {
		initialize();
		
	}

	private void initialize() {
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		int textEinrücken = (int) (size.getWidth()*0.1);
		frm=new JFrame("Spiel hinzufügen");
		frm.setBounds((int)(size.getWidth()*0.3),(int)(size.getHeight()*0.3),(int)(size.getWidth()*0.4),(int)(size.getHeight()*0.4));
		frm.setIconImage(Toolkit.getDefaultToolkit().getImage("/SchlagDeinTeam/GUI/Icons/Logo_klein.png"));
		
		pn = new JPanel();
		pn.setLayout(null);
		pn.setSize(size);
		pn.setVisible(true);
		JLabel logo = new JLabel();
		logo.setVisible(true);
		logo.setIcon(new ImageIcon (new ImageIcon(WindowSpielleiter.class.getResource("/SchlagDeinTeam/GUI/Icons/Logo_klein.png")).getImage().getScaledInstance((int)(size.getWidth()*0.1), (int)(size.getWidth()*0.1), Image.SCALE_DEFAULT)));
		logo.setBounds(0,0,logo.getIcon().getIconWidth(),logo.getIcon().getIconWidth());
		
		
		pn.add(logo);
		frm.getContentPane().add(pn);
		
		
		JLabel lblTitel = new JLabel("Titel:");
		lblTitel.setVerticalAlignment(SwingConstants.TOP);
		lblTitel.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitel.setBorder();
		int übrig = (int)(size.getWidth()-(textEinrücken + logo.getIcon().getIconWidth()*1.5));
		lblTitel.setBounds(textEinrücken, (int)(logo.getIcon().getIconWidth()*1.2), (int)(logo.getIcon().getIconWidth()*1.5), (int)(logo.getIcon().getIconWidth()*0.5));
		Font schrift = new Font ("Tahoma", Font.BOLD, (int)lblTitel.getSize().getHeight());
		pn.add(lblTitel);
		
		textField = new JTextField();
		textField.setBounds((int)(textEinrücken + logo.getIcon().getIconWidth()*1.7),(int)(logo.getIcon().getIconWidth()*1.2),(int)(übrig*0.9),(int)(lblTitel.getSize().getHeight()));
		pn.add(textField);
		textField.setColumns(10);
		
		JLabel lblBeschreibung = new JLabel("Beschreibung:");
		Beschreibung.setBorder();
		lblBeschreibung.setVerticalAlignment(SwingConstants.TOP);
		lblBeschreibung.setHorizontalAlignment(SwingConstants.LEFT);
		lblBeschreibung.setBounds(textEinrücken, (int)(lblTitel.getBounds().getMaxY()*1.01), (int)lblTitel.getSize().getWidth(), (int)lblTitel.getSize().getHeight());
		pn.add(lblBeschreibung);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(300, 441, 747, 161);
		pn.add(textArea);
		frm.setVisible(true);
	}
}
