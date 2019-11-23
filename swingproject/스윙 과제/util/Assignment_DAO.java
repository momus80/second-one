package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Assignment_DAO {
	Connection con = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	public Assignment_DAO() {
		con = DBConnection.getConnection();
	}
	
	public boolean Login(String id, String password) throws SQLException { //admin acc을 st으로 받아서 로그인 or admin login window를 새로 만들어서 login 
		PreparedStatement ps3 = null;
		ResultSet rs2 = null;
		String sql1 = "SELECT * FROM MEMBER3 WHERE ID LIKE ? AND PASSWORD LIKE ? ";
		String sql2 = "SELECT * FROM ADMIN WHERE ID LIKE ? AND PASSWORD LIKE ? ";
		
		Assignment_DTO dto = null;
		try {
			dto = new Assignment_DTO();
			ps = con.prepareStatement(sql2);
			ps.setString(1, id);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(id.equals("hulk") && password.equals("hogan")) {
				JOptionPane.showMessageDialog(null,"관리자 계정으로 로그인합니다.");
				Assignment_AdminMainpage_2 admin = new Assignment_AdminMainpage_2();
				admin.setVisible(true);
				return true;
			}else {
					ps3 = con.prepareStatement(sql1);
					ps3.setString(1, dto.getId());
					ps3.setString(2, dto.getPassword());
					rs2 = ps3.executeQuery();
					if(id.equals("") || password.equals("")) {
						JOptionPane.showMessageDialog(null,"아이디와 패스워드를 입력해주세요.");
						return false;
					}
					else if(rs2 != null) {
						JOptionPane.showMessageDialog(null,"로그인 성공");
						Assignment_UserMainpage au = new Assignment_UserMainpage();
						au.setVisible(true);
						return true;
					}else
						JOptionPane.showMessageDialog(null, "로그인 실패");
				}
			}finally {}
		return true;
	}

	public int insertMaker(Assignment_DTO dto) {
		String sql = "INSERT INTO MEMBER3 VALUES(?,?,?,?,?)";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getPassword());
			ps.setString(4, dto.getOccup());
			ps.setString(5, dto.getAddr());
			result = ps.executeUpdate();
		} catch (Exception e) {}
		finally {}
		return result;
	}
	
	public Assignment_DTO[] selectAll() {
		String sql = "SELECT * FROM member3";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			Assignment_DTO[] arr = makeArray(rs);
			return arr;
		} catch (Exception e) {
			System.out.println("�˻� ����"+e.getMessage());
			return null;
		}finally {
			DBClose.close(ps);
			DBClose.close(con);
		}
	}
	
	public Assignment_DTO[] makeArray(ResultSet rs) throws SQLException {
		Vector<Assignment_DTO> list = new Vector<Assignment_DTO>();
		Assignment_DTO dto = null;
		
		while(rs.next()) {
			dto = new Assignment_DTO();
			dto.setNo(rs.getInt("no"));
			dto.setId(rs.getString("id"));
			dto.setName(rs.getString("name"));
			dto.setOccup(rs.getString("occup"));
			dto.setAddr(rs.getString("addr"));
			list.add(dto);
		}
		Assignment_DTO[] memArr = new Assignment_DTO[list.size()];
		list.copyInto(memArr);
		return memArr;
	}
	
	public Assignment_DTO[] selectByName(String name) {
		String sql = "SELECT * FROM member3 WHERE NAME = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			Assignment_DTO[] arr = makeArray(rs);
			return arr;
		} catch (Exception e) {
			System.out.println("�˻� ����"+e.getMessage());
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
			} catch (SQLException e) {	
			}
		}
	}
	
	int deleteMember(String id) {
		String sql = "DELETE FROM MEMBER3 WHERE ID = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("존재하지 않는 ID입니다."+e.getMessage());
			return -1;
		}finally {
			try {
				if(ps != null) ps.close();
			} catch (SQLException e) {}
		}
		return 1;
	}
	
	
	
	public void close() {
		try {
			if(con!=null)
				con.close();
		}catch(SQLException e){System.out.println("�ݱ����");}
	}
	
	public void dbConnect() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		con=DriverManager.getConnection(url,"scott","tiger");
		System.out.println("Db Connected...");
	}
}