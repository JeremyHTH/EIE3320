// Hung Tsz Him 18064518d
// vs code JDK 16

import  javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class Q1 extends JFrame 
{
    JTextField shape = new JTextField(8);
    JTextField radius = new JTextField(8);
    JTextField length = new JTextField(8);
    JTextField width = new JTextField(8);
    JTextField Area = new JTextField(8);
    JTextField Perimeter = new JTextField(8);
    private JButton process = new JButton("Get Results");
    private Shape target;

    public Q1() 
    {
        setLayout(new GridLayout(7, 2, 5, 5));
        add(new JLabel("Choose shape: 's','r' or 'c'"));
        add(shape);
        add(new JLabel("Input radius of circle"));
        add(radius);
        add(new JLabel("Input length of square or rectangle"));
        add(length);
        add(new JLabel("Input width of rectangle"));
        add(width);
        add(new JLabel("Area:"));
        add(Area);
        add(new JLabel("Perimeter"));
        add(Perimeter);

        add(process);
        
        ButtonListener listener = new ButtonListener();
        process.addActionListener(listener);
    }

    class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            if (e.getSource() == process)
            {
                System.out.println("Process");
                String input = shape.getText();
                
                switch(input.charAt(0))
                {
                    case 's':
                    {
                        System.out.println("s");
                        target = new Square(Float.parseFloat(length.getText()));
                        target.computeArea();
                        target.computePerimeter();
                        Area.setText(String.valueOf(target.getArea()));
                        Perimeter.setText(String.valueOf(target.getPerimeter()));
                        break;
                    }
                    case 'c':
                    {
                        System.out.println("c");
                        target = new Circle(Float.parseFloat(radius.getText()));
                        target.computeArea();
                        target.computePerimeter();
                        Area.setText(String.valueOf(target.getArea()));
                        Perimeter.setText(String.valueOf(target.getPerimeter()));
                        break;
                    }
                    case 'r':
                    {
                        System.out.println("r");
                        target = new Rectangle(Float.parseFloat(length.getText()),Float.parseFloat(width.getText()));
                        target.computeArea();
                        target.computePerimeter();
                        Area.setText(String.valueOf(target.getArea()));
                        Perimeter.setText(String.valueOf(target.getPerimeter()));
                        break;
                    }
                    default:
                    {
                        Area.setText("Error");
                        Perimeter.setText("Error");
                    }
                }


            }
            
        }
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