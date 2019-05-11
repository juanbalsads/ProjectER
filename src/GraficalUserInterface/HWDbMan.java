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

public class HWDbMan extends JFrame {

	private JPanel contentPane;


	public HWDbMan() {
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
		btnInsertDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				NewDoc newDoc = new NewDoc();
				newDoc.setVisible(true);
			}
		});
		btnInsertDoc.setForeground(Color.BLACK);
		btnInsertDoc.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		btnInsertDoc.setBackground(new Color(255, 153, 0));
		btnInsertDoc.setBounds(178, 158, 135, 34);
		contentPane.add(btnInsertDoc);
		
		JButton btnDeleteDoc = new JButton("Delete");
		btnDeleteDoc.setForeground(Color.BLACK);
		btnDeleteDoc.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		btnDeleteDoc.setBackground(new Color(255, 153, 0));
		btnDeleteDoc.setBounds(323, 160, 130, 34);
		contentPane.add(btnDeleteDoc);
		
		JButton btnUpdateDoc = new JButton("Update");
		btnUpdateDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				UpdateDoc updateDoc = new UpdateDoc();
				updateDoc.setVisible(true);
			}
		});
		btnUpdateDoc.setForeground(Color.BLACK);
		btnUpdateDoc.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		btnUpdateDoc.setBackground(new Color(255, 153, 0));
		btnUpdateDoc.setBounds(463, 160, 133, 34);
		contentPane.add(btnUpdateDoc);
		
		JButton buttonInsertNur = new JButton("Insert");
		buttonInsertNur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				NewNur newNur = new NewNur();
				newNur.setVisible(true);
			}
		});
		buttonInsertNur.setForeground(Color.BLACK);
		buttonInsertNur.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		buttonInsertNur.setBackground(new Color(255, 153, 0));
		buttonInsertNur.setBounds(178, 233, 135, 34);
		contentPane.add(buttonInsertNur);
		
		JButton buttonDeleteNur = new JButton("Delete");
		buttonDeleteNur.setForeground(Color.BLACK);
		buttonDeleteNur.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		buttonDeleteNur.setBackground(new Color(255, 153, 0));
		buttonDeleteNur.setBounds(323, 235, 130, 34);
		contentPane.add(buttonDeleteNur);
		
		JButton buttonUpdateNur = new JButton("Update");
		buttonUpdateNur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				UpdateNur updateNur = new UpdateNur();
				updateNur.setVisible(true);
			}
		});
		buttonUpdateNur.setForeground(Color.BLACK);
		buttonUpdateNur.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		buttonUpdateNur.setBackground(new Color(255, 153, 0));
		buttonUpdateNur.setBounds(463, 233, 133, 34);
		contentPane.add(buttonUpdateNur);
		
		JButton buttonInsertBox = new JButton("Insert");
		buttonInsertBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				NewBox newBox = new NewBox();
				newBox.setVisible(true);
			}
		});
		buttonInsertBox.setForeground(Color.BLACK);
		buttonInsertBox.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		buttonInsertBox.setBackground(new Color(255, 153, 0));
		buttonInsertBox.setBounds(178, 319, 135, 34);
		contentPane.add(buttonInsertBox);
		
		JButton buttonDeleteBox = new JButton("Delete");
		buttonDeleteBox.setForeground(Color.BLACK);
		buttonDeleteBox.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		buttonDeleteBox.setBackground(new Color(255, 153, 0));
		buttonDeleteBox.setBounds(323, 321, 130, 34);
		contentPane.add(buttonDeleteBox);
		
		JButton buttonUpdateBox = new JButton("Update");
		buttonUpdateBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				UpdateBox updateBox = new UpdateBox();
				updateBox.setVisible(true);
				
			}
		});
		buttonUpdateBox.setForeground(Color.BLACK);
		buttonUpdateBox.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		buttonUpdateBox.setBackground(new Color(255, 153, 0));
		buttonUpdateBox.setBounds(463, 321, 133, 34);
		contentPane.add(buttonUpdateBox);
		
		JButton buttonInsertDrug = new JButton("Insert");
		buttonInsertDrug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				NewDrug newDrug = new NewDrug();
				newDrug.setVisible(true);
				
			}
		});
		buttonInsertDrug.setForeground(Color.BLACK);
		buttonInsertDrug.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		buttonInsertDrug.setBackground(new Color(255, 153, 0));
		buttonInsertDrug.setBounds(178, 411, 135, 34);
		contentPane.add(buttonInsertDrug);
		
		JButton buttonDeleteDrug = new JButton("Delete");
		buttonDeleteDrug.setForeground(Color.BLACK);
		buttonDeleteDrug.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		buttonDeleteDrug.setBackground(new Color(255, 153, 0));
		buttonDeleteDrug.setBounds(323, 413, 130, 34);
		contentPane.add(buttonDeleteDrug);
		
		JButton buttonUpdateDug = new JButton("Update");
		buttonUpdateDug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				UpdateDrug updateDrug = new UpdateDrug();
				updateDrug.setVisible(true);
			}
			
		});
		buttonUpdateDug.setForeground(Color.BLACK);
		buttonUpdateDug.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		buttonUpdateDug.setBackground(new Color(255, 153, 0));
		buttonUpdateDug.setBounds(463, 413, 133, 34);
		contentPane.add(buttonUpdateDug);
		
		JButton listDoc = new JButton("List");
		listDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListDoc listDoc = new ListDoc();
				setVisible(false);
				listDoc.setVisible(true);
			}
		});
		listDoc.setForeground(Color.BLACK);
		listDoc.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		listDoc.setBackground(new Color(255, 153, 0));
		listDoc.setBounds(606, 160, 133, 34);
		contentPane.add(listDoc);
		
		JButton listNur = new JButton("List");
		listNur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListNur listnur = new ListNur();
				setVisible(false);
				listnur.setVisible(true);
				
			}
		});
		listNur.setForeground(Color.BLACK);
		listNur.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		listNur.setBackground(new Color(255, 153, 0));
		listNur.setBounds(606, 231, 133, 34);
		contentPane.add(listNur);
		
		JButton listBox = new JButton("List");
		listBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListBox listBox = new ListBox();
				setVisible(false);
				listBox.setVisible(true);
			}
		});
		listBox.setForeground(Color.BLACK);
		listBox.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		listBox.setBackground(new Color(255, 153, 0));
		listBox.setBounds(606, 321, 133, 34);
		contentPane.add(listBox);
		
		JButton listDrug = new JButton("List");
		listDrug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListDrug listDrug = new ListDrug();
				setVisible(false);
				listDrug.setVisible(true);
			}
		});
		listDrug.setForeground(Color.BLACK);
		listDrug.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		listDrug.setBackground(new Color(255, 153, 0));
		listDrug.setBounds(606, 413, 133, 34);
		contentPane.add(listDrug);
		btnHW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HWDbMan dbManHW = new HWDbMan();
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
