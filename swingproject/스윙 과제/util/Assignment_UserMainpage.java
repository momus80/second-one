package util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Assignment_UserMainpage extends JDialog {
	
	ImagePanel panel = new ImagePanel(new ImageIcon("C:\\Users\\user\\Desktop\\boono.gif").getImage());
	private final JPanel contentPanel = new JPanel();
	private final JButton buyback = new JButton("BuyBack");
	private final JButton btnCart = new JButton("Cart");
	private final JButton bookSearching = new JButton("Book search");
	
	public static void main(String[] args) {
		try {
			Assignment_UserMainpage dialog = new Assignment_UserMainpage();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Assignment_UserMainpage() {
		setTitle("User main Page");
		setSize(800,350);
		getContentPane().setLayout(null);
		
		contentPanel.setBounds(0, 0, 800, 350);
		getContentPane().add(contentPanel);
		contentPanel.add(panel);
		buyback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuyBack bb = new BuyBack();
				bb.setVisible(true);
			}
		});
		buyback.setBorderPainted(true);
		buyback.setBounds(12, 43, 120, 23);
		
		panel.add(buyback);
		btnCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Cart cart = new Cart();
			cart.setVisible(true);
			}
		});
		btnCart.setIcon(null);
		btnCart.setBorderPainted(true);
		btnCart.setBounds(12, 76, 120, 23);
		
		panel.add(btnCart);
		bookSearching.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Assignment_Booklist book = new Assignment_Booklist();
			book.setVisible(true);
			}
		});
		bookSearching.setBorderPainted(true);
		bookSearching.setBounds(12, 10, 120, 23);
		
		panel.add(bookSearching);
	}
}
