package MenuCard.Update;

import java.io.*;
import java.util.*;

public class UpdateMenu
{
  int No,newNo;
  String upd,upd1,newName,newPrice,upd2;
  Scanner sc=new Scanner(System.in);
	  
  File org=new File("menuDetials.txt");
  File temp=new File("temp.txt");
	  
 public void update() throws Exception
  {
	  
	  //BufferedReader br=new BufferedReader(new FileReader("menuDetials.txt"));
	  //No=No+" ";
	  
	  //modified
	 int i=1;  //loop Breaker;
	 do
	  {
	   BufferedReader br=new BufferedReader(new FileReader("menuDetials.txt"));  
		  
	   System.out.println("Update Dish--->");
	   System.out.print("Enter menu no:");
	   No=sc.nextInt();
	   
	   
	   while((upd=br.readLine())!=null)
	    {
		 StringTokenizer st=new StringTokenizer(upd,",");

		 String updcomp[]=upd.split(",");
		 int nocomp=Integer.parseInt(updcomp[0]);
		 
		 if(No==nocomp)
		{
		  System.out.println("\t"+st.nextToken()+"\t"+st.nextToken()+"\t\tRs."+st.nextToken()+"/-");		    
	      i=2;  //loop Breaker;
		}
	  }
	    if(i==1)
		System.out.println("\nInvalid Number,try Again...\n");
	    
		br.close();
	  }while(i!=2);
	  
	  System.out.println("\nProceed to change...");
  
  //extra-------------------------------------
      
		  System.out.println("Do you want to Enter New ID Number y/n ?");
		  
		  String changeID="",y="y",n="n";
		  changeID=sc.nextLine();
		  changeID+=sc.nextLine();
		  
		  if(changeID.equalsIgnoreCase(y))
		  {
			  int val=1;
			  do
			  {
			   BufferedReader br=new BufferedReader(new FileReader("menuDetials.txt"));
			   val=1;
			   System.out.print("Enter new menu no:");
	           newNo=sc.nextInt();
			   //No=newNo;
			   
			   while((upd1=br.readLine())!=null)
			   {
				StringTokenizer st=new StringTokenizer(upd1,",");

                String updcomp[]=upd1.split(",");	
                int nocomp=Integer.parseInt(updcomp[0]);
				
			   if(newNo==nocomp)
		        {
			     System.out.println("\nThis ID Number already exist...!");
			     System.out.println("Please try another one\n");
		         val++;
				}
			   }
			 br.close();  
		    }while(val!=1);
			
			newName=sc.nextLine();  //Arrangement done for Changing ID no of dish,without this it will take directly price of dish.
			upd1(); 
		  }
		  
		  
		  else if(changeID.equalsIgnoreCase(n))
		  {
	        upd();
          }
   else 
   {
	   System.out.println("Invalid input command,try Again...");
	   
   }
       System.out.println("Update Succesfully...!"); 
  }
  
  
  public void upd()
  {
	  try{
	  
	  //BufferedReader br=new BufferedReader(new FileReader("menuDetials.txt"));
	  BufferedWriter bw=new BufferedWriter(new FileWriter("temp.txt"));
	  System.out.print("\nEdit the Dish Name:");
	  newName=sc.nextLine();
		 
	  System.out.print("Edit Price:");
	  newPrice=sc.next();
		 
	  BufferedReader br=new BufferedReader(new FileReader("menuDetials.txt"));
		  
	  while((upd2=br.readLine())!=null)
		  {
			  StringTokenizer st=new StringTokenizer(upd2,",");
			  
			  String upd2comp[]=upd2.split(",");
			  int nocomp=Integer.parseInt(upd2comp[0]);
			  
			  if(No==nocomp)
			  {
				  bw.write(No+","+newName+","+newPrice);
			  }
			  else
			  {
				  bw.write(upd2);
			  }  
		  
   	        bw.flush();
		    bw.newLine();
		  }
		  
	  bw.close();
	  br.close();
	  org.delete();
	  temp.renameTo(org);
	  
	  }catch(Exception e)
	  {
		  System.out.println(e);
	  }	  
  }
  
  public void upd1() throws Exception
  {
	  {
	  String del;
	  BufferedReader br=new BufferedReader(new FileReader("menuDetials.txt"));
	  BufferedWriter bw=new BufferedWriter(new FileWriter("temp.txt"));
	  
	  System.out.print("\nEdit the Dish Name:");
	  newName=sc.nextLine();
		 
	  System.out.print("Edit Price:");
	  newPrice=sc.next();
	  
	  while( (del=br.readLine())!=null)
	  {
		  StringTokenizer st=new StringTokenizer(del,",");
			  
		  String delcomp[]=del.split(",");
	      int nocomp=Integer.parseInt(delcomp[0]);
		  
		  if(nocomp==No)
		  {
			bw.write(newNo+","+newName+","+newPrice);  
		  }
		  else
		  {
		  bw.write(del);
		  }
		  bw.flush();
		  bw.newLine();
	  }
	  
	  br.close();
	  bw.close();
	  org.delete();       
	  temp.renameTo(org);
	  }
	   
  }

}