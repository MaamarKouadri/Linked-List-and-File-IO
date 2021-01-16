import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/**
@author Maamar Kouadri
Name: Maamar Kouadri
ID: 40057671
COMP249
Assignment #4
Due Date 2020-04-19
 */
public class SubDictionaryCreator {

	private static int FinalSize = 0; // this int value will hold the final size of the subdictionary after all the
										// verifications

	public static void main(String[] args) {
		

		System.out.print("Hello welcome to my Sub-Dictionary Creator, please enter the name of your file: ");
		// Scanner input = new Scanner(System.in);

		// String name = input.next();
		System.out.println();

		try {
			Scanner sc = new Scanner(new FileInputStream("SubDictionary.txt"));
			System.out.println("Now the file " + "PersonOfTheCentury.txt" + " is going to be read");
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------");
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------");
			// A complex method that will be explained with greater details below. 
			ReadFile(sc);

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

/**
 * This method is going to read the file, display it , and store the entire text inside a String called text and 
 * and Array List Array. At the end of the while loop it will invoke the method TextArray which is going to be explained below. 
 * @param sc Scanner object that countains the file that is going to be read.
 */
	public static void ReadFile(Scanner sc) {
		String Line = "";
		String Text = "";
		ArrayList<String> Array = new ArrayList<String>();
		int NumberOfLines = 0;
		while (sc.hasNextLine()) {

			NumberOfLines++;
			Line = sc.nextLine();
			Array.add(Line);
			Text += Line + "\n";

			// System.out.println(Line);
		}
		// System.out.print(Text);
		TextArray(Text, Array);
		// System.out.println("This text has " + NumberOfLines + "lines.");
	}

	
	/**
	 * This method is the most important of this project, it will do 90% of the jobe, it is rather long, but explanations will
	 * be provided for each step since this method itself calls multiples others.
	 * Firt it takes two parameters, a string called text countaining all the text inside the file 
	 * and an array list Array countain alos all the text in the file. Then we store each word isolated inside an array of strings
	 * called split . Now that we have isolated all the Words we are going to store them inside an ArrayList called Word.
	 * From there we do all the verifications for the , repeated words, and other conditions until we narrow down the size of Words
	 * to fit the format of the subdictionnary.
	 * @param text string called text countaining all the text inside the file 
	 * @param Array array list Array countain alos all the text in the file.
	 */
	
	public static void TextArray(String text, ArrayList<String> Array) {

		ArrayList<String> Word = new ArrayList<String>();

		String[] split = text.split("\\s+"); // spliting all the text word by word
		

		for (int i = 0; i < split.length; i++) {
			Word.add(split[i]);
		}
		// sorting all the words isolated inside the Arraylist Word.


		int index = 0; // to keep track of the position of each word.

		
		/**
		 * In this block of if statements we will go though the entire ArrayList and do the verifications for the ponctuations, presence of numbers etc..
		 * 
		 */
		for (String y : Word) {

			if (y.contains("?"))
				Word.set(index, y.replace("?", ""));
			
			
			else if (y.contains("’m"))
				Word.set(index, y.replace("’m", ""));
			
			else if (y.contains("’M"))
				Word.set(index, y.replace("’M", ""));
			
			
			else if (y.contains("’S"))
				Word.set(index, y.replace("’S", ""));
			
			
			else if (y.contains("’s"))
				Word.set(index, y.replace("’s", ""));

			else if (y.contains("!"))
				Word.set(index, y.replace("!", ""));

			else if (y.contains("."))
				Word.set(index, y.replace(".", ""));

			else if (y.contains(","))
				Word.set(index, y.replace(",", ""));

			else if (y.contains(";"))
				Word.set(index, y.replace(";", ""));

			else if (y.contains(":"))
				Word.set(index, y.replace(":", ""));

			else if (y.contains("="))
				Word.set(index, y.replace("=", ""));

			else if (y.contains("’"))
				Word.set(index, y.replace("’", ""));

			else if (CheckForNumbers(y))
				Word.set(index, "");

			index++;
		}

		index = 0;
		// Now we are turning all the words into UpperCase.
		for (String y : Word) {
			Word.set(index, y.toUpperCase());
			index++;
		}

		boolean find = false;
		int sup = 0;
		
// deletes the repeated words ,  CountRepeatedWords is a rather complex method, it will be explained with greater details below.
		for (String s : Word)
			CountRepeatedWords(s, Word);
		// deleting last numbers if there are any left.
		for (String k : Word) {
			if (CheckForNumbers(k))
				// System.out.println(k);
				Word.set(Word.indexOf(k), "");
		}
		index = 0;

		Word.sort(String.CASE_INSENSITIVE_ORDER); // sorting the list in alphabatical order.

		index = 0;

/**
 * Because of all the previous modifications it might happen that some new words appear who are going to repeat , just in case
 * we will invoke CountRepeatedWords one final time to delete those duplicated values. The String array NewSplit will coutain
 * the new quantity of words inside the list. CountRepeatedWords will delete the duplicated value, it will be explained with greater
 * details below. 
 * 
 */

		for (String s : Word)
			CountRepeatedWords(s, Word);

		
		// This the final ArrayList that is going to countain the final version of the Subdicitonnary
		ArrayList<String> SubDictionnary = new ArrayList<String>();
		
		//This method Will delete all the single chars Except A and I
		DeleteSingleChars(Word);

		// Now we are adding all the words in Alphabetical Order
		for (char i = 'A'; i <= 'Z'; i++) {
			AddElementsInOrder(i, Word, SubDictionnary); // Method that adds the element in Alphabetical Order

		}
		
           // This method, will create a new file and Write the ArrayList SubDictionnary into that file.
		PrintList(SubDictionnary);
		
		
		
	}

	
	/**
	 * This method will simply Iterate through the Array List and delete and the chars except A and I.
	 * @param Word an ArrayList<String> that countains all the words inside the file isolated separatly.
	 */
	public static void DeleteSingleChars(ArrayList<String> Word) {
		int index = 0;
		for (String s : Word) {
			if (s.length() == 1 && (!s.contentEquals("A") && !s.contentEquals("I")))
				Word.set(Word.indexOf(s), "");
		}
		index++;
	}

	
	/**
	 * This method is going to add all the words countain into Word towards SubDictionnary , this is going to be the final
	 * version that will be written into the file. The method will add them in alphabetical order. 
	 * @param letter the letter representing the group of words that is going to be added . A for albert , E for Einstein etc.
	 * @param Word Word an ArrayList<String> that countains all the words inside the file isolated separatly.
	 * @param SubDictionnary This the final ArrayList that is going to countain the final version of the Subdicitonnary.
	 */
	public static void AddElementsInOrder(char letter, ArrayList<String> Word, ArrayList<String> SubDictionnary) {
		String temp = "" + letter;

		int MyCount = 0;
		for (String x : Word) {
			String[] Split = x.split("");
			if (Split[0].contentEquals(temp)) {
				if (MyCount < 1) {
					SubDictionnary.add(temp);
					SubDictionnary.add("==");
				}
				MyCount++;
				SubDictionnary.add(x);
				FinalSize++;
			}

		}
		SubDictionnary.add("\n");

	}

	
	/**
	 * This method will create the file and write the SubDictionnary inside of it. 
	 * @param SubDictionnary This the final ArrayList that is going to countain the final version of the Subdicitonnary.
	 */
	public static void PrintList(ArrayList<String> SubDictionnary) {

		for (String x : SubDictionnary)
			System.out.println(x);

		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream("VegetoSubDictionary.txt"));
			pw.println("The document produced this sub-dictionary, which includes " + FinalSize + " entries.");
			pw.println();
			for (String x : SubDictionnary)
				pw.println(x);

			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	/**
	 * This method will verify the presence of a repeated words and deletes every time that the words repeats more than one time.
	 * @param s The word that is going to be verified inside the method by going through the entire WordList.
	 * @param Word Word an ArrayList<String> that countains all the words inside the file isolated separatly.
	 * @param split A String array that countains all the words inside the text File.
	 */
	public static void CountRepeatedWords(String s, ArrayList<String> Word) {

		int index = 0;
		int count = 0;

		for (String x : Word) {

			if (s.contentEquals(x)) {
				count++;

				if (count > 1) {
					// if it repeats more than one time, we set that word to "" and it disappears from the list.
					Word.set(index, "");
					
				}
			}
			index++;
		}

		
	

	}

	
/*
 * This method takes a string splits it into several part an verifies if it countains a number or not, it retruns a boolean value. 
 */
	public static boolean CheckForNumbers(String k) {

		String[] Split = k.split("");

		int count = 0;

		for (int i = 0; i < Split.length; i++) {

			try {

				double a = Double.parseDouble(Split[i]);
				count++;
			}

			catch (NumberFormatException e) {

			}

		}

		if (count > 0)
			return true;
		// then countains or is a number
		else
			return false;
		// then does not countain or is not a number

	}

	public static void ifRepated(String s, ArrayList<String> Word) {

		int sup = 0;
		int index = 0;
		boolean find = false;
		ArrayList<Integer> IndexOfRepeated = new ArrayList<Integer>();
		for (String l : Word) {

			if (s.contentEquals(l)) {
				sup++;
				if (sup > 1) {
					find = true;
					IndexOfRepeated.add(index);
				}
			}
			index++;
		}
		System.out.println();

		if (find) {
			System.out.println("This  word  is repeated times: " + (sup - 1));
			for (int x : IndexOfRepeated)
				System.out.print(x + " ");
		}

		else
			System.out.println("This word  is not repeated more than 1 time");
	}
}
