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
    private JButton display = new JButton("Display All");
    private JButton displayByISBN = new JButton("Display All by ISBN");
    private JButton displayByTitle = new JButton("Display All by Title");
    private JButton exit = new JButton("Exit");
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
    private int editIndex;
    private boolean ISBNascending = true;
    private boolean Titleascending = true;




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
        p5.add(display );
        p5.add(displayByISBN);
        p5.add(displayByTitle);
        p5.add(exit);

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

        setbuttonmode(0);

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
        table.addMouseListener(new MouseAdapter() 
        {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				InputISBN = (table.getModel().getValueAt(row, 0).toString());
				InputTitle = (table.getModel().getValueAt(row, 1).toString());
				isbn.setText(InputISBN);
				tit.setText(InputTitle);
			}
		});

        add.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                getInput();
                if(InputISBN.equals("") && InputTitle.equals(""))
                    JOptionPane.showMessageDialog(f1,"ISBN and Title must be filled!","Error",JOptionPane.ERROR_MESSAGE);
                else if(InputISBN.equals(""))
                    JOptionPane.showMessageDialog(f1,"ISBN must be filled!","Error",JOptionPane.ERROR_MESSAGE);
                else if(InputTitle.equals(""))
                    JOptionPane.showMessageDialog(f1,"Title must be filled!","Error",JOptionPane.ERROR_MESSAGE);
                else if(isbnExistInData(InputISBN)) 
                    JOptionPane.showMessageDialog(f1,"Book ISBN exist in current database","Error",JOptionPane.ERROR_MESSAGE);
                else 
                {
                    if (!isbnExistInData(InputISBN))
                    {
                        Book newbook = new Book();
                        newbook.setISBN(InputISBN);
                        newbook.setTitle(InputTitle);
                        newbook.setAvailable(true);
                        data.add(newbook);
                        addDataToTable(newbook.getTitle(),newbook.getISBN(),newbook.isAvailable());
                    }
                }
            }
        });

        edit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                getInput();
                boolean found = isbnExistInData(InputISBN);
                editIndex = indexOfIsbn(InputISBN);
                if(!found) 
                    JOptionPane.showMessageDialog(f1,"Book ISBN is not in the database","Error",JOptionPane.ERROR_MESSAGE);
                else 
                {
                    isbn.setText(data.get(editIndex).getISBN());
                    tit.setText(data.get(editIndex).getTitle());
                    setbuttonmode(1);
                }

                
            }
        });

        save.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                boolean exit = true;
                getInput();
                if (InputISBN !=data.get(editIndex).getISBN()) 
                {
                    if(isbnExistInData(InputISBN)) 
                    {
                        JOptionPane.showMessageDialog(f1,"Book ISBN exist in current database","Error",JOptionPane.ERROR_MESSAGE);
                        exit = false;
                    }
                }    
                if(exit)
                {
                    data.get(editIndex).setISBN(InputISBN);
                    data.get(editIndex).setTitle(InputTitle);
                    displayAllData();
                    setbuttonmode(0);
                }
                
            }
        });
        
        del.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                getInput();
                boolean found = isbnExistInData(InputISBN);
                if (!found)
                    JOptionPane.showMessageDialog(f1,"Book ISBN is not in the database","Error",JOptionPane.ERROR_MESSAGE);
                else 
                {
                    editIndex = indexOfIsbn(InputISBN);
                    data.remove(editIndex);
                    displayAllData();
                }
            }
        });

        search.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                getInput();
                TableModel.setRowCount(0);
                if (InputISBN.equals("") && InputTitle.equals(""))
                {}
                else if(InputISBN.equals("") && !InputTitle.equals(""))
                {
                    for(int i= 0; i<data.size();i++)
                    {
                        if (data.get(i).getTitle().contains(InputTitle))
                            addDataToTable(data.get(i).getTitle(),data.get(i).getISBN(),data.get(i).isAvailable());
                    }
                }
                else if(!InputISBN.equals("") && InputTitle.equals(""))
                {
                    for(int i= 0; i<data.size();i++)
                    {
                        if (data.get(i).getISBN().contains(InputISBN))
                            addDataToTable(data.get(i).getTitle(),data.get(i).getISBN(),data.get(i).isAvailable());
                    }
                }
                else
                {
                    for(int i= 0; i<data.size();i++)
                    {
                        if (data.get(i).getTitle().contains(InputTitle))
                            addDataToTable(data.get(i).getTitle(),data.get(i).getISBN(),data.get(i).isAvailable());
                        else if (data.get(i).getISBN().contains(InputISBN))
                            addDataToTable(data.get(i).getTitle(),data.get(i).getISBN(),data.get(i).isAvailable());
                    }
                }

            }
        });

        more.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                f2.setVisible(true);
            }
        });

        load.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
                Book book1 = new Book();
		        book1.setTitle("HTML How to Program");
		        book1.setISBN("0131450913");
		        book1.setAvailable(true);

                Book book2 = new Book();
                book2.setTitle("C++ How to Program");
                book2.setISBN("0131857576");
                book2.setAvailable(true);

                Book book3 = new Book();
		        book3.setTitle("Java How to Program");
		        book3.setISBN("0132222205");
		        book3.setAvailable(true);

                
                boolean[] found = {false,false,false};
                found[0] = isbnExistInData(book1.getISBN());
                found[1] = isbnExistInData(book2.getISBN());
                found[2] = isbnExistInData(book3.getISBN());

                if(!found[0]) data.add(book1);
                    else JOptionPane.showMessageDialog(f1,"ISBN 0131450913 is already added!","Error",JOptionPane.ERROR_MESSAGE);

                if(!found[1]) data.add(book2);
                    else JOptionPane.showMessageDialog(f1,"ISBN 0131857576 is already added!","Error",JOptionPane.ERROR_MESSAGE);

                if(!found[2]) data.add(book3);
                    else JOptionPane.showMessageDialog(f1,"ISBN 0132222205 is already added!","Error",JOptionPane.ERROR_MESSAGE);

                displayAllData();
            }
        });

        display.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                displayAllData();
            }
        });

        displayByISBN.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                sort(0);
            }
        });

        displayByTitle.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                sort(1);
            }
        });

        exit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                f1.dispose();
                f2.dispose();
            }
        });

    }

    

    // take input from two text box
    public void getInput()
    {
        InputISBN = isbn.getText();
        InputTitle = tit.getText();
    }

    public void addDataToTable(String T, String I, Boolean A)
    {
        Object[] Data = {I, T, A};
		TableModel.addRow(Data);
    }

    public boolean isbnExistInData(String input)
    {
        boolean found = false;
        for(int i=0; i<data.size(); i++)
        {
            if(input.equals(data.get(i).getISBN()))
            {
                found = true;
            }
        }
        return found;
    }

    public int indexOfIsbn(String input)
    {
        int index = -1;
        for(int i=0; i<data.size(); i++)
        {
            if(input.equals(data.get(i).getISBN()))
            {
                index = i;
            }
        }
        return index;
    }

    public void setbuttonmode(int mode)
    {
        if(mode == 0)
        {
            add.setEnabled(true); 
            edit.setEnabled(true); 
            save.setEnabled(false); 
            del.setEnabled(true);
            search.setEnabled(true); 
            more.setEnabled(true); 
            load.setEnabled(true); 
            display.setEnabled(true); 
            displayByISBN.setEnabled(true); 
            displayByTitle.setEnabled(true);
            exit.setEnabled(true); 
            Borrow.setEnabled(true); 
            Return.setEnabled(true); 
            Reserve.setEnabled(true); 
            WaitingQ.setEnabled(true);
        }
        else if(mode == 1)
        {
            add.setEnabled(false); 
            edit.setEnabled(false); 
            save.setEnabled(true); 
            del.setEnabled(false);
            search.setEnabled(false); 
            more.setEnabled(false); 
            load.setEnabled(false); 
            display.setEnabled(false); 
            displayByISBN.setEnabled(false); 
            displayByTitle.setEnabled(false);
            exit.setEnabled(false); 
            Borrow.setEnabled(false); 
            Return.setEnabled(false); 
            Reserve.setEnabled(false); 
            WaitingQ.setEnabled(false);
        }
        else if(mode == 2)
        {
            add.setEnabled(false); 
            edit.setEnabled(false); 
            save.setEnabled(false); 
            del.setEnabled(false);
            search.setEnabled(false); 
            more.setEnabled(false); 
            load.setEnabled(false); 
            display.setEnabled(false); 
            displayByISBN.setEnabled(false); 
            displayByTitle.setEnabled(false);
            exit.setEnabled(false); 
            Borrow.setEnabled(false); 
            Return.setEnabled(false); 
            Reserve.setEnabled(false); 
            WaitingQ.setEnabled(false);
        }
    }

    public void displayAllData()
    {
        TableModel.setRowCount(0);
        for(int i= 0; i<data.size();i++)
        {
            addDataToTable(data.get(i).getTitle(),data.get(i).getISBN(),data.get(i).isAvailable());
        }
    }

    public void sort(int mode)
    {
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
        table.setRowSorter(sorter);
        ArrayList <RowSorter.SortKey> sortKeys = new ArrayList<>();

        if(mode == 0)
        {
            if(ISBNascending)
            {
                sortKeys.add(new RowSorter.SortKey(0, SortOrder.DESCENDING));
                ISBNascending = false;
            }
            else 
            {
                sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
                ISBNascending = true;
            }
        }
        else if(mode == 1)
        {
            if(Titleascending)
            {
                sortKeys.add(new RowSorter.SortKey(1, SortOrder.DESCENDING));
                Titleascending = false;
            }
            else 
            {
                sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
                Titleascending = true;
            }
        }
        sorter.setSortKeys(sortKeys);
		sorter.sort();

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
        Layout();
        updateTime();
    }
    
    public static void main(String[] args) 
    {
	    new GUI();
    }
}
