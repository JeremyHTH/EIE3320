//Test 1 - Q1 Version A
//Your name: Hung Tsz Him
//Your student ID: 18064518d

public class Worker extends People
{
    private String name;
    
    public Worker(String name,int age)
    {
        super(age);
        this.name = name;
    }
    
    public void print()
    {
        System.out.println("Name = " + name);
    }
    
    public void matureNot()
    {
        System.out.println("Any age");
    };
     
}
