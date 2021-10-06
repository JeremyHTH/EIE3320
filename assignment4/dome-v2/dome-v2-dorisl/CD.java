//Hung Tsz Him 18064518d 
public class CD extends Item
{
    // instance variables - replace the example below with your own
    private String artist;
    private int numberOfTracks;
    

    /**
     * Constructor for objects of class CD
     */
    public CD(String theTitle, String theArtist, int tracks, int time)
    {
        // initialise instance variables
        super(theTitle,time);
        numberOfTracks = tracks;
        artist = theArtist;
        
        
    }
    
    public void print()
    {
        System.out.println("CD");
        super.print();
        System.out.println("Artist: "+ artist);
        System.out.println("No. of tracks: "+ numberOfTracks);
    }
}
