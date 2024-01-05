package it_academy.strategy.cocreteStrtegies;

import it_academy.ConstantContainer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThirdTypeStrategyTest {
	public static final double TEST_TALENT = 0.5;

	@Test
	void calculateTime() {

		int totalTime = (int) (ConstantContainer.TOTAL_LENGTH_OF_EDUCATION_PROCESS_FOR_TYPE_1_AND_TALENT_1
				* ConstantContainer.X_LENGTH_OF_EDUCATIONAL_PROCESS_FOR_TYPE_3
				/ TEST_TALENT);

		int timeToEachKindOfProcess = (totalTime / ConstantContainer.COUNT_OF_DIFFERENT_PROCESS_FOR_3_TYPE);

		ThirdTypeStrategy thirdTypeStrategy = new ThirdTypeStrategy();

		assertEquals(totalTime, thirdTypeStrategy.calculateTime(TEST_TALENT)[0]);
		assertEquals(timeToEachKindOfProcess, thirdTypeStrategy.calculateTime(TEST_TALENT)[1]);
	}
}