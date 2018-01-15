package MenuCard.Display;

import java.io.*;
import java.util.*;

public class ViewAll
{
	
 public void viewAll() throws Exception
  {
	  String rd;
	  BufferedReader br=new BufferedReader(new FileReader("menuDetials.txt"));
      Scanner sc=new Scanner(System.in);
	  
	  
	  //System.out.println("\tNo.  \tName\t \tPrice");
	  System.out.println("\t  No.  \t\tName\tPrice");
	  while((rd=br.readLine())!=null)
	  {
		  StringTokenizer st=new StringTokenizer(rd,",");
		  //System.out.println("\t"+st.nextToken()+"\t"+st.nextToken()+"\t\t"+st.nextToken());
		 System.out.format("\t%5s %15s %5s\n",st.nextToken(),st.nextToken(),st.nextToken()); 
		 
	 }
      br.close();
  }

}