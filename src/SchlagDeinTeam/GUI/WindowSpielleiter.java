package SchlagDeinTeam.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import SchlagDeinTeam.SdTException;
import SchlagDeinTeam.Spiel;
import SchlagDeinTeam.bedienerInterface;
import java.awt.BorderLayout;




public class WindowSpielleiter extends Thread{
	JFrame frm;
	Dimension size;
	Dimension iconSize;
	JPanel spielSteuerung = new JPanel();
	JFileChooser chooser;
	JToolBar tb = new JToolBar();
	Dimension buttonSize;
	static bedienerInterface bi = new Spiel();
	Font schrift = new Font ("Areal", Font.PLAIN, 25);	
	public WindowSpielleiter (String name) {
		initialize(name);
		start();
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
		JPanel punkteStand = new JPanel();
		punkteStand.setBounds((int)(size.getWidth()*0.1),(int)(size.getHeight()*0.2),(int) (size.getWidth()*0.8),(int)(size.getHeight()*0.6));
		punkteStand.setBackground(Color.BLACK);
		punkteStand.setVisible(true);
		spielSteuerung.add(punkteStand, BorderLayout.CENTER);
		
		frm.getContentPane().add(spielSteuerung);
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
		
		
		mnDesign.add(mntmMinimieren);
		frm.setVisible(true);
		
	}




}
