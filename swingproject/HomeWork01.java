package HomeWork;

import java.util.Scanner;

public class HomeWork01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
//1. 사용자로 부터 암호룰 입력받아 암호가 맞으면 "환영합니다" 라는 메세지를 출력하여 종료하고 
//암호가 틀리면 "암호가 틀림입니다" 메세지를 출력한다.
//암호를  3번 잘못 입력하면 접속을 "거부합니다" 출력하고 종료한다.
//암호는 koreajava로 한다
		int num =0;
		
		for(num = 0 ; num<3 ; num++) {
			System.out.print("암호를 입력하세요 : ");
			String password = sc.nextLine();
		
		// Object koreajava;
		if(password.equals("koreajava")) {    
		//  ㄴ korea 오류 뜨는거 확인시 위에 옵젝뜨는 이유
                 	// 문자는 == 대신에 equals 를 사용하고 ( )안에 " " 를 넣어서
		//  (" ") 이렇게 사용해야한다.

		System.out.println("환영합니다~");
		System.exit(-1);
		} else if(!password.equals("koreajava")) {
			System.out.println("암호가 틀립니다.(3번 잘못입력시 거부합니다)");
		}
		
		}	
		System.out.println("거부. 종료합니다.");
}
	}
// C
