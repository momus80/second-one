package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BuyBackDAO {
	public static Connection con = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	
	public BuyBackDAO() { 
		con = DBConnection.getConnection();
	}
	
	public int used_add(BuyBackDTO dto) {
		String sql = "INSERT INTO BUYBACK VALUES(?,?,?)";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getPrice());
			result = ps.executeUpdate();
		} catch (Exception e) {}
		return result;
	}
}
