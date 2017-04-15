package structures.linear;

public class OrderViolationException extends RuntimeException {
	public OrderViolationException(){
		super();
	}
	
	public OrderViolationException(String s){
		super(s);
	}
}
