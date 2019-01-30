package ch.meccariello.sorting.ressources;

import java.util.List;

public interface Sort {
	
	public List<Integer> sort(List<Integer> numbers);
	
	public Object sort(List<Integer> numbers, boolean verbose);
	
}
