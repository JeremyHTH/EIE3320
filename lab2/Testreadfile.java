import java.io.*;
import java.util.*;
public class Testreadfile 
{
    static MyLinkedList<Book> test =  new MyLinkedList<>();
    static int mode =1;

    public static void main(String[] args)
    {
        // try 
        // {
        //     File myObj = new File("Book.txt");
        //     if (myObj.createNewFile()) {
        //       System.out.println("File created: " + myObj.getName());
        //     } else {
        //       System.out.println("File already exists.");
        //     }
        // } 
        // catch (IOException e) 
        // {
        //     System.out.println("An error occurred.");
        //     e.printStackTrace();
        // }
        
        if (mode == 1)
        {
            try 
            {
                File myObj = new File("Book.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) 
                {
                    String data = myReader.nextLine();
                    String[] name = data.split("~");
                    Book temp = new Book();
                    temp.setISBN(name[0]);
                    temp.setTitle(name[1]);
                    if (name[2].equals("true"))
                        temp.setAvailable(true);
                    else 
                        temp.setAvailable(false);
        
                    
                    test.add(temp);
                }
                myReader.close();
            } 
            catch (FileNotFoundException e) 
            {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        if (mode == 2)
        {
            try {
                FileWriter myWriter = new FileWriter("book.txt",true);
                myWriter.write("Files in Java might be tricky, but it is fun enough!");
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } 
            catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

    }
}
