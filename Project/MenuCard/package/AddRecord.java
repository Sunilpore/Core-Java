package MenuCard.Add;
//For data in tabular form:-https://c4code.wordpress.com/2014/03/17/how-to-print-the-results-to-console-in-a-tabular-format-using-java/

import java.io.*;
import java.util.*;

public class AddRecord
{
public void AddRecord() throws Exception
  {
	  
	  //Here Because of defining FileWriter we don't need to convert string into byte array because it provides method to write string directly.
	  
	  BufferedWriter bw=new BufferedWriter(new FileWriter("menuDetials.txt",true));
      Scanner sc=new Scanner(System.in);
	  
	  String No,Name,Price;
      int no,val=1;
	  do
	  {
      val=1;
      BufferedReader br=new BufferedReader(new FileReader("menuDetials.txt"));
	  
	  System.out.print("Enter the no for dish:");
	  no=sc.nextInt();
	  //No=No+" ";
	  
	  String check;
	  while((check=br.readLine())!=null)
	  {
		   StringTokenizer st=new StringTokenizer(check,",");
		   
		   String comp[]=check.split(",");
		   int nocomp=Integer.parseInt(comp[0]);
		  
		  if(no==nocomp)
		  {
			  System.out.println("\nThis ID Number already exist...!");
			  System.out.println("Please try another one\n");
			  val++;
		  }
	  }
	   br.close();
	  }while(val!=1);
	  
	  System.out.print("Enter the Dish Name:");
	  Name=sc.nextLine();
	  Name+=sc.nextLine();
	  
	  System.out.print("Enter thr Price:");
      Price=sc.nextLine();
		  
	  No=String.valueOf(no);	 
	  
	  bw.write(No+","+Name+","+Price);
	  bw.flush();
	  bw.newLine();
	  bw.close(); 
		  
	  }
  }