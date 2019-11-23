package util;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

public class Assignment_Swing {

	private JFrame frmManagementsystem;
	private JTextField password;
	private JTextField identification;

	Assignment_DTO dto = new Assignment_DTO();
	Assignment_DAO dao = new Assignment_DAO();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Assignment_Swing window = new Assignment_Swing();
					window.frmManagementsystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Assignment_Swing() {
		initialize();
	}

	private void initialize() {
		frmManagementsystem = new JFrame();
		frmManagementsystem.setTitle("ManagementSystem");
		frmManagementsystem.setBounds(100, 100, 450, 222);
		frmManagementsystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmManagementsystem.getContentPane().setLayout(null);
		
		ImagePanel panel = new ImagePanel(new ImageIcon("‪").getImage());
		panel.setBounds(0, 0, 434, 192);
		frmManagementsystem.getContentPane().add(panel);
		panel.setVisible(true);
		
		JButton Exit = new JButton("Exit");
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JButton CreateAccount = new JButton("Create Account");
		CreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Create_account ca = new Create_account();
			ca.setVisible(true);
			}
		});
		CreateAccount.setBounds(12, 146, 130, 23);
		panel.add(CreateAccount);
		Exit.setBounds(325, 146, 97, 23);
		panel.add(Exit);
		
		password = new JTextField();
		password.setBounds(282, 88, 116, 21);
		panel.add(password);
		password.setColumns(10);
		
		identification = new JTextField();
		identification.setColumns(10);
		identification.setBounds(282, 41, 116, 21);
		panel.add(identification);
		
		JLabel ID = new JLabel("ID");
		ID.setBounds(196, 47, 57, 15);
		panel.add(ID);
		
		JLabel Password = new JLabel("Password");
		Password.setBounds(196, 91, 57, 15);
		panel.add(Password);
		
		JButton login = new JButton("Log In");
		login.setBounds(154, 146, 159, 23);
		panel.add(login);
		
		JButton RemoveBtn = new JButton("Acc Removal");
		RemoveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_account da = new delete_account();
				da.setVisible(true);
			}
		});
		RemoveBtn.setBounds(12, 113, 130, 23);
		panel.add(RemoveBtn);
	}
	
	public void login() {
		dto.setId(identification.getText());
		dto.setPassword(password.getText());
	}
}