package framework;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.params.provider.Arguments;

public class Scenario {
	private String name="";
	private List<ScenarioParameter> params;
	
	
	public Scenario() {
		params = new ArrayList<ScenarioParameter>();
	}
	
	public void addScenarioParameter( ScenarioParameter scenarioParameter) {
		params.add(scenarioParameter);
	}
	
	public void copy(Scenario scenario) {
		scenario.name = new String(this.name);
		scenario.params = new ArrayList<>(this.params);
	}
	
	public String getName() {
		return name;
	}
	
}
