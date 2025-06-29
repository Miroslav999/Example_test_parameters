package framework;

import java.util.List;

import org.junit.jupiter.api.DynamicTest;

public interface ITestFabric {
	public DynamicTest[] getTests(List<IParameter> parameters);
}
