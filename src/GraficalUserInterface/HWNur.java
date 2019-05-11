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

public class HWNur extends JFrame {

	private JPanel contentPane;


	public HWNur() {
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
		
		JLabel lblNewLabel = new JLabel("NURSE HOME WINDOW");
		lblNewLabel.setFont(new Font("Gill Sans MT", Font.BOLD, 25));
		lblNewLabel.setBounds(239, 47, 374, 32);
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
		btnHW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HWNur nurHW = new HWNur();
				setVisible(false);
				nurHW.setVisible(true);
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
