

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.text.SimpleDateFormat;
import java.awt.event.*;

public class GUI 
{
    // instance variables - replace the example below with your own
    private JLabel bl1 = new JLabel("Student Name and ID: Lo Yuen Wing (18055797D)");
    private JLabel bl2 = new JLabel("Student Name and ID: Hung Tsz Him (18064518D)");
    private JLabel bl3 = new JLabel("");
    private JLabel bl4 = new JLabel("ISBN:");
    private JLabel bl5 = new JLabel("Title:");
    private JLabel LabelForMoreISBN = new JLabel("testin Isbn");
    private JLabel LabelForMoreTitle = new JLabel("testing title");
    private JLabel LabelForMoreAvaliable = new JLabel("testing abaliable");
    
    
    private JTextField isbn = new JTextField(8);
    private JTextField tit = new JTextField(8);
    
    private JButton add = new JButton("Add");
    private JButton edit = new JButton("Edit");
    private JButton save = new JButton("Save");
    private JButton del = new JButton("Delete");
    private JButton search = new JButton("Search");
    private JButton more = new JButton("More>>");
    private JButton load = new JButton("Load Test Data");
    private JButton dis = new JButton("Display All");
    private JButton disbn = new JButton("Display All by ISBN");
    private JButton distit = new JButton("Display All by Title");
    private JButton ex = new JButton("Exit");
    private JButton Borrow = new JButton("Borrow");
    private JButton Return = new JButton("Return");
    private JButton Reserve = new JButton("Reserve");
    private JButton WaitingQ = new JButton("Waiting Queue");

    JFrame f1 = new JFrame("Library Admin System");
    JFrame f2 = new JFrame("");
    
    
    String column[] = { "ISBN", "Title", "Avaliable" };
    DefaultTableModel TableModel = new DefaultTableModel(column, 0);
    private JTable table = new JTable(TableModel);
    private JScrollPane srol = new JScrollPane(table);    
    private JTextArea ar;

    private String InputISBN, InputTitle = "";
    private MyLinkedList<Book> data =  new MyLinkedList<>();
    private MyQueue<String> queue = new MyQueue<>();


    // the layout set up
    public void Layout()
    {
        JPanel p1 = new JPanel(new BorderLayout());
        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
        p1.setBackground(Color.white);
        p1.add(bl1);
        p1.add(bl2);
        p1.add(bl3);
        
        JPanel p2 = new JPanel(new BorderLayout());
        p2.add(srol);
        
        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,5));
        p3.add(bl4);
        p3.add(isbn);
        p3.add(bl5); 
        p3.add(tit);
        
        JPanel p4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p4.add(add);
        p4.add(edit);
        p4.add(save);
        p4.add(del);
        p4.add(search);
        p4.add(more);
        
        JPanel p5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p5.add(load);
        p5.add(dis);
        p5.add(disbn);
        p5.add(distit);
        p5.add(ex);

        JPanel p6 = new JPanel();
        p6.setLayout(new GridLayout(3,1));
        p6.add(p3);
        p6.add(p4);
        p6.add(p5);



        f1.setSize(800,600);
        f1.setLocationRelativeTo(null);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setVisible(true);
        f1.setLayout(new GridLayout(3,1));
        ar = new JTextArea("");
        f1.getContentPane().add(p1);
        f1.getContentPane().add(p2);
        f1.getContentPane().add(p6);

        JPanel p7 = new JPanel(new GridLayout(3,1));
        p7.add(LabelForMoreISBN);
        p7.add(LabelForMoreTitle);
        p7.add(LabelForMoreAvaliable);
        p7.setBackground(Color.white);

        JPanel p8 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p8.add(Borrow);
        p8.add(Return);
        p8.add(Reserve);
        p8.add(WaitingQ);

        f2.setSize(600,300);
        f2.setLocationRelativeTo(null);
        f2.setVisible(false);
        f2.setLayout(new BorderLayout());
        f2.add(p7,BorderLayout.NORTH);
        f2.add(p8,BorderLayout.CENTER);

        
    }

    // make all buttonListener
    public void CreateListener()
    {
        table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String ISBNValue = (table.getModel().getValueAt(row, 0).toString());
				String titleValue = (table.getModel().getValueAt(row, 1).toString());
				isbn.setText(ISBNValue);
				tit.setText(titleValue);
			}
			
		});

        add.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(f1,"ISBN and Title must be filled!","Error",JOptionPane.ERROR_MESSAGE);
            }
        });

        more.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                f2.setVisible(true);
            }
        });

    }

    // take input from two text box
    public void getInput()
    {
        InputISBN = isbn.getText();
        InputTitle = tit.getText();
    }




    public void updateTime()
	{
		Thread clock = new Thread()
		{
			public void run()
			{
				try {
					for (;;)
					{
						SimpleDateFormat formatter=new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy",java.util.Locale.ENGLISH);
						Date date = new Date();
					
					bl3.setText(formatter.format(date));
					
						sleep(1000);
					} 
				}
				catch (InterruptedException e) 
				{
						e.printStackTrace();
				}
			}
		};
		clock.start();
	}
    
    public GUI()
    {
        CreateListener();
        String T = "A";
		String I = "B";
		Boolean A = true;
		Object[] Data = {I, T, A};
		TableModel.addRow(Data);
        Layout();
        updateTime();

    }
    
    public static void main(String[] args) 
    {
	new GUI();
    }
}
