package it_academy;

import it_academy.context.Student;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClientTest {


	@Test
	void createGroupOfStudents() throws NoSuchFieldException, IllegalAccessException {
		List<Student> list = Client.createGroupOfStudents(3);

		assertEquals((3 * 3), list.size());

		Class clazz = Student.class;
		Field field = clazz.getDeclaredField("calc");
		field.setAccessible(true);


		int type_1 = 0;
		int type_2 = 0;
		int type_3 = 0;
		for (Student s : list) {
			switch (field.get(s).getClass().getSimpleName()) {
				case ("FirstTypeStrategy"):
					type_1++;
					break;
				case ("SecondTypeStrategy"):
					type_2++;
					break;
				case ("ThirdTypeStrategy"):
					type_3++;
					break;
				default:
					assertEquals(" ", "Not so type.");
			}
		}
		assertEquals(3, type_1);
		assertEquals(3, type_2);
		assertEquals(3, type_3);
	}

	@Test
	void getRanTalent() {
		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			double rnd = Client.getRanTalent(random);
			assertTrue(ConstantContainer.MIN_TALENT_OF_STUDENTS <= rnd
					&& rnd <= ConstantContainer.MAX_TALENT_OF_STUDENTS);

		}
	}
}