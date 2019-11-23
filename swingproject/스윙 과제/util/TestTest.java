package util;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

	public class TestTest extends JDialog {

		private final JPanel Panel = new JPanel();
		
		DTO dto = new DTO();
		DAO dao = new DAO();
		
		public static void main(String[] args) {
			try {
				Assignment_Booklist dialog = new Assignment_Booklist();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public TestTest() {
			setTitle("Sell List");
			Assignment_JTable customer = new Assignment_JTable();
			setBounds(100, 100, 800, 389);
			getContentPane().setLayout(new BorderLayout());
			Panel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(Panel, BorderLayout.CENTER);
			Panel.setLayout(null);

			{
				JPanel tablePanel = new JPanel();
				tablePanel.setVisible(true);
				tablePanel.setBounds(0, 0, 800, 257);
				Panel.add(tablePanel);

				JTextArea chosenList = new JTextArea();
				chosenList.setBounds(10, 278, 609, 63);
		        tablePanel.add(chosenList);
		        
				String[] headers = new String[] {"title","name","price"};
				String[][] data = customer.getCustomers();
				tablePanel.setLayout(null);
				
				JTable table = new JTable(data, headers);
				table.setRowHeight(30);
				table.setFont(new Font("Sanserif", Font.BOLD, 15));
				table.setAlignmentX(0);
				table.setSize(800,600);
				table.setPreferredScrollableViewportSize(new Dimension(800,600));
				
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setBounds(0, 0, 788, 268);
				tablePanel.add(scrollPane);
				
				JButton btnNewButton = new JButton("판매 신청");
				btnNewButton.setBounds(643, 278, 133, 65);
				tablePanel.add(btnNewButton);
		
				
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						dao.add_to_cart(dto);
						JOptionPane.showMessageDialog(null, "판매 신청이 완료되었습니다");
					}
				});
				tablePanel.setBounds(0, 0, 800, 600);
				Panel.add(tablePanel);
				
				
			}
		}
	}