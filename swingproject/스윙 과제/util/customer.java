package util;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class customer {

	private JFrame frmBooksList;
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customer window = new customer();
					window.frmBooksList.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public customer() {
		initialize();
	}

	void initialize() {
		frmBooksList = new JFrame();
		frmBooksList.setTitle("Books list");
		frmBooksList.setBounds(100, 100, 800, 600);
		frmBooksList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBooksList.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 800, 600);
		frmBooksList.getContentPane().add(panel);
		panel.setLayout(null);
		
		Assignment_JTable customer = new Assignment_JTable();
		
		JPanel tablePanel = new JPanel();
		tablePanel.setVisible(true);
		String[] headers = new String[] {"title","name","price"};
		//String [][] data = new String [][] {{"1","2","3"}, {"4","5","6"}};
		String[][] data = customer.getCustomers();
		JTable table = new JTable(data, headers);
		table.setRowHeight(30);
		table.setFont(new Font("Sanserif", Font.BOLD, 15));
		table.setAlignmentX(0);
		table.setSize(800,600);
		table.setPreferredScrollableViewportSize(new Dimension(800,600));
		
		tablePanel.add(new JScrollPane(table));
		tablePanel.setBounds(0, 0, 800, 600);
		panel.add(tablePanel);
	}
}
