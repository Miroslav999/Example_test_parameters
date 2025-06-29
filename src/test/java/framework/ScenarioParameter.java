package framework;


public class ScenarioParameter {
	private String name;
	private Object value;
	
	
	public ScenarioParameter(String name, Object value) {
		this.name = name;
		this.value = value;
	}
	
	
	public String getName() {
		return name;
	}
	
	public Object getValue() {
		return value;
	}
}
