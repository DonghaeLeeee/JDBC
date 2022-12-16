package d1212.test;

import java.sql.Connection;
import java.sql.SQLException;

import d1208.test.Member;
import d1208.test.MemberDao;
import jdbc.util.OracleUtil;

public class MemberUpdateTest {

	public static void main(String[] args) throws SQLException {
//		Connection conn = OracleUtil.getConnection();	
//		System.out.println("autocommit : " + conn.getAutoCommit());		//autocommit 기본값 true(On)
//			ㄴ 여기서 Update 하는것은 디벨로프에 바로 적용됨.
		
		MemberDao dao = MemberDao.getMemberDao();
		
		dao.update(new Member(100041, null,"010-2323-2323","강원도 속초시",null,null,"33"));
	}
}
