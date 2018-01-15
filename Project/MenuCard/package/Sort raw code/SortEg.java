//package MenuCard.Sort;

import java.io.*;
import java.util.*;

class Menu
{
 String No,Name,Price;

 public Menu(String No,String Name,String Price)
 {
	 this.No=No;
	 this.Name=Name;
	 this.Price=Price;
 } 
}

class noCompare implements Comparator<Menu>
{
	public int compare(Menu m1,Menu m2) //Here add m3?,public int
	{
		return m1.No.compareTo(m2.No);
	}
}

class nameCompare implements Comparator<Menu>
{
	public int compare(Menu m1,Menu m2) 
	{
		return m1.Name.compareTo(m2.Name);
	}
	
}

class priceCompare implements Comparator<Menu>
{
	public int compare(Menu m1,Menu m2) 
	{
		return m1.Price.compareTo(m2.Price);
	}
	
}

public class SortEg
{
 public static void main(String arg[]) throws Exception
 {
  
   BufferedReader br=new BufferedReader(new FileReader("menuDetials.txt"));
   
   ArrayList<Menu> menuRecord=new ArrayList<Menu>();
   
   String reader;
   
   while((reader=br.readLine())!=null)
   {
	   String[] menuInfo=reader.split(",");
	   
	   String No=menuInfo[0];
	   String Name=menuInfo[1];
	   String Price=menuInfo[2];
	   //int id =menuInfo[3];
	   
	   menuRecord.add(new Menu(No,Name,Price));
   }
   
   Collections.sort(menuRecord, new noCompare());
   
   
   BufferedWriter bw=new BufferedWriter(new FileWriter("menuDetials.txt"));
  
   for(Menu mn:menuRecord)  
   {
	   bw.write(mn.No);
	   bw.write(","+mn.Name);
	   bw.write(","+mn.Price);
	   bw.newLine();
   }
   
   br.close();
   bw.close();
 }
}