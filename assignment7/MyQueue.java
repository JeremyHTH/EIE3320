// Hung Tsz Him 18064518d 
// vscode jdk 11

import java.util.*;

public class MyQueue <E> 
{
    private LinkedList <E> list = new LinkedList<E>();
    
    public void enqueue(E e)
    {
        list.addLast(e);
    }

    public E dequeue()
    {
        E temp = list.getFirst();
        list.removeFirst();
        return temp;
    }

    public int getSize()
    {
        return list.size();
    }

    public String toString() 
    {
        return "Queue: " + list.toString();
    }
}
