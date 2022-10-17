package singraul.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StudentListToMap {
  public static void main(String [] args) {
	  List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student(10,"Devendra",32, "CS"));
		studentList.add(new Student(12,"Kumar",34, "CS"));
		studentList.add(new Student(14,"Singraul",32, "CS"));
		studentList.add(new Student(11,"Anand",32, "ME"));
		studentList.add(new Student(15,"Mahindra",35, "ME"));
		studentList.add(new Student(16,"Ratan",30, "CE"));
		studentList.add(new Student(18,"Syrus Mistri",32, "IT"));
		studentList.add(new Student(17,"Pichai",36, "IT"));
		
		// HasMap
		Map<Integer, Student> studentMap = studentList.stream().collect(
				Collectors.toMap(Student::getId, student ->student));
		System.out.println("stduentMap "+studentMap);
		
		// HasMap again
				Map<Integer, Student> studentMap2 = studentList.stream().collect(
						Collectors.toMap(Student::getId, Function.identity()));
				System.out.println("stduentMap2 "+studentMap2);
		
		// Sorted Map
		Map<Integer, Student> studentTreeMap =studentList.stream().collect(
				Collectors.toMap(s -> s.getId(), Function.identity(), (s1, s2) -> s1 , TreeMap::new)
				);
		System.out.println("studentTreeMap "+studentTreeMap);
		// Concurrent Hash Map
		Map<Integer, Student> studentConcurrentMap =studentList.stream().collect(
				Collectors.toMap(s -> s.getId(), Function.identity(), (s1, s2) -> s1 , ConcurrentHashMap::new)
				);
		System.out.println("studentConcurrentMap "+studentConcurrentMap);
  }
}
