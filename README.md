The test project demonstrates the capabilities of junit 5. Thanks to org.junit.jupiter.params.provider.ArgumentsSource you can define your own ArgumentsProvider, which implements an algorithm for completely iterating through the testing parameters
For example, at the input we have three testing parameters:
1. Parameter 1 with values 0, 1
2. Parameter 2 with values String,Number,Date
3. Parameter 3 with values Abstract, Not abstract.

The method framework.TestFabric.getTestsScenario(List<Parameter>) receives the test parameters as input, and returns a list of scenarios corresponding to a complete enumeration of the test parameters.

Output:
```
0 String Abstract 
0 String Not abstract 
0 Number Abstract 
0 Number Not abstract 
0 Date Abstract 
0 Date Not abstract 
1 String Abstract 
1 String Not abstract 
1 Number Abstract 
1 Number Not abstract 
1 Date Abstract 
1 Date Not abstract 
```
