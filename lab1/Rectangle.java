import java.util.Scanner;

public class Rectangle extends Shape
{
    private float length;
    private float width;


    public Rectangle()
    {
        this(1,1);
    }

    public Rectangle(float l,float w)
    {
        this.length = l;
        this.width = w;
    }

    public void readShape()
    {
        System.out.println("Please input the length: ");
        Scanner input = new Scanner(System.in);
        float l = input.nextFloat();
        this.length = l;
        System.out.println("Please input the width: ");
        float w = input.nextFloat();
        this.width = w;
    }

    public void computeArea()
    {
        super.area = length*width;
    }

    public void computePerimeter()
    {
        super.perimeter = 2*(length + width);
    }

    public void displayShape()
    {
        System.out.println("Area of Rectangle = " + super.area);
        System.out.println("Perimeter of Rectangle = " + super.perimeter);
        System.out.println();
    }
}
