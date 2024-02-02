package it_academy;

import java.util.Arrays;


public enum Types {

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

