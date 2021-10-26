//18064518D Hung Tsz Him

public abstract class Shape 
{
    protected float area;
    protected float perimeter;

    // To read the shape information from users
    abstract public void readShape(); 

    // To compute the shape’s area
    abstract public void computeArea();

    // To computer the shape’s perimeter 
    abstract public void computePerimeter(); 

    // To display the area and perimeter of the shape
    abstract public void displayShape();

    public float getArea()
    {
        return area;
    }

    public float getPerimeter()
    {
        return perimeter;
    }
}
