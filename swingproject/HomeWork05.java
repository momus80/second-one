package HomeWork;

import java.util.Scanner;

public class HomeWork05 {

	public static void main(String[] args) {
		//자바 점수을 읽어 60이상 받은 학생들의 수와
		//60점 미만를 받은 학생들의 수를 계산하는 프로그램을 작성하시오.
				Scanner sc = new Scanner(System.in);
				int  jumsu = 0;
				int x = 0;
				int Acount = 0;
				int Bcount = 0;
			
				do {
					System.out.println("점수를 입력하세요 (-1 입력시 종료)");
					jumsu = sc.nextInt();
					
					if(jumsu >= 60) {
						Acount++;
					}
					if(jumsu < 60) {
							Bcount++;
					}
				}while(jumsu != -1 );
				System.out.println("60점 이상 학생의 수 : "+Acount);
				System.out.println("60점 미만 학생의 수 : "+Bcount);
	}
}//c