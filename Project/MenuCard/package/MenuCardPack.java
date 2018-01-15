/*Note "=,==,===" ,'=assign value','==compare','===compare with same data types'

*/
package MenuCard;

import MenuCard.Display.ViewAll;
import MenuCard.Sreach.SearchMenu;
import MenuCard.Add.AddRecord;
import MenuCard.Update.UpdateMenu;
import MenuCard.Delete.DeleteMenu;
import MenuCard.Sort.SortEg1;
import MenuCard.Swap.SwapMenu;

import java.util.*;
import java.io.*;

class MenuCardPack
{

 
 Scanner sc=new Scanner(System.in);
 
 public static void main(String arg[]) throws Exception
 {
  Scanner sc=new Scanner(System.in);   
  char choice;
  String y="y",n="n",ext = "";
   
   
  do
   {
  System.out.println("View and Edit Record--->>>>");
  System.out.println("1.View all Dishes Menu"); //
  System.out.println("2.Search Dish");  //
  System.out.println("3.Add New Dish"); //
  System.out.println("4.Update Dish"); 
  System.out.println("5.Delete Dish");  //
  System.out.println("6.Sort");         //
  System.out.println("7.Swap");
  System.out.println("8.Exit");
  
  System.out.print("\nEnter choice:");
  
  choice=sc.nextLine().charAt(0); //It will accept only  1st place number for choice.Afterward it will treat as garbage value.
                                  //Example for 'char' we entered '124',then it will take as a valid no. and remaining as a garbage value. 
  
  switch(choice)
   {
	  case '1':ViewAll c=new ViewAll();
	           c.viewAll();
	  break;
			 
	  case '2':SearchMenu c1=new SearchMenu();
	           c1.search();
	  break;
			 
	  case '3':AddRecord c2=new AddRecord();
	           c2.AddRecord();
	  break;
			 
	  case '4':UpdateMenu c3=new UpdateMenu();
	           c3.update();
	  break;
			 
	  case '5':DeleteMenu c4=new DeleteMenu();
	           c4.delete();
	  break;
		
      case '6':SortEg1 c5=new SortEg1();
			   c5.sort();
	  break;
			
	  case '7':SwapMenu c6 =new SwapMenu();
	           c6.swap();
	  break;
	  
	  case '8':System.out.println("Do you want to exit y/n?");
	         ext=sc.nextLine();
			 
			 if(ext.equalsIgnoreCase(y))
			 {
				System.out.println(" \tThank you,visit Again...!");
			 }
			 else if(ext.equalsIgnoreCase(n))
			 { 
			 }
			 else
			 {
			 System.out.println(" \tPlease enter valid message");
			 }
			 
			 //System.exit(0);
	break; 
			
	 
	  
	  default:System.out.println("Invalid choice");
			  break;
			
			 
    }
        System.out.println("\t-------------***------------");
        System.out.println("\n");
   }
    while(!ext.equals(y));  //for string 'not equal to'case
	//while(choice !=6);
  }
}

/* String srt=sc.nextLine();
   if(srt.equals("1"))
   Collections.sort(menuRecord, new noCompare());
   else if(srt.equals("2"))
   Collections.sort(menuRecord, new nameCompare());
   else if(srt.equals("3"))
   Collections.sort(menuRecord, new priceCompare());*/
  