//Hung Tsz Him 18064518d 
public class Video extends Item
{
    // instance variables - replace the example below with your own
    private String director;

    /**
     * Constructor for objects of class Video
     */
    public Video(String theTitle, String theDirector, int time)
    {
        // initialise instance variables
        super(theTitle,time);
        director = theDirector;
    }
    
    public String getDirector()
    {
        return director;
    }
    
    public void print()
    {
        System.out.println("Video");
        super.print();
        System.out.println("Director: "+ director);
    }
}
