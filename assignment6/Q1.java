// Hung Tsz Him 18064518d
// vs code JDK 16

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class Q1 extends JFrame 
{
    
    public Q1() 
    {
        setLayout(new GridLayout(7, 2, 5, 5));
        add(new JLabel("Choose shape: 's','r' or 'c'"));
        add(new JTextField(8));
        add(new JLabel("Input radius of circle"));
        add(new JTextField(8));
        add(new JLabel("Input length of square or rectangle"));
        add(new JTextField(8));
        add(new JLabel("Input width of rectangle"));
        add(new JTextField(8));
        add(new JLabel("Area:"));
        add(new JTextField(8));
        add(new JLabel("Perimeter"));
        add(new JTextField(8));
        add(new JButton("Get Results"));
    }

    public static void main(String[] arg)
    {
        Q1 frame = new Q1();
        frame.setTitle("ShowGridLayout");
        frame.setSize(500, 375);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}