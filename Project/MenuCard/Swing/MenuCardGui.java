//package GUI;

//import GUI.Display.ViewAll;

import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.*;

import java.io.*;
import java.util.*;
import java.util.regex.*;

class MenuCardGui extends WindowAdapter implements ActionListener
{
	JFrame f;
	JTextArea ta;
	JButton b,b1,b2,b3,b4,b5;
	JTextField tf,tf1,tf2,tf3;
	JLabel lb,lb1,lb2,lb3,lb4,lb5;
	Choice c,c1;
	//JPanel p1,p2;
	int back=0,search=0;  //back for 'BACK' button,search for 'SHOW' button
	
 MenuCardGui()
 {
  f=new JFrame();

  //p1=new JPanel();
  
  ta=new JTextArea();
  ta.setBounds(10,30,400,200);
  ta.setEditable(false);
  
  //p2=new JPanel();
  
  lb=new JLabel("SELECT");
  lb.setBounds(10,240,50,30);
  
  lb1=new JLabel("Enter ID");
  lb1.setBounds(10,240,50,30);
  lb1.setVisible(false);
  
  lb2=new JLabel("Enter Dish Name");
  lb2.setBounds(25,240,100,30);
  lb2.setVisible(false);
  
  lb3=new JLabel("Enter Price Range");
  lb3.setBounds(25,240,120,30);
  lb3.setVisible(false);
  
  lb4=new JLabel("min");
  lb4.setBounds(25,270,30,30);
  lb4.setVisible(false);
  
  lb5=new JLabel("max");
  lb5.setBounds(25,300,30,30);
  lb5.setVisible(false);
  
  c=new Choice();
  c.setBounds(70,245,50,30);
  
  c1=new Choice();
  c1.setBounds(70,245,50,30);
  c1.setVisible(false);
  
  tf=new JTextField();
  tf.setBounds(70,245,40,20);
  tf.setVisible(false);
  
  tf1=new JTextField();
  tf1.setBounds(10,270,125,20);
  tf1.setVisible(false);
  
  tf2=new JTextField();
  tf2.setBounds(60,275,50,20);
  tf2.setVisible(false);
  
  tf3=new JTextField();
  tf3.setBounds(60,305,50,20);
  tf3.setVisible(false);
  
  b=new JButton("OK");
  b.setBounds(155,245,55,20);
  
  b1=new JButton("HOME");
  b1.setBounds(150,300,70,20);
  b1.setVisible(false);
 
  b2=new JButton("EXIT");
  b2.setBounds(150,350,70,20);
  
  b3=new JButton("NEXT");
  b3.setBounds(150,245,70,20);
  b3.setVisible(false);
  
  b4=new JButton("SHOW");
  b4.setBounds(150,245,80,20);
  b4.setVisible(false);
  
  b5=new JButton("BACK");
  b5.setBounds(150,270,70,20);
  b5.setVisible(false);
  
  
  f.add(ta);
  f.add(c);f.add(c1);
  f.add(tf);f.add(tf1);f.add(tf2);f.add(tf3);
  f.add(lb);f.add(lb1);f.add(lb2);f.add(lb3);f.add(lb4);f.add(lb5);
  f.add(b);f.add(b1);f.add(b2);f.add(b3);f.add(b4);f.add(b5);
  
  
  //f.add(p1);f.add(p2);
  //f.setLayout(new GridLayout(1,1));
  
  display();
  
  f.setSize(500,500);
  f.setLayout(null);
  f.setVisible(true);
 
  b.addActionListener(this);b1.addActionListener(this);b2.addActionListener(this);
  b3.addActionListener(this);b4.addActionListener(this);b5.addActionListener(this);
 
  f.addWindowListener(this);
  f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
 
 }
 
 
 //Output display(At Starting Panel)
 public void display()
 {
	 String tamsg;
	 
	 c.removeAll();
	 c.add("1");c.add("2");c.add("3");c.add("4");
     c.add("5");c.add("6");c.add("7");c.add("8");
  
	 tamsg="View and Edit Record--->>>>\n1.View all Dishes Menu\n2.Search Dish\n3.Add New Dish\n";
     tamsg+="4.Update Dish\n5.Delete Dish\n6.Sort\n7.Swap\n8.Exit";
     
	 ta.setText(tamsg);
 }
 
