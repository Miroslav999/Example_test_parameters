package test2.my.param;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import framework.Parameter;
import framework.TestFabric;

public class MyArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
    	
    	List<Parameter> params = new ArrayList();

		List<Integer> counts = new ArrayList<Integer>();
		counts.add(0);
		counts.add(1);
		Parameter<Integer> reqCount = new Parameter<Integer>("Parameter 1", counts);

		List<String> types = new ArrayList<String>();
		types.add("String");
		types.add("Number");
		types.add("Date");
		Parameter<String> reqType = new Parameter<String>("Parameter 2", types);

		List<String> tbp = new ArrayList<String>();
		tbp.add("Abstract");
		tbp.add("Not abstract");
		Parameter<String> typesTbp = new Parameter<String>("Parameter 3", tbp);

		params.add(reqCount);
		params.add(reqType);
		params.add(typesTbp);
	    	
        return new TestFabric().getTestsScenario(params).stream().map(p-> Arguments.of(p));
    }
}