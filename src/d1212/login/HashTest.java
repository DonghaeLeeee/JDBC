package d1212.login;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.google.common.hash.Hashing;

import jdbc.util.OracleUtil;

public class HashTest {

	public static void main(String[] args) throws SQLException {

		Connection conn = OracleUtil.getConnection();
		String sql = "update book_member set password64 = ? \r\n"
				+ "where mem_idx = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		Scanner sc =new Scanner(System.in);
		System.out.println("회원번호 입력 : ");
		pstmt.setInt(2, Integer.parseInt(sc.nextLine()));
		System.out.println("변경할 패스워드 입력 : ");
		String pass = sc.nextLine();
	
		String hval = Hashing.sha256()
				.hashString(pass, StandardCharsets.UTF_8)		//첫번째 인자값이 인코딩형식
				.toString();
			pstmt.setNString(1, hval);
				
			System.out.println("입력한 함수를 sha256함수로 해시값으로 만들면?");
				System.out.println(hval);	//256비트를 16진수로 표시하면 64문자
				
				pstmt.execute();
				pstmt.close();
				conn.close();
				System.out.println("패스워드 변경 성공!");
				
				
				//해시값으로 평문을 예측(계산)할수 없는 복잡한 알고리즘이 해시함수는 이미 검증된 것을 사용.
	
	
	}

}
