package d1207.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.util.OracleUtil;

public class SelectTest3 {

	public static void main(String[] args) {

		Connection conn = OracleUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT mt.CUSTNO ,CUSTNAME ,DECODE(grade,'A','VIP','B','일반','C','직원') agrade,psum \r\n"
				+ "FROM MEMBER_TBL_02 mt\r\n" + "JOIN\r\n" + "(\r\n" + "	SELECT custno, sum(price) psum	\r\n"
				+ "	FROM MONEY_TBL_02\r\n" + "	GROUP BY custno\r\n" + ")sale\r\n" + "ON mt.custno = sale.custno\r\n"
				+ "ORDER BY psum desc";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("회원매출현황");
			System.out.println("::::::::::::::::::::::::::::::::");
			while (rs.next()) {
				System.out.println(
				rs.getInt(1) + "\t" 
				+ rs.getNString(2) + "\t" 
				+ rs.getNString(3) 
				+ "\t" + rs.getInt(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
