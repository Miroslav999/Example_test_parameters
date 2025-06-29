package framework;

import java.util.List;

public class Parameter<T> {
	private String name;
	private List<T> values;
	
	
	public Parameter(String name, List<T> values) {
		this.name = name;
		this.values = values;
	}
	
	
	public String getName() {
		return name;
	}
	
	public List<T> getValues() {
		return values;
	}
	
	
	
}
