package com.custom;

//http://dinocajic.blogspot.com/2016/06/creating-your-own-arraylist-in-java.html
//https://www.java2novice.com/java-interview-programs/arraylist-implementation/
public class CustomArrayList {

	private Object[] arrayList;
	private int elementsInArray = 0;

	// default size =10
	public CustomArrayList() {
		this(10);
		// this.arrayList = new Object[10];
	}

	// custom size
	public CustomArrayList(int n) {
		if (n < 0) {
			System.out.println("Size must be greater than 0. try again");
			return;
		}
		this.arrayList = new Object[n];
	}

	// add element at last
	public void add(Object x) {
		if (checkIfArrayFull()) {
			copyArray(2);
		}
		this.arrayList[this.elementsInArray] = x;
		this.elementsInArray++;
	}

	public void add(int index, Object x) {
		if (checkIfArrayFull()) {
			copyArray(2);
		}
		if (index >= this.arrayList.length) {
			System.out.println("The index is out of bounds");
			System.exit(-1);
		}
		this.arrayList[index] = x;
	}

	public Object get(int index) {
		Object element = null;

		// Invariant: 0 <= index < arrayList.length
		try {
			element = this.arrayList[index];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("The index that you specified is not within bounds.");
			System.exit(-1);
		}

		return element;
	}

	public int size() {
		return this.elementsInArray;
	}
	
	public boolean isEmpty() {
		return this.elementsInArray ==0;
	}
	
	 public boolean isExists(Object ob) {
	        return find(ob) >= 0;
	    }
	public int find (Object ob) {
        // Invariant: 0 <= i < arrayList.length
        for (int i = 0; i < this.arrayList.length; i++) {
            if (ob.equals(this.arrayList[i])) {
                return i;
            }
        }

        return -1;
    }
	
	 public void remove (Object n) {
	        // Invariant: 0 <= i < elementsInArray
	        for (int i = 0; i < this.elementsInArray; i++) {
	            if (n.equals(this.arrayList[i])) {
	                this.arrayList[i] = null;
	                this.elementsInArray--;
	                copyArray(1);
	                return;
	            }
	        }
	    }

	private boolean checkIfArrayFull() {
		return this.arrayList.length == this.elementsInArray;
	}

	private void copyArray(int loadFactor) {

		int size = this.arrayList.length * loadFactor;

		Object[] tempArray = new Object[size];

		int tempElement = 0;

		// Invariants: 0 <= i < arrayList.length && 0 <= tempElement < arrayList.length
		for (int i = 0; i < this.arrayList.length; i++, tempElement++) {
			if (this.arrayList[i] == null) {
				tempElement--;
				continue;
			}

			tempArray[tempElement] = this.arrayList[i];
		}

		this.arrayList = null;
		this.arrayList = new Object[tempArray.length];
		this.arrayList = tempArray;
	}

}

class ArrayListDriver {
	public static void main(String[] args) {
		 System.out.println("Create Constructor setting ArrayList to capacity 50");
	        CustomArrayList numeric = new CustomArrayList(50);

	        System.out.println("The ArrayList is empty: " + numeric.isEmpty());
	        System.out.println("The numer of elements in array is: " + numeric.size());

	        System.out.println("Populate the ArrayList with values from 1 to 20");
	        for (int i = 0; i < 50; i++) {
	            numeric.add((int)(Math.random() * 20) + 1);
	        }

	        System.out.println("The ArrayList is empty: " + numeric.isEmpty());
	        System.out.println("The number of elements in array is: " + numeric.size());

	        System.out.println("Add an element to the end of the ArrayList: i.e. 12345");
	        numeric.add(12345);
	        System.out.println("The index of 12345 is " + numeric.find(12345));

	        System.out.println("The number of elements in array is: " + numeric.size());
	        System.out.println("The value of element 50 is: " + numeric.get(50));

	        System.out.println("Element at index 5 before removal: " + numeric.get(5));
	        System.out.println("The number of elements in array is: " + numeric.size());
	        System.out.println("Remove element at index 5");
	        numeric.remove(numeric.get(5));
	        System.out.println("Element at index 5 after removal: " + numeric.get(5));
	        System.out.println("The number of elements in array is: " + numeric.size());

	        System.out.println("Add an element at specific position");
	        System.out.println("Element at index 10 before insertion: " + numeric.get(10));
	        numeric.add(10, 200);
	        System.out.println("Element at index 10 after insertion: " + numeric.get(10));
	        System.out.println("Element at index 11 after insertion: " + numeric.get(11));

	        System.out.println("Check to see if particular element is in array?");
	        System.out.println("Is 12345 in array? " + numeric.isExists(12345));
	        System.out.println("Is 123456 in array? " + numeric.isExists(123456));

	        for (int i = 0; i < numeric.size(); i++) {
	            System.out.println("ArrayList[" + i + "]: " + numeric.get(i));
	        }

	        System.out.println("************************************************");

	        System.out.println("Tests the default constructor");

	        CustomArrayList test = new CustomArrayList();
	        System.out.println("Current size: " + test.size());
	        System.out.println("Is the Array List empty? : " + test.isEmpty());
	        test.add("x");
	        test.add("b");
	        test.add("aa");
	        test.add("bh");
	        test.add("G");
	        test.add("d");
	        test.add("a");
	        test.add("e");
	        test.add("bd");
	        test.add("c");
	        test.add(2, "DINO");
	        test.add(2, "CAJIC");
	        test.add(10, "DINO");
	        test.add(19, "DINO");
	        test.remove("DINO");
	        test.remove("x");
	        System.out.println("Current size: " + test.size());
	        System.out.println("Is the Array List empty? : " + test.isEmpty());
	        System.out.println("Object at index 1: " + test.get(1));
	        System.out.println("Object at index 3: " + test.get(3));
	        System.out.println("Position of G: " + test.find("G"));
	        System.out.println("Position of na: " + test.find("na"));
	        System.out.println("Is bd in array list? : " + test.isExists("bd"));
	        System.out.println("Is bda in array list? : " + test.isExists("bda"));

	        for(int i = 0; i < test.size(); i++) {
	            System.out.println("ArrayList[" + i + "] : " + test.get(i));
	        }

	        System.out.println("Out of bounds test: " + test.get(22));
	    }

	}
