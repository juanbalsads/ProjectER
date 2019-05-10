package GraficalUserInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InitialWindow extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public InitialWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(220, 100, 820, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(585, 114, 141, 212);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\juanb\\git\\ProjectER\\Images\\dataManager.png"));
		contentPane.add(lblNewLabel_3);
		
		JLabel label = new JLabel("");
		label.setBounds(409, 124, 141, 212);
		label.setIcon(new ImageIcon("C:\\Users\\juanb\\git\\ProjectER\\Images\\nurse.png"));
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(191, 114, 180, 212);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\juanb\\git\\ProjectER\\Images\\Doctor.png"));
		contentPane.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(20, 114, 180, 212);

		label_1.setIcon(new ImageIcon("C:\\Users\\juanb\\git\\ProjectER\\Images\\Assistant.png"));
		contentPane.add(label_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(10, 0, 106, 128);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\juanb\\git\\ProjectER\\Images\\hospital100.png"));
		contentPane.add(lblNewLabel_1);
		
		JRadioButton rdbtnAss = new JRadioButton("ASSISTANT");
		rdbtnAss.setBounds(20, 333, 145, 32);
		buttonGroup.add(rdbtnAss);
		rdbtnAss.setFont(new Font("Gill Sans MT", Font.BOLD, 20));
		rdbtnAss.setBackground(new Color(255, 153, 0));
		contentPane.add(rdbtnAss);
		
		JRadioButton rdbtnDoctor = new JRadioButton("DOCTOR");
		rdbtnDoctor.setBounds(214, 333, 132, 32);
		buttonGroup.add(rdbtnDoctor);
		rdbtnDoctor.setFont(new Font("Gill Sans MT", Font.BOLD, 20));
		rdbtnDoctor.setBackground(new Color(255, 153, 0));
		contentPane.add(rdbtnDoctor);
		
		JRadioButton rdbtnNurse = new JRadioButton("  NURSE");
		rdbtnNurse.setBounds(419, 333, 131, 32);
		buttonGroup.add(rdbtnNurse);
		rdbtnNurse.setFont(new Font("Gill Sans MT", Font.BOLD, 20));
		rdbtnNurse.setBackground(new Color(255, 153, 0));
		contentPane.add(rdbtnNurse);
		
		JRadioButton rdbtnDbManager = new JRadioButton("DB MANAGER");
		rdbtnDbManager.setBounds(585, 333, 171, 32);
		buttonGroup.add(rdbtnDbManager);
		rdbtnDbManager.setFont(new Font("Gill Sans MT", Font.BOLD, 20));
		rdbtnDbManager.setBackground(new Color(255, 153, 0));
		contentPane.add(rdbtnDbManager);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setFont(new Font("Gill Sans MT", Font.BOLD, 14));
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				if(rdbtnAss.isSelected()) {
					setVisible(false);
					AssHW assHW = new AssHW();
					assHW.setVisible(true);
				}
				if(rdbtnDoctor.isSelected()) {
					setVisible(false);
					DocHW docHW = new DocHW();
					docHW.setVisible(true);
				}
				if(rdbtnNurse.isSelected()) {
					setVisible(false);
					NurHW nurHW = new NurHW();
					nurHW.setVisible(true);
				}
				if(rdbtnDbManager.isSelected()) {
					setVisible(false);
					DbManHW DbManHW = new DbManHW();
					DbManHW.setVisible(true);
				}
				
			}
		});
		btnSignIn.setForeground(new Color(0, 0, 0));
		btnSignIn.setBounds(499, 419, 106, 32);
		btnSignIn.setBackground(new Color(255, 153, 51));
		contentPane.add(btnSignIn);
		
		
	}
}
