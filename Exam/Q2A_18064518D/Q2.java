
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

public class Q2 
{
    public static void main(String[] args)
    {
        BST<String> tree = new BST();
        System.out.println("Input a list of strings and press enter:");
        Scanner scanner = new Scanner(System.in);
        String input[] = scanner.nextLine().split(" ");
        for(int i =0 ;i < input.length;i++)
        {
            tree.insert(input[i]);
        }
        System.out.print("\nInorder: ");
        tree.nonRecursivePostorder();
        System.out.println();
        System.out.print("Input an element:");
        String input2 =  scanner.nextLine();

        System.out.println("\nIs "+ input2 + " in the tree?" + Boolean.toString(tree.search(input2)));

        if(tree.search(input2))
        {
            System.out.print("A path from the root to "+ input2 + " is: ");
            java.util.ArrayList<BST.TreeNode<String>> path = tree.path(input2);
            for (int i = 0; path != null && i < path.size(); i++)
            System.out.print(path.get(i).element + " ");
        }
    }
}
