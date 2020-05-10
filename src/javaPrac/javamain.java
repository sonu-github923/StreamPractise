package javaPrac;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class javamain {

	public static void main(String[] args) {
       // System.out.println("sonu kumar");

	   
        ArrayList al = new ArrayList(); // Define arrayList in generic form
        ArrayList<String> al2 = new ArrayList<String>(); // Define arrayList in specific type
        al2.add("rudra");
        al2.add("siva");
        al2.add("LowKush");
        al.add("sonu"); 
        //al.add(1);
        al.add("kumar"); al.add("Srri Ram"); al.add(3,"LowKush");
        
        //method of Iteration of List
        //1. ListIteration 
        //ListIterator<String> lt= al.listIterator(al.size());
       // while(lt.hasPrevious()) {
        //System.out.println(lt.previous());
        //}
        //System.out.println("iteration in top to bottom");
        
        //while(lt.hasNext()) { System.out.println(lt.next());}
        
        //2. iteration with foreach loop add forEachRemaining
        //System.out.println("iteration using for loop");
        //for(String obj:al2) {System.out.println(obj);}
        //System.out.println("iteration using foreach loop");
        //al2.forEach(a->{System.out.println(a);});
        //System.out.println("iteration using forEachremaing");
        //Iterator<String> itr = al.iterator();
        Iterator itr2 = al.iterator();
        itr2.forEachRemaining(a->{System.out.println(a);});
        
        al.remove("sonu");
        al.removeIf(a->a.equals("kumar"));
        al.retainAll(al2);  //to get common element between two array
        al.add(1,"SiyaRam");
        al.set(1, "Sri Ram");
        System.out.println("isempty check="+al.isEmpty());
        
        
       //serialization and deserialization
        
       try {
    	   FileOutputStream fos = new FileOutputStream("D:\\sonu.txt");
    	   ObjectOutputStream oos =  new ObjectOutputStream(fos);
    	   oos.writeObject(al);
    	   fos.close();
    	   oos.close();
    	   //deserialization 
    	   
    	   FileInputStream fis = new FileInputStream("D:\\sonu.txt");
    	   ObjectInputStream ois = new ObjectInputStream (fis);
    	   ArrayList alt = (ArrayList)ois.readObject();
    	   System.out.println(alt);
    	   
    	   
       }
       
       catch(Exception e)
       {
    	   
       }
       
       Collections.swap(al, 0, 1); //to swap element between two index
       System.out.println(al);
       
       Object[] obj = al.toArray();
       //String[] str1 = new String[al.size()];
       //str1 = (String[]) al.toArray();
       
    // converting arrayList to array toArray() return object -------
       
       String[] strArray = (String[]) al.toArray(new String[al.size()]); 
       String[] strar = (String[]) al.stream().toArray(String[]::new);
       for(Object ob:obj)
       {
    	   System.out.println(ob+" ");
       }
       System.out.println("convert arrayList to array="+Arrays.toString(strArray));
       
       String[] namesArray = new String[] {"alex", "brian", "charles", "david"};
       List<String> nameList = Arrays.asList(namesArray);
       String a=nameList.get(1);
       System.out.println("convert Array to mutuable ArrayList = "+a);
       List<String> nameList2 =Collections.unmodifiableList(Arrays.asList(namesArray));
       //nameList2.add("kumar");
       System.out.println("convert Array to unmodified List="+nameList2);
       
       // Splitertor---------
       
       ArrayList<Integer> spt = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11));
       Spliterator<Integer> st = spt.spliterator();
       st.tryAdvance(d->System.out.println(d));
       st.tryAdvance(d->System.out.println(d));
       Spliterator<Integer> st1 = st.trySplit();
       Spliterator<Integer> st2 =st.trySplit();
       System.out.println("size of splittor = "+st.getExactSizeIfKnown());
       st.forEachRemaining(ab ->System.out.println(ab));
       System.out.println("size of trysplit="+st1.getExactSizeIfKnown());
       st1.forEachRemaining(av -> System.out.println(av));
       System.out.println("size of trysplit="+st2.getExactSizeIfKnown());
       st2.forEachRemaining(avb -> System.out.println(avb));
       
       
       //subList-------
       
       ArrayList<Integer> sub = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11));
       ArrayList<Integer> sub1 = new ArrayList<>(sub.subList(4, sub.size()));
       System.out.println(sub1);
       sub1.subList(3,5).clear();
       System.out.println("sublist element remove = "+sub1);
       
       // ensure the size of arraylist using ensurecapacity -------
       
       ArrayList<String> lst = new ArrayList<>(4);
       lst.add("sonu");
       System.out.println("size of arraylist="+lst.size());
       lst.ensureCapacity(10);
       System.out.println("again size of arraylist="+lst.size());
       
       // using comparator to sort list of object
       
       ArrayList<Employee> emp = new ArrayList<>();
       
       emp.add(new Employee(1l, "Brian", LocalDate.of(2018, Month.APRIL, 21)));
       emp.add(new Employee(4l, "Alex", LocalDate.of(2018, Month.APRIL, 22)));
       emp.add(new Employee(3l, "David", LocalDate.of(2018, Month.APRIL, 25)));
       emp.add(new Employee(5l, "Charles", LocalDate.of(2018, Month.APRIL, 23)));
       emp.add(new Employee(2l, "Edwin", LocalDate.of(2018, Month.APRIL, 24)));
       
       //emp.sort(new NameSorter());
       //Collections.sort(emp, Collections.reverseOrder());
       System.out.println(emp);
       
       // LinkedList --- linkedlist and arraylist both are list only difference is one hold element using index and one 
                         // with next address list
       LinkedList<Employee> lst1 = new LinkedList<Employee>();
       lst1.addAll(emp);
       LinkedList<Employee> lst2 = emp.stream()
				                               .collect(Collectors.toCollection(LinkedList::new));;
       System.out.println(lst2);
       
       // Java Comparator interface imposes a total ordering on the objects which may not have a natural ordering.
       //Comparator<Employee> comp = Comparator.comparing(Employee::getName);
       //Collections.sort(emp,comp);
       
       Comparator.comparing(Employee :: getName).thenComparing(Employee:: getId);
       //Collections.sort(emp, Comparator.comparing(Employee :: getName).reversed());
       System.out.println("emp ="+emp);
        
	}

}
