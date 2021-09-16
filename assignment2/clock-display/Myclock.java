// Hung Tsz Him 18064518d
// The tool used : Visual Studio Code

public class Myclock 
{
    public static void main(String[] args)
    {
        ClockDisplay hkTime = new ClockDisplay(11,58);
        ClockDisplay londonTime = new ClockDisplay(23,58);
        
        for (int i=0; i<=6; i++)
        {
        hkTime.timeTick();
        londonTime.timeTick();
        System.out.println(hkTime.getTime());
        System.out.println(londonTime.getTime());
        }
    }
}
