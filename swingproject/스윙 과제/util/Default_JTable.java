package util;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JTable;
import javax.swing.border.*;
import java.sql.*;
public class Default_JTable extends JFrame {
	 public static void main(String[] args) {  
		  Default_JTable default_JTable = new Default_JTable();
	 }
 // 테이블 헤더 데이터
 public String[] col_name={"title","author","price"};
 
 // 테이블에 포함될 데이터
 public Object[][] data = new Object[50][3];
 
 JTextField name;
 
 // 생성자
 public Default_JTable() {
	 final JFrame f = new JFrame();
     Container cp = f.getContentPane();      
     cp.setLayout(new FlowLayout());
     JTable table=new JTable(data,col_name);
     JScrollPane scrollPane = new JScrollPane(table);
     cp.add(scrollPane, BorderLayout.EAST);   
     f.setSize(600, 450);    
     f.setVisible(true);      
 }
 

 
 public void dataGet() {
            Connection con=null;
            PreparedStatement ps=null;
            ResultSet rs=null;
            try {
            	String sql = "select * from BOOKLIST";
            Class.forName("oracle.jdbc.driver.OracleDriver");                         
               con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
               ps = con.prepareStatement(sql);
               rs = ps.executeQuery();
               int i = 0;
               while(rs.next()) {                  
                  data[i][0] = rs.getString("title");
                  data[i][1] = rs.getString("author");
                  data[i][2] = rs.getString("price");
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
