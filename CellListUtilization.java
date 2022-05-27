import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

public class CellListUtilization
{

	public static void main(String[] args)
	{
		String fileName;
		Scanner scanner = new Scanner(System.in);
		Scanner sc = null;		// A scanner object 
		
		System.out.println("What is the name of the file you wan to read?: ");
		fileName = scanner.next();
		
	
		try
		{
			sc = new Scanner(new FileInputStream(fileName + ".txt"));				     
		}
		catch(FileNotFoundException e) 
		{							   
			System.out.println("Could not open input file for reading. Please check if file exists.");	
			System.out.print("Program will terminate.");
			System.exit(0);			   
		}
		
		CellList listFromFile = new CellList();
		fileReader(sc,listFromFile);
		
		CellList list1 = new CellList(); //default constructor
		
		CellPhone cellphone1 = new CellPhone(1111, "random1", 2001, 100.00);
		CellPhone cellphone2 = new CellPhone(2222, "random2", 2002, 200.00);
		CellPhone cellphone3 = new CellPhone(3333, "random3", 2003, 300.00);
		CellPhone cellphone4 = new CellPhone(4444, "random4", 2004, 400.00);
		list1.addToStart(cellphone4);  //addToStart method
		list1.addToStart(cellphone3);
		list1.addToStart(cellphone2);
		list1.addToStart(cellphone1);
		System.out.println("\nthis is your first list");
		list1.showContents();  //showContents method
		
		CellList list2 = new CellList(list1); //Copy constructor 
		System.out.println("\nthis is your second list");
		list2.showContents();
		System.out.println();
		
		CellPhone cellphone5 = new CellPhone(5555, "random5", 2005, 500.00);
		list1.insertAtIndex(cellphone5, 4); //insert at index method
		System.out.println();
		list1.showContents();
		
		System.out.println();
		list1.deleteFromIndex(4);
		System.out.println();
		list1.showContents();
		
		System.out.println();
		list1.deleteFromStart();
		System.out.println();
		list1.showContents();
		
		CellPhone cellphone6 = new CellPhone(6666, "random6", 2006, 600.00);
		System.out.println();
		list1.replaceAtIndex(cellphone6, 2);
		System.out.println();
		list1.showContents();
		
		System.out.println("\n" + list1.find(6666).getCellphone());
		
		System.out.println("\n" + list1.contains(5555));
		System.out.println(list1.contains(2222));
		
		CellList list3 = new CellList(list1);
		
		System.out.println("\n" + list1.equals(list3));
		System.out.println(list1.equals(listFromFile));
		
		scanner.close();
	}
	
	public static void fileReader(Scanner s, CellList list)
	{
		CellPhone cell;
		String brand;
		double price;
		int year;
		long serialNum;
		
		while(s.hasNextLine())
		{
			serialNum = s.nextLong();
			brand = s.next();
			price = s.nextDouble();
			year = s.nextInt();	
			
			cell = new CellPhone(serialNum, brand, year, price);
			list.addToStart(cell);
		}
		
		s.close();
		list.showContents();
	}

}
