package it_academy.context;

import it_academy.Types;
import it_academy.strategy.cocreteStrtegies.FirstTypeStrategy;
import it_academy.strategy.cocreteStrtegies.SecondTypeStrategy;
import it_academy.strategy.cocreteStrtegies.ThirdTypeStrategy;
import it_academy.strategy.TimeCalculator;

public class Student {

	private TimeCalculator calc;
	private Types type;
	private int totalTime;
	private int timeToEachKindOfProcess;
	private final double talent;

	public Student(Types type, double talent) {
		this.type = type;
		this.talent = talent;
		checkType();
	}

	public int getTotalTime() {
		return totalTime;
	}

	public int getTimeToEachKindOfProcess() {
		return timeToEachKindOfProcess;
	}

	public double getTalent() {
		return talent;
	}

	public void setType(Types type) {
		this.type = type;
		checkType();
	}

	private void checkType() {
		switch (type.getType()) {
			case 1:
				calc = new FirstTypeStrategy();
				break;
			case 2:
				calc = new SecondTypeStrategy();
				break;
			case 3:
				calc = new ThirdTypeStrategy();
				break;
		}
		calculateTimes();
	}

	private void calculateTimes() {
		int[] times = calc.calculateTime(talent);
		totalTime = times[0];
		timeToEachKindOfProcess = times[1];
	}

	@Override
	public String toString() {
		return "Student{" +
				" talent=" + talent +
				"; totalTime=" + totalTime +
				"; " + type +
				"; time To Each Type Of Training=" + timeToEachKindOfProcess +
				'}';
	}
}
