package util;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AssignBack_Prac {
	
	private JFrame frmBookstoreManagementSystem;
	
	Assignment_DTO dto = new Assignment_DTO();
	Assignment_DAO dao = new Assignment_DAO();
	
	private JTextField IDTfield;
	private JPasswordField PWTField;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AssignBack_Prac window = new AssignBack_Prac();
					window.frmBookstoreManagementSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AssignBack_Prac() {
		initialize();
	}

	private void initialize() {
		frmBookstoreManagementSystem = new JFrame();
		frmBookstoreManagementSystem.setTitle("Bookstore Management System");
		frmBookstoreManagementSystem.setBounds(100, 100, 418, 278);
		frmBookstoreManagementSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImagePanel panel = new ImagePanel(new ImageIcon("C:\\Users\\user\\Desktop\\bono.gif").getImage());
		frmBookstoreManagementSystem.getContentPane().add(panel);
		frmBookstoreManagementSystem.setResizable(false);
		
		JButton EXITbtn = new JButton("EXIT");
		EXITbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		EXITbtn.setBounds(341, 220, 97, 23);
		panel.add(EXITbtn);
		
		JButton Loginbtn = new JButton("Login");
		Loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dto.setId(IDTfield.getText());
				dto.setPassword(PWTField.getText());
				try {
					dao.Login(dto.getId(), dto.getPassword());
				} catch (SQLException e1) {
				}
			}
		});
		Loginbtn.setBounds(232, 220, 97, 23);
		panel.add(Loginbtn);
		
		IDTfield = new JTextField();
		IDTfield.setColumns(10);
		IDTfield.setBounds(266, 153, 172, 21);
		panel.add(IDTfield);
		
		JLabel IDLabel = new JLabel("ID");
		IDLabel.setBounds(197, 156, 57, 15);
		panel.add(IDLabel);
		
		JLabel PWLabel = new JLabel("PW");
		PWLabel.setBounds(197, 192, 57, 15);
		panel.add(PWLabel);
		
		PWTField = new JPasswordField();
		PWTField.setBounds(266, 184, 172, 21);
		panel.add(PWTField);
		
		JButton AccCreatebtn = new JButton("Create Acc");
		AccCreatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Create_account ca = new Create_account();
				ca.setVisible(true);
			}
		});
		AccCreatebtn.setBounds(12, 220, 97, 23);
		panel.add(AccCreatebtn);
		
		JButton AccDelteBtn = new JButton("DeleteAcc");
		AccDelteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_account da = new delete_account();
				da.setVisible(true);
			}
		});
		AccDelteBtn.setBounds(123, 220, 97, 23);
		panel.add(AccDelteBtn);
		frmBookstoreManagementSystem.pack();
		
	}
}

class ImagePanel extends JPanel{
	private Image img;
	
	public ImagePanel(Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setLayout(null);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}