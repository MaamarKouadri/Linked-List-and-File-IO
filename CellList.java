import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * @author Maamar Kouadri Name: Maamar Kouadri ID: 40057671 COMP249 Assignment
 *         #4 Due Date 2020-04-19
 */
public class CellList {

	/**
	 * This is the inner class CellNode that will allows us to start the LinkedLIST
	 * 
	 * @author Maamar Kouadri
	 *
	 */

	private class CellNode {

		private CellPhone CP;

		private CellNode next;

		/**
		 * This is the default constructor for the Class CellNode.
		 */
		public CellNode() {
			CP = null;
			next = null;
		}

		/**
		 * /** This is the parameterized constructor that will take a CellPhone object
		 * as a parameter , and a CellNode object and will assign the attributes into
		 * the new object that is going to be generated.
		 * 
		 * @param cP       The CellPhone object that is going to be assigned.
		 * @param CellNode object that will serve as pointer for the next Node in the
		 *                 LinkedList.
		 */
		public CellNode(CellPhone cP, CellNode next) {

			this.CP = cP; // Maybe privacy link since we are passing the reference to an
							// object.Better do a deep copy
			this.next = next;
		}

		/**
		 * This the copy construction that will take CellNode object as a parameter and
		 * perform a deep copy, by invoking the clone method of its CellPhone object
		 * attribute and assignent its CellNode to the CellNode of the new object.
		 * 
		 * @param Obj A CellNode Object that is going to be copied.
		 */
		public CellNode(CellNode Obj) {

			this.CP = Obj.CP.clone();// Deep Copy.
			this.next = Obj.next;
		}

		/**
		 * This the clone method that will generate a deep copy of the calling CellNode
		 * object.
		 */
		public CellNode clone() {
			return new CellNode(this);
		}

		/**
		 * @return This the Getter method that will grant access to the private
		 *         attribute CP which is a CellPhone .
		 */
		public CellPhone getCP() {
			return CP;
		}

		/**
		 * This is the mutator method for the attribute CP.
		 * 
		 * @param cP The method will take this value as a parameter and assign this
		 *           value to the attribute CP.
		 */
		public void setCP(CellPhone cP) {
			CP = cP;
		}

		/**
		 * @return This the Getter method that will grant access to the private
		 *         attribute next which is a CellNode .
		 */
		public CellNode getNext() {
			return next;
		}

		/**
		 * This is the mutator method for the attribute next.
		 * 
		 * @param next The method will take this CellNode object as a parameter and
		 *             assign this reference to the attribute next.
		 */
		public void setNext(CellNode next) {
			this.next = next;
		}

	}

	private CellNode head;
	private int size;

	/**
	 * This is the default constructor for the Class CellNode.
	 */
	public CellList() {
		size = 0;
		head = null;
	}

	/**
	 * This method simply regulates the Size of the LinkedList by continuously checking
	 * the number of CellNodes inside of it.
	 */

	public void Size() {
		CellNode temp = head;
		int count = 0;

		while (temp != null) {
			count++;
			temp = temp.next;

		}

		this.size = count;

	}

	/**
	 * This is the copy Constructor of the class Linked list. We are creating three
	 * pointer that we are going to use to get the references of each CellNode
	 * countained in the CellList. Each time that we need to create a CellNode we
	 * are invoking the CellNode copy constructor, which in turn invoks the copy
	 * constructor of the CellPhone object countained in that Node. By Iterating
	 * through the while loop we can copy all nodes into the LinkedList.
	 * 
	 * @param lst A CellList object that is going to be copied.
	 */
	public CellList(CellList lst) {
//  To verify aagain
		if (lst.head == null)
			head = null;
		else {
			head = null;
			CellNode t1, t2, t3;

			t1 = lst.head;
			t2 = t3 = null;

			while (t1 != null) {

				if (head == null) {
					t2 = new CellNode(t1.CP.clone(), null);
					head = t2;
				} else {
					t3 = new CellNode(t1.CP.clone(), null);
					t2.next = t3;
					t2 = t3;
				}
				t1 = t1.next;
			}

			t2 = t3 = null;

		}
		Size();
	}

	/**
	 * This the clone method that will generate a deep copy of the calling CellNode
	 * object.
	 */
	public CellList clone() {
		return new CellList(this);
	}

	/**
	 * This method takes CellPhone object as a parameter , creates a new CellNode,
	 * makes the new CellNode the head of the list and puts the CellPhone object
	 * inside of it.
	 * 
	 * @param CP A CellPhone object that will be added to the start of the linked
	 *           list inside a new Node.
	 */
	public void addToStart(CellPhone CP) {
		CellNode First = new CellNode(CP, null);
		CellNode temp;
		temp = head;
		head = First;
		First.next = temp;
		Size();

	}

