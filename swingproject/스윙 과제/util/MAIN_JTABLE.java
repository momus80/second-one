package util;

import java.awt.Container;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class MAIN_JTABLE extends JDialog {
	public MAIN_JTABLE() {
		setTitle("Booklist");
		DefaultTableModel model = new DefaultTableModel();
	    Container cnt = this.getContentPane();
	    JTable jtbl = new JTable(model);
	    JTable table;
		table = new JTable();
		cnt.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		model.addColumn("이름");
        model.addColumn("저자");
        model.addColumn("가격");
        model.addRow(new Object[] {"나의 라임 오렌지 나무","말루","천원"});
        model.addRow(new Object[] {"나의 투쟁","히트러","천원"});
        model.addRow(new Object[] {"거래의 법칙","트럼프","천원"});
        model.addRow(new Object[] {title,name,price});
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM BOOKLIST");
            ResultSet rs = ps.executeQuery();
            while(rs.next()); {
            	String a = rs.getString(1);
            	String b = rs.getString(2);
            	String c = rs.getString(3);
                model.addRow(new Object[]{a, b, c});
            }
        } catch (Exception e) {}
        JScrollPane pg = new JScrollPane(jtbl);
        cnt.add(pg);
        this.pack();
    }
	DTO dto = new DTO();
	String title = dto.getTitle();
	String name = dto.getName();
	String price = dto.getPrice();
	
	public void add_to_list(DTO dto) {

	}
    
	public static void main(String[] args) {
		try {
			MAIN_JTABLE dialog = new MAIN_JTABLE();
			dialog.setLocationRelativeTo(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
