package d1208.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
	//디벨로프에서는 autocommit이 안켜져있기때문에 무조건 확인해야함
public class MemberApp {

	public static void main(String[] args) throws SQLException {
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		//SQL 실행할 Dao 객체 생성
		MemberDao dao = MemberDao.getMemberDao();
		while (run) {
			System.out.println("[i] insert [s]select 전체 [p]select PK [e] 종료");
			System.out.println("메뉴선택 : ");
			String sel = sc.nextLine();

			switch (sel) {
			case "i":
				System.out.println("이름 입력 : ");
				String name = sc.nextLine();
				System.out.println("주소 입력 : ");
				String addr = sc.nextLine();
				Member member = new Member(0, name, null, addr, null, null, null);
				dao.insert(member);
				break;
			case "s":
				List<Member> list = dao.selectList();
			for(Member m : list)
				System.out.println(m.getCustno() + "\t" +
									m.getCustname() + "\t" +
									m.getAddress() + "\t" +
									m.getPhone() + "\t" +
									m.getJoindate() + "\t" +
									m.getGrade() + "\t" +
									m.getCity());
				break;
			case "p":
				System.out.println("회원번호 입력 : ");
				int cust = Integer.parseInt(sc.nextLine());
				Member m = dao.selectOne(cust);
				System.out.println("조회결과");
				System.out.println("::::::::::::::::::::::");
				if(m!=null)
					System.out.println(m.getCustno() + "\t" +
									m.getCustname() + "\t" +
									m.getAddress() + "\t" +
									m.getPhone() + "\t" +
									m.getJoindate() + "\t");
					
				
				break;
			case "e":
				System.out.println("프로그램을 종료합니다.");
				break;
				
			default:
				break;
			}
		}

	}

}
