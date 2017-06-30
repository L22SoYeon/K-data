package kdata.exeptions;

public class MyRuntimeException extends RuntimeException{

	public MyRuntimeException(){
		super("MyRuntimeException »ý¼ºÀÚ#1");
	}
	
	public MyRuntimeException(String msg){
		super(msg);
	}
}
