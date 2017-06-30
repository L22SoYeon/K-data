package kdata.api.object;

public class StringBufferTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringBuffer sb = new StringBuffer();
		System.out.println(sb.hashCode());
		sb.append("Hello");
		System.out.println(sb.hashCode());
		sb.append("!");
		System.out.println(sb.hashCode());
		System.out.println(sb);
		
		StringBuffer sb2 = new StringBuffer("Hello");
		System.out.println(sb2.hashCode());
		//StringBuffer sb2 = sb2 + "!";
		System.out.println(sb.hashCode());
	}

}