 //Action Event Buttons
 public void actionPerformed(ActionEvent ae)
 {
	 try{
	 String evt=ae.getActionCommand();

	
	if(evt.equals("OK"))
	{
		String ch=c.getItem(c.getSelectedIndex());
	
		if(ch.equals("1"))
		{
			viewAll();
			
			b.setVisible(false);
			b1.setVisible(false);
			b5.setVisible(true);
			
			c.setVisible(false);
            lb.setVisible(false);
			
			back=1;                //Back to Home Screen
		}
		
		else if(ch.equals("2"))
		{
		    mainSearch();          //GUI-View Search Option types i.e. By ID,Name,Price,etc...
			back=1;			       //Back to Home Screen
	    }
		
		else if(ch.equals("3"))
		{
			
		}
		else if(ch.equals("4"))
		{
			
		}
		else if(ch.equals("5"))
		{
			
		}
		else if(ch.equals("6"))
		{
			
		}
		else if(ch.equals("7"))
		{
			
		}
		else if(ch.equals("8"))
		{
			f.dispose();
		}
		
	}
	
	if(evt.equals("NEXT"))
	{
		searchOption();          //Individual search GUI for ID,Name,Price
		
	}
	
	if(evt.equals("SHOW"))
	{
		if(search==1)      //search for ID
		{
		searchID();
		back=2;
		}
		if(search==2)      //search for Name
		{
		searchName();
		back=2;
		}
		if(search==3)      //search for Price
		{
		searchPrice();
		back=2;
		}
	}
	
	if(evt.equals("HOME"))
	{	
	 b.setVisible(true);
	 b1.setVisible(false);
	 b3.setVisible(false);
	 b4.setVisible(false);
	 b5.setVisible(false);
	 
	 tf.setVisible(false);
	 tf1.setVisible(false);
	 tf2.setVisible(false);
	 tf3.setVisible(false);
	 
     c.setVisible(true);
     c1.setVisible(false);
     
	 lb.setVisible(true);
     lb1.setVisible(false);
     lb2.setVisible(false);
     lb3.setVisible(false);
     lb4.setVisible(false);
     lb5.setVisible(false);
	 
	 display();
	}
	
	if(evt.equals("BACK"))
	{
	 if(back==1)              //Dedicated to Viewall
	 {
	  b.setVisible(true);
	  b1.setVisible(false);
	  b3.setVisible(false);
	  b4.setVisible(false);
	  b5.setVisible(false);
	  b5.setVisible(false);
	  
	  tf.setVisible(false);
	 
      c.setVisible(true);
      c1.setVisible(false);
      
	  lb.setVisible(true);
      lb1.setVisible(false);
	  
	  display();
	 }
	 if(back==2)             //Dedicated to search
	 {
		mainSearch();
	 }
	}
	
	if(evt.equals("EXIT"))
	{
		f.dispose();
	}
	
    }catch(Exception e)
	 {
		System.out.println(e);
   	 }
 }
 
 //Window closing event
 public void windowClosing(WindowEvent e)
 {
	 int a=JOptionPane.showConfirmDialog(f,"Are you sure?");
	 
	 if(a==JOptionPane.YES_OPTION)
	 {
		 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 }
 }

 
 //1.Read and display MENU List(Internal Operation)
  public void viewAll() throws Exception
  {
	  String rd;
	  BufferedReader br=new BufferedReader(new FileReader("menuDetials.txt"));
	  String viewmsg="";
	  while((rd=br.readLine())!=null)
	  {
		  StringTokenizer st=new StringTokenizer(rd,",");
 	      viewmsg+="  "+st.nextToken()+"\t"+st.nextToken()+"\t\t"+st.nextToken()+"\n";
	 }
	 
	 ta.setText(" No.   \tName\t\tPrice\n\n"+viewmsg);
	 br.close();
  }
 
 
 
 //Ouput for 2.Search for Menu Section-1
 public void sdisplay()
 {
	 String tamsg;
	 c.setVisible(false);
	 c1.setVisible(true);
	 
	 c1.removeAll();
	 c1.add("1");c1.add("2");c1.add("3");
	 
	 tamsg="Search Your Favorite Dish By--->\n1.ID\n2.NAME\n3.Price";
	 ta.setText(tamsg); 
 }
 
 //2 Search Menu Options View Panel
 public void mainSearch() throws Exception
 {
	    sdisplay();
		c.setVisible(false);
			
		b.setVisible(false);
		b1.setVisible(true);
		b3.setVisible(true);
		b4.setVisible(false);
		b5.setVisible(false);
			
		c1.setVisible(true);
		
		lb.setVisible(true);
        lb1.setVisible(false);
		lb2.setVisible(false);
		lb3.setVisible(false);
		lb4.setVisible(false);
		lb5.setVisible(false);
		
	    tf.setVisible(false); 
	    tf1.setVisible(false); 
	    tf2.setVisible(false); 
	    tf3.setVisible(false); 
 }
 
