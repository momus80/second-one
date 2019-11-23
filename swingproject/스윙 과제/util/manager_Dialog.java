package util;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class manager_Dialog extends JDialog {
	
	ImagePanel panel1 = new ImagePanel(new ImageIcon("C:\\Users\\user\\Desktop\\bueno.gif").getImage());
	
	private final JPanel contentPanel = new JPanel();
	private JTextField titleTF;
	private JTextField authorTF;
	private JTextField priceTF;
	
	private static Connection con = null;
	private static PreparedStatement ps = null;
	
	DTO dto = new DTO();
	DAO dao = new DAO();
	
	public void add_books() {
		dto.setTitle(titleTF.getText());
		dto.setName(authorTF.getText());
		dto.setPrice(priceTF.getText());
		
		String msg = "";
		if(dto.getTitle().length() != 0 && dto.getName().length() != 0 && dto.getPrice().length() != 0) {
			dao.addBooks(dto);
			msg = "추가되었습니다.";
			JOptionPane.showMessageDialog(null, msg);
			setVisible(false);
		}else {
			msg = "공란을 채워주세요.";
			JOptionPane.showMessageDialog(null, msg);
		}
	}
	

	public static void main(String[] args) {
		try {
			manager_Dialog dialog = new manager_Dialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public manager_Dialog() {
		setTitle("Add products");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(panel1);
		
		JLabel titleLB = new JLabel("타이틀 입력 : ");
		titleLB.setBounds(12, 10, 97, 15);
		panel1.add(titleLB);
		
		JLabel authorLB = new JLabel("저자 입력 : ");
		authorLB.setBounds(12, 61, 83, 15);
		panel1.add(authorLB);
		
		JLabel priceLB = new JLabel("가격 입력 : ");
		priceLB.setBounds(12, 108, 83, 15);
		panel1.add(priceLB);
		
		titleTF = new JTextField();
		titleTF.setBounds(115, 10, 179, 21);
		panel1.add(titleTF);
		titleTF.setColumns(10);
		
		authorTF = new JTextField();
		authorTF.setBounds(114, 56, 179, 21);
		panel1.add(authorTF);
		authorTF.setColumns(10);
		
		priceTF = new JTextField();
		priceTF.setBounds(117, 103, 179, 21);
		panel1.add(priceTF);
		priceTF.setColumns(10);
		{
			JButton okButton = new JButton("OK");
			okButton.setBounds(238, 220, 83, 23);
			panel1.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					add_books();
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Cancel");
			cancelButton.setBounds(336, 220, 73, 23);
			panel1.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
		{
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 434, 261);
			contentPanel.add(panel);
			panel.setLayout(null);
		}
	}
}
