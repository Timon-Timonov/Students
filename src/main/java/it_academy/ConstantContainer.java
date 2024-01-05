package it_academy;

import java.util.Arrays;

public interface ConstantContainer {

	int COUNT_OF_STUDENTS_OF_EACH_TYPE = 3;
	int COUNT_OF_TYPES_OF_STUDENTS = 3;
	double MIN_TALENT_OF_STUDENTS = 0.1;
	double MAX_TALENT_OF_STUDENTS = 1.0;
	int ACCURACY_OF_TALENT_CALCULATIONS = 10;

	int X_LENGTH_OF_EDUCATIONAL_PROCESS_FOR_TYPE_1 = 1;
	int X_LENGTH_OF_EDUCATIONAL_PROCESS_FOR_TYPE_2 = 2;
	int X_LENGTH_OF_EDUCATIONAL_PROCESS_FOR_TYPE_3 = 3;

	int COUNT_OF_DIFFERENT_PROCESS_FOR_1_TYPE = 3;
	int COUNT_OF_DIFFERENT_PROCESS_FOR_2_TYPE = 2;
	int COUNT_OF_DIFFERENT_PROCESS_FOR_3_TYPE = 1;

	int TOTAL_LENGTH_OF_EDUCATION_PROCESS_FOR_TYPE_1_AND_TALENT_1 = 198;


	enum Types {

		ONE(1, new String[]{"potok", "razbor", "practic"}),
		TWO(2, new String[]{"razbor", "practic"}),
		THREE(3, new String[]{"practic"});

		private int type;
		private String[] typesOfTraining;

		public int getType() {
			return type;
		}

		public String[] getTypesOfTraining() {
			return typesOfTraining;
		}

		Types(int type, String[] typesOfTraining) {
			this.type = type;
			this.typesOfTraining = typesOfTraining;
		}

		@Override
		public String toString() {
			return "type=" + type +
					"; typesOfTraining: " + Arrays.toString(typesOfTraining);
		}
	}

}
