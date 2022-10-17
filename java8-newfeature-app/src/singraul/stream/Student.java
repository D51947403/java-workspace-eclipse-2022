package singraul.stream;

public class Student {
	
	private int id;
	private String name;
	private int age;
	private String depatment;

	public Student(int id, String name, int age, String depatment) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.depatment=depatment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDepatment() {
		return depatment;
	}

	public void setDepatment(String depatment) {
		this.depatment = depatment;
	}
	
	
}
