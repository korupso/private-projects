package ch.meccariello.M226.b.organigram;

import java.time.LocalTime;
import java.util.LinkedHashMap;

public class Schedule {

	public LinkedHashMap<String, Day> schedule;
	
	public Schedule(Day monday, Day tuesday, Day wednesday, Day thursday, Day friday, Day saturday, Day sunday) {
		schedule = new LinkedHashMap<>();
		schedule.put("Monday", monday);
		schedule.put("Tuesday", tuesday);
		schedule.put("Wednesday", wednesday);
		schedule.put("Thursday", thursday);
		schedule.put("Friday", friday);
		schedule.put("Saturday", saturday);
		schedule.put("Sunday", sunday);
	}
	
}

class Day {

	public LocalTime start;
	public LocalTime lunchStart;
	public LocalTime lunchEnd;
	public LocalTime end;
	
	public Day(String start, String lunchStart, String lunchEnd, String end) {
		this.start = LocalTime.parse(start);
		this.start = LocalTime.parse(lunchStart);
		this.start = LocalTime.parse(lunchEnd);
		this.start = LocalTime.parse(end);
		System.out.println(start.toString() + " " + start);
	}

	public LocalTime getStart() {
		return start;
	}

	public void setStart(LocalTime start) {
		this.start = start;
	}

	public LocalTime getLunchStart() {
		return lunchStart;
	}

	public void setLunchStart(LocalTime lunchStart) {
		this.lunchStart = lunchStart;
	}

	public LocalTime getLunchEnd() {
		return lunchEnd;
	}

	public void setLunchEnd(LocalTime lunchEnd) {
		this.lunchEnd = lunchEnd;
	}

	public LocalTime getEnd() {
		return end;
	}

	public void setEnd(LocalTime end) {
		this.end = end;
	}
	
	
	
}