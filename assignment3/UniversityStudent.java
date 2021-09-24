package assignment3;

public class UniversityStudent 
{
    private String studentName; 
    private int courseNumber;
    private Course[] courseList = new Course[10];

    public UniversityStudent(String name, int number, Course[] inputCourse)
    {
        studentName = name;
        courseNumber =  number;
        courseList = inputCourse;

    }
    public void print()
    {
        System.out.println("Student Name: " + studentName);
        for (int i = 0; i < courseNumber; i++)
        {
            System.out.println(courseList[i].toString());
        }
    }
}
