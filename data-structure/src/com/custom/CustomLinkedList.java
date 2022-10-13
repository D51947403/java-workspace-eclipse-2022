package com.custom;
//https://www.devglan.com/datastructure/linkedlist-implementation-java
public class CustomLinkedList {
  private Node head;
  private int actSize;
  public CustomLinkedList() {
	  
  }
  
  public void insert(int data) {
	  Node newNode= new Node(data);
	  if(this.head==null) {
		  head=newNode;
		  actSize++;
	  }else {
		  Node currentNode =head;
		  while(currentNode.getNextNode() !=null) {
			  currentNode=currentNode.getNextNode();
		  }
		  currentNode.setNextNode(newNode);
		  actSize++;
	  }
  }
  
  public void insertAt ( int index, int data) {
	  Node newNode = new Node(data);
	  Node tempNode=head;
	  for(int i=0; i< index-1; i++) {
		  tempNode=tempNode.getNextNode(); 
	  }
	  newNode.setNextNode(tempNode.getNextNode());
	  tempNode.setNextNode(newNode);
	  actSize++;
  }
  
  public void deleteAt(int index) {
	  Node tempNode = head;
	  for(int i=0; i<= index-1; i++) {
		  tempNode= tempNode.getNextNode();
	  }
	  tempNode.setNextNode(tempNode.getNextNode().getNextNode());
	  actSize--;
  }
  
  public void display() {
	  if(head != null) {
		  Node currentNode=head;
		  while(currentNode.getNextNode() != null) {
			  System.out.println(currentNode.getData());
			  currentNode = currentNode.getNextNode();
		  }
		  System.out.println(currentNode.getData());
	  }
  }
  
  public void reverse() {
	  Node previous =null;
	  Node current=head;
	  Node next ;
	  while(current != null) {
		  next= current.getNextNode();
		  current.setNextNode(previous);
		  previous = current;
          current = next;
		  
	  }
  }
  
  public void insertHead(int data){
      Node newNode = new Node(data);
      newNode.setNextNode(head);
      head = newNode;
}
	public int size() {
		return actSize;
	}
	public boolean isEmpty() {
		return actSize==0;
	}
}

class Node {
	private int data;
	private Node nextNode;
	
	public Node(int data){
		this.data=data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
}