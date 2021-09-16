import java.util.*;

public static class Assignment2
{
    public static void main(String[] arg)
    {
        System.out.println("testing");
        Scanner input = new Scanner(system.in);
        String temp = input.nextLine();
        ClockDisplay hkTime = new ClockDisplay(2,30);
        ClockDisplay londonTime = new ClockDisplay(10,30);
        hkTime.timeTick();
        londonTime.timeTick();
        System.out.println(hkTime.getTime());
        System.out.println(londonTime.getTime());

    }
}