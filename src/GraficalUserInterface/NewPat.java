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
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class NewPat extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private JTextField sSNtextField;
	private JTextField nametextField;
	private JTextField weighttextField;
	private JTextField heighttextField;
	private JTextField daytextField;
	private JTextField monthtextField;
	private JTextField yeartextField;


	public NewPat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255, 255, 153));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("   New Patient");
		lblNewLabel.setFont(new Font("Gill Sans MT", Font.BOLD, 20));
		lblNewLabel.setBounds(302, 11, 184, 48);
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
				HWAss assHW = new HWAss();
				setVisible(false);
				assHW.setVisible(true);
			}
		});

		
		JButton btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon("C:\\Users\\juanb\\git\\ProjectER\\Images\\icons8-izquierda-c\u00EDrculo-24 (1).png"));
		btnBack.setBounds(663, 11, 37, 38);
		contentPane.add(btnBack);
		
		JLabel lblSsn = new JLabel("   SSN:");
		lblSsn.setFont(new Font("Gill Sans MT", Font.BOLD, 17));
		lblSsn.setBounds(48, 70, 76, 38);
		contentPane.add(lblSsn);
		
		JLabel lblName = new JLabel("   Name:");
		lblName.setFont(new Font("Gill Sans MT", Font.BOLD, 17));
		lblName.setBounds(48, 107, 76, 38);
		contentPane.add(lblName);
		
		JLabel lblWeight = new JLabel("   Weight:");
		lblWeight.setFont(new Font("Gill Sans MT", Font.BOLD, 17));
		lblWeight.setBounds(48, 156, 98, 38);
		contentPane.add(lblWeight);
		
		JLabel lblHeight = new JLabel("   Height:");
		lblHeight.setFont(new Font("Gill Sans MT", Font.BOLD, 17));
		lblHeight.setBounds(48, 205, 76, 38);
		contentPane.add(lblHeight);
		
		JLabel lblDob = new JLabel("   DOB:");
		lblDob.setFont(new Font("Gill Sans MT", Font.BOLD, 17));
		lblDob.setBounds(48, 254, 76, 38);
		contentPane.add(lblDob);
		
		JRadioButton rdbtnMale = new JRadioButton("  Male");
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setBackground(new Color(255, 255, 153));
		rdbtnMale.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		rdbtnMale.setBounds(193, 298, 109, 30);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("  Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		rdbtnFemale.setBackground(new Color(255, 255, 153));
		rdbtnFemale.setBounds(360, 298, 109, 30);
		contentPane.add(rdbtnFemale);
		
		JRadioButton rdbtnA = new JRadioButton(" A");
		buttonGroup_1.add(rdbtnA);
		rdbtnA.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		rdbtnA.setBackground(new Color(255, 255, 153));
		rdbtnA.setBounds(128, 331, 57, 30);
		contentPane.add(rdbtnA);
		
		JRadioButton rdbtnB = new JRadioButton(" B");
		buttonGroup_1.add(rdbtnB);
		rdbtnB.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		rdbtnB.setBackground(new Color(255, 255, 153));
		rdbtnB.setBounds(246, 331, 57, 30);
		contentPane.add(rdbtnB);
		
		JRadioButton rdbtnAb = new JRadioButton("AB");
		buttonGroup_1.add(rdbtnAb);
		rdbtnAb.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		rdbtnAb.setBackground(new Color(255, 255, 153));
		rdbtnAb.setBounds(351, 331, 57, 30);
		contentPane.add(rdbtnAb);
		
		JRadioButton radioButton_2 = new JRadioButton(" 0");
		buttonGroup_1.add(radioButton_2);
		radioButton_2.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		radioButton_2.setBackground(new Color(255, 255, 153));
		radioButton_2.setBounds(483, 331, 57, 30);
		contentPane.add(radioButton_2);
		
		JRadioButton radioButton = new JRadioButton("+");
		buttonGroup_2.add(radioButton);
		radioButton.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		radioButton.setBackground(new Color(255, 255, 153));
		radioButton.setBounds(206, 364, 57, 30);
		contentPane.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("-");
		buttonGroup_2.add(radioButton_1);
		radioButton_1.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		radioButton_1.setBackground(new Color(255, 255, 153));
		radioButton_1.setBounds(373, 364, 57, 30);
		contentPane.add(radioButton_1);
		
		sSNtextField = new JTextField();
		sSNtextField.setBounds(173, 70, 301, 31);
		contentPane.add(sSNtextField);
		sSNtextField.setColumns(10);
		
		nametextField = new JTextField();
		nametextField.setColumns(10);
		nametextField.setBounds(173, 113, 301, 31);
		contentPane.add(nametextField);
		
		weighttextField = new JTextField();
		weighttextField.setColumns(10);
		weighttextField.setBounds(173, 162, 301, 31);
		contentPane.add(weighttextField);
		
		heighttextField = new JTextField();
		heighttextField.setColumns(10);
		heighttextField.setBounds(173, 211, 301, 31);
		contentPane.add(heighttextField);
		
		daytextField = new JTextField();
		daytextField.setColumns(10);
		daytextField.setBounds(229, 260, 46, 31);
		contentPane.add(daytextField);
		
		monthtextField = new JTextField();
		monthtextField.setColumns(10);
		monthtextField.setBounds(357, 260, 46, 31);
		contentPane.add(monthtextField);
		
		yeartextField = new JTextField();
		yeartextField.setColumns(10);
		yeartextField.setBounds(460, 260, 46, 31);
		contentPane.add(yeartextField);
		
		JLabel lblDay = new JLabel(" day:");
		lblDay.setFont(new Font("Gill Sans MT", Font.BOLD, 17));
		lblDay.setBounds(173, 254, 46, 38);
		contentPane.add(lblDay);
		
		JLabel lblMonth = new JLabel(" month:");
		lblMonth.setFont(new Font("Gill Sans MT", Font.BOLD, 17));
		lblMonth.setBounds(285, 254, 70, 38);
		contentPane.add(lblMonth);
		
		JLabel lblYear = new JLabel(" year:");
		lblYear.setFont(new Font("Gill Sans MT", Font.BOLD, 17));
		lblYear.setBounds(413, 254, 46, 38);
		contentPane.add(lblYear);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(173, 408, 296, 91);
		contentPane.add(textPane);
		
		JLabel lblHistory = new JLabel("   History:");
		lblHistory.setFont(new Font("Gill Sans MT", Font.BOLD, 17));
		lblHistory.setBounds(48, 408, 98, 38);
		contentPane.add(lblHistory);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBackground(new Color(204, 153, 0));
		btnCreate.setFont(new Font("Gill Sans MT", Font.BOLD, 15));
		btnCreate.setBounds(278, 520, 89, 30);
		contentPane.add(btnCreate);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HWAss assHW = new HWAss();
				setVisible(false);
				assHW.setVisible(true);


			}
		});
	}
}
