package util;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sell extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField Sum;

	public static void main(String[] args) {
		try {
			Sell dialog = new Sell();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Sell() {
		setTitle("Sell");
		Assignment_JTable customer = new Assignment_JTable();
		JPanel tablePanel = new JPanel();
		String[] headers = new String[] {"title","name","price"};
		String[][] data = customer.getUsedCarts();
		JTable table = new JTable(data, headers);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 800, 496);
		contentPanel.add(panel);
		table.setRowHeight(30);
		table.setFont(new Font("Sanserif", Font.BOLD, 15));
		table.setAlignmentX(0);
		table.setSize(800,600);
		table.setPreferredScrollableViewportSize(new Dimension(800,600));
		JScrollPane scrollPane = new JScrollPane(table);
		tablePanel.add(scrollPane);
		tablePanel.setBounds(0, 0, 800, 600);
		panel.add(tablePanel);
		setBounds(100, 100, 826, 626);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton button = new JButton("종료");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		button.setBounds(654, 538, 130, 23);
		contentPanel.add(button);

	}
}
