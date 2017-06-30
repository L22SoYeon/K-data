package kdata.exeptions;

public class RuntimeExeptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// runtime exception

		try {
			System.out.println("try 시작");
			System.out.println(2 / 2); // 컴파일 시 문제 발생X 실행 시 문제 발생O

			String s = null;

			System.out.println(s.charAt(1));

			System.out.println("try 끝");
			
		}catch (ArithmeticException e) {
			System.out.println("catch - Arithmetic");
		} catch (NullPointerException e) {
			System.out.println("catch - NullPointer");
		}catch(RuntimeException e){
			e.printStackTrace();
		}finally {
		}
			System.out.println("finally");
		}
	

}
