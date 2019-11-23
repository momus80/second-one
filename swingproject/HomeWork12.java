package HomeWork;

import java.util.Scanner;

public class HomeWork12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 *  12. 학생들의 점수를 입력하여 최종 점수에 따라 A은 90-100,
            B은 80-89, C은 70-79 그이외 점수는 D로 준다. 출력
		 *  점수(종료는 -999입력) 입력 : 90 점수(종료는 -999입력) 입력 : 86
		 *  점수(종료는 -999입력) 입력 : 96 점수(종료는-999입력) 입력 : 89 
		 *  점수(종료는 -999입력) 입력 : 75 점수(종료는 -999입력) 입력 : 72 
		 *  점수(종료는 -999입력) 입력 : 87 점수(종료는 -999입력) 입력 : 96 
		 *  점수(종료는 -999입력) 입력 : -99
		 *  A : 3 B : 3 C : 2
		 */
		Scanner sc= new Scanner(System.in);
		
		
		int jumsu = 0;  // 점수
		int Acount = 0;
		int Bcount = 0;
		int Ccount = 0;
		int Dcount = 0;
		
		do {
			
			System.out.println("점수를 입력하세요 :");
			System.out.println("-999입력시 종료   ");
			jumsu = sc.nextInt();
	
			if(90<=jumsu&&jumsu<=100) {
				Acount++;
			}
			else if(80<=jumsu&&jumsu<=89) { 
					Bcount++;
			}
			else if(70<=jumsu&&jumsu<=79)  {
					Ccount++;
			}
			else if(0<=jumsu&&jumsu<=69 ) { 
					Dcount++;
			}
			
	}while(jumsu != -999);
		System.out.println("A등급 :"+Acount+"\nB등급 :"+Bcount+"\nC등급 :"+Ccount+"\nD등급 :"+Dcount);
	}
}   //cc