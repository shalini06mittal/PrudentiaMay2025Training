package collections;

import java.util.ArrayList;
import java.util.TreeSet;

public class ListDemo {

    public static void main(String[] args) {

        // arrays - size, store data of same type
        // Data structures [ Collection Framework ]- Collection ( Interface ), Collections (Class)
        // Interface - store data, serialization and deserialization
        // list, queue, set and map (key-value)
        // List -> ArrayList, LinkedList
        // Set -> hashSet, Linkedhasheset, TreeSet [ SortedSet -> Set ]
        // queue - PriorityQueue, LinkedList
        // map -> HashMap, LinkedHashMap, TreeMap [ SortedMap -> Map ]
        ArrayList<Integer> nos = new ArrayList<>();
        System.out.println(nos.size());
        nos.add(10);
        nos.add(40);
        nos.add(20);
        nos.add(80);
        nos.add(10);
        System.out.println(nos.size());
        System.out.println(nos);
        System.out.println(nos.get(3));
        nos.remove(2);
        System.out.println(nos);
        nos.add(4,100);
        System.out.println(nos);
        nos.add(2,200);
        System.out.println(nos);
        nos.sort(null);
        System.out.println(nos);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1,"Shalini","Mumbai"));
        employees.add(new Employee(4,"Asha","Delhi"));
        employees.add(new Employee(2,"Ronak","Pune"));
        employees.add(new Employee(5,"Pallavi","Mumbai"));
        employees.add(new Employee(3,"Prashant","Patna"));

        employees.sort(null);
        for(Employee employee:employees)
            System.out.println(employee);

        employees.sort(new EmployeeCityComparator());
        for(Employee employee:employees)
            System.out.println(employee);



    }
}
