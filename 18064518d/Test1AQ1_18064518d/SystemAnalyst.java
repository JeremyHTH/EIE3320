//Test 1 - Q1 Version A
//Your name: Hung Tsz Him
//Your student ID: 18064518d

public class SystemAnalyst extends Programmer implements OTAllowance
{
    private int numofsupervise;
    private int OTpaid = 500;
    
    public SystemAnalyst(String name,String lang,int num, int age)
    {
        // initialise instance variables
        super(name,lang,age);
        this.numofsupervise = num;
    }
    
    public void print()
    {
        super.print();
        System.out.println("Number of programmers = " + numofsupervise);
    }
    
    public int getOTAllowance(int y)
    {
        return OTpaid * y;
    }
}
