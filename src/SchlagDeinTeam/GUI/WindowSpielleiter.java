package SchlagDeinTeam.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import SchlagDeinTeam.SdTException;
import SchlagDeinTeam.Spiel;
import SchlagDeinTeam.bedienerInterface;




public class WindowSpielleiter extends Thread{
	JFrame frm;
	Dimension size;
	Dimension iconSize;
	JPanel spielSteuerung = new JPanel();
	JPanel punkteAnzeige;
	JLabel punkteStand1;
	JLabel punkteStand2;
	JFileChooser chooser;
	JToolBar tb = new JToolBar();
	Dimension buttonSize;
	static bedienerInterface bi;
	ArrayList <JButton> punkteListe = new ArrayList<JButton>();
	Font schrift = new Font ("Areal", Font.PLAIN, 25);
	/**
	 * @wbp.nonvisual location=1240,498
	 */
	public WindowSpielleiter (String name) {
		int start = JOptionPane.showConfirmDialog(null, "Möchten Sie einen vorhandenen Spielstand laden?", "Startoption", JOptionPane.YES_NO_CANCEL_OPTION);
		int[] temp = {98,77};
		bi = new Spiel();
		bi.setErgebnis(temp);
		initialize(name);
		switch (start) {
		case 0:{
			chooser = new JFileChooser();
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			chooser.setFileFilter(new FileNameExtensionFilter("SchlagdeinTeam Datei", "sdt"));
			if (chooser.showOpenDialog(frm) == JFileChooser.APPROVE_OPTION) {
				try {
					bi.speichern(chooser.getSelectedFile().getAbsolutePath());
				}catch (SdTException e) {
					JOptionPane.showMessageDialog(null, "Laden konnte nicht durchgeführt werden", "Ladefehler", JOptionPane.ERROR_MESSAGE);
				}
			}else
				JOptionPane.showMessageDialog(null, "keine Datei ausgewählt", "Ladefehler", JOptionPane.ERROR_MESSAGE);
		}case 1:{
			spieleEingeben();
			break;
		}default:{
			System.exit(0);
		}
		}
		frm.setVisible(true);
		start();
		
	}
	
	
	private void spieleEingeben() {
		
		
	}


