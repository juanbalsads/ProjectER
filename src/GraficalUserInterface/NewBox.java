package GraficalUserInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class NewBox extends JFrame {

	private JPanel contentPane;
	private JTextField nametextField;
	private final ButtonGroup buttonGroup = new ButtonGroup();


	public NewBox() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(220, 100, 820, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("   New Box");
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
				HWDbMan hWDbMan = new HWDbMan();
				setVisible(false);
				hWDbMan.setVisible(true);
			}
		});

		
		JButton btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon("C:\\Users\\juanb\\git\\ProjectER\\Images\\icons8-izquierda-c\u00EDrculo-24 (1).png"));
		btnBack.setBounds(663, 11, 37, 38);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HWDbMan hWDbMan = new HWDbMan();
				setVisible(false);
				hWDbMan.setVisible(true);

				

			}
		});
		JLabel label = new JLabel("   Name:");
		label.setFont(new Font("Gill Sans MT", Font.BOLD, 17));
		label.setBounds(39, 107, 76, 38);
		contentPane.add(label);
		
		JRadioButton rdbtnAvailable = new JRadioButton("Available");
		buttonGroup.add(rdbtnAvailable);
		rdbtnAvailable.setBackground(new Color(255, 255, 153));
		rdbtnAvailable.setFont(new Font("Gill Sans MT", Font.BOLD, 20));
		rdbtnAvailable.setBounds(215, 357, 121, 38);
		contentPane.add(rdbtnAvailable);
		
		JRadioButton rdbtnNotAvailable = new JRadioButton("Not Available");
		buttonGroup.add(rdbtnNotAvailable);
		rdbtnNotAvailable.setFont(new Font("Gill Sans MT", Font.BOLD, 20));
		rdbtnNotAvailable.setBackground(new Color(255, 255, 153));
		rdbtnNotAvailable.setBounds(431, 357, 171, 38);
		contentPane.add(rdbtnNotAvailable);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBackground(new Color(204, 153, 0));
		btnCreate.setFont(new Font("Gill Sans MT", Font.BOLD, 15));
		btnCreate.setBounds(278, 520, 89, 30);
		contentPane.add(btnCreate);

	}

}
