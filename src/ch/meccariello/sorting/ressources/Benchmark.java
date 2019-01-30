package ch.meccariello.sorting.ressources;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Benchmark {
	
	private static ArrayList<ArrayList<Integer>> cases;
	
	public static void run(int[] sortConfig, Class<?>[] sortClasses) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
		ArrayList<Sort> sorts = new ArrayList<Sort>() {{
			for (Class<?> sort : sortClasses) add((Sort) sort.getConstructor().newInstance());
		}};
		
		cases = NumberGenerator.start(sortConfig);
		
		printUnsorted(cases);
		
		for (Sort sort : sorts) {
			
			long ns = measureSort(sort);
			
			System.out.println("Time took to calculate: " + String.format("%,d%s\n", ns, " ns"));
			
			System.gc();
		}
	}
	
	private static void printUnsorted(ArrayList<ArrayList<Integer>> cases) {
		if (NumberGenerator.isNotTooLong()) {
			System.out.println("Unsorted"
					+ "\nBest case:    " + cases.get(0)
					+ "\nAverage case: " + cases.get(1)
					+ "\nWorst case:   " + cases.get(2)
					+ "\n");
		} else {
			System.out.println("Unsorted Lists with " + NumberGenerator.length() + " integers, the highest one being " + (NumberGenerator.top() - 1) + ".\n");
		}
	}
	
	private static long measureSort(Sort sort) {
		ArrayList<ArrayList<Integer>> tempCases = cases.stream().map(list -> new ArrayList<>(list)).collect(Collectors.toCollection(ArrayList::new));
		long ns = 0;
		long start_ns;
		boolean notTooLong = NumberGenerator.isNotTooLong();
		Object[] css = new Object[3];
		String[] complexityCases = new String[] {sort.getClass().getSimpleName() + "\nBest case:    ", "Average case: ", "Worst case:   "};
		
		for (int i = 0; i < 3; i++) {
			System.out.print(complexityCases[i]);
			start_ns = System.nanoTime();
			css[i] = sort.sort(tempCases.get(0), notTooLong);
			long temp = System.nanoTime() - start_ns;
			ns += temp;
			System.out.print(css[i] + String.format(" (%,d%s\n", temp, " ns)"));
		}
		css = new Object[3];
		tempCases = null;
		
		return ns;
	}
	
}
