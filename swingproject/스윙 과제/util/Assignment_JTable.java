package util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Assignment_JTable {
	public static void main(String[] args) {
		//ArrayList<String> list = getCustomers();
		//for(String item: list) {
		//	System.out.println(list);
		//}
	}
	
	public static String[][] getCustomers(){
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT title, name, price FROM BOOKLIST");
			ResultSet rs = ps.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(rs.next()) {
				list.add(new String[]{
					rs.getString("title"),
					rs.getString("name"),
					rs.getString("price"),
				});
			}
			System.out.println("the data has been fetched");
			String[][] arr = new String[list.size()][3];
			return list.toArray(arr);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static String[][] getCarts(){
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT title, name, price FROM CART");
			ResultSet rs = ps.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(rs.next()) {
				list.add(new String[]{
					rs.getString("title"),
					rs.getString("name"),
					rs.getString("price"),
				});
			}
			System.out.println("the data has been fetched");
			String[][] arr = new String[list.size()][3];
			return list.toArray(arr);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static String[][] getUsedCarts(){
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT title, name, price FROM BUYBACK");
			ResultSet rs = ps.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(rs.next()) {
				list.add(new String[]{
					rs.getString("title"),
					rs.getString("name"),
					rs.getString("price")
				});
			}
			System.out.println("the data has been fetched");
			String[][] arr = new String[list.size()][3];
			return list.toArray(arr);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
