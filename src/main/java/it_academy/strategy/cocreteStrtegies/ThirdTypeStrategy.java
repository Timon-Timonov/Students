package it_academy.strategy.cocreteStrtegies;

import it_academy.ConstantContainer;
import it_academy.strategy.TimeCalculator;

public class ThirdTypeStrategy implements TimeCalculator {
	@Override
	public int[] calculateTime(double talent) {
		int[] time = new int[2];
		//totalTime:
		time[0] = (int) (ConstantContainer.TOTAL_LENGTH_OF_EDUCATION_PROCESS_FOR_TYPE_1_AND_TALENT_1
				*ConstantContainer.X_LENGTH_OF_EDUCATIONAL_PROCESS_FOR_TYPE_3
				/ talent);

		//timeToEachKindOfProcess:
		time[1] = (time[0] / ConstantContainer.COUNT_OF_DIFFERENT_PROCESS_FOR_3_TYPE);

		return time;
	}
}
