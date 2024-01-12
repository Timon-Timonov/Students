package it_academy.context;

import it_academy.ConstantContainer;
import it_academy.Types;
import it_academy.strategy.cocreteStrtegies.FirstTypeStrategy;
import it_academy.strategy.cocreteStrtegies.SecondTypeStrategy;
import it_academy.strategy.cocreteStrtegies.ThirdTypeStrategy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StudentTest {
	public static final double TEST_TALENT = 0.5;
	public static final int TEST_TYPE_1 = 0;
	public static final int TEST_TYPE_2 = 1;
	public static final int TEST_TYPE_3 = 2;
	static Student student;

	@BeforeAll
	static void createInstance() {
		student = new Student(Types.values()[TEST_TYPE_1], TEST_TALENT);
	}

	@Test
	void getTalent() {
		assertEquals(TEST_TALENT, student.getTalent());
	}

	@Test
	void setType() throws NoSuchFieldException, IllegalAccessException {
		Class clazz = student.getClass();
		Field field = clazz.getDeclaredField("calc");
		field.setAccessible(true);

		student.setType(Types.values()[TEST_TYPE_1]);
		assertTrue(field.get(student) instanceof FirstTypeStrategy);

		student.setType(Types.values()[TEST_TYPE_2]);
		assertTrue(field.get(student) instanceof SecondTypeStrategy);

		student.setType(Types.values()[TEST_TYPE_3]);
		assertTrue(field.get(student) instanceof ThirdTypeStrategy);

		field.setAccessible(false);
	}

	@Test
	void testToString() {
		student.setType(Types.values()[TEST_TYPE_1]);
		assertEquals("Student{ talent=0.5; totalTime=396; type=1; typesOfTraining: [potok, razbor, practic]; time To Each Type Of Training=132}", student.toString());
		student.setType(Types.values()[TEST_TYPE_2]);
		assertEquals("Student{ talent=0.5; totalTime=792; type=2; typesOfTraining: [razbor, practic]; time To Each Type Of Training=396}", student.toString());
		student.setType(Types.values()[TEST_TYPE_3]);
		assertEquals("Student{ talent=0.5; totalTime=1188; type=3; typesOfTraining: [practic]; time To Each Type Of Training=1188}", student.toString());
	}

	@Test
	void getTotalTime() {
		student.setType(Types.values()[TEST_TYPE_1]);

		int expected = (int) (ConstantContainer.TOTAL_LENGTH_OF_EDUCATION_PROCESS_FOR_TYPE_1_AND_TALENT_1
				* ConstantContainer.X_LENGTH_OF_EDUCATIONAL_PROCESS_FOR_TYPE_1 / TEST_TALENT);

		assertEquals(expected, student.getTotalTime());
	}

	@Test
	void getTimeToEachKindOfProcess() {
		student.setType(Types.values()[TEST_TYPE_1]);

		int expected = (int) (ConstantContainer.TOTAL_LENGTH_OF_EDUCATION_PROCESS_FOR_TYPE_1_AND_TALENT_1
				* ConstantContainer.X_LENGTH_OF_EDUCATIONAL_PROCESS_FOR_TYPE_1
				/ (TEST_TALENT * ConstantContainer.COUNT_OF_DIFFERENT_PROCESS_FOR_1_TYPE));

		assertEquals(expected, student.getTimeToEachKindOfProcess());
	}
}