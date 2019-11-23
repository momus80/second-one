package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBClose {
	public static void close(ResultSet rs) {
		try {
			if(rs != null)
				rs.close();
			} catch (Exception e) {
				System.out.println("´Ý±â ½ÇÆÐ");
			}
	}
	
	public static void close(Statement st) {
		try {
			if(st != null)
				st.close();
		} catch (Exception e) {}
	}
	
	public static void close(PreparedStatement ps) {
		try {
			if(ps != null)
				ps.close();
		} catch (Exception e) {}
	}
	
	public static void close(Connection con) {
		try {
			if(con != null)
				con.close();
		} catch (Exception e) {}
	}
}
