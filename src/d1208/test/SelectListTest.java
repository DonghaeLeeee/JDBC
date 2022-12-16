package d1208.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.util.OracleUtil;

public class SelectListTest {

	// select 조회 결과를 ArrayList 타입의 객체로 저장하기 (리스트의 제너릭 타입은 테이블의 구조와 맞는 클래스 정의)
	public static void main(String[] args) throws SQLException {
		Connection conn = OracleUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member_tbl_02";

		pstmt = conn.prepareStatement(sql); // Exception 처리는 jvm에게 throw(위임,떠넘기기)
		rs = pstmt.executeQuery();
		List<Member> memberlist = new ArrayList<>();		//select 조회결과를 자바 객체로 저장하는것이 목적.

		int cnt = 0;
		while (rs.next()) {
			Member m = new Member(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getDate(5),
					rs.getString(6),
					rs.getString(7)
					);
			cnt++;
			memberlist.add(m);
		}

		System.out.println("리스트의 크기 : " + memberlist.size());
		System.out.println("카운트의 값 : " + cnt);
	}

}
