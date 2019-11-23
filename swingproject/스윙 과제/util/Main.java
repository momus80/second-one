package util;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;

class UserList extends JFrame {
    DefaultTableModel model = new DefaultTableModel();
    Container cnt = this.getContentPane();
    JTable jtbl = new JTable(model);
    public UserList() {
        cnt.setLayout(new FlowLayout(FlowLayout.LEFT));
        model.addColumn("이름");
        model.addColumn("저자");
        model.addColumn("가격");
        model.addRow(new Object[] {"나의 라임 오렌지 나무","말루","천원"});
        model.addRow(new Object[] {"나의 투쟁","히트러","천원"});
        model.addRow(new Object[] {"거래의 법칙","트럼프","천원"});
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "MB", "heaven");
            PreparedStatement ps = con.prepareStatement("SELECT title,author,price FROM BOOKLIST");
            ResultSet rs = ps.executeQuery();
            while(rs.next()); {
            	String a = rs.getString(1);
            	String b = rs.getString(2);
            	String c = rs.getString(3);
                model.addRow(new Object[]{a, b, c});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        JScrollPane pg = new JScrollPane(jtbl);
        cnt.add(pg);
        this.pack();
    }
}
public class Main {
    public static void main(String[] args) {
        JFrame frame = new UserList();
        frame.setTitle("Swing Example");
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}