import java.util.Scanner;

/**
@author Maamar Kouadri
Name: Maamar Kouadri
ID: 40057671
COMP249
Assignment #4
Due Date 2020-04-19
 */
public class CellPhone {

	private long serialNum;
	private String brand;
	private int year;
	private double price;
	
	
	/**
	 * This is the default constructor for the Class CellPhone.
	 */

	public CellPhone() {

		serialNum = 0;
		brand = "Test";
		year = 2020;
		price = 500;

	}

	
	
	 /**
	  * This is the copy constructor that will take a CellPhone object as a parameter , and long for the SerialNumber and will  copy the attributes into the new object 
	  * that is going to be generated and assign the SerialNumber to the value of the new object.
	  * @param obj The CellPhone objected that is going to be copied.
	  * @param serialNum The SerialNumber  that is going to be copied and passed to the SerialNumber value of the new object.
	  */
	
	public CellPhone(CellPhone obj, long serialNum) {

		this.serialNum = serialNum;
		this.brand = obj.brand;
		this.year = obj.year;
		this.price = obj.price;

	}

	
	/**
	 * This is the constructor that takes four parameters and will allow us to assign those two values directly into the attributes
	  * of the new  object.
	 * @param serialNum The value that is going to be assigned  for  the SerialNumber of the new object.
	 * @param brand  The value that is going to be assigned  for  the Brand of the new object.
	 * @param year  The value that is going to be assigned  for  the Year of the new object.
	 * @param price  The value that is going to be assigned  for  the Price of the new object.
	 */
	public CellPhone(long serialNum, String brand, int year, double price) {

		this.serialNum = serialNum;
		this.brand = brand;
		this.year = year;
		this.price = price;
	}
	
/**
 * This the cloning method that takes a SerialNumber as parameter as passes into the copy construcor of the calling object in order to generate a deepm copy.
 * @param serialNum The value that is going to be assigned  for  the SerialNumber of the new object.
 * @return a new CellPhone which is a deep copy of the original object.
 */
	public CellPhone clone() {
		System.out.print("You may now enter a new serial Number for the copied object :");
		Scanner input2 = new Scanner(System.in);
	     long serialNum = input2.nextLong();	
		CellPhone NewCell =  new CellPhone(this, serialNum);
		
		return NewCell;
			

	}

	
	/**
	 * This is a toString method that will print the values countained inside that CellPhone Object.
	 *  @return a String representing the informations held by the attributes of the calling object.
	 */
	
	public String toString() {

		return (this.serialNum + ":  " + this.brand + "  " + this.price + "$  " + this.year);
	}

	
	/**
	 * This method verifies the equalitie between two objects for all the attributes except SerialNumber.
	 * It verifies the brand, the year and the price.
	 * @param c A  CellPhone object that is going to be compared to the calling object.
	 * @return a boolean value that indicates if the calling  and passing object hold the same values for the brand, the year and the price.
	 */
	
	public boolean equals(CellPhone c) {
		return (this.brand.contentEquals(c.brand) && this.year == c.year && this.price == c.price);
	} // Maybe use MATH.abs to compare the two doubles

	
	
	
	
	/** 
	 * @return This the Getter method that will grant access to the private attribute serialNum.
	 */
	public long getSerialNum() {
		return serialNum;
	}
	/**
	 * This is the mutator method for the attribute serialNum.
	 * @param serialNum The method will take this value as a parameter and assign this value to the attribute serialNum. 
	 */
	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}
	/** 
	 * @return This the Getter method that will grant access to the private attribute brand.
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * This is the mutator method for the attribute brand.
	 * @param brand The method will take this value as a parameter and assign this value to the attribute brand. 
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/** 
	 * @return This the Getter method that will grant access to the private attribute year.
	 */
	public int getYear() {
		return year;
	}
	/**
	 * This is the mutator method for the attribute year.
	 * @param year The method will take this value as a parameter and assign this value to the attribute year. 
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/** 
	 * @return This the Getter method that will grant access to the private attribute price.
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * This is the mutator method for the attribute price.
	 * @param price The method will take this value as a parameter and assign this value to the attribute price. 
	 */
	public void setPrice(double price) {
		this.price = price;
	}

}
