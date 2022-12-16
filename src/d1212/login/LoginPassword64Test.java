package d1212.login;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.google.common.hash.Hashing;

import jdbc.util.OracleUtil;

public class LoginPassword64Test {
	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		Connection conn = OracleUtil.getConnection();
		
		String sql = "select * from book_member\r\n"
				+ "where email = ? and password64 = ?";
		//email 컬럼은 unique
		PreparedStatement pstmt = conn.prepareStatement(sql);

		System.out.println("아이디(이메일) 입력 : ");
		String id = sc.nextLine();
		System.out.println("패스워드 입력 : ");
		String password = sc.nextLine();
		
		pstmt.setNString(1, id);
		//사용자가 입력한 패스워드 평문을 해시값으로 변경해서 sql에 전달.
		pstmt.setNString(2, Hashing.sha256()
				.hashString(password, StandardCharsets.UTF_8)		//첫번째 인자값이 인코딩형식
				.toString());
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next())
			System.out.println("사용자 인증 - 로그인 성공했습니다.");
		else
			System.out.println("사용자 인증 - 아이디 또는 패스워드가 잘못된 값입니다.");
		
		rs.close();
		pstmt.close();
		conn.close();
		

		
		
	}
}
