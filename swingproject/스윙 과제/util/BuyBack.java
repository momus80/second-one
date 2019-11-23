package util;

import java.awt.BorderLayout;
import java.awt.Color;
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

public class BuyBack extends JDialog {
	
	ImagePanel panel = new ImagePanel(new ImageIcon("C:\\Users\\user\\Desktop\\bo11.gif").getImage());
	private final JPanel contentPanel = new JPanel();
	private JTextField TiTF;
	private JTextField AuTF;
	private JTextField PrTF;
	
	private static Connection con = null;
	private static PreparedStatement ps = null;
	
	BuyBackDTO dto = new BuyBackDTO();
	BuyBackDAO dao = new BuyBackDAO();
	
	public void add_usedbooks() {
		dto.setTitle(TiTF.getText());
		dto.setName(AuTF.getText());
		dto.setPrice(PrTF.getText());
		
		String msg = "";
		if(dto.getTitle().length() != 0 && dto.getName().length() != 0 && dto.getPrice().length() != 0) {
			dao.used_add(dto);
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
			BuyBack dialog = new BuyBack();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public BuyBack() {
		initGUI();
	}
	private void initGUI() {
		setTitle("BuyBackSystem");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(panel);
		{
			JButton okButton = new JButton("OK");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					add_usedbooks();
					Sell sell = new Sell(); // 얘 만들기 판매목록
					sell.setVisible(true);
				}
			});
			okButton.setBounds(276, 235, 73, 23);
			panel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
			
			
		}
		{
			JButton cancelButton = new JButton("Cancel");
			cancelButton.setBounds(356, 235, 73, 23);
			panel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
		{
			JLabel lblTi = new JLabel("Title");
			lblTi.setBounds(18, 25, 57, 15);
			panel.add(lblTi);
		}
		{
			JLabel lblAu = new JLabel("Author");
			lblAu.setBounds(12, 76, 57, 15);
			panel.add(lblAu);
		}
		{
			JLabel lblPr = new JLabel("Price");
			lblPr.setBounds(11, 120, 57, 15);
			panel.add(lblPr);
		}
		{
			TiTF = new JTextField();
			TiTF.setBackground(Color.WHITE);
			TiTF.setBounds(68, 25, 110, 20);
			panel.add(TiTF);
			TiTF.setColumns(10);
		}
		{
			AuTF = new JTextField();
			AuTF.setBounds(68, 72, 110, 20);
			panel.add(AuTF);
			AuTF.setColumns(10);
		}
		{
			PrTF = new JTextField();
			PrTF.setBounds(68, 120, 110, 20);
			panel.add(PrTF);
			PrTF.setColumns(10);
		}
	}

}
