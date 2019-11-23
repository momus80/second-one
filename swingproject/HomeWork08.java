package HomeWork;

import java.util.Scanner;

public class HomeWork08 {

	public static void main(String[] args) {
		/*
		 * 8. 택시 운전사가 "자바"라는 손님을 태우고 목적지까지 데려다 주면 
		 * 영업을 중단하고 그 날 수입을 계산하는 프로그램을 작성 하시오. 
		 * 각 손님의 이름과 요금을 읽어 손님들이 요금을 낸 요금의 합을 구한다 
		 * 출력 손님의 이름을 입력 : QQQQ 요금 : 7000 
		 * 손님의 이름을 입력 : WWWW 요금 : 5000 
		 * 손님의 이름을 입력 : 자바 요금 : 10000
		 * 총합은 22000원이다
		 */
	Scanner sc = new Scanner(System.in);
		int sum = 0;
		
		while(true) {
			System.out.print("손님의 이름 : ");
			String name = sc.nextLine();
			
			System.out.print("요금 : ");
			sum += sc.nextInt();
			sc.nextLine();
			
			if(name.equalsIgnoreCase("java"))
				break;
		}
		System.out.println("Total : " + sum);
	}
}
