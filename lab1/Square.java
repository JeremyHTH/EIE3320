//18064518D Hung Tsz Him

import java.util.Scanner;

public class Square extends Shape
{
    private float length; 

    public Square()
    {
        this(1);
    }

    public Square(float l)
    {
        this.length = l;
    }

    public void readShape()
    {
        System.out.println("Please input the length: ");
        Scanner input = new Scanner(System.in);
        float l = input.nextFloat();
        this.length = l;
    }

    public void computeArea()
    {
        super.area = length*length;
    }

    public void computePerimeter()
    {
        super.perimeter = 4*length;
    }

    public void displayShape()
    {
        System.out.println("Area of Square = " + super.area);
        System.out.println("Perimeter of Square = " + super.perimeter);
        System.out.println();
        draw();
    }

    public void draw()
    {
        Canvas canvas = Canvas.getCanvas();
        canvas.draw(this,"blue",new java.awt.Rectangle(100,100,(int)length,(int)length));
    }
}
