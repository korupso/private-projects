package ch.meccariello.macdb.sandbox;

public class ForeignKey {
	
	Object value = null;
	
	public ForeignKey(Object value) {
		this.value = value;
	}
	
	public String toString() {
		return value.toString();
	}
	
}