	private void initialize(String name) {
		size = Toolkit.getDefaultToolkit().getScreenSize();
		iconSize = new Dimension((int)(size.getHeight()/40), (int)(size.getHeight()/40));
		frm = new JFrame(name);
		frm.setUndecorated(true);
		
		frm.setTitle(name);
		frm.setResizable(false);
		frm.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frm.getContentPane().setLayout(new GridLayout(1,0,0,0));
		spielSteuerung.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		spielSteuerung.setVisible(true);
		punkteAnzeige = new JPanel();
		punkteAnzeige.setBounds((int)(size.getWidth()*0.1),(int)(size.getHeight()*0.2),(int) (size.getWidth()*0.8),(int)(size.getHeight()*0.6));
		punkteAnzeige.setLayout(null);
		punkteAnzeige.setBackground(Color.LIGHT_GRAY);
		punkteAnzeige.setVisible(true);
		
		spielSteuerung.setLayout(null);
		frm.pack();
		frm.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frm.setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		frm.setJMenuBar(menuBar);
		
		JMenu mnOptionen = new JMenu("Optionen");
		mnOptionen.setFont(schrift);
		mnOptionen.setIcon(new ImageIcon (new ImageIcon(WindowSpielleiter.class.getResource("/SchlagDeinTeam/GUI/Icons/optionen.png")).getImage().getScaledInstance((int)iconSize.getWidth(), (int)iconSize.getHeight(), Image.SCALE_DEFAULT)));
		menuBar.add(mnOptionen);
		
		JMenuItem mntmSpeichern = new JMenuItem("Speichern");
		mntmSpeichern.setFont(schrift);
		mntmSpeichern.setIcon(new ImageIcon (new ImageIcon(WindowSpielleiter.class.getResource("/SchlagDeinTeam/GUI/Icons/speichern.png")).getImage().getScaledInstance((int)iconSize.getWidth(), (int)iconSize.getHeight(), Image.SCALE_DEFAULT)));
		mntmSpeichern.setSelectedIcon(null);
		mntmSpeichern.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				chooser = new JFileChooser ("Speicherdatei auswählen");
				chooser.setDialogTitle("Gültigen Dateinamen eingeben");
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				chooser.setFileFilter(new FileNameExtensionFilter ("SchlagDeinTeam Datei", "sdt"));
				if (chooser.showOpenDialog(mntmSpeichern) == JFileChooser.APPROVE_OPTION) {
					try {
						bi.speichern(chooser.getSelectedFile().getAbsolutePath());
					}catch (SdTException sdt) {
						JOptionPane.showMessageDialog(null, sdt.getMessage(), "Speicherfehler", JOptionPane.ERROR_MESSAGE);
					}
				}else
					JOptionPane.showMessageDialog(null, "Keinen Gültigen Dateinamen ausgewählt", "Speicherfehler", JOptionPane.ERROR_MESSAGE);
			}
			
		});
		mnOptionen.add(mntmSpeichern);
		
		JMenuItem mntmLaden = new JMenuItem("Laden");
		mntmLaden.setFont(schrift);
		mntmLaden.setIcon(new ImageIcon (new ImageIcon(WindowSpielleiter.class.getResource("/SchlagDeinTeam/GUI/Icons/Laden_neu.png")).getImage().getScaledInstance((int)iconSize.getWidth(), (int)iconSize.getHeight(), Image.SCALE_DEFAULT)));
		mntmLaden.setSelectedIcon(null);
		mntmLaden.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				chooser = new JFileChooser ("Speicherdatei auswählen");
				chooser.setDialogTitle("zu öffnende Datei auswählen");
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				chooser.setFileFilter(new FileNameExtensionFilter ("SchlagDeinTeam Datei", "sdt"));
				if (chooser.showOpenDialog(mntmLaden) == JFileChooser.APPROVE_OPTION) {
					try {
						bi.speichern(chooser.getSelectedFile().getAbsolutePath());
					}catch (SdTException sdt) {
						JOptionPane.showMessageDialog(null, sdt.getMessage(), "Ladefehler", JOptionPane.ERROR_MESSAGE);
					}
				}else
					JOptionPane.showMessageDialog(null, "Keine Gültige Datei ausgewählt", "Ladefehler", JOptionPane.ERROR_MESSAGE);
			}
			
		});
		mnOptionen.add(mntmLaden);
		mnOptionen.add(new JSeparator());
		
		JMenuItem mntmBeenden = new JMenuItem("Beenden");
		mntmBeenden.setFont(schrift);
		mntmBeenden.setIcon(new ImageIcon (new ImageIcon(WindowSpielleiter.class.getResource("/SchlagDeinTeam/GUI/Icons/Beenden.png")).getImage().getScaledInstance((int)iconSize.getWidth(), (int)iconSize.getHeight(), Image.SCALE_DEFAULT)));
		mntmBeenden.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int Auswahl = JOptionPane.showConfirmDialog(null, "Spiel vorher speichern?", "Programm beenden Optionen", JOptionPane.YES_NO_CANCEL_OPTION);
				switch (Auswahl) {
				case 0:		mntmSpeichern.doClick();
				case 1:	{
					System.exit(0);
					break;
				}
				default:{}
				}
			}
			
		});
		mnOptionen.add(mntmBeenden);
		mnOptionen.add(new JSeparator());
		
		JMenu mnDesign = new JMenu("Design");
		mnDesign.setFont(schrift);
		mnDesign.setIcon(new ImageIcon (new ImageIcon(WindowSpielleiter.class.getResource("/SchlagDeinTeam/GUI/Icons/design.png")).getImage().getScaledInstance((int)iconSize.getWidth(), (int)iconSize.getHeight(), Image.SCALE_DEFAULT)));
		mnOptionen.add(mnDesign);
		
		JMenuItem mntmBildschirmeTauschen = new JMenuItem("Bildschirme Tauschen");
		mntmBildschirmeTauschen.setFont(schrift);
		mntmBildschirmeTauschen.setIcon(new ImageIcon (new ImageIcon(WindowSpielleiter.class.getResource("/SchlagDeinTeam/GUI/Icons/tauschen.png")).getImage().getScaledInstance((int)iconSize.getWidth(), (int)iconSize.getHeight(), Image.SCALE_DEFAULT)));
		mnDesign.add(mntmBildschirmeTauschen);
		
		JMenuItem mntmMaximieren = new JMenuItem("Maximieren");
		mntmMaximieren.setFont(schrift);
		mntmMaximieren.setIcon(new ImageIcon (new ImageIcon(WindowSpielleiter.class.getResource("/SchlagDeinTeam/GUI/Icons/maximieren.png")).getImage().getScaledInstance((int)iconSize.getWidth(), (int)iconSize.getHeight(), Image.SCALE_DEFAULT)));
		mnDesign.add(mntmMaximieren);
		
		JMenuItem mntmMinimieren = new JMenuItem("Minimieren");
		mntmMinimieren.setFont(schrift);
		mntmMinimieren.setIcon(new ImageIcon (new ImageIcon(WindowSpielleiter.class.getResource("/SchlagDeinTeam/GUI/Icons/minimieren.png")).getImage().getScaledInstance((int)iconSize.getWidth(), (int)iconSize.getHeight(), Image.SCALE_DEFAULT)));
		mntmMinimieren.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frm.setState(JFrame.ICONIFIED);
			}
			
		});
		
		
		
		punkteStand1 = new JLabel();
		punkteStand1.setHorizontalAlignment(SwingConstants.CENTER);
		punkteStand1.setForeground(Color.YELLOW);

		punkteStand1.setBackground(Color.DARK_GRAY);
		punkteStand1.setBounds((int)(punkteAnzeige.getSize().getWidth()*0.2), (int)(punkteAnzeige.getSize().getHeight()*0.2), (int)(punkteAnzeige.getSize().getWidth()*0.2), (int)(punkteAnzeige.getSize().getHeight()*0.25));
		
		Font punkte = new Font("Tahoma", Font.BOLD, (int)(punkteStand1.getSize().getHeight()*0.9));
		
		punkteStand1.setFont(punkte);
		punkteStand1.setText("" + bi.getPunktestand()[0]);
		punkteStand1.setBorder(new LineBorder(Color.WHITE, 5, true));
		punkteStand1.setVisible(true);
		
		punkteStand2 = new JLabel ();
		punkteStand2.setHorizontalAlignment(SwingConstants.CENTER);
		punkteStand2.setForeground(Color.YELLOW);
		punkteStand2.setFont(punkte);
		punkteStand2.setBackground(Color.DARK_GRAY);
		punkteStand2.setBounds((int)(punkteAnzeige.getSize().getWidth()*0.55), (int)(punkteAnzeige.getSize().getHeight()*0.2), (int)(punkteAnzeige.getSize().getWidth()*0.2), (int)(punkteAnzeige.getSize().getHeight()*0.25));
		punkteStand2.setText("" + bi.getPunktestand()[1]);
		punkteStand2.setBorder(new LineBorder(Color.WHITE, 5, true));
		punkteStand2.setVisible(true);
		
		punkteEintragen();
		
		punkteAnzeige.add(punkteStand1);
		punkteAnzeige.add(punkteStand2);
		
		spielSteuerung.add(punkteAnzeige, BorderLayout.CENTER);
		frm.getContentPane().add(spielSteuerung);
		mnDesign.add(mntmMinimieren);
		
	}


	private void punkteEintragen() {
		
		
		double feldLinks = punkteStand1.getBounds().getMinX();
		double feldLinksUnten = punkteStand1.getBounds().getMaxY()*1.02;
		double feldRechts = punkteStand2.getBounds().getMinX();
		double feldRechtsUnten = punkteStand2.getBounds().getMaxY()*1.02;
		int pixelButton = (int)(punkteStand1.getSize().getWidth()*0.18);
		Font punkte = new Font("Tahoma", Font.BOLD, (int)(pixelButton*0.45));
		int c=0;
//		for (int i = 1; i <= bi.anzSpiele(); i++) {
		for (int i = 1; i <= 20; i++) { //Test
			JButton tempLinks = new JButton("" + i);
			tempLinks.setName("" + c++);//Position in ArrayList
			tempLinks.setActionCommand(tempLinks.getText()+ ";" + tempLinks.getName());
			tempLinks.setBackground(Color.black);
			tempLinks.setForeground(Color.DARK_GRAY);
			tempLinks.setVisible(true);
			tempLinks.setFont(punkte);
			
			tempLinks.setBounds((int)feldLinks, (int)feldLinksUnten, pixelButton, pixelButton);

			JButton tempRechts = new JButton(""+i);
			tempRechts.setName("" + c++);
			tempRechts.setActionCommand(tempRechts.getText()+ ";" + tempRechts.getName());
			tempRechts.setBackground(Color.black);
			tempRechts.setForeground(Color.DARK_GRAY);
			tempRechts.setVisible(true);
			tempRechts.setFont(punkte);
			tempRechts.setBounds((int)feldRechts, (int) feldRechtsUnten, pixelButton, pixelButton);
			if (i!=1) {
				tempLinks.setEnabled(false);
				tempRechts.setEnabled(false);
			}
			
			punkteListe.add(tempLinks);
			punkteListe.add(tempRechts);
			feldLinks += (pixelButton *1.16);
			feldRechts += (pixelButton *1.16);
			if ((i % 5) == 0) { //Reihe voll
				feldLinks = punkteStand1.getBounds().getMinX();
				feldRechts = punkteStand2.getBounds().getMinX();
				feldLinksUnten += pixelButton*1.16;
				feldRechtsUnten += pixelButton*1.16;
			}
			for (JButton temp: punkteListe) {
				punkteAnzeige.add(temp);
				temp.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						temp.setBackground(Color.LIGHT_GRAY);
						String[] actionKommando = e.getActionCommand().split(";");
						int[] punkt = {Integer.parseInt(actionKommando[0]),Integer.parseInt(actionKommando[1])};
						punkteListe.get(punkt[1]+2).setEnabled(true);
						int team1 = 0;
						int team2 = 0;
						if (punkt[1]%2 == 1) {
							punkteListe.get(punkt[1]+1).setEnabled(true);
							punkteListe.get(punkt[1]-1).setEnabled(false);
							team2 = punkt[0];
						}else {
							punkteListe.get(punkt[1]+3).setEnabled(true);
							punkteListe.get(punkt[1]+1).setEnabled(false);
							team1 = punkt[0];
						}
						bi.setErgebnisMiniSpiel(team1, team2);
						punkteStand1.setText("" + bi.getPunktestand()[0]);
						punkteStand2.setText("" + bi.getPunktestand()[1]);
					}
					
				});
			}
	
			}
		
	}




}
