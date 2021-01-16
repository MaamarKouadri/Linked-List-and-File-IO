# Linked-List

Part 1: ArrayList & File I/O
Sub-Dictionary Creator
In this part, you are required to write a program that will accept any text file, as input, and creates a sub-dictionary that includes all the words found in that input file based on some rules. The input file may have zero or more words, as well as specific limited set of other characters /punctuation that are used in a specific and predetermined manner. In particular, the text on the input file is only assumed to have the following (besides the words of course!):
• “?”: only appears at the end of a word; for instance: why not?
• “:”: only appears at the end of a word; for instance: the rules are: ….
• “’”: which can only appear in front of m or s; for instance: I’m … or It’s …
• “,”: only appears at the end of a word; for instance: However, ….
• “=”: which can appear by itself in the middle of an equation; for instance: x = y
• “;”: only appears at the end of a word; for instance: violin; what else …
• “!”: only appears at the end of a word; for instance: That is fantastic!
• “.”: only appears at the end of a word; for instance: These times were good.
• Digits: 0 to 9, which may appear as a number (i.e. 1927); or as a part of a word (i.e. hi5)
• Single characters: A, B, T, etc.
You are required to implement a program that will take any such text file as input, and create a sub-dictionary of the words on that file, based on the following rules:
• For each word, only one entry can be recorded in the sub-dictionary. For instance, if the word “Hello” appeared in the text 15 times, it is still recorded once in the sub-dictionary.
• All words must be recorded only in UPPERCASE. For instance, Hello must be recorded as HELLO.
• Words cannot be recorded with any of the punctuation; for instance, “fantastic!” must be recorded only as “fantastic”.
• No numbers or words that have digits anywhere (i.e. 1927, hi5 or b4that) can be recorded in the sub-dictionary.
• No single characters (i.e. k, M, t, etc.), with the exception of A and I, can be recorded in the dictionary. (Notice that “a” and “i” are allowed but need to be recorded as A and I respectively).
• All words with “’s” or “’m” (or their upper case versions) must be recorded without the ‘s or ‘m. For instance, It’s, will need to be recorded as IT.
• All words are recorded in the sub-dictionary in the usual sorted alphabetic order. Additionally, each group must be preceded with an indication of the character that starts this group (similar to real-life dictionaries). For instance, all words starting with “K”, will be preceded with something like:
K
= =
• Finally, the sub-dictionary must have an initial line indicating its size based on the given input file. For instance:
The document produced this sub-dictionary, which includes 447 entries.
For instance, given the following file PersonOfTheCentury.txt[1] (which is provided with the assignment), your program will create the output file SubDictionary.txt (which is also provided with the assignment). You should notice that this input file is just one example and your program must be able to work with any input file. In fact, the marker will actually test your program with other input files. For immediate illustration, partial images of the input and output files are shown below.


Part 2: Linked Lists
Cell Phones Records
In this part, you are required to write a program, using linked lists, that manipulates a set of records of cell phones and performs some operations on these records.
I) The CellPhone class has the following attributes: a serialNum (long type), a brand (String type), a year (int type, which indicates manufacturing year) and a price (double type). It is assumed that brand name is always recorded as a single word (i.e. Motorola, SonyEricsson, Panasonic, etc.). It is also assumed that all cellular phones follow one system of assigning serial numbers, regardless of their different brands, so no two cell phones may have the same serial number.
You are required to write the implementation of the CellPhone class. Beside the usual mutator and accessor methods (i.e. getPrice(), setYear()) the class must have the following:
(a) Parameterized constructor that accepts four values and initializes serialNum, brand, year and price to these passed values;
(b) Copy constructor, which takes two parameters, a CellPhone object and a long value. The newly created object will be assigned all the attributes of the passed object, with the exception of the serial number. serialNum is assigned the value passed as the second parameter to the constructor. It is always assumed that this value will correspond to the unique serial number rule;
(c) clone() method. This method will prompt the user to enter a new serial number, then creates and returns a clone of the calling object with the exception of the serial number, which is assigned the value entered by the user;
(d) Additionally, the class should have a toString() and an equals() methods. Two cell phones are equal if they have the same attributes, with the exception of the serial number, which could be different.
Comp 249 – Winter 2020
Assignment # 4©AH 2020 - Page 4 of 7
II) The file Cell_Info.txt, which one of its versions is provided with this assignment, has the information of various cell phone objects. The file may have zero or more records. The information stored in this file is always assumed to be correct and following the unique serial number rule. A snapshot of the contents of the Cell_info.txt file is shown in Figure 1 below.
Figure 1: Cell_info.txt
III) The CellList class has the following:
(a) An inner class called CellNode. This class has the following:
i. Two private attributes: an object of CellPhone and a pointer to a CellNode object;
ii. A default constructor, which assigns both attributes to null;
iii. A parameterized constructor that accepts two parameters, a CellPhone object and a CellNode object, then initializes the attributes accordingly;
iv. A copy constructor;
v. A clone() method;
vi. Other mutator and accessor methods.
(b) A private attribute called head, which should point to the first node in this list object;
(c) A private attribute called size, which always indicates the current size of the list (how many nodes are in the list);
(d) A default constructor, which creates an empty list;
(e) A copy constructor, which accepts a CellList object and creates a copy of it;
Comp 249 – Winter 2020
Assignment # 4©AH 2020 - Page 5 of 7
(f) A method called addToStart(), which accepts one parameter, an object from CellPhone class. The method then creates a node with that passed object and inserts this node at the head of the list;
(g) A method called insertAtIndex(), which accepts two parameters, an object from CellPhone class, and an integer representing an index. If the index is not valid (a valid index must have a value between 0 and size-1), the method must throw a NoSuchElementException and terminate the program. If the index is valid, then the method creates a node with the passed CellPhone object and inserts this node at the given index. The method must properly handle all special cases;
(h) A method called deleteFromIndex(), which accepts one integer parameter representing an index. Again, if the index is not valid, the method must throw a NoSuchElementException and terminate the program. Otherwise; the node pointed by that index is deleted from the list. The method must properly handle all special cases;
(i) A method called deleteFromStart(), which deletes the first node in the list (the one pointed by head). All special cases must be properly handled.
(j) A method called replaceAtIndex(), which accepts two parameters, an object from CellPhone class, and an integer representing an index. If the index is not valid, the method simply returns; otherwise the object in the node at the passed index is to be replaced by the passed object;
(k) A method called find(), which accepts one parameter of type long representing a serial number. The method then searches the list for a node with a cell phone with that serial number. If such an object is found, then the method returns a pointer to that node where the object is found; otherwise, the method returns null. The method must keep track of how many iterations were made before the search finally finds the phone or concludes that it is not in the list;
(l) A method called contains(), which accepts one parameter of type long representing a serial number. The method returns true if an object with that serial number is in the list; otherwise, the method returns false;
(m) A method called showContents(), which displays the contents of the list, in a similar fashion to what is shown in Figure 2 below.
(n) A method called equals(), which accepts one parameter of type CellList. The method returns true if the two lists contain similar objects; otherwise the method returns false. Recall that two CellPhone objects are equal if they have the same values with the exception of the serial number, which can, and actually is expected to be, different.
