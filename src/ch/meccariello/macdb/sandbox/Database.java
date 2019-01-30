package ch.meccariello.macdb.sandbox;

public class Database {

	public static void main(String[] args) {
		Table address = new Table(
			new String[] {
				"street_and_number",
				"town"
			},
			new Class<?>[] {
				String.class,
				String.class
			}
		);
		address.addValues(new Object[] {
			"Schachenweg 10",
			"Uster"
		});
		
		/* Add new Table */
		Table person = new Table(
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
		person.addValues(new Object[] {
				"Joel Meccariello",
				false,
				person.foreignKey(address, "1")
			});
		person.addValues(new Object[] {
				"Thamisha Meccariello",
				true
			});
		
		/* Print table */
		System.out.println(person.toString());
	}
	
}
