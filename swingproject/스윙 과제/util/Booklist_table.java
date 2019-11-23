package util;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Booklist_table {
	
	public String name, author, price;
	
	private JFrame frame;
	private JTable table;
	private String[] col_name = {"name", "author", "price"};
	private Object[][] data = new Object[50][3];
	private DefaultTableModel model = new DefaultTableModel(col_name,0); 

	
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Booklist_table window = new Booklist_table();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Booklist_table() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		Container cp = frame.getContentPane();
		cp.setLayout(new FlowLayout());
		table = new JTable(data,col_name);
		JScrollPane scrollPane = new JScrollPane(table);
		cp.add(scrollPane, BorderLayout.CENTER);
		frame.setSize(600,450);
	}

	public void dataGet() {
      Connection con = null;
      PreparedStatement ps=null;
      ResultSet rs=null;
           try {
              Class.forName("oracle.jdbc.driver.OracleDriver");
              String sql = "select * from booklist ";
              con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
              ps = con.prepareStatement(sql);
              rs = ps.executeQuery();
              int i = 0;
          	
          	  model.addRow(new Object[] {"나의 라임 오렌지 나무","말루","천원"});
              model.addRow(new Object[] {"나의 투쟁","히트러","천원"});
              model.addRow(new Object[] {"거래의 법칙","트럼프","천원"});
              while(rs.next()) {     
            	 name = rs.getString("name");
            	 author = rs.getString("author");
            	 price = rs.getString("price");
                 model.addRow(new Object[] {name,author,price});
                 i++;
              }
           }
           catch(Exception e) {System.out.println(e);}
           finally { 
                    try {
                            if (con != null) 
                            {
                             con.close();      
                            }
                    }
                    catch (Exception e){}
           }
       }
}

