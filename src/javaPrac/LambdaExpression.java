package javaPrac;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

interface Drawable{
	
	public void draw(int width);
}

interface H1 {
	
	public int add(int a , int b);
}

public class LambdaExpression {

	public static void main(String args[])
	{
		
		Drawable dwb = new Drawable(){
			
			@Override
			public void draw(int width) {
				
				System.out.println("draw width = "+width);
			}
		};
		
		dwb.draw(20);
		
		Drawable dwb1 = (width)-> { System.out.println("lambda expression = "+width);};
		dwb1.draw(20);
		
	// Lambda without return
		
	H1 hn = (a,b) ->(a+b);
	
	// Lambda 
	
	H1 hm =(a,b)->{ return (a+b); };
	
      System.out.println("add = "+hn.add(20, 56) +" add with return = "+hm.add(70, 76));
      
      
    // iteration using lambda
      
      List<String> list=new ArrayList<String>();  
      list.add("ankit");  
      list.add("mayank");  
      list.add("sonu");  
      list.add("jai");
      
      list.forEach((n) -> System.out.println(n));
      
    // using Thread with Lambda 
      
      Runnable r1 = () ->{System.out.println("this thread");};
      
      Thread t1 = new Thread(r1);
      t1.start();
      
    // comparator with Lambda
      
      ArrayList<Employee> emp = new ArrayList<>();
      
      emp.add(new Employee(1l, "Brian", LocalDate.of(2018, Month.APRIL, 21)));
      emp.add(new Employee(4l, "Alex", LocalDate.of(2018, Month.APRIL, 22)));
      emp.add(new Employee(3l, "David", LocalDate.of(2018, Month.APRIL, 25)));
      emp.add(new Employee(2l, "Charles", LocalDate.of(2018, Month.APRIL, 23)));
      emp.add(new Employee(5l, "Edwin", LocalDate.of(2018, Month.APRIL, 24)));
      
      Collections.sort(emp ,(p1,p2) ->{return p1.getName().compareTo(p2.getName());});
      System.out.println("sort the Employee by id using comparator = "+emp);
      
      //Functional interface  --
        //1. Consumer 2. Preadicate 3. Function
      
      //Consumer 
      
      Consumer<String> c1 = (s) -> System.out.println(s.toUpperCase());
      c1.accept("sonu");
      Consumer<Employee> c2 =(s) -> System.out.print(s.getName().toUpperCase()+" ");
      Consumer<Employee> c3 =(s) -> System.out.print(s.getId()+" ");
     
      emp.forEach(c2); // forEach take parameter  Consume
      System.out.println();
      emp.forEach((em -> {
    	  
    	  if(em.getId()>=4)
    	  {
    		  c2.andThen(c3).accept(em);
    	  }
      }));
      
     // Biconsumer -- The only difference between biconsumer and consumer 
      
     System.out.println("\n"+"BiConsumer Example");
      BiConsumer<Integer,List<Employee>> bicon = (rollno, name) -> { 
    	  name.forEach(a -> { 
    		  if(a.getId()>rollno.intValue()) 
    		  {
    			  System.out.println(a.getName().toUpperCase());
    		  };
    	  }
    	  );
      };
      
     bicon.accept(3, emp);
     
    // Predicate -- predicate return boolean 
     
     Predicate<Integer> prev = (p) ->{ return p%2==0; };
     Predicate<Integer> preo = (p) -> { return p%5==0;};
     
     
     System.out.println("Predicate example = "+prev.test(4));
     System.out.println("Predicate and check = "+prev.and(preo).test(10));
     System.out.println("Predicate or check = "+prev.or(preo).test(5));
     
     //Together use of Consumer, BiConsumer and Predicatetor
     
     System.out.println("Example of combine biCnsumer, Consumer , Predicator");
     Predicate<Employee> cpr = (p)->{ return p.getId()>3;};
     BiConsumer<String,LocalDate> cbi = (p,j)->{System.out.println("name = "+p +"Dob = "+j);};
     Consumer<Employee> ccon = (p)->{
    	 if(cpr.test(p))
    	 {
    		 cbi.accept(p.getName(), p.getDob());
    	 }
    		 };
     emp.forEach(p->{ccon.accept(p);});
     
     BiPredicate<Integer,Double> bipre = (a,b)->{return a>3&&b>3.5;};
     System.out.println(bipre.test(7,4.2));
     
     // Function interface
     
     Function<String, String> fun =(p)->{ return p.toUpperCase();};
     Function<String, String> fun1 =(p)->{ return p.concat("kumar");};
     System.out.println("Eaxmple of function interface = "+fun.compose(fun1).apply("sonu"));
     Function<List<Employee>, Map<Long , String>> fun3 = (p)->{
    	 Map<Long, String> map = new HashMap<>();
    	 p.forEach(k->{
    		 if(cpr.test(k))
    		 {
    		  map.put(k.getId(), k.getName()); 
    		 }
    	 }
    	 );
    	 return map;
     };
      
     System.out.println("collection function example = "+fun3.apply(emp));
     
     //UnaryOperator and BinaryOperator
     
     UnaryOperator<Integer> un = (p)->{ return (p.intValue()+3);};
     System.out.println("Unaryoperator = "+un.apply(76));
     BinaryOperator<Integer> un1 = (a,b)->{ return (a.intValue()+b.intValue());};
     System.out.println("Biaryoperator example = "+un1.apply(20, 90));
     
     //suppier 
     
     Supplier<String> sup = ()->{return " this is supplier";};
     System.out.println("supplier = "+sup.get());
     
     //Method reference
     
     Function<String,String> mfun = (p)->{return p.toUpperCase();};
     Function<String,String> mfun1 = String::toUpperCase;
     System.out.println("using function interface = "+mfun.apply("sonu"));
     System.out.println("using function method referencce = "+mfun1.apply("sonu"));
     
       // classname::instanceMethodname
     
     Consumer<Employee> mcon = System.out::println;
     Consumer<Employee> mcon1 = Employee::toEmployee;
     emp.forEach((p)->{
    	     mcon1.accept(p); 
     }
     );
     
     // Constructor interface
     
     Supplier<Employee> csup = Employee::new;
     Function<String,Employee> cfun = Employee::new;
     System.out.println(csup.get());
     emp.forEach(p->{
    	 System.out.println(cfun.apply(p.getName()));
     });
     
     
     
     
	}
     
     }
	
