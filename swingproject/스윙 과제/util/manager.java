package util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class manager {
	DAO dao = new DAO();
	DTO dto = new DTO();
	
	public void inputData() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("상품 정보를 입력하세요.");
		boolean bool = false;
		boolean result = false;
		System.out.println("타이틀 입력");
		String title = scanner.next();
		dto.setTitle(title);
		System.out.println("저자 입력");
		String name = scanner.next();
		dto.setName(name);
		System.out.println("가격 입력");
		String price = scanner.next();
		dto.setPrice(price);
		int res = dao.addBooks(dto);
		if(res == 1) System.out.println("등록 완료");
		else System.out.println("등록 실패");
	}
	
	public void writeAll() {
		System.out.println("전부 출력");
		ArrayList<DTO> list = dao.getAllList();
		Iterator<DTO> it = list.iterator();
		while(it.hasNext()) {
			DTO dto = it.next();
			String str = dto.toString();
			System.out.println(str);
		}
	}
}
