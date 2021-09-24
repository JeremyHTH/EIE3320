package assignment3;

public class Course 
{
    private String courseName;
    private int testMarks;

    public Course(String name, int marks)
    {
        courseName = name; 
        testMarks = marks;
    }

    public String toString()
    {
        return courseName + ", " + testMarks;
    }
}
