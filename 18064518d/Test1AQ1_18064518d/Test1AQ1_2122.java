//Test 1 - Q1 Version A
//Your name: Hung Tsz Him
//Your student ID: 18064518d
public class Test1AQ1_2122
{
   public static void main()
    {
        Salesman s = new Salesman("A", "AA", 18);
        s.print();
        System.out.println();
        ProgrammerTrainee pt = new ProgrammerTrainee("B", "BB", 1, 18);
        pt.print();
        System.out.println("OT allowance: " + pt.getOTAllowance(2));
        pt.matureNot();
        System.out.println();
        SystemAnalyst sa = new SystemAnalyst("C", "CC", 3, 30);
        sa.print();
        System.out.println("OT allowance: " + sa.getOTAllowance(6));
        sa.matureNot();
        System.out.println();
        Worker w = new Worker("D", 30);
        w.print();
        w.matureNot();
        System.out.println();
        Programmer p = new Programmer("E", "EE", 24);
        p.print();
        p.matureNot();
    } 
}
