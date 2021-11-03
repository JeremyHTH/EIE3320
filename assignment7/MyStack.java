// Hung Tsz Him 18064518d 
// vscode jdk 11

import java.util.*;

public class MyStack <E>
{
    private ArrayList<E> list  = new ArrayList<E>();

    public int getSize()
    {
        return list.size();
    }

    public E peek()
    {
        return list.get(getSize() - 1);
    }

    public E pop()
    {
        E temp = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return temp;
    }
    
    public void push(E o)
    {
        list.add(o);
    }

    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    public String toString() 
    {
        return "stack: " + list.toString();
    }

    
}