 //2.1/2.2/2.3 Search Menu Sections
 public void searchOption() throws Exception
 {
	back=2;
	String sch=c1.getItem(c1.getSelectedIndex()); //for 2.Select search menu section-1
	 
        if(sch.equals("1"))
		{
			search=1;
			
			ta.setText("");
			
			b3.setVisible(false);
			b4.setVisible(true);
			b5.setVisible(true);
			
			c1.setVisible(false);
			
			lb.setVisible(false);
			lb1.setVisible(true);
			
			tf.setVisible(true);
		}			
        else if(sch.equals("2"))	 
        {
			search=2;
			
			lb.setVisible(false);
			lb1.setVisible(false);
			lb2.setVisible(true);
			
			b3.setVisible(false);
			b4.setVisible(true);
			b5.setVisible(true);
			
			c1.setVisible(false);
			
			tf1.setVisible(true);
			
		}
	    else if(sch.equals("3"))	 
	    {
			search=3;
			
			lb.setVisible(false);
			lb1.setVisible(false);
			lb2.setVisible(false);
			lb3.setVisible(true);
			lb4.setVisible(true);
			lb5.setVisible(true);
			
			tf.setVisible(false);
			tf1.setVisible(false);
			tf2.setVisible(true);
			tf3.setVisible(true);
			
			c.setVisible(false);
			c1.setVisible(false);
			
			b3.setVisible(false);
			b4.setVisible(true);
			b5.setVisible(true);
			
		}
 }
 
 //2.1 Search for Menu by ID(Internal Operation)
 public void searchID() throws Exception
  {
	  String Name,srch;
	  BufferedReader br=new BufferedReader(new FileReader("menuDetials.txt"));
	  String viewmsg="";
	  
	      int no=Integer.parseInt(tf.getText());
		  int check=0;
		  while((srch=br.readLine())!=null)
		  {
			  StringTokenizer st=new StringTokenizer(srch,",");
			  
			  String comp[]=srch.split(",");
			  int nocomp=Integer.parseInt(comp[0]);
			  
			  if(no==nocomp)
			  {
			  viewmsg+="  "+st.nextToken()+"\t"+st.nextToken()+"\t\t"+st.nextToken()+"\n";
			  check=1;
			  }
			  
		  }
          if(check==1)		  
		  ta.setText(" No.   \tName\t\tPrice\n\n"+viewmsg);
		  else
		  {
			 JOptionPane.showMessageDialog(f,"Menu could not found!!!");
		  }
		  br.close();
  }
 
 //2.2 Search for Menu by NAME(Internal Operation)
 public void searchName() throws Exception
  {
	  String srch;
	  BufferedReader br=new BufferedReader(new FileReader("menuDetials.txt"));
	  String viewmsg="";
	  
		 String	name=tf1.getText();
		  int check=0;
		  while((srch=br.readLine())!=null)
		  {
			  StringTokenizer st=new StringTokenizer(srch,",");
			  if(srch.contains(name))
			  {
				viewmsg+="  "+st.nextToken()+"\t"+st.nextToken()+"\t\t"+st.nextToken()+"\n";
			    check=1;  
			  }  
			  
		  }
          if(check==1)		  
		  ta.setText(" No.   \tName\t\tPrice\n\n"+viewmsg);
		  else
		  {
			 JOptionPane.showMessageDialog(f,"Menu could not found!!!");
		  }
		  br.close();
  }
 
 //2.3 Search for Menu by Price(Internal Operation)
 public void searchPrice() throws Exception
  {
	  String srch;
	  int minP=0,maxP=0;
	  BufferedReader br=new BufferedReader(new FileReader("menuDetials.txt"));
	  String viewmsg="";
	  
	      minP=Integer.parseInt(tf2.getText());
	      maxP=Integer.parseInt(tf3.getText());
		  
		  int check=0;
		  while((srch=br.readLine())!=null)
		  {
			  StringTokenizer st=new StringTokenizer(srch,",");
			  
			  String comp[]=srch.split(",");
			  int nocomp=Integer.parseInt(comp[2]);
			  
			  if( (nocomp>=minP) && (nocomp<=maxP))
			  {
			  viewmsg+="  "+st.nextToken()+"\t"+st.nextToken()+"\t\t"+st.nextToken()+"\n";
			  check=1;
			  }
			  
		  }
          if(check==1)		  
		  ta.setText(" No.   \tName\t\tPrice\n\n"+viewmsg);
		  else
		  {
			ta.setText("\nSorry,Menu not available in this Price Range"); 
		  }
		  br.close();
  }
  
  
 

 
 public static void main(String arg[])
  {
   new MenuCardGui();
  }

}


