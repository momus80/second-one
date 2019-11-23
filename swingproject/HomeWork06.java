package HomeWork;

import java.util.Scanner;

public class HomeWork06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
//6. 퀴즈의 점수를 입력하여 최대 점수와 최소 점수와 평균 점수를 구하는
//프로그램을 작성하시오 입력 점수 종료는 -999 가 입력하면 종료 함.

		int i = 0; // i는 입력하는 점수 값
		int max =0; // 최대 점수
		int min = 0; // 최소 점수
		int count=0; // i 카운팅 하기위해서 초기화 
		double sum = 0; // 평균점수
		int x = 0; // 저장공간
		
		
		System.out.println("점수를 입력하세요 : (-999입력시 종료.)");
		i = sc.nextInt(); 
		 
		max = i;
		min = i;
		sum = x;
		
		while(i!=-999) {
			count++; // 점수 i를 받을때 마다 카운팅
			x+=i;  // x는 저장소
			
			if(i>max) max=i; {
				
			}
			if(i<min) min=i; {
			// 큰수 - 작은수를 비교하기 위해서 while문안에 작성
				System.out.print("점수를 입력하세요 :"); 
				i = sc.nextInt();
			}
	}
		sum = x/count; // 평균
		 System.out.print("최고 점수= " +max);
		 System.out.print("최저 점수= "+min);
		 System.out.print("평균 점수= "+sum);
		}
	}   // C