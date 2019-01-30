package ch.meccariello.M226.b.organigram;

public class Manager {

	public static void main(String[] args) {

		Worker worker = new Worker("Joel", "Meccariello", "2000-07-20", 4100.0,
				new Schedule(
						new Day("07:50", "12:15", "13:00", "17:50"),
						new Day("07:50", "12:15", "13:00", "17:00"),
						new Day("07:50", "12:15", "13:00", "17:00"),
						new Day("07:50", "12:15", "13:00", "17:00"),
						new Day("07:50", "12:15", "13:00", "17:00"),
						new Day("07:50", "12:15", "13:00", "17:00"),
						new Day("07:50", "12:15", "13:00", "17:00")),
				false);

		Day test = new Day("07:50", "12:15", "13:00", "17:00");
		System.out.println(test.toString());
		
		worker.getSchedule();

	}

}
