package design.pattern.creational.helper;

public class Movie implements EntertainPrototype {
	private String name = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Movie clone() throws CloneNotSupportedException {
		System.out.println("Cloning Movie object..");
		return (Movie) super.clone();
	}

	@Override
	public String toString() {
		return "Movie";
	}
	
	public  void display() {
		System.out.println("display movie");
	}
}
