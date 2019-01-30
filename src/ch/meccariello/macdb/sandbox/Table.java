package ch.meccariello.macdb.sandbox;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class is able to save, delete and print values
 * in a database-like fashion.
 * 
 * @author Joel Meccariello
 */
public class Table {

	private ArrayList<ArrayList<Object>> table = new ArrayList<ArrayList<Object>>();
	private ArrayList<Class<?>> types = new ArrayList<Class<?>>();
	private ArrayList<String> names = new ArrayList<String>(Arrays.asList("ID"));
	
	private BigInteger lastID = new BigInteger("0");
	
	/**
	 * This constructor creates a new Table with names and types.
	 * 
	 * @param names The names of the columns.
	 * @param types The types of the fields.
	 */
	public Table(String[] names, Class<?>[] types) {
		if (names.length == types.length) {
			this.names.addAll(Arrays.asList(names));
			this.types.add(BigInteger.class);
			this.types.addAll(Arrays.asList(types));
		}
	}
	
	/**
	 * This method adds a new row to the table.
	 * 
	 * @param values The values of the row.
	 * @return Returns true if the method succeeds.
	 */
	public boolean addValues(Object[] values) {
		// Validation
		if (values.length != types.size() - 1) {
			System.out.println("size");
			return false;
		}
		
		for (int i = 0; i < values.length; i++) {
			if (!types.get(i + 1).equals(values[i].getClass())) {
				return false;
			}
		}
		
		// Add new values
		ArrayList<Object> row = new ArrayList<Object>(Arrays.asList(lastID.add(new BigInteger("1"))));
		lastID = lastID.add(new BigInteger("1"));
		row.addAll(Arrays.asList(values));
		
		return table.add(row);
	}
	
	/**
	 * This method removes a row from the table.
	 * 
	 * @param ID The ID of the row that will be deleted.
	 * @return Returns true if the method succeeds.
	 */
	public boolean deleteValues(String ID) {
		BigInteger IDbi = new BigInteger(ID);
		
		// Validation
		if (IDbi.compareTo(new BigInteger(table.get(table.size() - 1).get(0).toString())) > 0) {
			return false;
		}
		
		// Get object to be removed
		BigInteger toBeRemoved = new BigInteger("0");
		for (int i = 0; i < table.size(); i++) {
			if (IDbi.compareTo(new BigInteger(table.get(i).get(0).toString())) == 0) {
				toBeRemoved = new BigInteger(i + "");
			}
		}
		
		// Remove object
		table.remove(toBeRemoved.intValue());
		
		return true;
	}
	
	/**
	 * This method processes the query and finds the desired value.
	 * 
	 * @param ID The ID of the desired row.
	 * @param field The name of the field.
	 * @return Returns the value if found. If not found returns false.
	 */
	public Object query(String ID, String field) {
		int position = 0;
		
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).equals(field)) {
				position = i;
			}
		}
		if (names.contains(field)) {
			for (ArrayList<Object> row : table) {
				if (row.get(0).equals(new BigInteger(ID))) {
					return row.get(position);
				}
			}
		}
		return false;
	}
	
	/**
	 * This method compiles the entire table into a readable string.
	 * 
	 * @return Returns the entire table as a string. Neatly formatted, if I may say so myself.
	 */
	public String toString() {
		
		String returnValue = "";
		
		// Get lengths for formatting
		ArrayList<Integer> lengths = new ArrayList<Integer>();
		for (int i = 0; i < names.size(); i++) {
			lengths.add(names.get(i).length());
		}
		for (int i = 0; i < table.size(); i++) {
			ArrayList<Object> row = table.get(i);
			for (int j = 0; j < row.size(); j++) {
				Object field = row.get(j);
				if (lengths.get(j) < field.toString().length()) {
					lengths.set(j, field.toString().length());
				}
			}
		}
		
		// Add formatting line to return value
		String line = "";
		int temp = (lengths.size() - 1) * 3;
		for (int i : lengths) {
			temp += i;
		}
		for (int i = 0; i < temp + 4; i++) {
			line = line + "-";
		}
		returnValue = returnValue + line + "\n| ";
		
		// Add names to return value
		for (int i = 0; i < names.size(); i++) {
			String name = names.get(i);
			int temp1 = lengths.get(i) - name.length();
			String whitespace = "";
			for (int j = 0; j < temp1; j++) {
				whitespace = whitespace + " ";
			}
			returnValue = returnValue + name + whitespace + " | ";
		}
		returnValue = returnValue + "\n";
		
		// Add second formatting line to return value
		returnValue = returnValue + line + "\n";
		
		// Add values to return value
		for (int i = 0; i < table.size(); i++) {
			returnValue = returnValue + "| ";
			for (int j = 0; j < table.get(i).size(); j++) {
				Object value = table.get(i).get(j);
				int temp1 = lengths.get(j) - value.toString().length();
				String whitespace = "";
				for (int k = 0; k < temp1; k++) {
					whitespace = whitespace + " ";
				}
				if (value.getClass().equals(ForeignKey.class)) {
					value = value.toString();
				}
				returnValue = returnValue + value + whitespace + " | ";
			}
			returnValue = returnValue + "\n";
		}
		
		// Add tailing formatting line to return value
		returnValue = returnValue + line + "\n";
		
		return returnValue;
	}
	
	/**
	 * This method adds the foreign key functionality.
	 * 
	 * @param foreign This parameter takes the desired table to connect to.
	 * @param ID The ID of the row in the foreign table.
	 * @return The foreign key.
	 */
	public ForeignKey foreignKey(Table foreign, String ID) {
		
		
		return null;
	}
}
