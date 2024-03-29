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

public class remove_listings extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static Connection con = null;
	private static PreparedStatement ps = null;
	
	DTO dto = new DTO();
	DAO dao = new DAO();
	
	public void remove_books() {
		dto.setTitle(titleTF.getText());
		dto.setName(authorTF.getText());
		dto.setPrice(priceTF.getText());
		
		String msg  = "";
		if(dto.getTitle().length() != 0 && dto.getName().length() != 0 && dto.getPrice().length() != 0) {
			dao.removeBooks(dto);
			msg = "삭제 되었습니다.";
			JOptionPane.showMessageDialog(null, msg);
			Assignment_Booklist ab = new Assignment_Booklist();
			ab.setVisible(true);
			//setVisible(false);
		}else {
			msg = "공란을 채워주세요.";
			JOptionPane.showMessageDialog(null, msg);
		}
	}
	
	ImagePanel panel1 = new ImagePanel(new ImageIcon("C:\\Users\\user\\Desktop\\bueno.gif").getImage());
	private JTextField titleTF;
	private JTextField authorTF;
	private JTextField priceTF;
	
	public static void main(String[] args) {
		try {
			remove_listings dialog = new remove_listings();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public remove_listings() {
		setTitle("Remove products");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(panel1);
		{
			JButton okButton = new JButton("OK");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					remove_books();
				}
			});
			okButton.setBounds(242, 227, 84, 23);
			panel1.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				setVisible(false);
				}
			});
			cancelButton.setBounds(335, 226, 79, 23);
			panel1.add(cancelButton);
			cancelButton.setActionCommand("Cancel");
		}
		
		JLabel titleLB = new JLabel("타이틀 입력 : ");
		titleLB.setBounds(12, 10, 84, 15);
		panel1.add(titleLB);
		
		JLabel authorLB = new JLabel("저자 입력 : ");
		authorLB.setBounds(12, 62, 84, 15);
		panel1.add(authorLB);
		
		JLabel priceLB = new JLabel("가격 입력 : ");
		priceLB.setBounds(12, 111, 84, 15);
		panel1.add(priceLB);
		
		titleTF = new JTextField();
		titleTF.setBounds(100, 7, 163, 21);
		panel1.add(titleTF);
		titleTF.setColumns(10);
		
		authorTF = new JTextField();
		authorTF.setColumns(10);
		authorTF.setBounds(100, 59, 163, 21);
		panel1.add(authorTF);
		
		priceTF = new JTextField();
		priceTF.setColumns(10);
		priceTF.setBounds(100, 108, 163, 21);
		panel1.add(priceTF);
	}
}
