package it_academy.strategy.cocreteStrtegies;

import it_academy.ConstantContainer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SecondTypeStrategyTest {
	public static final double TEST_TALENT = 0.5;

	@Test
	void calculateTime() {

		int totalTime = (int) (ConstantContainer.TOTAL_LENGTH_OF_EDUCATION_PROCESS_FOR_TYPE_1_AND_TALENT_1
				* ConstantContainer.X_LENGTH_OF_EDUCATIONAL_PROCESS_FOR_TYPE_2
				/ TEST_TALENT);

		int timeToEachKindOfProcess = (totalTime / ConstantContainer.COUNT_OF_DIFFERENT_PROCESS_FOR_2_TYPE);

		SecondTypeStrategy secondTypeStrategy = new SecondTypeStrategy();

		assertEquals(totalTime, secondTypeStrategy.calculateTime(TEST_TALENT)[0]);
		assertEquals(timeToEachKindOfProcess, secondTypeStrategy.calculateTime(TEST_TALENT)[1]);
	}
}