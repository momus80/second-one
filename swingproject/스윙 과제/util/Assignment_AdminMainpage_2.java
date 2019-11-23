package util;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Assignment_AdminMainpage_2 extends JDialog {
	
	ImagePanel panel = new ImagePanel(new ImageIcon("C:\\Users\\user\\Desktop\\boono.gif").getImage());
	private final JPanel contentPanel = new JPanel();
	private final JButton Add_book = new JButton("Add_book");
	
	public static void main(String[] args) {
		try {
			Assignment_AdminMainpage_2 dialog = new Assignment_AdminMainpage_2();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Assignment_AdminMainpage_2() {
		setTitle("Admin page");
		setSize(800,350);
		getContentPane().setLayout(null);
		setResizable(false);
		
		contentPanel.setBounds(0, 0, 800, 350);
		getContentPane().add(contentPanel);
		contentPanel.add(panel);
		Add_book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager_Dialog mg = new manager_Dialog();
				mg.setVisible(true);
			}
		});
		Add_book.setIcon(null);
		Add_book.setBorderPainted(true);
		Add_book.setBounds(12, 10, 120, 23);
		
		panel.add(Add_book);
		
		JButton removeBtn = new JButton("Remove_book");
		removeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				remove_listings rl = new remove_listings();
				rl.setVisible(true);
			}
		});
		removeBtn.setBounds(12, 43, 120, 23);
		panel.add(removeBtn);
		
		JButton btnNewButton = new JButton("BuyBackCerti");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sell sell =  new Sell();
				sell.setVisible(true);
			}
		});
		btnNewButton.setBounds(12, 76, 120, 23);
		panel.add(btnNewButton);
	}
}
