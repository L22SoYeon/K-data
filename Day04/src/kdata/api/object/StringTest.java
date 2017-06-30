package kdata.api.object;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		String s3 = "Hello";
		String s4 = "Hello";

		//System.out.println(s1.hashCode());0c                      vv v
		s1 = s1 + "!";
		//System.out.println(s1.hashCode());

		//System.out.println(s2.hashCode());
		s2 = s2 + "!";
		//System.out.println(s2.hashCode());

		System.out.println(s1 == s2);

		//System.out.println(s3.hashCode());
		s3 = s3 + "!";
		//System.out.println(s3.hashCode());
		
		System.out.println();

		//System.out.println(s4.hashCode());
		s4 = s4 + "!";
		//System.out.println(s4.hashCode());

		System.out.println(s3 == s4);
	}

}
