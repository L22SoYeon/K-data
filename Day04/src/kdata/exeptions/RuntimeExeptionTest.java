package kdata.exeptions;

public class RuntimeExeptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// runtime exception

		try {
			System.out.println("try ����");
			System.out.println(2 / 2); // ������ �� ���� �߻�X ���� �� ���� �߻�O

			String s = null;

			System.out.println(s.charAt(1));

			System.out.println("try ��");
			
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
