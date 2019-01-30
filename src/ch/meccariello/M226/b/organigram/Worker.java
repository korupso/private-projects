package ch.meccariello.M226.b.organigram;

import java.util.Map.Entry;

public class Worker extends Person {
	
	private Double salary;
	private Schedule schedule;
	private boolean overtime;
	
	public Worker(String firstName, String lastName, String birthdate, Double salary, Schedule schedule, boolean overtime) {
		super(firstName, lastName, birthdate);
		this.salary = salary;
		this.schedule = schedule;
		this.overtime = overtime;
	}
	
	public void getSchedule() {
		String res = super.getFirstName() + " " + super.getLastName() + " works ";
		for (Entry<String, Day> day : schedule.schedule.entrySet()) {
			res += day.getKey() + "s from " + day.getValue().getStart().toString() + " to " + day.getValue().getEnd().toString() + "\n";
		}
		res += "\n";
		System.out.println(res);
	}
	
}