	/**
	 * This method allows to add CellNode with a specific CellPhone object , at a
	 * specific index. It first verifies if the index is withing the range . Than
	 * checks if the index is 0 , if it is the new Node will be the head otherwise
	 * it will go through the LinkedList , locate the specific index and manipulates
	 * the references of the CellNodes in order to a insert a new one at that
	 * specific index.
	 * 
	 * @param cell  The CellPhone that is going to be added inside a new CellNode at
	 *              a specific index.
	 * @param index
	 */
	public void insertAtIndex(CellPhone cell, int index) {
		try {
			if (index < 0 || index > this.size-1)// maybe - 1 ? we will verify
				throw new NoSuchElementException();

			CellNode t = null;

			if (index == 0) {
				t = new CellNode(cell, head);
				head = t;
			}

			else {
				t = head;
				CellNode temp = null;
				for (int i = 0; i < index - 1; i++) {

					t = t.next;
				}

				temp = new CellNode(cell, t.next);
				t.next = temp;

			}

		} catch (NoSuchElementException e) {
			System.out.println("The index is invalid now the program will stop");
			System.exit(0);
		}
		Size();
	}

	/**
	 * This method allows use to delete a CellNode from a specific index in the
	 * LinkedList, actually all it does is erase the all the references linked to
	 * that CellNode. It first verifies if the entered index is whithin the
	 * acceptable range. If it is that it tries to locaate the position of that
	 * CellNode and simply erases all references of that CellNode in the list.
	 * 
	 * 
	 * @param index The index from which we are going to delete the CellNode at that
	 *              position.
	 */
	public void deleteFromindex(int index) {
		try {
			Size();
			if (index < 0 || index > this.size - 1) // why size -1 ?
				throw new NoSuchElementException();
			int i;
			CellNode temp = null;

			if (index == 0) {
				temp = head.next;
				head = temp;
				temp = null;
				Size();
			}

			else {
				temp = head;
				CellNode delete = null;
				{
					for (i = 0; i < index - 1; i++)
						temp = temp.next;
					// System.out.println(temp.getCP().getSerialNum());
				}
				delete = temp.next;
				temp.next = delete.next;
				delete = null;
			}

		} catch (NoSuchElementException e) {
			System.out.println("The index is invalid now the program will stop");
			System.exit(0);
		}
		Size();
	}

	/**
	 * This method deletes the first index in the LinkedList, it checks if there is
	 * a head, if the LinkedList is not empty . If it that it earses the references
	 * linked to the head of the list.
	 */
	public void deleteFromStart() {
		CellNode temp = null;
		CellNode temp2 = null;
		if (head == null)
			System.out.println("The list is empty , there is nothing to delete");

		else {
			temp = head.next;
			head = temp;
			temp = null;
		}
		Size();
	}

	/**
	 * 
	 * @param cs
	 * @param index
	 */

	/**
	 * This methode replaces a CellNode at specific index with a new CellNode countaining  a new CellPhone object inside of it. It first verifies if the index
	 * is within the appropriate range than goes through the LinkedList and assigns a new reference to the index located at that positon.
	 * @param cs The CellPhone object that is going to be store into the CellNode that is going to be replacing the old one.
	 * @param index The specific index at which the replacement is supposed to happen. 
	 */
	
	
	public void replaceAtIndex(CellPhone cs, int index) {
		
		CellNode replace = new CellNode(cs, null);

		if (index < 0 || index > this.size)
			System.out.println();
		else
		{

		CellNode temp = head;

		if (index == 0) {
			temp = new CellNode(cs, head.next);
			head = temp;
		} else {

			for (int i = 0; i < index - 1; i++) {
				temp = temp.next;
			}

			replace = temp.next;
			temp.next = new CellNode(cs, replace.next);
		}
		}
		Size();
	}

	
	
	/**
	 * This method takes a SerialNumber , goes through the entire LinkedList and finds the CellNode object countaing the CellPhone object that holds that serial number
	 * and simply returns that pointer.
	 * @param SerialNumber A SerialNumer that is going to be used to find the  he CellNode that has a CellPhone with that SerialNumber.
	 * @return returns a reference to the CellNode that has a CellPhone with that SerialNumber.
	 */
	private CellNode find(long SerialNumber) {

		CellNode temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			if (temp.getCP().getSerialNum() == SerialNumber)
				break;

			temp = temp.next;
		}

