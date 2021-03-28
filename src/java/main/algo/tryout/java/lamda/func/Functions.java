package algo.tryout.java.lamda.func;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Functions {

	public static void main(String[] args) {

		generateStaffDetails();
		generateStudentDetails();
	}

	private static void generateStaffDetails() {
		List<Staff> staffs = Arrays.asList(new Functions.Staff("Mani", "Durai", 8795, 30), new Staff("Mani1", "Durai1", 8956, 65),
				new Staff("Mani", "Durai", 8768, 76));
		List<String> staffDetails = toStringObject(staffs,toStaffList);

	}

	private static Function<Staff, List<String>> toStaffList = staff -> {
		return Arrays.asList(staff.getName(), staff.getFatherName(), "" + staff.getContactNumber(),
				"" + staff.getAge());
	};

	private static void generateStudentDetails() {
		List<Student> students = Arrays.asList(new Functions.Student("Mani", "Durai", 8795, 30), new Student("Mani1", "Durai1", 8956, 65),
				new Student("Mani", "Durai", 8768, 76));
		List<String> staffDetails = toStringObject(students,toStudentList);
	}
	private static Function<Student, List<String>> toStudentList = student -> {
		return Arrays.asList(student.getName(), student.getFatherName(), "" + student.getContactNumber(),
				"" + student.getAge());
	};

	private static <T> List<String> toStringObject(List<T> detailsList, Function<T, List<String>> toStringFunction) {
		List<String> outputList = new ArrayList<>();
		detailsList.forEach(x -> {
			outputList.add(String.join(",", toStringFunction.apply(x)));
		});
		return outputList;
	}

	private static class Student {

		private String name;
		private String fatherName;
		private int contactNumber;
		private int age;

		public Student(String name, String fatherName, int contactNo, int age) {
			this.name = name;
			this.fatherName = fatherName;
			this.contactNumber = contactNo;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getFatherName() {
			return fatherName;
		}

		public void setFatherName(String fatherName) {
			this.fatherName = fatherName;
		}

		public int getContactNumber() {
			return contactNumber;
		}

		public void setContactNumber(int contactNumber) {
			this.contactNumber = contactNumber;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

	}

	public static class Staff {
		private String name;
		private String fatherName;
		private int contactNumber;
		private int age;

		public Staff(String name, String fatherName, int contactNo, int age) {
			this.name = name;
			this.fatherName = fatherName;
			this.contactNumber = contactNo;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getFatherName() {
			return fatherName;
		}

		public void setFatherName(String fatherName) {
			this.fatherName = fatherName;
		}

		public int getContactNumber() {
			return contactNumber;
		}

		public void setContactNumber(int contactNumber) {
			this.contactNumber = contactNumber;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

	}
}
