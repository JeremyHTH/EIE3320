import java.util.Scanner;

public class SharpTester 
{
    public static void main(String arg[]) 
    {
        Shape test;
        boolean conti = true;

        while (conti)
        {
            System.out.println("*************************************");
            System.out.println("* Please choose one the followings: *");
            System.out.println("* Press 'c' - Circle                *");
            System.out.println("* Press 's' - Square                *");
            System.out.println("* Press 'r' - Rectangle             *");
            System.out.println("* Press 'x' - Exit                  *");
            System.out.println("*************************************");
            System.out.println();
            Scanner input = new Scanner(System.in);
            char choose = input.next().charAt(0);

            switch(choose)
            {
                case 'c' :
                    test = new Circle();
                    test.readShape();
                    test.computeArea();
                    test.computePerimeter();
                    test.displayShape();
                    break;

                case 's' :
                    test = new Square();
                    test.readShape();
                    test.computeArea();
                    test.computePerimeter();
                    test.displayShape();
                    break;

                case 'r' :
                    test = new Rectangle();
                    test.readShape();
                    test.computeArea();
                    test.computePerimeter();
                    test.displayShape();
                    break;

                case 'x' :
                    conti = false;
                    break;
            }
        }
    }
}
