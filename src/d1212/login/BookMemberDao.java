package d1212.login;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.google.common.hash.Hashing;

import jdbc.util.OracleUtil;

public class BookMemberDao {
	//싱글턴
	private static BookMemberDao dao = new BookMemberDao();
	private BookMemberDao() {};
	public static BookMemberDao getinstance() {
		return dao;
	}
	

	
	
	public static boolean login(int id, int password) throws SQLException {
		boolean run = true;
		String sql = "select * from book_member\r\n"
				+ "where mem_idx = ? and password = ?";
		
		Connection conn = OracleUtil.getConnection();		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, id);
		pstmt.setInt(2, password);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next())
			System.out.println("사용자 인증 - 로그인 성공했습니다.");
		else {
			System.out.println("사용자 인증 - 아이디 또는 패스워드가 잘못된 값입니다.");
			run = false;
		}
		
		rs.close();
		pstmt.close();
		conn.close();		
		return run;
	}
	
	
	
	
	
	
	
	public static void UpdatePassword(int mem_idx, String password64) throws SQLException {
		
		String sql = "update book_member set password64 = ? \r\n"
				+ "where mem_idx = ?";
		Connection conn = OracleUtil.getConnection();		
		PreparedStatement pstmt = conn.prepareStatement(sql);
	
		String hval = Hashing.sha256()
				.hashString(password64, StandardCharsets.UTF_8)
				.toString();
			pstmt.setNString(1, hval);
			pstmt.setInt(2, mem_idx);
	
			pstmt.execute();
			pstmt.close();
			conn.close();
	}
	
	
	
	
	
	
	
	
	
	public static void insert(String name, String email, String password) throws SQLException {

		String sql = "insert into book_member\r\n" 
		+ "Values (memidx_seq.nextval,?,?,null,?,?)";
		Connection conn = OracleUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setNString(1, name);
		pstmt.setNString(2, email);
		pstmt.setNString(3, password);
		pstmt.setNString(4, Hashing.sha256()
				.hashString(password, StandardCharsets.UTF_8)
				.toString());
		
		pstmt.execute();
		pstmt.close();
		conn.close();
		
	}
	
	
	
	
}
