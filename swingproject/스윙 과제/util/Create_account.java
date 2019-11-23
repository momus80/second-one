package util;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Create_account extends JDialog {

	ImagePanel panel = new ImagePanel(new ImageIcon("C:\\Users\\user\\Desktop\\bono.gif").getImage());
	
	private final JPanel contentPanel = new JPanel();
	private JTextField IDField;
	private JTextField Occfield;
	private JTextField Addrfield;
	
	Assignment_DAO dao = new Assignment_DAO();
	Assignment_DTO dto = new Assignment_DTO();
	Assignment_Swing swing = new Assignment_Swing();
	private JPasswordField passwordField;
	private JTextField nameTF;
	
	public static void main(String[] args) {
		try {
			Create_account dialog = new Create_account();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void add_Account() {
		dto.setId(IDField.getText());
		dto.setName(nameTF.getText());
		dto.setPassword(passwordField.getText());
		dto.setOccup(Occfield.getText());
		dto.setAddr(Addrfield.getText());
		
		String msg = "";
		if(dto.getId().length() != 0 && dto.getPassword().length() != 0 && dto.getOccup().length() != 0 && dto.getAddr().length() != 0){
			dao.insertMaker(dto);
			msg = "가입되었습니다";
			JOptionPane.showMessageDialog(this,msg);
			setVisible(false);
		}
		else {
			msg = "공란을 모두 채워주세요.";
			JOptionPane.showMessageDialog(this, msg);
		}
	}
	
	public Create_account() {
		setTitle("Being creating account");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			IDField = new JTextField();
			IDField.setBounds(109, 24, 116, 21);
			contentPanel.add(IDField);
			IDField.setColumns(10);
		}
		{
			Occfield = new JTextField();
			Occfield.setColumns(10);
			Occfield.setBounds(109, 120, 116, 21);
			contentPanel.add(Occfield);
		}
		{
			Addrfield = new JTextField();
			Addrfield.setColumns(10);
			Addrfield.setBounds(109, 145, 116, 21);
			contentPanel.add(Addrfield);
		}
		{
			JLabel ID = new JLabel("ID");
			ID.setBounds(12, 27, 57, 15);
			contentPanel.add(ID);
		}
		{
			JLabel Password = new JLabel("Password");
			Password.setBounds(12, 98, 74, 15);
			contentPanel.add(Password);
		}
		{
			JLabel Occupation = new JLabel("Occupation");
			Occupation.setBounds(12, 123, 74, 15);
			contentPanel.add(Occupation);
		}
		{
			JLabel Address = new JLabel("Address");
			Address.setBounds(12, 148, 57, 15);
			contentPanel.add(Address);
		}
		{
			passwordField = new JPasswordField();
			passwordField.setBounds(109, 95, 116, 21);
			contentPanel.add(passwordField);
		}
		{
			JLabel Name = new JLabel("Name");
			Name.setBounds(12, 64, 74, 15);
			contentPanel.add(Name);
		}
		{
			nameTF = new JTextField();
			nameTF.setColumns(10);
			nameTF.setBounds(109, 64, 116, 21);
			contentPanel.add(nameTF);
		}
		panel.setBounds(0, 0, 434, 253);
		contentPanel.add(panel);
		{
			JButton okButton = new JButton("OK");
			okButton.setBounds(274, 220, 63, 23);
			panel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					add_Account();
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Cancel");
			cancelButton.setBounds(349, 220, 73, 23);
			panel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
	}

}
