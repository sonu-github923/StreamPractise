package javaPrac;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamExample {

	public static void main(String args[])
	{
		
		
		ArrayList<Employee> emp = new ArrayList<>();
	      
	      emp.add(new Employee(1l, "Brian", LocalDate.of(2018, Month.APRIL, 21)));
	      emp.add(new Employee(4l, "Alex", LocalDate.of(2018, Month.APRIL, 22)));
	      emp.add(new Employee(3l, "David", LocalDate.of(2018, Month.APRIL, 25)));
	      emp.add(new Employee(2l, "Charles", LocalDate.of(2018, Month.APRIL, 23)));
	      emp.add(new Employee(5l, "Edwin", LocalDate.of(2018, Month.APRIL, 24)));
	      
	      
	      List<String> arstng =  Arrays.asList("sonu","kumar","thakur","sristy","sharma","sonu");
	      
	      // Stream example
	      
	      Predicate<Employee> pre = (p)->{ return p.getId()>2;};
	      Map<Long, String> str = emp.stream()
	    		  .peek(Employee->{
	    			  System.out.println(Employee);
	    		  })
	    		  .filter(pre)
	    		  .filter(Employee->Employee.getId()>3)
	    		  .peek(Employee->{
	    			  System.out.println("secound peek "+Employee);
	    		  })
	    		  .collect(Collectors.toMap(Employee::getId, Employee::getName));
	      System.out.println(str);
	      
	  // Stream Map Example -- how to use map() in stream    
	      List<String> mapstr=  emp.stream()   //  output - Stream<Employee>
	    	  	     .map(Employee::getName)         //  output - Stream<String> -- map() convert one type(stream<Employee>) to another type(Stream<String>)
	    	  	     .map(String::toUpperCase)
	    	  	     .collect(Collectors.toList());
	      System.out.println("collect as List = "+mapstr);
	      
	      Set<String> setstr = arstng.stream()
	    		                     .collect(Collectors.toSet());
	      System.out.println("collect as Set = "+setstr);
	      
	      
	      
	}
	
	
}
