package it_academy;

import it_academy.context.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Client {

	public static final String OK_MESSAGE = "List of all created group:";
	public static final String CHANGE_MESSAGE = "List of group after any changes:";
	private static Random random = new Random();
	private static List<Student> group;

	public static void main(String[] args) {

		group = createGroupOfStudents(ConstantContainer.COUNT_OF_TYPES_OF_STUDENTS,
				ConstantContainer.COUNT_OF_STUDENTS_OF_EACH_TYPE);

		printGroup(group, OK_MESSAGE);
/*
		//experiment with chang of type:
		group.get(group.size() - 1).setType(ConstantContainer.Types.values()[0]);
		group.get(group.size() - 2).setType(ConstantContainer.Types.values()[0]);
		printGroup(group, CHANGE_MESSAGE);
		*/
	}

	public static List<Student> createGroupOfStudents(int types, int countOfSTudentEachType) {
		List<Student> list = new ArrayList<>();
		for (int i = 0; i < types; i++) {

			for (int j = 0; j < countOfSTudentEachType; j++) {
				list.add(new Student(ConstantContainer.Types.values()[i], getRanTalent(random)));
			}
		}
		return list;
	}

	private static void printGroup(List<Student> group, String message) {
		System.out.println(message);
		for (Student st : group) {
			System.out.println(st.toString());
		}
		System.out.println();
	}

	public static double getRanTalent(Random random) {

		int max = (int) (ConstantContainer.MAX_TALENT_OF_STUDENTS
				* ConstantContainer.ACCURACY_OF_TALENT_CALCULATIONS);
		int min = (int) (ConstantContainer.MIN_TALENT_OF_STUDENTS
				* ConstantContainer.ACCURACY_OF_TALENT_CALCULATIONS);
		int rand = (random.nextInt(max - min + 1) + min);

		return (rand * 1.0) / ConstantContainer.ACCURACY_OF_TALENT_CALCULATIONS;
	}
}
