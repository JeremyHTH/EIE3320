import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.*;

public class Picture 
{
    private ArrayList<Shape> shapes = new ArrayList<Shape>();

    public void addShape(Shape s)
    {
        shapes.add(s);
    }

    public void computeShape()
    {
        for(Iterator iter = shapes.iterator(); iter.hasNext();)
        {
            Shape currentShape = (Shape)iter.next();
            currentShape.computeArea();
            currentShape.computePerimeter();
        }
    }

    public void listAllShapeTypes()
    {
        for(Iterator iter = shapes.iterator(); iter.hasNext();)
        {
            Shape currentShape = (Shape)iter.next();
            currentShape.displayShape();
        }
    }

    public void listSingleShapeType(String className)
    {
        for(Iterator iter = shapes.iterator(); iter.hasNext();)
        {
            Shape currentShape = (Shape)iter.next();
            if (className == currentShape.getClass().getName())
            {
                currentShape.displayShape();
            }

        }

        for(Shape test : shapes)
        {
            if (className == test.getClass().getName())
            {
                test.displayShape();
            }
        }
    }


}
