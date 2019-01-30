package ch.meccariello.macdb;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class Table {

	private ArrayList<ArrayList<Object>> table = new ArrayList<ArrayList<Object>>();
	private ArrayList<Class<?>> types = new ArrayList<Class<?>>();
	private ArrayList<String> names = new ArrayList<String>(Arrays.asList("ID"));
	
	private BigInteger lastID = new BigInteger("0");
	
	/* Add types to array */
	public Table(String[] names, Class<?>[] types) {
		if (names.length == types.length) {
			this.names.addAll(Arrays.asList(names));
			this.types.add(BigInteger.class);
			this.types.addAll(Arrays.asList(types));
		}
	}
	
	/* Add values */
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
	
	/* Remove values */
	public boolean deleteValues(BigInteger ID) {
		// Validation
		if (ID.compareTo(new BigInteger(table.get(table.size() - 1).get(0).toString())) > 0) {
			return false;
		}
		
		// Get object to be removed
		BigInteger toBeRemoved = new BigInteger("0");
		for (int i = 0; i < table.size(); i++) {
			if (ID.compareTo(new BigInteger(table.get(i).get(0).toString())) == 0) {
				toBeRemoved = new BigInteger(i + "");
			}
		}
		
		// Remove object
		table.remove(toBeRemoved.intValue());
		
		return true;
	}
	
	/* Create printable output */
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
		
		// Return names
		for (int i = 0; i < names.size(); i++) {
			String name = names.get(i);
			int temp = lengths.get(i) - name.length();
			String whitespace = "";
			for (int j = 0; j < temp; j++) {
				whitespace = whitespace + " ";
			}
			returnValue = returnValue + name + whitespace + " | ";
		}
		returnValue = returnValue + "\n";
		
		// Return formatting line
		int temp = (lengths.size() - 1) * 3;
		for (int i : lengths) {
			temp += i;
		}
		for (int i = -1; i <= temp; i++) {
			returnValue = returnValue + "-";
		}
		returnValue = returnValue + "\n";
		
		// Return values
		for (int i = 0; i < table.size(); i++) {
			for (int j = 0; j < table.get(i).size(); j++) {
				int temp1 = lengths.get(j) - table.get(i).get(j).toString().length();
				String whitespace = "";
				for (int k = 0; k < temp1; k++) {
					whitespace = whitespace + " ";
				}
				returnValue = returnValue + table.get(i).get(j) + whitespace + " | ";
			}
			returnValue = returnValue + "\n";
		}
		
		return returnValue;
	}
	
}
