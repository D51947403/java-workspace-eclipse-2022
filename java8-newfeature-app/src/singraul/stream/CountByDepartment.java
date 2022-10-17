package singraul.stream;
/**
 * https://www.geeksforgeeks.org/how-to-convert-a-stream-into-a-map-in-java/
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class CountByDepartment {

	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student(10,"Devendra",32, "CS"));
		studentList.add(new Student(12,"Kumar",34, "CS"));
		studentList.add(new Student(14,"Singraul",32, "CS"));
		studentList.add(new Student(11,"Anand",32, "ME"));
		studentList.add(new Student(15,"Mahindra",35, "ME"));
		studentList.add(new Student(16,"Ratan",30, "CE"));
		studentList.add(new Student(18,"Syrus Mistri",32, "IT"));
		studentList.add(new Student(17,"Pichai",36, "IT"));
		
//		Map<String,Integer> studentMap =new HashMap<String, Integer>();
		
//		for (Student student : studentList) {
//		studentMap.put(student.getDepatment(), studentMap.getOrDefault(student.getDepatment(), 0)+1);
//		}
//		
//		for(Entry<String, Integer> entry: studentMap.entrySet()) {
//			System.out.println("Department : "+entry.getKey());
//			System.out.println("Student Count : "+entry.getValue());
//		}
		// using stream in java8
		Map<String,Long> studentMapJava8 =studentList.stream().collect(
				Collectors.groupingBy(Student::getDepatment, Collectors.counting())
				);
		
		for(Entry<String, Long> entry: studentMapJava8.entrySet()) {
			System.out.println("Department : "+entry.getKey());
			System.out.println("Student Count : "+entry.getValue());
		}
			
	}
}
