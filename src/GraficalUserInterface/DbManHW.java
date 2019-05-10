package GraficalUserInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DbManHW extends JFrame {

	private JPanel contentPane;


	public DbManHW() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(220, 100, 820, 600);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\juanb\\git\\ProjectER\\Images\\hospital100.png"));
		label.setBounds(0, 0, 106, 128);
		contentPane.add(label);
		
		
		//RIGHT BUTT
		
		JLabel lblNewLabel = new JLabel("DB MANAGER HOME WINDOW");
		lblNewLabel.setFont(new Font("Gill Sans MT", Font.BOLD, 25));
		lblNewLabel.setBounds(198, 47, 404, 32);
		contentPane.add(lblNewLabel);
		
		JButton btnendSession = new JButton("");
		btnendSession.setIcon(new ImageIcon("C:\\Users\\juanb\\git\\ProjectER\\Images\\icons8-fin-de-cadena-24.png"));
		btnendSession.setBounds(757, 11, 37, 38);
		contentPane.add(btnendSession);
		btnendSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				InitialWindow iniWini = new InitialWindow();
				iniWini.setVisible(true);
			}
		});
		
		JButton btnHW = new JButton("");
		btnHW.setIcon(new ImageIcon("C:\\Users\\juanb\\git\\ProjectER\\Images\\icons8-p\u00E1gina-principal-24.png"));
		btnHW.setBounds(710, 11, 37, 38);
		contentPane.add(btnHW);
		
		JLabel lblDoctor = new JLabel("  DOCTORS:");
		lblDoctor.setFont(new Font("Gill Sans MT", Font.BOLD, 17));
		lblDoctor.setBounds(44, 156, 124, 38);
		contentPane.add(lblDoctor);
		
		JLabel lblNurses = new JLabel("  NURSES:");
		lblNurses.setFont(new Font("Gill Sans MT", Font.BOLD, 17));
		lblNurses.setBounds(44, 231, 124, 38);
		contentPane.add(lblNurses);
		
		JLabel lblBoxes = new JLabel("BOXES:");
		lblBoxes.setFont(new Font("Gill Sans MT", Font.BOLD, 17));
		lblBoxes.setBounds(44, 317, 124, 38);
		contentPane.add(lblBoxes);
		
		JLabel lblDrugs = new JLabel("  DRUGS:");
		lblDrugs.setFont(new Font("Gill Sans MT", Font.BOLD, 17));
		lblDrugs.setBounds(44, 409, 124, 38);
		contentPane.add(lblDrugs);
		
		JButton btnInsertDoc = new JButton("Insert");
		btnInsertDoc.setForeground(Color.BLACK);
		btnInsertDoc.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		btnInsertDoc.setBackground(new Color(255, 153, 0));
		btnInsertDoc.setBounds(234, 156, 154, 34);
		contentPane.add(btnInsertDoc);
		
		JButton btnDeleteDoc = new JButton("Delete");
		btnDeleteDoc.setForeground(Color.BLACK);
		btnDeleteDoc.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		btnDeleteDoc.setBackground(new Color(255, 153, 0));
		btnDeleteDoc.setBounds(415, 156, 154, 34);
		contentPane.add(btnDeleteDoc);
		
		JButton btnUpdateDoc = new JButton("Update");
		btnUpdateDoc.setForeground(Color.BLACK);
		btnUpdateDoc.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		btnUpdateDoc.setBackground(new Color(255, 153, 0));
		btnUpdateDoc.setBounds(593, 156, 154, 34);
		contentPane.add(btnUpdateDoc);
		
		JButton buttonInsertNur = new JButton("Insert");
		buttonInsertNur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonInsertNur.setForeground(Color.BLACK);
		buttonInsertNur.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		buttonInsertNur.setBackground(new Color(255, 153, 0));
		buttonInsertNur.setBounds(234, 231, 154, 34);
		contentPane.add(buttonInsertNur);
		
		JButton buttonDeleteNur = new JButton("Delete");
		buttonDeleteNur.setForeground(Color.BLACK);
		buttonDeleteNur.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		buttonDeleteNur.setBackground(new Color(255, 153, 0));
		buttonDeleteNur.setBounds(415, 231, 154, 34);
		contentPane.add(buttonDeleteNur);
		
		JButton buttonUpdateNur = new JButton("Update");
		buttonUpdateNur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonUpdateNur.setForeground(Color.BLACK);
		buttonUpdateNur.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		buttonUpdateNur.setBackground(new Color(255, 153, 0));
		buttonUpdateNur.setBounds(593, 231, 154, 34);
		contentPane.add(buttonUpdateNur);
		
		JButton buttonInsertBox = new JButton("Insert");
		buttonInsertBox.setForeground(Color.BLACK);
		buttonInsertBox.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		buttonInsertBox.setBackground(new Color(255, 153, 0));
		buttonInsertBox.setBounds(234, 317, 154, 34);
		contentPane.add(buttonInsertBox);
		
		JButton buttonDeleteBox = new JButton("Delete");
		buttonDeleteBox.setForeground(Color.BLACK);
		buttonDeleteBox.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		buttonDeleteBox.setBackground(new Color(255, 153, 0));
		buttonDeleteBox.setBounds(415, 317, 154, 34);
		contentPane.add(buttonDeleteBox);
		
		JButton buttonUpdateBox = new JButton("Update");
		buttonUpdateBox.setForeground(Color.BLACK);
		buttonUpdateBox.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		buttonUpdateBox.setBackground(new Color(255, 153, 0));
		buttonUpdateBox.setBounds(593, 317, 154, 34);
		contentPane.add(buttonUpdateBox);
		
		JButton buttonInsertDrug = new JButton("Insert");
		buttonInsertDrug.setForeground(Color.BLACK);
		buttonInsertDrug.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		buttonInsertDrug.setBackground(new Color(255, 153, 0));
		buttonInsertDrug.setBounds(234, 409, 154, 34);
		contentPane.add(buttonInsertDrug);
		
		JButton buttonDeleteDrug = new JButton("Delete");
		buttonDeleteDrug.setForeground(Color.BLACK);
		buttonDeleteDrug.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		buttonDeleteDrug.setBackground(new Color(255, 153, 0));
		buttonDeleteDrug.setBounds(415, 409, 154, 34);
		contentPane.add(buttonDeleteDrug);
		
		JButton buttonUpdateDug = new JButton("Update");
		buttonUpdateDug.setForeground(Color.BLACK);
		buttonUpdateDug.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		buttonUpdateDug.setBackground(new Color(255, 153, 0));
		buttonUpdateDug.setBounds(593, 409, 154, 34);
		contentPane.add(buttonUpdateDug);
		btnHW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DbManHW dbManHW = new DbManHW();
				setVisible(false);
				dbManHW.setVisible(true);
			}
		});

		
		/*JButton btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon("C:\\Users\\juanb\\git\\ProjectER\\Images\\icons8-izquierda-c\u00EDrculo-24 (1).png"));
		btnBack.setBounds(663, 11, 37, 38);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		
			}
		});*/
		

	}

}
