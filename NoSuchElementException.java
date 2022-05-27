
public class NoSuchElementException extends Exception
{
	public NoSuchElementException()
	{
		super("Not a valid index");
	}
	
	
	public NoSuchElementException(String s)
	{	
		super(s);
	}
	
	public String getMessage()    
	{
		return super.getMessage();
	}
}


