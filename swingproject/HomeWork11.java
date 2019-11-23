package HomeWork;

import java.util.Scanner;

public class HomeWork11 {

	public static void main(String[] args) {
		int citySum1 = 0, citySum2 = 0;

		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("보고 할 구가 있으면 \"yes\"를 입력하고, 없으면 \"no\"를 입력 : ");
			String add = sc.nextLine();
			
			if(add.equalsIgnoreCase("yes")) {
				System.out.print("첫번째 후보 득표 수 입력 : ");
				citySum1 += sc.nextInt();
				System.out.print("두번째 후보 득표 수 입력 : ");
				citySum2 += sc.nextInt();
				sc.nextLine();
				System.out.println();
			} else if (add.equalsIgnoreCase("no")) {
				break;
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				System.out.println();
			}
		}
		double percent = (double)citySum1 / (citySum1 + citySum2) * 100;
		
		System.out.printf("첫번째 후보가 얻는 총 득표수 %d이고 득표율은 %.2f%%이다.", citySum1, percent);
		System.out.printf("두번째 후보가 얻는 총 득표수 %d이고 득표율은 %.2f%%이다.", citySum2, percent);
	}
}