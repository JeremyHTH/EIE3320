import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.text.SimpleDateFormat;
import java.awt.event.*;
import java.io.*; 

public class Q3
{
    public Q3()
    {

    }

    public static void main(String[] args)
    {
        Map<Integer, Integer> map = new HashMap<>(); 
        ArrayList<Integer> listofKey = new ArrayList<>();
        boolean conti = true;
        Scanner input = new Scanner(System.in);
        while (conti)
        {
            System.out.print("Enter an integer:  ");
            int inputint = input.nextInt();
            if (inputint == 0)
            {
                conti = false;
            }
            else 
            {
                if (!map.containsKey(inputint))
                {
                    map.put(inputint, 1);
                    listofKey.add(Integer.valueOf(inputint));
                }
                else 
                {
                    int frequency = map.get(inputint);
                    frequency++;
                    map.put(inputint, frequency);
                }
            }
        }

        ArrayList<Integer> listoffrequency = new ArrayList<>();
        for (int i = 0; i<listofKey.size(); i++)
        {
            if (!listoffrequency.contains(map.get(listofKey.get(i))))
            {
                listoffrequency.add(map.get(listofKey.get(i)));
            }
        }

        Collections.sort(listoffrequency);

        int max = listoffrequency.get(listoffrequency.size()-1);

        for(int i =0; i<listofKey.size(); i++)
        {
            if (map.get(listofKey.get(i)) == max)
            {
                System.out.println("Number " + listofKey.get(i).toString() + " occurred most");
            }
        }

        System.out.println("Key        Occurrence");
        //List<Map.Entry<Integer,Integer>> entries = new ArrayList<>(treeMap.entrySet());

        for(int i=0; i < listoffrequency.size();i++)
        {
            ArrayList<Integer> listofprintkey = new ArrayList<>();
            int nooff = 0;
            for (int j=0; j<listofKey.size(); j++)
            {
                if (map.get(listofKey.get(j)) == listoffrequency.get(i))
                {
                    listofprintkey.add(listofKey.get(j));

                }
            }

            Collections.sort(listofprintkey);
            for (int j=0; j<listofprintkey.size(); j++)
            {
                System.out.println( listofprintkey.get(j).toString()+ "      " + map.get(listofprintkey.get(j)).toString());
            }
        }
    }

}