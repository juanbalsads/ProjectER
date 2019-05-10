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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class EditAdm extends JFrame {

	private JPanel contentPane;
	private JTextField PatientSSNtextField;
	private JTextField Doctor_idtextField;
	private JTextField Nurse_idtextField;
	private JTextField box_idtextField;
	private JTextField arrtime_daytextField;
	private JTextField arrtim_monthtextField;
	private JTextField arrtim_yeartextField;
	private JTextField arrtim_houtextField;
	private JTextField arrtim_mintextField;


	public EditAdm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(220, 100, 820, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("   Edit Admission");
		lblNewLabel.setFont(new Font("Gill Sans MT", Font.BOLD, 20));
		lblNewLabel.setBounds(354, 36, 184, 48);
		contentPane.add(lblNewLabel);
		

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
				AssHW assHW = new AssHW();
				setVisible(false);
				assHW.setVisible(true);
			}
		});

		
		JButton btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon("C:\\Users\\juanb\\git\\ProjectER\\Images\\icons8-izquierda-c\u00EDrculo-24 (1).png"));
		btnBack.setBounds(663, 11, 37, 38);
		contentPane.add(btnBack);
		
		JLabel lblPatientSsn = new JLabel("  Patient SSN:");
		lblPatientSsn.setFont(new Font("Gill Sans MT", Font.BOLD, 17));
		lblPatientSsn.setBounds(39, 94, 124, 38);
		contentPane.add(lblPatientSsn);
		
		PatientSSNtextField = new JTextField();
		PatientSSNtextField.setColumns(10);
		PatientSSNtextField.setBounds(237, 101, 301, 31);
		contentPane.add(PatientSSNtextField);
		
		JLabel lblDoctor = new JLabel("  Doctor:");
		lblDoctor.setFont(new Font("Gill Sans MT", Font.BOLD, 17));
		lblDoctor.setBounds(49, 164, 124, 38);
		contentPane.add(lblDoctor);
		
		JLabel lblNurse = new JLabel("  Nurse:");
		lblNurse.setFont(new Font("Gill Sans MT", Font.BOLD, 17));
		lblNurse.setBounds(39, 228, 124, 38);
		contentPane.add(lblNurse);
		
		JLabel lblBox = new JLabel("  Box:");
		lblBox.setFont(new Font("Gill Sans MT", Font.BOLD, 17));
		lblBox.setBounds(39, 291, 124, 38);
		contentPane.add(lblBox);
		
		JLabel lblArrivalTime = new JLabel("  Arrival Time:");
		lblArrivalTime.setFont(new Font("Gill Sans MT", Font.BOLD, 17));
		lblArrivalTime.setBounds(39, 345, 124, 38);
		contentPane.add(lblArrivalTime);
		
		Doctor_idtextField = new JTextField();
		Doctor_idtextField.setColumns(10);
		Doctor_idtextField.setBounds(237, 170, 301, 31);
		contentPane.add(Doctor_idtextField);
		
		Nurse_idtextField = new JTextField();
		Nurse_idtextField.setColumns(10);
		Nurse_idtextField.setBounds(237, 234, 301, 31);
		contentPane.add(Nurse_idtextField);
		
		box_idtextField = new JTextField();
		box_idtextField.setColumns(10);
		box_idtextField.setBounds(237, 297, 301, 31);
		contentPane.add(box_idtextField);
		
		arrtime_daytextField = new JTextField();
		arrtime_daytextField.setColumns(10);
		arrtime_daytextField.setBounds(254, 351, 49, 31);
		contentPane.add(arrtime_daytextField);
		
		JLabel lblDay = new JLabel("  day:");
		lblDay.setFont(new Font("Gill Sans MT", Font.BOLD, 17));
		lblDay.setBounds(186, 345, 58, 38);
		contentPane.add(lblDay);
		
		JLabel lblMonth = new JLabel("  month:");
		lblMonth.setFont(new Font("Gill Sans MT", Font.BOLD, 17));
		lblMonth.setBounds(306, 345, 71, 38);
		contentPane.add(lblMonth);
		
		JLabel lblYear = new JLabel("  year:");
		lblYear.setFont(new Font("Gill Sans MT", Font.BOLD, 17));
		lblYear.setBounds(451, 345, 71, 38);
		contentPane.add(lblYear);
		
		arrtim_monthtextField = new JTextField();
		arrtim_monthtextField.setColumns(10);
		arrtim_monthtextField.setBounds(387, 351, 49, 31);
		contentPane.add(arrtim_monthtextField);
		
		arrtim_yeartextField = new JTextField();
		arrtim_yeartextField.setColumns(10);
		arrtim_yeartextField.setBounds(516, 351, 49, 31);
		contentPane.add(arrtim_yeartextField);
		
		JLabel lblHour = new JLabel("  hour:");
		lblHour.setFont(new Font("Gill Sans MT", Font.BOLD, 17));
		lblHour.setBounds(282, 403, 58, 38);
		contentPane.add(lblHour);
		
		arrtim_houtextField = new JTextField();
		arrtim_houtextField.setColumns(10);
		arrtim_houtextField.setBounds(342, 409, 49, 31);
		contentPane.add(arrtim_houtextField);
		
		JLabel label = new JLabel("  :");
		label.setFont(new Font("Gill Sans MT", Font.BOLD, 17));
		label.setBounds(389, 403, 24, 38);
		contentPane.add(label);
		
		arrtim_mintextField = new JTextField();
		arrtim_mintextField.setColumns(10);
		arrtim_mintextField.setBounds(412, 410, 49, 31);
		contentPane.add(arrtim_mintextField);
		
		JButton submit_button = new JButton("Edit");
		submit_button.setFont(new Font("Gill Sans MT", Font.BOLD, 15));
		submit_button.setBackground(new Color(204, 153, 0));
		submit_button.setBounds(347, 483, 89, 30);
		contentPane.add(submit_button);
		
		JButton Pat_button = new JButton("Patients");
		Pat_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListPat listPat = new ListPat();
				//setVisible(false);
				listPat.setVisible(true);
				
			}
		});
		Pat_button.setForeground(Color.BLACK);
		Pat_button.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		Pat_button.setBackground(new Color(255, 153, 0));
		Pat_button.setBounds(593, 96, 154, 34);
		contentPane.add(Pat_button);
		
		JButton Doc_button = new JButton("Doctors");
		Doc_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListDoc listDoc = new ListDoc();
				//setVisible(false);
				listDoc.setVisible(true);
			}
		});
		Doc_button.setForeground(Color.BLACK);
		Doc_button.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		Doc_button.setBackground(new Color(255, 153, 0));
		Doc_button.setBounds(593, 166, 154, 34);
		contentPane.add(Doc_button);
		
		JButton Nur_button = new JButton("Nurses");
		Nur_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListNur listNur = new ListNur();
				//setVisible(false);
				listNur.setVisible(true);
			}
		});
		Nur_button.setForeground(Color.BLACK);
		Nur_button.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		Nur_button.setBackground(new Color(255, 153, 0));
		Nur_button.setBounds(593, 230, 154, 34);
		contentPane.add(Nur_button);
		
		JButton Box_button = new JButton("Boxes");
		Box_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListBox listBox = new ListBox();
				//setVisible(false);
				listBox.setVisible(true);
			}
		});
		Box_button.setForeground(Color.BLACK);
		Box_button.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		Box_button.setBackground(new Color(255, 153, 0));
		Box_button.setBounds(593, 298, 154, 34);
		contentPane.add(Box_button);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AssHW assHW = new AssHW();
				setVisible(true);
				assHW.setVisible(true);

			}
		});
		

	}

}
