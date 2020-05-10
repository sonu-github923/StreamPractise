package javaPrac;

import java.util.Comparator;

public class NameSorter implements Comparator<Employee>{

	@Override
	public int compare(Employee arg0, Employee arg1) {
		return arg0.getId().compareTo(arg1.getId());
	}

}
