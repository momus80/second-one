package HomeWork;

import java.util.Scanner;

public class HomeWork03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int price = 0; // 구매 금액
		int change = 0; // 잔돈
		int hund, ten, one; // 100원 , 10원, 1원
		
		System.out.println("구매금액을 입력하시오(0-500):");
		price = sc.nextInt();
		change = 500-price;
		System.out.println("거스름돈 : "+change+"원");

		hund = change/100;
		System.out.println("100원 동전 : "+hund+"개");
		ten = (change/10)%10;
		System.out.println("10원 동전 : "+ten+"개");
		one = change%10;
		System.out.println("1원 동전 : "+one+"개");
	}

}  // C