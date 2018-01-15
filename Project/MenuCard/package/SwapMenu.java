package MenuCard.Swap;

import java.util.*;
import java.io.*;

public class SwapMenu
{
  static int No;	

 public void swap() throws Exception
 {
	 
	 String choice,y="y",n="n";
	 
	 File org=new File("menuDetials.txt");
	 File temp=new File("temp.txt");
	 File temp1=new File("temp1.txt");
	  
	 BufferedWriter bw=new BufferedWriter(new FileWriter("temp.txt"));
	 BufferedWriter bw1=new BufferedWriter(new FileWriter("temp1.txt"));
	 
	 Scanner sc=new Scanner(System.in);
	 SwapMenu obj=new SwapMenu();
	 
	 System.out.println("Swap the Menu By ID Number--->");

	 System.out.print("1st Menu no:");
	 int first=sc.nextInt();
	 No=first;
	 obj.display();
	 
	 System.out.print("2nd Menu no:");
	 int second=sc.nextInt();
 	 No=second;
     obj.display();
	 
	 
	 System.out.println("Proceed to swap y/n?\n");
	 choice=sc.next();
	 
	if(choice.equalsIgnoreCase(y)) 
	{
	 String del,fno="",fname="",fprice="",sno="",sname="",sprice="";
     BufferedReader br=new BufferedReader(new FileReader("menuDetials.txt"));
     while((del=br.readLine())!=null)	
	 {
		 StringTokenizer st=new StringTokenizer(del,",");
			  
		 String comp[]=del.split(",");
	     int nocomp=Integer.parseInt(comp[0]);
	    
	     if(first==nocomp)
		 {
			 fno=String.valueOf(second);
			 fname=comp[1];
			 fprice=comp[2];
		 }
		 else if(second==nocomp)
		 {
			 sno=String.valueOf(first);
			 sname=comp[1];
			 sprice=comp[2];
		 }
		 else
		 {
		 bw.write(del);
		 bw.flush();
		 bw.newLine();
		 }
		 	 
	 }
		
		bw.write(fno+","+fname+","+fprice);
	    bw.newLine();
		bw.write(sno+","+sname+","+sprice);
		bw.newLine();
		
		br.close();
	    bw.close();
	    bw1.close();
	    org.delete();       
	    temp.renameTo(org);	
	}
	
	
 }
		 
	public void display()// throws Exception
	{
		try{
	 BufferedReader br=new BufferedReader(new FileReader("menuDetials.txt"));
	 
	 int i=1;
	 String swap;
	 while( (swap=br.readLine())!=null)
	    {
		 
			  StringTokenizer st=new StringTokenizer(swap,",");
			  
			  String comp[]=swap.split(",");
			  int nocomp=Integer.parseInt(comp[0]);
			  
			  if(No==nocomp)
			  {
				System.out.println("\t"+st.nextToken()+"\t"+st.nextToken()+"\t\tRs."+st.nextToken()+"/-");	  
			   i++;
			  } 
		}
		 if(i==1)
		 	 System.out.println("Invalid Menu....!!!");
		 
		br.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}
    }
 
}