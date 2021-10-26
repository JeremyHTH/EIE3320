//18064518D Hung Tsz Him

import java.util.Scanner;

public class Circle extends Shape
{
    private float radius; 

    public Circle()
    {
        this(1);
    }

    public Circle(float r)
    {
        this.radius = r;
    }

    public void readShape()
    {
        System.out.println("Please input the radius:");
        Scanner input = new Scanner(System.in);
        float r = input.nextFloat();
        this.radius = r;
    }

    public void computeArea()
    {
        super.area = radius*radius*(float)Math.PI;
    }

    public void computePerimeter()
    {
        super.perimeter = 2*(float)Math.PI*radius;
    }

    public void displayShape()
    {
        System.out.println("Area of circle = " + super.area);
        System.out.println("Perimeter of circle = " + super.perimeter);
        System.out.println();
    }

    
}
