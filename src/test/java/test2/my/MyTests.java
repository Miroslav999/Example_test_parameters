package test2.my;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
public class MyTests {
	
	@BeforeAll
	public static void beforeClass(TestInfo testInfo) {
		System.out.println();
	}
	
	
	@ParameterizedTest
	@ArgumentsSource(MyArgumentsProvider.class)
	public void test1(TestConnection conn) {
		System.out.println(conn.getName());
	}
	
}
