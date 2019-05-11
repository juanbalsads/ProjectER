package GraficalUserInterface;

import java.awt.BorderLayout;
import ER.jpa.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import ER.POJOS.Admission;

import javax.swing.JList;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JTable;

public class ListAdm extends JFrame {

	private JPanel contentPane;
	private JList list;
	private DefaultListModel modelList;
	private static EntityManager em;
	private JPAManager manager;
	

	public ListAdm() {
		manager = new JPAManager();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(220, 100, 820, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("  Admissions");
		lblNewLabel.setFont(new Font("Gill Sans MT", Font.BOLD, 24));
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
				HWAss assHW = new HWAss();
				setVisible(false);
				assHW.setVisible(true);
			}
		});

		
		JButton btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon("C:\\Users\\juanb\\git\\ProjectER\\Images\\icons8-izquierda-c\u00EDrculo-24 (1).png"));
		btnBack.setBounds(663, 11, 37, 38);
		contentPane.add(btnBack);

		
		/*ArrayList<Admission> listaadm = new ArrayList<Admission>();
		listaadm = (ArrayList<Admission>) manager.listAdmissionsList();
		list = new JList();
        modelList = new DefaultListModel();
 

        for (int i = 0; i < listaadm.size(); i++) {
        	
            modelList.addElement(listaadm.get(i));
        }
        list.setModel(modelList);
        JScrollPane jscrollPane = new JScrollPane();
        list.add(jscrollPane, BorderLayout.EAST);
		
		
		Query q1 = em.createNativeQuery("SELECT * FROM Admissions", Admission.class);
			List<Admission> adms = (List<Admission>) q1.getResultList();
			for (Admission adm : adms) {
				System.out.println(adm);
			}
		
		
		list.setVisible(true);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(91, 119, 609, 284);
		contentPane.add(list);*/
		
		
		
		
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HWAss assHW = new HWAss();
				setVisible(true);
				assHW.setVisible(true);


			}
		});
	}
}
