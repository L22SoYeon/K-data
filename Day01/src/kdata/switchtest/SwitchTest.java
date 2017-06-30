package kdata.switchtest;

public class SwitchTest {
	public static void main(String[] args){
		
		int a = 10;
		
		switch(a % 2){
		case 0 : 
			System.out.println("짝수"); 
			break;
		case 1 : 
			System.out.println("홀수"); 
			break;
		}
		
		
		int score = 89;
		
		switch(score / 10){
		case 10 :
		case 9 :
			System.out.println("A입니다");
			break;
		case 8 :
			System.out.println("B입니다");
			break;
		case 7 :
			System.out.println("C입니다");
			break;
		case 6 : 
			System.out.println("D입니다");
			break;
		default :
			System.out.println("F입니다");
		}
	}
}
