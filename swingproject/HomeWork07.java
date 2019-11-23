package HomeWork;

import java.util.Scanner;

public class HomeWork07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//7. 택시 운전사가 10명을 태우면 그 날 영업을 중단하고 그날의 수입을
//계산하는 프로그램을작성하시오  수입은 손님이 낸 요금을 읽어 들여 합을 구한다.
		Scanner sc = new Scanner(System.in);
		
		int sum =0;  //  요금 합
		int i = 0;  
		int x =0;// 일회용
		
		
		for(i=0;i<10;i++) {
			System.out.println((i+1)+"번째 손님"+"입력한 요금만큼 갑니닼ㅋㅋㅋ");
			x = sc.nextInt();
			sum += x ;
		}
		System.out.print("오늘 번돈ㅠㅠ "+sum);
}
}	//ccc
