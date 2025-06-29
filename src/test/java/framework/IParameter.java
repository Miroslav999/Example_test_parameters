package framework;

import java.util.List;

public interface IParameter<T> {
	
	public String getName();
	
	public List<T> getValues();
}
