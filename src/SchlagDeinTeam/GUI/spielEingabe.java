package SchlagDeinTeam.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import SchlagDeinTeam.EinzelSpiel;
import SchlagDeinTeam.GruppenSpiel;
import SchlagDeinTeam.SdTException;
import SchlagDeinTeam.Spiel;
import SchlagDeinTeam.bedienerInterface;


public class spielEingabe extends Thread{
	JFileChooser chooser;
	JFrame frm;
	JPanel pn;
	JLabel lb;
	JTextArea b;
	JLabel lt;
	JTextArea t;
	private bedienerInterface bi;
	private JTextField textField;
	
	
	
	
	public spielEingabe() {
		int start = JOptionPane.showConfirmDialog(null, "Möchten Sie einen vorhandenen Spielstand laden?", "Startoption", JOptionPane.YES_NO_CANCEL_OPTION);
		int[] temp = {0,0};
		bi = new Spiel();
		bi.setErgebnis(temp);
		
		switch (start) {
		case 0:{
			chooser = new JFileChooser();
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			chooser.setFileFilter(new FileNameExtensionFilter("SchlagdeinTeam Datei", "sdt"));
			if (chooser.showOpenDialog(frm) == JFileChooser.APPROVE_OPTION) {
				try {
					this.bi = bi.laden(chooser.getSelectedFile().getAbsolutePath());
				}catch (SdTException e) {
					JOptionPane.showMessageDialog(null, "Laden konnte nicht durchgeführt werden", "Ladefehler", JOptionPane.ERROR_MESSAGE);
				}
			}else
				JOptionPane.showMessageDialog(null, "keine Datei ausgewählt", "Ladefehler", JOptionPane.ERROR_MESSAGE);
		}case 1:{
			initialize();
			break;
		}default:{
			System.exit(0);
		}
		}
		start();
		
	}
	

	private void initialize() {
		
		
		
		
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		int textEinrücken = (int) (size.getWidth()*0.07);
		frm=new JFrame("Spiel hinzufügen");
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		lblTitel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitel.setBounds(textEinrücken, (int)(logo.getIcon().getIconWidth()*0.5), (int)(logo.getIcon().getIconWidth()*1), (int)(logo.getIcon().getIconWidth()*0.15));
		Font schrift = new Font ("Tahoma", Font.BOLD, (int)(lblTitel.getSize().getHeight()*0.8));
		lblTitel.setFont(schrift);
		pn.add(lblTitel);
		
		textField = new JTextField();
		textField.setBounds((int)(lblTitel.getBounds().getMaxX()*1.1),(int)(lblTitel.getBounds().getMinY()),(int)((frm.getBounds().getWidth()-lblTitel.getBounds().getWidth()-logo.getIcon().getIconWidth()*1.2)),(int)(lblTitel.getSize().getHeight()));
		pn.add(textField);
		textField.setColumns(10);
		
		JLabel lblBeschreibung = new JLabel("Beschreibung:");
		lblBeschreibung.setVerticalAlignment(SwingConstants.TOP);
		lblBeschreibung.setFont(schrift);
		lblBeschreibung.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBeschreibung.setBounds(textEinrücken, (int)(lblTitel.getBounds().getMaxY()*1.01), (int)lblTitel.getSize().getWidth(), (int)lblTitel.getSize().getHeight());
		pn.add(lblBeschreibung);
		
		JTextArea textArea = new JTextArea();
		Rectangle text = textField.getBounds();
		textArea.setBounds((int)text.getMinX(),(int) lblBeschreibung.getBounds().getMinY(), (int) text.getWidth(),(int) ((frm.getBounds().getHeight()-lblBeschreibung.getBounds().getMaxY())*0.5));
		pn.add(textArea);
		
		JCheckBox c1 = new JCheckBox ("Einzelspiel");
		c1.setBackground(null);
		c1.setVerticalAlignment(SwingConstants.TOP);
		c1.setVisible(true);
		c1.setSelected(true);
		
		JCheckBox c2 = new JCheckBox ("Gruppenspiel");
		c2.setBackground(null);
		c2.setVerticalAlignment(SwingConstants.TOP);
		c2.setVisible(true);
		
		JList<JCheckBox> list = new JList<JCheckBox>();
		list.setBackground(null);
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		

		list.setLayout(new FlowLayout());
		
		c1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if (c2.isSelected())
					c2.setSelected(false);
				else
					c1.setSelected(true);
			}
			
		});
		c2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if (c1.isSelected())
					c1.setSelected(false);
				else
					c2.setSelected(true);
			}
			
		});
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds((int)(textField.getBounds().getMinX()), (int)(logo.getIcon().getIconWidth()*0.2), (int)(logo.getIcon().getIconWidth()*1.2), (int)(logo.getIcon().getIconWidth()*0.18));
		
		c1.setSize((int)(list.getSize().getWidth()/2),(int)list.getSize().getHeight());
		c2.setSize((int)(list.getSize().getWidth()/2),(int)list.getSize().getHeight());
		
		list.add(c1);
		list.add(c2);
		pn.add(list);
		
		JButton btnFortfahren = new JButton("Fortfahren");
		
		btnFortfahren.setSize((int)(textField.getBounds().getWidth()*0.5), (int)(textField.getBounds().getHeight()));
		btnFortfahren.setBounds((int)(textField.getBounds().getMaxX()-btnFortfahren.getSize().getWidth()), (int)(textArea.getBounds().getMaxY()+textField.getSize().getHeight()), (int) btnFortfahren.getSize().getWidth(), (int) btnFortfahren.getSize().getHeight());
		pn.add(btnFortfahren);
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.setBounds((int)btnFortfahren.getBounds().getMinX(), (int)(btnFortfahren.getBounds().getMaxY()+textField.getSize().getHeight()*0.5), (int) btnFortfahren.getSize().getWidth(), (int) btnFortfahren.getSize().getHeight());
		btnSpeichern.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					if(c1.isSelected()) {
						bi.addSpiel(new EinzelSpiel (textField.getText(), textArea.getText()));
						textField.setText("");
						textArea.setText("");
					}else
						bi.addSpiel(new GruppenSpiel (textField.getText(), textArea.getText()));
					
				}catch (SdTException arg0) {
					JOptionPane.showMessageDialog(frm, "" + "Eingaben überprüfen!", "Fehler", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		btnFortfahren.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(textField.getText() != null && textArea.getText() != null) {
					btnSpeichern.doClick();
					new WindowSpielleiter (bi);
					frm.dispose();
				}
				
				
			}
				
		});
		pn.add(btnSpeichern);
		frm.setVisible(true);
	}
}