		return temp;  //Maybe a privacy leak since we are returning a reference.
	}

	
	/**
	 * This method invoks the find method, and verifies if it returns a pointer or not , and thus if the passsed SerialNumer is in the LinkedList or not. 
	 * @param SerialNumber a Serial Number that is going to be used in order to verify its presence in the LinkedList
	 * @return a boolean value that indicates if that SerialNumber is present in the list or not.
	 */
	
	public boolean countains(long SerialNumber) {
		if (find(SerialNumber) != null)
			return true;
		else
			return false;
	}

	/**
	 * This method is going to be used, to find all the duplicate entries inside the LinkedList and delete them in order to keep only the original ones,it does delete
	 * every time that it finds a replicated SerialNumber  in order to respect the rule of the unique SerialNumber.
	 */
	public void FindDuplicate() {

		CellNode temp = head;
		

		ArrayList<CellNode> DuplicateCell = new ArrayList<CellNode>(); // Storing the CellNodes in an array list.
		while (temp != null) {
			DuplicateCell.add(temp);
			temp = temp.next;
			
		}

		// Now we have all the CellNodes stored in an ArrayList.
		
		
		
		ArrayList<Long> Serials = new ArrayList<Long>(); // This list is going to store the SerialNumbers of the Repeated entries.
		
		ArrayList<CellNode> TheRepeatedOnes = new ArrayList<CellNode>(); // This list is going to store the CellNodes that repeats into the Linked List.
		int Count = 0;//Every time that a new repeated SerialNumber is found this value is going to increase.
		int Count2 = 0; // Counts the number of times a Serial Number repeats itself.
		for (CellNode x : DuplicateCell) {

			for (CellNode l : DuplicateCell) {

				// We are verifying if there is a repeated Serial Number, if the two objects are not the same and if that objects has not been added already to the list TheRepeatedOnes.
				if (x.getCP().getSerialNum() == l.getCP().getSerialNum() && !x.CP.equals(l.CP)   	&& !TheRepeatedOnes.contains(x))
				
				{
                          // If it is A new Serial Number Count will increase.
					if (!Serials.contains(x.getCP().getSerialNum())) {
						Count++;
						Count2 = 0;

					}
					Serials.add(x.getCP().getSerialNum());    // Adding the SerialNumber.
					TheRepeatedOnes.add(x);      //Adding the CellNode Object.
					Count2++;
					// System.out.println(x.getCP() +" Count : "+ Count + " Count2 " + Count2 + "
					// repeats itself at index " + DuplicateCell.indexOf(l) + " times.");

					// This only happend if the Serial Number repeats itself more than time , than we delete all the duplicated entries.
					if (Count2 > 1) {
						System.out.println(x.CP + " will be Deleted");
						CellNode Delete = head;
						CellNode Temporary = null;

						// In here we are simply erasing the refences of the duplicated entries thus deleting themp from the list. 
						while (Delete != null) {

							if (Delete.next == x)
								break;
							Delete = Delete.next;
						}
						Temporary = x.next;
						Delete.next = Temporary;
						Temporary = null;
					}
				}

			}
			
		}

		Size();
	}

	
	/**
	 * This method is going to be used in order to pring the informations of CellPhone object countained in a CellNode object in the list
	 * if it is found by using the SerialNumber. It does say or not if the SerialNumber corresponds to an object in the list. 
	 * @param SerialNumber  The Serial Number that we are going to use to find a specifc CellPhone in the Linked List.
	 */
	public void PrintBySerialNumber(long SerialNumber) {
		boolean found = false;
		CellNode temp = head;
		int count = 0;
		while (temp != null) {

			if (temp.getCP().getSerialNum() == SerialNumber) {
				found = true;
				System.out.println("Found it!  " + temp.CP);
				System.out.println("It took " + count
						+ " iterations before finding the CellPhone with the serial number " + SerialNumber);
			}

			temp = temp.next;
			count++;
		}
		if (found == false)
			System.out.println("The serial number you have entered is not held my any CellPhone in this list.");
	}

	public void PrintAtIndex(int x) {
		CellNode temp = head;
		int count = 0;
		while (temp != null) {
			if (count == x)
				System.out.println(temp.CP);
			temp = temp.next;
			count++;

		}
	}

	
	
	/**
	 * This the method that we are going to used in order to print the entire lists, if the list is empty it does mention it. Otherwise it prints
	 * all the CellPhones countained insde the CellNodes in the list by indicating the size of the LinkedList as well.
	 * 
	 */
	public void showContents() {
		CellNode temp = null;
		if (head == null)
			System.out.println("The list is empty there is nothing to show");

		else {
			temp = head;
			System.out.println("The current size of the list is " + this.size + ". Here are the contents of the list.");
			System.out.println(
					"-------------------------------------------------------------------------------------------------------");
			System.out.println(
					"-------------------------------------------------------------------------------------------------------");
			int count = 0;
			while (temp != null) {
				System.out.print("{" + temp.CP + "}" + "--->");
				temp = temp.next;
				count++;
				if (count % 3 == 0 && count != 0) {
					if (temp == null)
						System.out.print("X");
					System.out.println();
				}

				if (count % 3 != 0 && count != 0 && temp == null)
					System.out.print("X");
			}

		}
	}

	
	/**
	 * Verifies the equality in  terms of CellPhones objects between the two lists, it compares all their attributes except the SerialNumber.
	 * 
	 * @param obj CellList object that is going to be compared to the calling CellList object.
	 * @return a boolean value that indicates if two lists are the same
	 */
	public boolean equals(CellList obj) {

		CellNode temp = head;
		CellNode temp2 = obj.head;
		boolean verification = true;
		while (temp != null && temp2 != null) {

			if (temp.CP.equals(temp2.CP) == false) {
				verification = false;
				break;
			}

			temp = temp.next;
			temp2 = temp2.next;

		}
		return verification;
	}

}
