public class Book 
{
    private String title;
	private String ISBN;
	private boolean available;
	private MyQueue<String> reservedQueue = new MyQueue<>();

    public void setTitle(String input)
    {
        this.title =  input;
    }

    public String getTitle()
    {
        return title;
    } 

    public void setISBN(String input)
    {
        this.ISBN = input;
    }

    public String getISBN()
    {
        return ISBN;
    }

    public void setAvailable(boolean input)
    {
        this.available = input;
    }

    public boolean isAvailable()
    {
        return available;
    }

    public void setReservedQueue(MyQueue<String> input)
    {
		reservedQueue = input;
	}
	
	MyQueue<String> getReservedQueue()
    {
		return reservedQueue;
	}
}
