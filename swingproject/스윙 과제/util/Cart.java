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

public class Cart extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField Sum;

	public static void main(String[] args) {
		try {
			Cart dialog = new Cart();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Cart() {
		setTitle("Cart");
		Assignment_JTable customer = new Assignment_JTable();
		JPanel tablePanel = new JPanel();
		String[] headers = new String[] {"title","name","price"};
		String[][] data = customer.getCarts();
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
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
	
		Sum = new JTextField();
		int sum = 0;
		for(int i = 0; i < table.getRowCount(); i++) {
			String c = table.getValueAt(i, 2).toString();
			int b = Integer.parseInt(c);
			
			sum += b;
			
			Sum.setText(sum+"");
		}
		
		Sum.setBounds(398, 506, 258, 45);
		contentPanel.add(Sum);
		Sum.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("Total  : ");
		lblNewLabel.setBounds(344, 506, 57, 45);
		contentPanel.add(lblNewLabel);
		
		JButton button = new JButton("결제 버튼");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "결제를 진행하시겠습니까?");
				DAO dao = new DAO();
				dao.deleteMember();
				Sum.setText(null);
				setVisible(false);
			}
		});
		button.setBounds(668, 538, 116, 23);
		contentPanel.add(button);
	}
}
