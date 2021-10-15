
//Test 1 - Q1 Version A
//Your name: Hung Tsz Him
//Your student ID: 18064518d
public class ProgrammerTrainee extends Programmer implements OTAllowance
{
    // instance variables - replace the example below with your own
    private int trainingHours;
    private int OTpaid = 100;

    public ProgrammerTrainee(String name,String lang,int hour, int age)
    {
   
        super(name,lang,age);   
        this.trainingHours = hour;
    }
    
    public void print()
    {
        super.print();
        System.out.println("Training hour = " + trainingHours);
    }
    
    public int getOTAllowance(int y)
    {
        return OTpaid * y;
    }
    
    
    
}
