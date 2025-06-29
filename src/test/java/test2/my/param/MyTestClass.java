package test2.my.param;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import framework.Parameter;
import framework.Rule;
import framework.Scenario;
import framework.TestFabric;

public class MyTestClass {

	@TestFactory
	DynamicTest[] dynamicTestsFromArray() {
		return new DynamicTest[] {
				// dynamicTest("8th dynamic test", () -> assertEquals(4, calculator.multiply(2,
				// 2)))
		};
	}

	/*
	 * @TestFactory DynamicTest[] dynamicTestsFromArray2() { Calculator calculator =
	 * new Calculator(); return new DynamicTest[] { dynamicTest("8th dynamic test",
	 * () -> assertEquals(4, calculator.multiply(2, 2))) }; }
	 */
	@TestFactory
	 Stream<DynamicTest> test1() {
		
		List<Parameter> params = new ArrayList();
		List<Rule> rules = null;

		List<Integer> counts = new ArrayList<Integer>();
		counts.add(0);
		counts.add(1);
		Parameter<Integer> reqCount = new Parameter<Integer>("количество реквизитов", counts);

		List<String> types = new ArrayList<String>();
		types.add("String");
		types.add("Number");
		types.add("Date");
		Parameter<String> reqType = new Parameter<String>("тип реквизита", types);

		List<String> tbp = new ArrayList<String>();
		tbp.add("Абстрактный");
		tbp.add("Может иметь таблицу");
		Parameter<String> typesTbp = new Parameter<String>("тип ТБП", tbp);

		params.add(reqCount);
		params.add(reqType);
		params.add(typesTbp);
	
		return new TestFabric().getTests(params);
	}
	final List<String> fruits = Arrays.asList("apple", "banana", "lemon");


	@ParameterizedTest
	@ArgumentsSource(MyArgumentsProvider.class)
	void testWithArgumentsSource(Scenario scenario) {
	    System.out.println(scenario.getName());
	}
	
}
