//Test 1 - Q1 Version A
//Your name: Hung Tsz Him
//Your student ID: 18064518d
public class Salesman extends Worker
{
    private String Qualification;
    
    public Salesman(String name,String Qual, int age)
    {
        super(name,age);
        Qualification = Qual;
    }
        
    public void print()
    {
        super.print();
        System.out.println("Qualification = " + Qualification);
        super.matureNot();
    }
    
    
}
