//Hung Tsz Him 18064518d 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.*;

public class Database
{
    private ArrayList<Item> items;

    /**
     * Construct an empty Database.
     */
    public Database()
    {
        items = new ArrayList<Item>();
    }

    /**
     * Add an item to the database.
     */
    public void addItem(Item theItem)
    {
        items.add(theItem);
    }
    
    /**
     * Print a list of all currently stored CDs and videos to the
     * text terminal.
     */
    public void list()
    {
        for(Iterator iter = items.iterator(); iter.hasNext();)
        {
            Item item = (Item)iter.next();
            item.print();
            System.out.println();   // empty line between items
        }
    }
    
    public Item searchByTitle(String theTitle)
    {
        for(Item item : items)
        {
            if(item.getTitle() == theTitle)
                return item;
            
        }
        
        return null;
    }
    
    public Item searchByTitlePattern(String pat)
    {
        Pattern pattern = Pattern.compile(pat, Pattern.CASE_INSENSITIVE);
        
        for(Item item : items)
        {
            Matcher matcher = pattern.matcher(item.getTitle());
            if (matcher.find()) 
                return item;
            
        }
        
        return null;
    }    
    
    public Item searchByPattern(String theTitle)
    {
        Pattern pattern = Pattern.compile(theTitle, Pattern.CASE_INSENSITIVE);
        
        for(Item item : items)
        {
            Matcher matcher = pattern.matcher(item.getTitle());
            //if (matcher.find()) 
            //    return item;
            matcher = pattern.matcher(item.getComment());
            if (matcher.find()) 
                return item;
                
            Class currentClass = item.getClass();
            
            if(currentClass.getName() == "CD")
            {
                CD temp = (CD)item;
                matcher = pattern.matcher(temp.getArtist());
                if (matcher.find())
                    return item;
                
            }
            
            if(currentClass.getName() == "Video")
            {
                Video temp = (Video)item;
                matcher = pattern.matcher(temp.getDirector());
                if (matcher.find())
                    return item;
                
            }
            
            if(currentClass.getName() == "VideoGame")
            {
                VideoGame temp = (VideoGame)item;
                matcher = pattern.matcher(temp.getPlatform());
                if (matcher.find())
                    return item;
                
            }
            
        }
        
        return null;
    } 
}
