package HomeWork;

import java.util.Scanner;

public class HomeWork09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 9. 난수를 이용하여 1부터 10 사이의 숫자를 생성하여 숫자를 맞추는 
		 * 프로그램을 작성하시오 추측 숫자를 입력 : 5 추축한 숫자가틀렸습니다 
		 * 추축한 숫자가 너무 큽니다 추측 숫자를 입력 : 3 추축한 숫자가 틀렸습니다 
		 * 추축한 숫자가 너무 작습니다 추측 숫자를 입력 :4 추축한 숫자가 맞습니다
		 */
		Scanner sc = new Scanner(System.in);
		
		int num,answer;
		
		answer=(int)(Math.random()*10)+1;
		
		do { 
		System.out.print("추측한 숫자를 입력 : ");
		num = sc.nextInt();
		
		if(num>answer) {
			System.out.println("추측한 숫자가 틀렸습니다.");
		
			System.out.println("추측한 숫자가 작습니다.");
		}
		else if(num<answer) {
			System.out.println("추측한 숫자가 틀렸습니다.");
		
				System.out.println("추측한숫자가 큽니다");
		}
	} while(num!=answer);
		System.out.println("정답");
	}

	}// C
