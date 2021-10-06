//Hung Tsz Him 18064518d 
public class VideoGame extends Item
{
    // instance variables - replace the example below with your own
    private String platform;
    private int numberOfPlayer;

    /**
     * Constructor for objects of class VideoGame
     */
    public VideoGame(String inputTitle, String inputPlatform,int inputPlayer,int length)
    {
        // initialise instance variables
        super(inputTitle,length);
        platform = inputPlatform;
        numberOfPlayer = inputPlayer;
    }

    public void print()
    {
        System.out.println("VideoGame");
        super.print();
        System.out.println("Platform: " + platform);
        System.out.println("No. of players: " + numberOfPlayer);
    }
}
