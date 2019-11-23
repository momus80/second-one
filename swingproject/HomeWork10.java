package HomeWork;

import java.util.Scanner;

public class HomeWork10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 10. 숫자 1에서 100 사의 임의의 선택한다. 1과 100도 선택될 수 있다. 
		 * 추축한 숫자를 맞출때까지 계속하고, 맞출 때까지 횟수를 세고, 
		 * 맞고 난 후 횟수를 출력하시오. 
		 * 게임이 끝난 후에 맞추기 게임을 계속하기를 원하는지 알아보라.
		 */
Scanner sc = new Scanner(System.in);
		
		int num,answer;
		int count = 0;
		answer=(int)(Math.random()*100)+1;
		
		do { 
		System.out.print("추측한 숫자를 입력 : ");
		num = sc.nextInt();
		
		
		
		if(num>answer) {
			System.out.println("추측한 숫자가 틀렸습니다.");
		
			System.out.println("추측한 숫자가 작습니다.");
			count++;
			int i = count;
		}
		else if(num<answer) {
			System.out.println("추측한 숫자가 틀렸습니다.");
		
				System.out.println("추측한숫자가 큽니다");
				count++;
				
		}
	} while(num!=answer);
		int i= count;
		System.out.printf("정답\n"+"틀린횟수 :"+i);
		
	}
} //C
