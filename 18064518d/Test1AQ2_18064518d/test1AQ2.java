//Test 1 - Q2 Version A
//Your name: Hung Tsz Him
//Your student ID: 18064518d

import java.util.Scanner;

public class test1AQ2
{
    public static void main(String arg[]) 
    {
        System.out.print("n = ");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        
        
        System.out.println("(1 + 1/n)^n = " + calE(num));
        System.out.print("d = ");
        float d = input.nextFloat();
        int k = 1;
        while((calE(k+1) - calE(k) > d))
        {
            k += 1;
        }
        
        System.out.printf("n = %d and (1 + 1/n)^n = %f \n",k,calE(k));
        
        
    }
    
    public static float calE(int number)
    {
        float base = 1 + 1/(float)number;
        float answer = 1;

        for (int i = 1; i <= number; i++)
        {
            answer = answer * base;
        }
        
        return answer;
    }
}
