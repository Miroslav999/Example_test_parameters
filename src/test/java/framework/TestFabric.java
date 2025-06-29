package framework;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.function.ThrowingConsumer;
import org.junit.jupiter.params.provider.Arguments;

import test2.my.param.Calculator;

public class TestFabric implements Arguments {

	private List<DynamicTest> tests;
	Calculator calculator = new Calculator();

	private List<Scenario> scenarios = new ArrayList<Scenario>();

	public DynamicTest[] getTests2(List<Parameter> parameters, List<Rule> rules) {

		return null;
	}

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

		// Начало сценария
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
