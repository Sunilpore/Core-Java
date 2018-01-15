package MenuCard.Sreach;

import java.io.*;
import java.util.*;

public class SearchMenu
{
public void search() throws Exception
  {
	  String Name,srch;
	  
	  BufferedReader br=new BufferedReader(new FileReader("menuDetials.txt"));
	  Scanner sc=new Scanner(System.in);
	  
	  System.out.println("Search Your Favorite Dish By--->");
	  System.out.println("1.ID");
	  System.out.println("2.NAME");
	  System.out.println("3.Price");
	  
	  System.out.print("Enter your prference:");
	  int pref=sc.nextInt();
	  
	  if(pref==1)
	  {
		  System.out.print("Enter ID:");
		  int no=sc.nextInt();
		  //No=No+" ";
		  System.out.println("");
		  int check=0;
		  while((srch=br.readLine())!=null)
		  {
			  StringTokenizer st=new StringTokenizer(srch,",");
			  
			  String comp[]=srch.split(",");
			  int nocomp=Integer.parseInt(comp[0]);
			  
			  if(no==nocomp)
			  {
				  System.out.println("\t"+st.nextToken()+"\t"+st.nextToken()+"\t\tRs."+st.nextToken()+"/-");
			      check=1;
			  }
		  }
		  if(check==0)
		  {
			  System.out.println("\t    Could not found a menu");
		  }
	  }
	  else if(pref==2)
	  {
		  System.out.print("Enter Dish Name:");
		  Name=sc.nextLine();
		  Name+=sc.nextLine();
		  System.out.println("");
		  int check=0;
		  while((srch=br.readLine())!=null)
		  {
			  StringTokenizer st=new StringTokenizer(srch,",");
			  
			  if(srch.contains(Name))
			  {
				  System.out.println("\t"+st.nextToken()+"\t"+st.nextToken()+"\t\tRs."+st.nextToken()+"/-");
			      check=1;
			  }
		  }
		  if(check==0)
		  {
			  System.out.println("\t    Could not found a menu");
		  }
	  }
	  else if(pref==3)
	  {
		  System.out.println("Enter Price Range:");
		  System.out.print("min:");
		  int minPrice=sc.nextInt();
		  
		  System.out.print("max:");
		  int maxPrice=sc.nextInt();
		  
          int check=0;
		  while((srch=br.readLine())!=null)
		  {
			  StringTokenizer st=new StringTokenizer(srch,",");
              
			  String comp[]=srch.split(",");
			  int price=Integer.parseInt(comp[2]);
			
			if( (minPrice<=price) && (maxPrice>=price) )
			{
				System.out.println("\t"+st.nextToken()+"\t"+st.nextToken()+"\t\tRs."+st.nextToken()+"/-");
			    check=1;
			}
		   }	
          if(check==0)
		  {
			  System.out.println("\t    Could not found a menu");
		  }		   
	      }
	  else
	  {
		  System.out.println("Invalid preference choice");
	  }
	  
	  br.close();
  }
  
}

