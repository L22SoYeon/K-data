package kdata.switchtest;

public class SwitchTest {
	public static void main(String[] args){
		
		int a = 10;
		
		switch(a % 2){
		case 0 : 
			System.out.println("¦��"); 
			break;
		case 1 : 
			System.out.println("Ȧ��"); 
			break;
		}
		
		
		int score = 89;
		
		switch(score / 10){
		case 10 :
		case 9 :
			System.out.println("A�Դϴ�");
			break;
		case 8 :
			System.out.println("B�Դϴ�");
			break;
		case 7 :
			System.out.println("C�Դϴ�");
			break;
		case 6 : 
			System.out.println("D�Դϴ�");
			break;
		default :
			System.out.println("F�Դϴ�");
		}
	}
}
