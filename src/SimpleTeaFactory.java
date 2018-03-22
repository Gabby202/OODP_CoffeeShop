
public class SimpleTeaFactory {
	
	
	public Tea getTea(String name){
		// Check for existence of '.'
		if (name.equals("milk")) {
			return new MilkTea();
		} else {
			return new BlackTea();
		}
	}
}
