package it_academy;

import it_academy.context.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Client {

	public static final String OK_MESSAGE = "List of all created group:";
	public static final String CHANGE_MESSAGE = "List of group after any changes:";
	private static Random random = new Random();
	private static List<Student> group;

	public static void main(String[] args) {

		group = createGroupOfStudents(ConstantContainer.COUNT_OF_STUDENTS_OF_EACH_TYPE);

		printGroup(group, OK_MESSAGE);
/*
		//experiment with chang of type:
		group.get(group.size() - 1).setType(ConstantContainer.Types.values()[0]);
		group.get(group.size() - 2).setType(ConstantContainer.Types.values()[0]);
		printGroup(group, CHANGE_MESSAGE);
		*/
	}

	public static List<Student> createGroupOfStudents(int countOfSTudentEachType) {
		List<Student> list = new ArrayList<>();
		for (int i = 0; i < countOfSTudentEachType; i++) {
			list.addAll(Arrays.stream(Types.values())
					.map(typ -> new Student(typ, getRanTalent(random)))
					.collect(Collectors.toList()));
		}
		return list;
	}

	private static void printGroup(List<Student> group, String message) {
		System.out.println(message);
		group.forEach(System.out::println);
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
