package ch.meccariello.macdb;

public class Database {

	public static void main(String[] args) {
		/* Add new Table */
		Table table = new Table(
			// Add names
			new String[] {
				"name",
				"is_alive"
			},
			// Add types
			new Class<?>[] {
				String.class,
				Boolean.class
			}
		);
		
		/* Add values to table */
		table.addValues(new Object[] {
			"Joel Thanabalasingam-Meccariello",
			false
		});
		table.addValues(new Object[] {
			"Thamisha Thanabalasingam-Meccariello",
			true
		});
		
		/* Print table */
		System.out.println(table.toString());
	}
	
}
