package javaPrac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import javaPrac.MapHelper.MapHelper1;
import javaPrac.MapHelper.MapHelper2;
import javaPrac.MapHelper.MapHelper3;
import javaPrac.MapHelper.MapHelper4;

public class MapandSet {

	public static void main(String[] args) {
	
	System.out.println("this is map and set");
	
	//HashMap - does not maintain order  - Cloneable, Serializable
	//treeMap - maintain ascending order
	//LinkedHashMap - it main insertion order
	
	Map<Integer,String> map = new HashMap<Integer, String>();
	map.put(1, "sonu"); map.put(2, "kumar");
	
	//Entry is the subinterface of Map. So we will be accessed it by Map.Entry name.
	//It returns a collection-view of the map, whose elements are of this class.
	
	//iterate using set
	
	Set set = map.entrySet();
	Iterator itr = set.iterator();
	while(itr.hasNext())
	{
		Map.Entry entry =(Map.Entry)itr.next();
		System.out.println(entry.getKey()+" "+entry.getValue());
	}
	// iteration using for loop
	for(Map.Entry  m :map.entrySet())
	{
		System.out.println(m.getKey()+" "+m.getValue());
	}
	
	Iterator<Integer> kryitr = map.keySet().iterator(); // iteration using key
	Iterator<Entry<Integer, String>> entitr = map.entrySet().iterator(); // iteration using entryset
	//System.out.println(map);
	
	// testing of hashmap for user define class
	
	HashMap<Student,String> map1 = new HashMap<>();
	Student stud1 = new Student(1,"sonu");
	Student stud2 = new Student(2,"kumar");
	
	map1.put(stud1, stud1.getName());
	map1.put(stud2, stud2.getName());
	System.out.println("hashcode and value = "+stud1.hashCode()+" "+map1.get(stud1));
	System.out.println("hashcode and value = "+stud2.hashCode()+" "+map1.get(stud2));
	Student stud3 = new Student(2,"thakur");
	Student stud4=stud1;
	stud4.setName("thakur");
	//map1.put(stud4, stud4.getName());
	System.out.println("hashcode and value = "+stud4.hashCode()+" "+map1.get(stud4)+" "+stud1.hashCode());
	
	//testing ConcurrentHashMap
	
	Map<String, Integer> hashMap = new HashMap<>();
	//Map<String, Integer> syncMap = Collections.synchronizedMap(hashMap);
	Map<String, Integer> syncMap = new ConcurrentHashMap<>();
//	MapHelper1 mapHelper1 = new MapHelper1(syncMap);
//	MapHelper2 mapHelper2 = new MapHelper2(syncMap);
//	MapHelper3 mapHelper3 = new MapHelper3(syncMap);
//	MapHelper4 mapHelper4 = new MapHelper4(syncMap);

//	for (Map.Entry<String, Integer> e : syncMap.entrySet()) {
//		System.out.println(e.getKey() + "=" + e.getValue());
//	}
//	
	
	// HashTable --- contain array of List -- hashtable does not accept key and value as null
	
	Map<Integer, String> map2 = new HashMap<Integer, String>();
	map2.put(1,"sonu");
	map2.put(2,"kumar");
	map2.put(3,"thakur");
	map2.put(1,"sonu");
	map2.put(2,"ff");
	System.out.println(map2.getOrDefault(4, "kolkata")); // work as if else statment
	System.out.println(map2.getOrDefault(1 ,"kolkata"));
	map2.putIfAbsent(2,"sristy");
	map2.putIfAbsent(4,"new town");
	System.out.println(map2);
	System.out.println(map2.size());
	map2.remove(1,"jj");  // remove element  "jj" if it allocated at index at 1
	map2.replace(1, "sonu", "sristy"); // replace old value to new value
	map2.replaceAll((key, oldValue) -> oldValue + " weds sristy");
	System.out.println(map2);
	map2.compute(1, (k,v) -> v+" hai");
	System.out.println(map2);
	map2.computeIfAbsent(5, k -> "hello everyone");
	System.out.println(map2);
	map2.computeIfPresent(5,(k,v) -> v+" nameste");
	System.out.println(map2);
	map2.merge(5, "Hai",(k,v) -> k+v);
	System.out.println(map2);
	System.out.println("contain key="+map2.containsKey(5)+" contain value= "+map2.containsValue("new town weds sristy"));

	// HashTable   is simliar as hashMap all operation same as hashMap
	
	//TreeMap
	
	TreeMap<String, Integer> numbers = new TreeMap<>();
    numbers.put("First", 1);
    numbers.put("Second", 2);
    numbers.put("Third", 3);
    numbers.put("Fifth", 5);
    numbers.put("Sixth", 6);
    numbers.put("xith", 43);
	
	System.out.println("first key = "+numbers.firstKey()+" last key = "+numbers.lastKey()+" last entry = "+numbers.lastEntry()+ " first entry = "+numbers.firstEntry());
	
	System.out.println("higher key = "+numbers.higherKey("Third"));
	System.out.println("higher entry ="+numbers.ceilingKey("Third"));
	System.out.println("HeadMap = "+numbers.headMap("Sixth", true));
	System.out.println("tailMap ="+numbers.tailMap("Third"));
	System.out.println("subMap = "+numbers.subMap("Secound", false , "Sixth" , true));
	
	ArrayList<String> list = new ArrayList<>();
	 
	list.add("E");
	list.add("A");
	list.add("C");
	list.add("B");
	list.add("D");
	
	Collections.sort(list, Collections.reverseOrder());
	//Arrays.sort(list);
	System.out.println(list);
	
	
	}

}
