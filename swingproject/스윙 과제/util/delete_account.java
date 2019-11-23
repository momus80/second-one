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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class delete_account extends JDialog {

	ImagePanel panel = new ImagePanel(new ImageIcon("C:\\Users\\user\\Desktop\\bono.gif").getImage());
	
	private final JPanel contentPanel = new JPanel();
	private JTextField idField;
	private JTextField pwField;

	
	Assignment_DAO dao = new Assignment_DAO();
	
	public void delete() {
		/*������ ���̵� �Է� JOptionPane.showMessageDialog()
		  ���� 000���� ������ �����Ͻðڽ��ϱ�? ���� ����  JOptionPane.showConfirmDialog()*/
		String id = idField.getText();
		String password = pwField.getText();
		String msg = "";
		if(id == null || id.trim().equalsIgnoreCase("") || password == null || password.trim().equalsIgnoreCase("")) { // trim : �����̶�� ��
			msg = "아이디와 비밀번호를 입력해주세요.";
			idField.requestFocus();
			pwField.requestFocus();
			JOptionPane.showMessageDialog(this, msg);
			return;
		}
		msg = "정말"+id+"를 삭제하시겠습니까??";
		int yn = JOptionPane.showConfirmDialog(this, msg);
		if(yn == JOptionPane.YES_OPTION) {
			//dao.deleteMember(id.trim()) - ȣ���ϱ�
			// ȣ���ѵ� ���� ���� or �������� 
			int isdel = dao.deleteMember(id.trim());
			if(isdel > 0) {
				msg = "삭제가 완료되었습니다 ";
				setVisible(false);
			}	
			else 
				msg = "삭제 실패";
				JOptionPane.showMessageDialog(this, msg);
		}
	}
	
	public static void main(String[] args) {
		try {
			delete_account dialog = new delete_account();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public delete_account() {
		setTitle("account being deleted");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		panel.setBounds(0, 0, 450, 253);
		contentPanel.add(panel);
		
		{
			idField = new JTextField();
			idField.setBounds(75, 91, 116, 21);
			panel.add(idField);
			idField.setColumns(10);
		}
		{
			pwField = new JTextField();
			pwField.setBounds(80, 47, 116, 21);
			panel.add(pwField);
			pwField.setColumns(10);
		}
		{
			JLabel ID = new JLabel("ID");
			ID.setBounds(12, 50, 57, 15);
			panel.add(ID);
		}
		{
			JLabel password = new JLabel("Password");
			password.setBounds(12, 94, 95, 15);
			panel.add(password);
		}
		{
			JButton confirm_delete = new JButton("OK");
			confirm_delete.setBounds(250, 220, 68, 23);
			panel.add(confirm_delete);
			confirm_delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					delete();
				}
			});
			confirm_delete.setActionCommand("OK");
			getRootPane().setDefaultButton(confirm_delete);
		}
		{
			JButton cancel_delete = new JButton("Cancel");
			cancel_delete.setBounds(330, 220, 73, 23);
			panel.add(cancel_delete);
			cancel_delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			cancel_delete.setActionCommand("Cancel");
		}
	}

}
