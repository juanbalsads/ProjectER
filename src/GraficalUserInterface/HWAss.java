package GraficalUserInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class HWAss extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JTextField TypeSSNText;
	private JLabel TypeSSNLab;
	private JButton TypeSSNBut;
	private JButton btnBack;
	
	private JButton TypeIDBut;
	private JLabel TypeIDLab;
	private JTextField TypeIDText;
	private JButton btnListAdmission;
	
	public HWAss() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(220, 100, 820, 600);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("New Admission");
		btnNewButton.setBackground(new Color(255, 153, 0));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		btnNewButton.setBounds(66, 138, 193, 45);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\juanb\\git\\ProjectER\\Images\\hospital100.png"));
		label.setBounds(0, 0, 106, 128);
		contentPane.add(label);
		
		JButton btnEditAdmission = new JButton("Edit Admission");
		btnEditAdmission.setForeground(Color.BLACK);
		btnEditAdmission.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		btnEditAdmission.setBackground(new Color(255, 153, 0));
		btnEditAdmission.setBounds(66, 194, 193, 45);
		contentPane.add(btnEditAdmission);
		
		JButton btnNewPatient = new JButton("New Patient");

		btnNewPatient.setForeground(Color.BLACK);
		btnNewPatient.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		btnNewPatient.setBackground(new Color(255, 153, 0));
		btnNewPatient.setBounds(66, 250, 193, 45);
		contentPane.add(btnNewPatient);
		
		JButton btnEditPatient = new JButton("Edit Patient");

		btnEditPatient.setForeground(Color.BLACK);
		btnEditPatient.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		btnEditPatient.setBackground(new Color(255, 153, 0));
		btnEditPatient.setBounds(66, 306, 193, 45);
		contentPane.add(btnEditPatient);
		
		JButton btnPatients = new JButton("Patients");
		btnPatients.setForeground(Color.BLACK);
		btnPatients.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		btnPatients.setBackground(new Color(255, 153, 0));
		btnPatients.setBounds(48, 399, 154, 56);
		contentPane.add(btnPatients);
		
		JButton btnDoctors = new JButton("Doctors");
		btnDoctors.setForeground(Color.BLACK);
		btnDoctors.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		btnDoctors.setBackground(new Color(255, 153, 0));
		btnDoctors.setBounds(239, 399, 154, 56);
		contentPane.add(btnDoctors);
		
		JButton btnNurses = new JButton("Nurses");
		btnNurses.setForeground(Color.BLACK);
		btnNurses.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		btnNurses.setBackground(new Color(255, 153, 0));
		btnNurses.setBounds(433, 399, 154, 56);
		contentPane.add(btnNurses);
		
		JButton btnBoxes = new JButton("Boxes");
		btnBoxes.setForeground(Color.BLACK);
		btnBoxes.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		btnBoxes.setBackground(new Color(255, 153, 0));
		btnBoxes.setBounds(620, 399, 154, 56);
		contentPane.add(btnBoxes);
		
		TypeSSNText = new JTextField();
		TypeSSNText.setBounds(323, 194, 264, 45);
		contentPane.add(TypeSSNText);
		TypeSSNText.setColumns(10);
		TypeSSNText.setVisible(false);
		
		JLabel TypeSSNLab = new JLabel("Type the PATIENT'S SSN:");
		TypeSSNLab.setFont(new Font("Gill Sans MT", Font.BOLD, 17));
		TypeSSNLab.setBounds(323, 138, 339, 45);
		contentPane.add(TypeSSNLab);
		TypeSSNLab.setVisible(false);
		
		JButton TypeSSNBut = new JButton("");
		TypeSSNBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdatePat editPat = new UpdatePat();
				setVisible(false);
				editPat.setVisible(true);
			}
		});
		TypeSSNBut.setIcon(new ImageIcon("C:\\Users\\juanb\\git\\ProjectER\\Images\\icons8-derecha-c\u00EDrculo-24.png"));
		TypeSSNBut.setForeground(Color.BLACK);
		TypeSSNBut.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		TypeSSNBut.setBackground(new Color(204, 153, 0));
		TypeSSNBut.setBounds(611, 194, 51, 45);
		contentPane.add(TypeSSNBut);
		TypeSSNBut.setVisible(false);

		
		TypeIDText = new JTextField();
		TypeIDText.setBounds(323, 194, 264, 45);
		contentPane.add(TypeIDText);
		TypeIDText.setColumns(10);
		TypeIDText.setVisible(false);
		
		TypeIDLab = new JLabel("Type the ADMISSION'S ID number:");
		TypeIDLab.setFont(new Font("Gill Sans MT", Font.BOLD, 17));
		TypeIDLab.setBounds(323, 138, 339, 45);
		contentPane.add(TypeIDLab);
		TypeIDLab.setVisible(false);
		
		TypeIDBut = new JButton("");
		TypeIDBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateAdm editAdm = new UpdateAdm();
				setVisible(false);
				editAdm.setVisible(true);
			}
		});
		TypeIDBut.setIcon(new ImageIcon("C:\\Users\\juanb\\git\\ProjectER\\Images\\icons8-derecha-c\u00EDrculo-24.png"));
		TypeIDBut.setForeground(Color.BLACK);
		TypeIDBut.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		TypeIDBut.setBackground(new Color(204, 102, 0));
		TypeIDBut.setBounds(611, 194, 51, 45);
		contentPane.add(TypeIDBut);
		TypeIDBut.setVisible(false);
		
		JButton btnListAdmission = new JButton("Admissions");
		btnListAdmission.setVisible(false);
		btnListAdmission.setForeground(Color.BLACK);
		btnListAdmission.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
		btnListAdmission.setBackground(new Color(255, 153, 0));
		btnListAdmission.setBounds(402, 250, 185, 38);
		contentPane.add(btnListAdmission);
				
		
		btnEditAdmission.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TypeIDText.setVisible(true);
				TypeIDLab.setVisible(true);
				TypeIDBut.setVisible(true);
				btnListAdmission.setVisible(true);
				TypeSSNText.setVisible(false);
				TypeSSNLab.setVisible(false);
				TypeSSNBut.setVisible(false);
				
			}
		});
		

		
		btnEditPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TypeSSNText.setVisible(true);
				TypeSSNLab.setVisible(true);
				TypeSSNBut.setVisible(true);
				TypeIDText.setVisible(false);
				TypeIDLab.setVisible(false);
				TypeIDBut.setVisible(false);
				btnListAdmission.setVisible(false);
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewAdm assNewAdm = new NewAdm();
				setVisible(false);
				assNewAdm.setVisible(true);
				
			}
		});
		btnNewPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewPat newPat = new NewPat();
				setVisible(false);
				newPat.setVisible(true);
			}
		});
		btnDoctors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListDoc listDoc = new ListDoc();
				setVisible(false);
				listDoc.setVisible(true);
			}
		});
		btnBoxes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListBox listBox = new ListBox();
				setVisible(false);
				listBox.setVisible(true);
			}
		});
		btnListAdmission.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListAdm listAdm = new ListAdm();
				setVisible(false);
				listAdm.setVisible(true);
			}
		});
		btnNurses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListNur listNur = new ListNur();
				setVisible(false);
				listNur.setVisible(true);
			}
		});
		btnPatients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListPat listPat = new ListPat();
				setVisible(false);
				listPat.setVisible(true);
			}
		});
		//RIGHT BUTT
		
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
		btnHW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HWAss assHW = new HWAss();
				setVisible(false);
				assHW.setVisible(true);
			}
		});

		
		btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon("C:\\Users\\juanb\\git\\ProjectER\\Images\\icons8-izquierda-c\u00EDrculo-24 (1).png"));
		btnBack.setBounds(663, 11, 37, 38);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("ASSISTANT HOME WINDOW");
		lblNewLabel.setFont(new Font("Gill Sans MT", Font.BOLD, 25));
		lblNewLabel.setBounds(239, 47, 374, 32);
		contentPane.add(lblNewLabel);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TypeSSNText.setVisible(false);
				TypeSSNLab.setVisible(false);
				TypeSSNBut.setVisible(false);
				TypeIDText.setVisible(false);
				TypeIDLab.setVisible(false);
				TypeIDBut.setVisible(false);
				btnListAdmission.setVisible(false);
			}
		});
		
	}
}

