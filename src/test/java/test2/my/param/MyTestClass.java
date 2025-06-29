package test2.my.param;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import framework.Scenario;

public class MyTestClass {

	@ParameterizedTest
	@ArgumentsSource(MyArgumentsProvider.class)
	void testWithArgumentsSource(Scenario scenario) {
		System.out.println(scenario.paramsToString());
	}
	
}
