package util;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

public class DAO{
	public static Connection con = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	
	public DAO() { 
		con = DBConnection.getConnection(); //DBConnection�� getConnection�޼ҵ尡 static�� ����ǹǷ� ��ü������ �ʿ䰡 ����
	}
	
	public int add_to_cart(DTO dto) {
		String sql = "INSERT INTO CART VALUES(?,?,?)";
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
	
	public int used_add(DTO dto) {
		String sql = "INSERT INTO BOOKLIST VALUES(?,?,?)";
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
	
	public int addBooks(DTO dto) {
		String sql = "INSERT INTO BOOKLIST VALUES(?,?,?)";
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
	
	public int removeBooks(DTO dto) {
		String sql = "DELETE FROM BOOKLIST WHERE title = ?";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getTitle());
			//ps.setString(2, dto.getName());
			//ps.setString(3, dto.getPrice());
			result = ps.executeUpdate();
		} catch (Exception e) {}
		return result;
	}
	
	public DTO[]  selectAll() {      
		String sql = "SELECT * FROM BOOKLIST";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();   
			DTO[] arr = makeArray(rs);
			return arr;
		} catch (Exception e) {
			System.out.println("SQL오류"+e.getMessage());
			
			return null;
		}finally {
			DBClose.close(rs);
			DBClose.close(ps);
		}
	}
	
	public ArrayList<DTO> getAllList(){
		ArrayList<DTO> list = new ArrayList<DTO>();
		String sql = "SELECT * FROM BOOKLIST ";
		DTO dto = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				dto = new DTO();
				dto.setTitle(rs.getString("title"));
				dto.setName(rs.getString("name"));
				dto.setPrice(rs.getString("price"));
				list.add(dto);
			}
		} catch (Exception e) {}
		finally {}
		return list;
	}
	
	public DTO[] makeArray(ResultSet rs) throws SQLException {
		Vector<DTO> list = new Vector<DTO>();
		DTO dto = null;
		
		while(rs.next()) {
			dto = new DTO();
			dto.setTitle(rs.getString("title"));
			dto.setName(rs.getString("name"));
			dto.setPrice(rs.getString("price"));
			list.add(dto);
			
		}
		DTO[] memArr = new DTO[list.size()];
		list.copyInto(memArr);
		return memArr;
		}
	
	int deleteMember() {
		String sql = "DELETE FROM Cart ";
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("쿼리 오류"+e.getMessage());
			return -1;
		}finally {
			try {
				if(ps != null) ps.close();
				
			} catch (SQLException e2) {
				
			}
		}
		return 1;  // 리턴값 0 or 1 입력해서 정상적으로 실행되는지 확인하기. 
	}
	
}