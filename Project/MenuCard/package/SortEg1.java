package MenuCard.Sort;

//import MenuCard.Sort.Menu;    //Important Note:-Here we import various class files inside the 'SortEg1' import file
import MenuCard.Sort.*;        // where 'SortEg1' is a imported package file of 'MenuCardPack' file.
                              //From where I can get help,Link:http://www.studytonight.com/java/package-in-java.php
							  
import java.io.*;
import java.util.*;

class Menu
{
 int No,Price;
 String Name;

 public Menu(int No,String Name,int Price)
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
		
		return Integer.valueOf(m1.No) - Integer.valueOf(m2.No);
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
		return Integer.valueOf(m1.Price) - Integer.valueOf(m2.Price);
	}
	
}

public class SortEg1
{
	
 public void sort() throws Exception
 {
   Scanner sc=new Scanner(System.in);
  
   BufferedReader br=new BufferedReader(new FileReader("menuDetials.txt"));
   
   ArrayList<Menu> menuRecord=new ArrayList<Menu>();
   
   String reader;
   
   while((reader=br.readLine())!=null)
   {
	   String[] menuInfo=reader.split(",");
	   
	   int No=Integer.parseInt(menuInfo[0]);
	   String Name=menuInfo[1];
	   int Price=Integer.parseInt(menuInfo[2]);
	   
	   //String No=No2.substring(0,No2.length() -1);
	   //int id =menuInfo[3];
	   
	   menuRecord.add(new Menu(No,Name,Price));
   }
   
   //Collections.sort(menuRecord, new priceCompare());
   
    System.out.println("Sort By--->");
    System.out.println("1.Index No");
    System.out.println("2.Dish Name");
	System.out.println("3.Price");
    System.out.print("Enter your choice:");
    System.out.print("");                    //This line is required to break the sequence of above '1.S.O.P("Enter your choice:")'
	                                         //Else without extra '2.S.O.P("")' it will display 2.S.O.P and take again value which is no use.
	
	
	char srt=sc.nextLine().charAt(0);
   if(srt=='1')
   Collections.sort(menuRecord, new noCompare());
   else if(srt=='2')
   Collections.sort(menuRecord, new nameCompare());
   else if(srt=='3')
   Collections.sort(menuRecord, new priceCompare());
   
   BufferedWriter bw=new BufferedWriter(new FileWriter("menuDetials.txt"));
  
   for(Menu mn:menuRecord)  
   {
	   bw.write(String.valueOf(mn.No));
	   bw.write(","+mn.Name);
	   bw.write(","+String.valueOf(mn.Price));
	   bw.newLine();
   }
   
   br.close();
   bw.close();
 }
}