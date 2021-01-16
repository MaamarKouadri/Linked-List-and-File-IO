import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CellListUtilization {

	public static void main(String[] args) {

		boolean CorrectName = false;
		while (CorrectName != true) {
			try {
				CellList List = new CellList(); // First List that is going to be used that is going to store the data
												// of the file.

				Scanner input = new Scanner(System.in);

				System.out.print("------------------------------------------------------------------------------\n"
						+ "Hello welcome to my program, let's start by entering the name your file: ");

				// String NameOfFile = input.next();

				// Scanner Object to read the file and store the lines to create the list.
				Scanner sc = new Scanner(new FileInputStream("Cell_info.txt"));
				CorrectName = true;
				
				//  System.out.println();
				//  System.out.println("The file has been found, now let us display it ! ");
				//  System.out.println( "------------------------------------------------------------------------------" ); 
				//  System.out.println(  "------------------------------------------------------------------------------" );
				 

				// "Cell_Info.txt"

				// This method is going to use the Scanner object and store the line of text in
				// order to create the list later on.
				// The method will be explained with further details below.
				ReadFile(sc, List);
				
				System.out.println( "Now that we have read the file, we were able to create a list of CellPhones and display it here it is !");
				 System.out.println( "------------------------------------------------------------------------------"); 
				 System.out.println( "------------------------------------------------------------------------------");
				 

				// Before showing the list this method will delete the duplicated entries and
				// deletes outstanding entries.
				// List.FindDuplicate();

				// List.showContents();
				 System.out.println("\n");

				try {

					System.out.println(
							"You may now enter a SerialNumber and we will display to you the CellPhone that has this  SerialNumber: ");
					// long Serial = input.nextLong();

					// FindAndPrintCell(Serial, List);

					System.out.println(
							"Now let us test the methods that we have created in our CellList class by creating a new list and few objects.");

					CellList n1 = new CellList();
					CellList n2 = new CellList();

					CellPhone k2 = new CellPhone(1009001, "Apple", 2020, 700);
					CellPhone k4 = new CellPhone(234, "NOJO", 2020, 700);
					CellPhone k5 = new CellPhone(1001, "yesa", 2020, 700);

					CellPhone k3 = k2.clone();
					System.out.println("The original one : ");
					System.out.println(k2);
					System.out.println("The copied one: ");
					System.out.println(k3);
					System.out.println("Are they the same ? " + (k3 == k2));
					System.out.println("Are they equal in everything excep serialNumber ? " + k3.equals(k2));
					n1.addToStart(k2);
					n1.addToStart(k3);
					n1.addToStart(k4);
					n1.addToStart(k5);
					System.out.println("The original list");
					System.out.println("-----------------------------------------------------------------------------------------------------");
					n1.showContents();
					System.out.println("\n");
					n2 = new CellList(n1);
					System.out.println();
					System.out.println("The copy list");
					System.out.println("-----------------------------------------------------------------------------------------------------");
					n2.showContents();
					System.out.println("\n");
					System.out.println("Do the two lists have the same reference " +  (n1 == n2));
					System.out.println("Are they equal ? " +  n1.equals(n2));
				
/*
					n1.addToStart(k2);
					n1.addToStart(k3);
					n1.addToStart(k4);
					n1.showContents();
					System.out.println("Now let us test the methods ! ");
					System.out.println("First addToStart() ");
					System.out.println("==========================================================================");
					CellPhone k6 = new CellPhone(5555, "start", 2020, 700);
					n1.addToStart(k6);
					n1.showContents();
					System.out.println("==========================================================================");
					System.out.println("Then insertAtIndex(3) ");
					System.out.println("==========================================================================");
					CellPhone k7 = new CellPhone(2, "insertIndex", 2020, 700);
					n1.insertAtIndex(k7, 3);
					n1.showContents();
					System.out.println("==========================================================================");
					System.out.println("Then deleteFromindex(4) ");
					System.out.println("==========================================================================");
					n1.deleteFromindex(4);
					n1.showContents();
					System.out.println("==========================================================================");
					System.out.println("Then deleteFromStart() ");
					System.out.println("==========================================================================");
					n1.deleteFromStart();
					n1.showContents();
					System.out.println("==========================================================================");
					System.out.println("Then replaceAtIndex(1555) ");
					System.out.println("==========================================================================");
					CellPhone k8 = new CellPhone(212, "TheReplacedOne", 2020, 700);
					n1.replaceAtIndex(k8, 1555);
					n1.showContents();
					System.out.println("==========================================================================");
					System.out.println("Then countains(212) ");
					System.out.println("==========================================================================");
					System.out.println(n1.countains(212));
					System.out.println(n1.countains(0));
					System.out.println("==========================================================================");
					System.out.println("Then equals() ");
					System.out.println("==========================================================================");
					CellList n2 = n1.clone();
					CellList n3 = new CellList();
					n3.addToStart(k5);
					n3.addToStart(k4);
					System.out.println("n2 equal to n1 " + n1.equals(n1));
					System.out.println("n3 equal to n1 " + n3.equals(n1));
					System.out.println("Content of n1 :");
					n1.showContents();
					System.out.println("Content of n2 :");
					n2.showContents();
					System.out.println("Content of n3 :");
					n3.showContents();
					System.out.println();
					System.out.println("==========================================================================");			
					System.out.println("Here the program will stop , these are the exceptional cases.");
					System.out.println("==========================================================================");
					
					System.out.println("==========================================================================");
					System.out.println("Then insertAtIndex(-5) ");
					System.out.println("==========================================================================");
					CellPhone k11 = new CellPhone(2, "insertIndex", 2020, 700);
					n1.insertAtIndex(k7, -5);
					n1.showContents();
					System.out.println("==========================================================================");
					System.out.println("Then deleteFromindex(5) ");
					System.out.println("==========================================================================");
					n1.deleteFromindex(15);
					n1.showContents();
					
					*/
					
					
				}

				catch (Exception e) {
					System.out.println(
							"Make sure to enter a number, and  with the appropriate range you may try again !");
				}

				sc.close();

			} catch (FileNotFoundException e) {

				System.out.println();
				System.out.println(
						"--------------------------------------------------------------------------------------------------");
				System.out.println("ERROR");
				String s = "It seems that there is a mistake somewhere. Etiher you have  made a small typo while entering the name of the file \n"
						+ "or the file has not been imported correctly, or the file does not exist. Make sure to verify and enter the name again \n"
						+ "you will be given another chance.";
				System.out.println(s);
			}
		}

	}

/**
 * This method simply read the file and displays it and invokes the CreateCellPhone which will be described with greater details below.
 * @param sc A scanner objects that reads the file.
 * @param lst A CellList object that is going to be used in order to countaint he data inside the file.
 */

	public static void ReadFile(Scanner sc, CellList lst) {
		String line = null;
		String Text = null;

		while (sc.hasNext()) {

			line = sc.nextLine();
			// System.out.println(line);
			CreateCellPhone(line, lst);

		}
		sc.close();

	}

	
	/**
	 * This methods takes each line of text and isolate each word , aftewards it converts those strings into the appropriate values
	 * that are going to be used to create the CellPhone objects that are going to be stored in the CellList.
	 * @param line
	 * @param lst
	 */
	public static void CreateCellPhone(String line, CellList lst) {

		int count = 0;
		count++;
		String SerialNumber = "";
		String Brand = "";
		String price = "";
		String Year = "";

		
		String[] Split2 = line.split("\\s+");
		

		SerialNumber = Split2[0];
		price = Split2[2];
		Year = Split2[3];

		long SerialNum = 0;
		double Price = 0;
		int year = 0;

		SerialNum = Long.parseLong(SerialNumber);
		Brand = Split2[1];
		Price = Double.parseDouble(price);

		year = Integer.parseInt(Year);

		String name = ("CellPhone" + count);
		CellPhone c = new CellPhone(SerialNum, Brand, year, Price);
		// System.out.println(c);

		lst.addToStart(c); // Adding all the CellPhone objects to the list.

	}

	/**
	 * This method simply prints the CellNodeObject that countains a specific serial number
	 * @param Serial The SerialNumber that we desire to find and print the CellPhone that has it.
	 * @param lst The CellList that we are going to verify. 
	 */
	public static void FindAndPrintCell(long Serial, CellList lst) {

		lst.PrintBySerialNumber(Serial);

	}

}
