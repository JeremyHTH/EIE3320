// Hung Tsz Him 18064518d
// The tool used : Visual Studion Code

import java.util.Scanner;

public class Assignment1 
{
    public static void main(String[] args)
    {
        Question5();
    }

    public static void Question1()
    {
        System.out.print("Enter the number of lines: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String space = " ";

        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= (n - i); j++)
                System.out.printf("%3s",space);
            for (int j = i; j >0; j--)  
                System.out.printf("%3d",j);
            for (int j = 2; j <= i; j++) 
                System.out.printf("%3d",j);
            System.out.println();
        }
    }

    public static void Question2()
    {
        System.out.print("Enger the number of seconds: ");
        Scanner input = new Scanner(System.in);
        int seconds = input.nextInt();
        int hour = seconds/60/60;
        int min = (seconds - hour *60*60)/60;
        int second = (seconds - hour*60*60 - min*60);
        System.out.printf("%d seconds is %d hours, %d minutes, and %d second", seconds, hour, min, second);
    }

    public static void Question3()
    {
        System.out.print("The first 100 triangular numbers are:\n");
        int count = 0;
        for (int i=1; i<=100; i++)
        {
            System.out.print(getTriangularNumber(i) + " ");
            count++;
            if ((count % 10) == 0)
            {
                count = 0;
                System.out.print("\n");

            }
        }

    }

    public static int getTriangularNumber(int n)
    {
        if (n < 0) return 0;
        else return (1+n)*n/2; 
    }

    public static void Question4()
    {
        System.out.print("Enter a month (January = 1):");
        Scanner input = new Scanner(System.in);
        int month = input.nextInt();
        switch (month)
        {
            case 1 : System.out.println("January has 31 days"); break;
            case 2 : System.out.println("February has 28 days"); break;
            case 3 : System.out.println("March has 31 days"); break;
            case 4 : System.out.println("April has 30 days"); break;
            case 5 : System.out.println("May has 31 days"); break;
            case 6 : System.out.println("June has 30 days"); break;
            case 7 : System.out.println("July has 31 days"); break;
            case 8 : System.out.println("August has 31 days"); break;
            case 9 : System.out.println("September has 31 days"); break;
            case 10 : System.out.println("October has 31 days"); break;
            case 11 : System.out.println("November has 31 days"); break;
            case 12 : System.out.println("December has 31 days"); break;
            default : System.out.println("Fuck u");
        }

    }

    public static void Question5()
    {
        System.out.printf("Candy ");
        Scanner input = new Scanner(System.in);
        String data = input.nextLine();
        int index = data.indexOf(" ");
        int candy_in_hand = Integer.valueOf(data.substring(0, index));
        int number_for_return = Integer.valueOf(data.substring(index + 1, data.length()));
        int totalcandy = candy_in_hand;
        System.out.printf("n=%d; m=%d; No. of candies=",candy_in_hand,number_for_return);
        while (candy_in_hand >= number_for_return)
        {
            candy_in_hand -= number_for_return - 1;
            totalcandy += 1; 
        }
        System.out.printf("%d", totalcandy);
    }
}
