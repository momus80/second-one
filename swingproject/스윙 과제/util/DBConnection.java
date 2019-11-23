package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	static Connection con = null;
	static Statement st =null;
	private DBConnection() {}
	
	static { //static ��� ����
		String DRIVER = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		try {
			Class.forName(DRIVER);
			System.out.println("드라이버 로딩 성공");
			con = DriverManager.getConnection(url,user,password);
			System.out.println("DB연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다."+e.getMessage());
		} catch (SQLException e) {
			System.out.println("DB연결 실패"+e.getMessage());
		}
	}
	
	public static Connection getConnection() { //static ==> ��ü�� �������� �ʰ� ��� �����ϰ���!
		return con;
	}
	
	public static void close(ResultSet rs) {
		try {
			if(rs != null)
				rs.close();
			} catch (Exception e) {
				System.out.println("닫기 실패");
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

//static은 개체를 생성하기 이전에 이미 할당되어 있다. 모든 클래스에서 static은 사용가능하다!
//싱글톤 = 인스턴스가 사용될 때에 똑같은 인스턴스를 만들어 내는 것이 아니라, 동일 인스턴스를 사용하게끔 하는 것이 기본 전략이다.
//		  프로그램상에서 동일한 커넥션 객체를 만든다던지, 하나만 사용되야하는 객체를 만들때 매우 유용하다.