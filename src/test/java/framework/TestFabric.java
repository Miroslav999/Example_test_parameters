package framework;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.params.provider.Arguments;

public class TestFabric implements Arguments {

	private List<DynamicTest> tests;

	private List<Scenario> scenarios = new ArrayList<Scenario>();

	public Stream<DynamicTest> getTests(List<Parameter> parameters) {
		getScenario(parameters, null, null);
		
		return null;
	}
	
	public  List<Scenario>  getTestsScenario(List<Parameter> parameters) {
		getScenario(parameters, null, null);
		return scenarios;
	}

	private void getScenario(List<Parameter> parameters, Parameter currentParameter, Scenario scenario) {

		if (parameters.size() == 0) {
			scenarios.add(scenario);
			return;
		}

		if (scenario == null) {
			scenario = new Scenario();
		}
		
		List<Parameter> copyParameters = new ArrayList<Parameter>(parameters);
		currentParameter = copyParameters.get(0);
		copyParameters.remove(0);

		for (Object value : currentParameter.getValues()) {
			
			Scenario sc1 = new Scenario();
			scenario.copy(sc1);
			
			ScenarioParameter param = new ScenarioParameter(currentParameter.getName(), value);
			sc1.addScenarioParameter(param);
			
			getScenario(copyParameters, currentParameter, sc1);
		}

	}

	@Override
	public Object[] get() {
		return scenarios.toArray();
	}

}
