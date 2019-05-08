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

public class AssHW extends JFrame {

	private JPanel contentPane;
	private JPanel panel;

	public AssHW() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(220, 100, 800, 500);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AssNewAdm f = new AssNewAdm();
				f.setVisible(true);
				
			}
		});

	
		panel.setBackground(new Color(255, 153, 0));
		panel.setBounds(10, 95, 221, 56);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewadmission = new JLabel("NEW ADMISSION");
		lblNewadmission.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblNewadmission.setBounds(56, 11, 121, 34);
		panel.add(lblNewadmission);
		
		
	}
	public static void main(String[] args) {
		AssHW frame = new AssHW();
		frame.setVisible(true);
		
		
	}
}

