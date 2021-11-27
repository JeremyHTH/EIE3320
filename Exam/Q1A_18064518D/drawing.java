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


public class drawing extends JFrame
{
    private int l = 100;
    private int x = 10;
    private int y = 10;
    private int dx = 450;
    private int dy = 150;
    private JLabel l1,l2,l3;
    private JTextField userX, userY, userL;
    private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;

    public drawing() 
    {
        JButton b10 = new JButton();
        b10.setText("Draw");
        l1 = new JLabel("x");
        l2 = new JLabel("y");
        l3 = new JLabel("l");
        userX = new JTextField(8);
        userY = new JTextField(8);
        userL = new JTextField(8);


        
        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        p1.add(l1);
        p1.add(userX);
        p1.add(l2);
        p1.add(userY);
        p1.add(l3);
        p1.add(userL);
        p1.add(b10);

        b1 = new JButton();
        b2 = new JButton();
        b3 = new JButton();
        b4 = new JButton();
        b5 = new JButton();
        b6 = new JButton();
        b7 = new JButton();
        b8 = new JButton();
        b9 = new JButton();

        b1.setText("UpLeft");
        b2.setText("Up");
        b3.setText("UpRight");
        b4.setText("Left");
        b5.setText("Center");
        b6.setText("Right");
        b7.setText("DownLeft");
        b8.setText("Down");
        b9.setText("DownRight");

        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(3,3));
        p3.add(b1);
        p3.add(b2);
        p3.add(b3);
        p3.add(b4);
        p3.add(b5);
        p3.add(b6);
        p3.add(b7);
        p3.add(b8);
        p3.add(b9);

        this.add(p1,BorderLayout.NORTH);
        this.add(new drawPanel());
        this.add(p3,BorderLayout.SOUTH);
        
        b10.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                x = Integer.valueOf(userX.getText());
                y = Integer.valueOf(userY.getText());
                l = Integer.valueOf(userL.getText());
                repaint();
            }
        });

        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (x >=5)
                {
                    x-=5;

                }

                if (y>=5)
                {
                    y -=5;
                }
                repaint();
            }
        });

        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (y >=5)
                {
                    y-=5;
                }
                repaint();
            }
        });

        b3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (x <= dx -l - 10)
                {
                    x+=5;
                }
                
                if (y >=5)
                y-=5;
                

                repaint();
            }
        });

        b4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (x >=5 )
                {
                    x-=5;

                }
                repaint();
            }
        });

        b5.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                x = (dx-l)/2;
                y = (dy-l)/2;
                repaint();
            }
        });

        b6.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (x <=dx - l - 10)
                {
                    x+=5;
                }
                repaint();
            }
        });

        b7.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (x >=5)
                {
                    x-=5;
                }
                
                if (y <= dy-l-10)
                    y +=5;
                
                repaint();
            }
        });

        b8.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if ( y <=dy-l-10)
                {
                    y+=5;
                }
                repaint();
            }
        });
        
        b9.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (x <=dx-l-10)
                {
                    x+=5;
                }
                
                if (y <dy -l - 10)
                y+=5;
                repaint();
            }
        });
        

    }

    class drawPanel extends JPanel
	{
        public void paint(Graphics g)
		{
			if(x >= 0 && y >= 0&& x<=450 && y<=300)
                g.drawRect(x,y,l,l);
            dx = this.getWidth();
            dy = this.getHeight();
		}

        
	}

    public static void main(String[] arg)
    {
        drawing frame = new drawing();
        frame.setTitle("Deaw Square (Hung Tsz Him)");
        frame.setSize(450,300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
