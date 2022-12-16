package d1212.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.util.OracleUtil;

public class SaleDao {
//싱글턴
	private static SaleDao dao = new SaleDao();
	private SaleDao() {};
	public static SaleDao getSaleDao() { // getInstance() 메소드명 자주사용
		return dao;
	}

	
	
	
	public List<SaleDto> saleTotal() throws SQLException {
		String sql = "SELECT mt.CUSTNO ,CUSTNAME ,DECODE(grade,'A','VIP','B','일반','C','직원') agrade,psum \\r\\n\"\r\n"
				+ "				+ \"FROM MEMBER_TBL_02 mt\\r\\n\" + \"JOIN\\r\\n\" + \"(\\r\\n\" + \"	SELECT custno, sum(price) psum	\\r\\n\"\r\n"
				+ "				+ \"	FROM MONEY_TBL_02\\r\\n\" + \"	GROUP BY custno\\r\\n\" + \")sale\\r\\n\" + \"ON mt.custno = sale.custno\\r\\n\"\r\n"
				+ "				+ \"ORDER BY psum desc";
//			조회되는 결과 컬럼 : custno, custname, agarde, psum 4개 member와 money 한 곳에 있는 데이터가 아니므로
//							ㄴ새로운 DTO 를 만듭니다.
	Connection conn = OracleUtil.getConnection();
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
		
		List<SaleDto> list = new ArrayList<SaleDto>();
		while(rs.next()) {
			SaleDto sale = new SaleDto(rs.getInt(1),
					rs.getNString(2),
					rs.getNString(3),
					rs.getInt(4));
					list.add(sale);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;

	}


	
}
