package ClassEx;

public class Lotto {
	public static void main(String[] args) { 
        int[] Num = new int[6];  //6개의 공간 선언
        	
        
        System.out.println("\n<<추천 번호를 시작합니다>>\n"); 

        for(int i = 0; i<Num.length; i++ ) { 
        	 //랜덤 수를 6칸에 각각 저장한다.
        	
            Num[i] = (int)(Math.random()*45)+1; // 0부터 시작하니까 +1 -> 1로 시작   
            
            System.out.println((i+1) + "번째 숫자  :  "  + Num[i] + "\n");
            // 몇번째 숫자인지 : 랜덤 값 6개
        } 
        
        System.out.println("~~~~중복된 숫자 있는지 확인중~~~~\n");
        
        	// 저장된 램덤숫자를 서로 비교하기
           //  랜덤숫자가 같으면 숫자 다시 바꿔서 저장하기.
             
        for (int i = 0; i<Num.length; i++ )  { //for1  
        	
        	System.out.println("비교전 숫자  Num["+i+"] : "+Num[i]+"          ========= ");
        	
        	for (int j = i+1; j<Num.length; j++ ) {  // for2

        		if(Num[i] == Num[j]){     

        			System.out.println("\n\n중복된 숫자 발견  ["+i+"] : ["+j+"]  숫자 ===>"+Num[i]+" : "+Num[j]);

        			Num[i] = (int)(Math.random()*45)+1;

        			System.out.println("다른숫자로 변경   ["+i+"] : ["+j+"]  숫자를===>"+Num[i]+":"+Num[j]+"로  변경\n\n");
                         //i=0; // 같은값 발생하면 랜덤값 생성후 i값 변경후 다시 재검사

        			j--; 
                    } 
                System.out.print("비교 여부\t Num["+i+"] : Num["+j+"]===>"+Num[i]+" : "+Num[j]+" \n"); 
                } // 2 
            } // 1
             
        System.out.println(); 
        System.out.println("추천 번호는 ");
        for(int i=0;i<Num.length;i++){ 
        	
            System.out.print(Num[i]+" "); 
        } 
        System.out.println("입니다"); 
    } 
}