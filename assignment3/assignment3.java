package assignment3;

public class assignment3 
{public static void main(String[] args)
    {
        Course[] listA = new Course[10];
        listA[0] = new Course("EIE3320", 60);
        listA[1] = new Course("EIE3105", 40);
        UniversityStudent studentA = new UniversityStudent("John", 2, listA);
        studentA.print();
        Course[] listB = new Course[10];
        listB[0] = new Course("COMP1001", 84);
        listB[1] = new Course("EIE3105", 68);
        listB[2] = new Course("EIE3320", 52);
        UniversityStudent studentB = new UniversityStudent("Mary", 3, listB);
        studentB.print();
    }

}

