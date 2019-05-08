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

public class InitialWindow extends JFrame {

	private JPanel contentPane;

	public InitialWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(220, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\juanb\\git\\ProjectER\\Images\\dataManager.png"));
		lblNewLabel_3.setBounds(586, 124, 141, 212);
		contentPane.add(lblNewLabel_3);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\juanb\\git\\ProjectER\\Images\\nurse.png"));
		label.setBounds(409, 124, 141, 212);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\juanb\\git\\ProjectER\\Images\\Doctor.png"));
		lblNewLabel.setBounds(191, 114, 180, 212);
		contentPane.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("");

		label_1.setIcon(new ImageIcon("C:\\Users\\juanb\\git\\ProjectER\\Images\\Assistant.png"));
		label_1.setBounds(20, 114, 180, 212);
		contentPane.add(label_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\juanb\\git\\ProjectER\\Images\\hospital100.png"));
		lblNewLabel_1.setBounds(10, 0, 106, 128);
		contentPane.add(lblNewLabel_1);
		
		JPanel nursePan = new JPanel();
		nursePan.setBackground(new Color(255, 153, 0));
		nursePan.setBounds(30, 344, 112, 39);
		contentPane.add(nursePan);
		
		JLabel lblNurse = new JLabel("NURSE");
		lblNurse.setFont(new Font("Gill Sans MT", Font.BOLD, 20));
		nursePan.add(lblNurse);
		nursePan.setVisible(false);
		
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nursePan.setVisible(true);
				
				
			}
		});

	}
	
	
}
