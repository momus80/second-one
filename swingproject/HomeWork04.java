package HomeWork;

import java.util.Scanner;

public class HomeWork04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str="";
		int con=0, vow=0;
		int conCount=0, Acount=0, Ecount=0, Icount=0 ,Ocount=0, Ucount=0;
		
		System.out.println("단어 입력:");
		str=sc.nextLine();
		
		for (int i=0; i< str.length(); i++) {
			
			String subStr=str.substring(i, i+1);
			char subchar=str.charAt(i); 
			if(subStr.equalsIgnoreCase("a")) {
				Acount++;
			}
				else if(subStr.equalsIgnoreCase("e")) {
					Ecount++;
			}
				else if(subStr.equalsIgnoreCase("i")) {
					Icount++;
				}
				else if(subStr.equalsIgnoreCase("o")) {
					Ocount++;
				}
				else if(subStr.equalsIgnoreCase("u")) {
					Ucount++;
				}
				else {
					conCount++;
				}
		}
		System.out.println("a 개수="+Acount);
		System.out.println("e 개수="+Ecount);
		System.out.println("i 개수="+Icount);
		System.out.println("o 개수="+Ocount);
		System.out.println("u 개수="+Ucount);
		System.out.println("자음 개수="+conCount);
		
	}

} // C