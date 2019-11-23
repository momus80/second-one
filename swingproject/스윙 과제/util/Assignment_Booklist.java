package util;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Assignment_Booklist extends JDialog {

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
	
	public Assignment_Booklist() {
		setTitle("Booklist");
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
			
			table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
		        public void valueChanged(ListSelectionEvent event) {
		            // do some actions here, for example
		            // print first column value from selected row	
		        	String a = table.getValueAt(table.getSelectedRow(), 0).toString();
		            String b = table.getValueAt(table.getSelectedRow(), 1).toString();
		            String c = table.getValueAt(table.getSelectedRow(), 2).toString();
		            
					dto.setTitle(a);
					dto.setName(b);
					dto.setPrice(c);
					chosenList.setText("책 제목 : "+a+"  저자 : "+b+"  가격 : "+c+"\n");
			        }
			    });
			        
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(0, 0, 788, 268);
			tablePanel.add(scrollPane);
			
			JButton btnNewButton = new JButton("장바구니에 추가");
			btnNewButton.setBounds(643, 278, 133, 65);
			tablePanel.add(btnNewButton);
	
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					dao.add_to_cart(dto);
					JOptionPane.showMessageDialog(null, "장바구니에 추가되었습니다.");
				}
			});
			tablePanel.setBounds(0, 0, 800, 600);
			Panel.add(tablePanel);
		}
	}
}