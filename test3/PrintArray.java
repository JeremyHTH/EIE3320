//Q3. Your name and ID:Hung Tsz Him 18064518d
import java.util.Scanner;
public class PrintArray{  

/*Add your source code here. Do not modify any source code given. You are  required to implement the methods of reversePrint and printUnique.*/

    public static void main (String[] args) 
    {  
        System.out.print("Please enter array size: ");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.print("Please enter each element of array separated by a space: ");
        int arr[];
        arr= new int[a];        
        for (int i=0; i<a; i++)  {
            arr[i] = scanner.nextInt();
        }
        reversePrint(arr);  
        printUnique(arr);
    }  
    public static void reversePrint(int[] input)
    {
        System.out.print("The array inputted is printed reversely: ");
        for(int i=input.length -1; i >=0; i--)
        {
            System.out.print(input[i] + " ");
        }
        System.out.println();
    }
    public static void printUnique(int[] input)
    {
        System.out.print("The distinct elements of the array inputted are: ");
        System.out.print(input[0] + " ");
        for(int i =1; i<= input.length-1; i++)
        {
            int unique = 1;
            for (int j=0; j < i; j++)
            {
                if(input[i] == input[j])
                    unique = 0;
            }
            if(unique == 1)
                System.out.print(input[i] + " ");
        }
    }
}  