package d1213.book;

import java.sql.SQLException;

public class BookTest2 {

	public static void main(String[] args) {

		BookRentDao dao = BookRentDao.getInstance();
		System.out.println("::: 대여 :::");
//		Scanner sc = new Scanner(System.in);
		int mem_idx = 10001;
		String bcode ="A1102";
		try {
			if(!dao.isAvailableMember(mem_idx))
				System.out.println("회원님은 대여 중인 도서가 있어 추가 대여 불가!!");
			else if(!dao.isAvailableBook(bcode))
				System.out.println("이 책은 대여 중 입니다.!!");
			else { 
//				dao.rentBook(mem_idx, bcode);
				//dto클래스의 일부 속성 변수만 초기화 할때 아래와 같은 방법은 불편(가독성,효율성..).
//				dao.rentBook(new BookRentDto(0, mem_idx, bcode, null, null, null, 0));
				dao.rentBook(BookRentDto.builder()    //static메소드로 빌더객체 생성
							.mem_idx(mem_idx)    //빌더 객체에서 메소드 실행 순서는 무관
							.bcode(bcode)		 //       메소드 이름은 필드(속성변수)와 동일
							.rent_no(0)			 //       메소드는 초기화 필요한 것만 호출 
							.build());			//build() 메소드 실행으로 dto 객체생성 완료
				System.out.println(mem_idx + " 회원 "+ bcode  + "도서 대여처리 완료!!");
			}	
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	
	
	
	}

}