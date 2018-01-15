package MenuCard.Delete;

import java.io.*;
import java.util.*;

public class DeleteMenu
{

 public void delete() throws Exception
  {
	  String No,del;
	  Scanner sc=new Scanner(System.in);
	  
	  File temp=new File("temp.txt");
	  File org=new File("menuDetials.txt");
	  
	  BufferedReader br=new BufferedReader(new FileReader(org));
	  BufferedWriter bw=new BufferedWriter(new FileWriter(temp));
	  
	  System.out.println("For Deleting Dish From Menu--->");
	  
	  System.out.print("Enter the Dish No:");
	  No=sc.nextLine();
	  //No=No+" ";
	  
	  while((del=br.readLine())!=null)
	  {
		  if(del.contains(No))  //When ID detects.
			  continue;         //By using 'continue' command it will skip the if body operation and jump at loop condition.
		  
		  bw.write(del);
		  bw.flush();
		  bw.newLine();
		  
	  }
	  
	  br.close();
	  bw.close();
	  org.delete();       //Delete original file
	  temp.renameTo(org); //Rename temporary file as original file
  }
  
}

