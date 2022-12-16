package d1212.login;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {

		BookMemberDao.login(10003, 9876);	//9876으로 로그인
		BookMemberDao.UpdatePassword(10001, "1122");	//10001 비밀번호를 1122로 변경
		BookMemberDao.insert("이동해", "ehdgo173@naver.com", "0001");		//
	}

}
