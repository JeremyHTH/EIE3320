//Test 1 - Q1 Version A
//Your name: Hung Tsz Him
//Your student ID: 18064518d
public class Programmer extends Worker
{
    private String language;
    
    public Programmer(String name, String lang, int age)
    {
        super(name,age);
        this.language = lang;
    }
    
    public void print()
    {
        super.print();
        System.out.println("Programming language = " + language);
    }

    public void matureNot()
    {
        if (super.getAge() >= 25)
            System.out.println("Mature");
        else System.out.println("Not mature");
    }
}
