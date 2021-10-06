
//Hung Tsz Him 18064518d

public class VideoGame
{
    // instance variables - replace the example below with your own
    private String title;
    private String platform;
    private int numberOfPlayer;
    private int playingTime;
    private boolean gotIt;
    private String comment;
    

    /**
     * Constructor for objects of class VideoGame
     */
    public VideoGame(String inputTitle, String inputPlatform,int inputPlayer,int length)
    {
        // initialise instance variables
        title = inputTitle;
        platform = inputPlatform; 
        numberOfPlayer = inputPlayer;
        playingTime = length;
    }

    public void setComment(String input)
    {
        this.comment = input;
    }
    
    public String getComment()
    {
        return comment;
    }
    
    public void setOwn(boolean input)
    {
        this.gotIt = input;
    }
    
    public void print()
    {
        System.out.println("VideoGame");
        System.out.println("Title: " + this.title);
        if(this.gotIt) {
            System.out.println("Got it: Yes");
        } else {
            System.out.println("Got it: No");
        }
        System.out.println("Playing time: " + this.playingTime);
        System.out.println("Comment: " + this.comment);
        System.out.println("Platform: " + this.platform);
        System.out.println("No. of players: " + this.numberOfPlayer);
    }
}
