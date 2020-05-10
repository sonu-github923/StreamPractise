package javaPrac;

public class IdSorter implements Comparable<Employee>
{

	@Override
	public int compareTo(Employee o) {
		
		return o.getId().compareTo(o.getId());
	}

}
