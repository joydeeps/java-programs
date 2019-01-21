/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author josen
 */
public class ApplicaionOne {
    public static void main(String[] args) {
        
// Predefined Functional Interfaces        
// Predicate, Function, Consumer, Supplier
// BiPredicate, BiFunction, Biconsumer, BiSupplier, ...
// IntPredicate, IntFunction, ...

        Function<Integer, Integer> f = i->i*i;
        System.out.println("Square Root of 100 is: " + f.apply(100));
        System.out.println("Square Root of 1000 is: " + f.apply(1000));
        
        Predicate<Integer> p = i -> i%2 == 0;
        System.out.println("No. 5 is even number: " + p.test(5));
        System.out.println("No. 55 is even number: " + p.test(55));
        
// Annotating with @FunctionalInterface        
        InterfaceOne interface1 = () -> System.out.println("Functional Interface Example One!!!!");
        interface1.func1();
        
        InterfaceTwo interface2 = () -> System.out.println("Functional Interface Example Two!!!!");
        interface2.func1();
        
// Lambda Expresions used with threading.
// It will execute in child thread.
        Runnable r1 = () -> {
          for(int i = 0; i < 100; ++i) {
              System.out.println("Child Thread!!!!!!!!!!!!!!!!");
          }  
        };
        Thread t1 = new Thread(r1);
        t1.start();
        
// It will execute in parent (main) thread        
        for(int i = 0; i < 100; ++i) {
            System.out.println("Parent Thread!!!!!!!!!!!!!!!!");
        }
        
// Lamda expressions used with Collections.
        ArrayList<Integer> arrList1 = new ArrayList<>();
        arrList1.add(10);
        arrList1.add(100);
        arrList1.add(10000);
        arrList1.add(1023);
        arrList1.add(1025235);
        arrList1.add(10234);
        arrList1.add(1523523523);
        arrList1.add(10124);
        arrList1.add(1);
        
        System.out.println("Printing in Insertion order");
        System.out.println(arrList1);
        
// Sorting using Annonymous Innner Class        
        Collections.sort(arrList1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 < o2)
                    return -1;
                else if(o1 > o2)
                    return 1;
                else
                    return 0;
//              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }            
        });
        
// Printing using forEach method and Lamda Expressions.     
        System.out.println("Printing in Ascending order");
        arrList1.stream().forEach(i -> System.out.println(i));

// Normal Printing        
        System.out.println("Printing in Ascending order");
        System.out.println(arrList1);
        
// Sorting using Lamda Expressions
        Comparator<Integer> comp1 = (a, b) -> (a < b) ? -1 : (a > b) ? 1 : 0;
        Collections.sort(arrList1, comp1);

        System.out.println("Printing in Ascending order");
        arrList1.stream().forEachOrdered(i -> System.out.println(i));

        System.out.println("Printing in Descending order");
        Collections.sort(arrList1, (a, b) -> (a > b) ? -1 : (a < b) ? 1 : 0);
        arrList1.stream().forEachOrdered(i -> System.out.println(i));

        List<Integer> list1 = arrList1.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        
        System.out.println("Printing the Even elements");
        list1.stream().forEachOrdered(i -> System.out.println(i));
    
        ArrayList<Employee> arrList2 = new ArrayList<>();
        arrList2.add(new Employee("Joydeep", 220167));
        arrList2.add(new Employee("Sandeep", 220156));
        arrList2.add(new Employee("Pradeep", 220148));
        arrList2.add(new Employee("Deepdeep", 220198));
        arrList2.add(new Employee("Dhandeep", 220200));
        arrList2.add(new Employee("Randeep", 220067));
        
        System.out.println("Printing in Insertion order");
        arrList2.stream().forEach(i -> System.out.println(i));
        
        System.out.println("Printing in Descending order of EmployeeNumber");
        Collections.sort(arrList2, (a, b) -> (a.getEmployeeNumber() > b.getEmployeeNumber()) ? -1 : (a.getEmployeeNumber() < b.getEmployeeNumber()) ? 1 : 0);
        arrList2.stream().forEach(i -> System.out.println(i));
        
        System.out.println("Printing in Ascending order of EmployeeName / Alphabatical Order");
        Collections.sort(arrList2, (a, b) -> a.getEmployeeName().compareTo(b.getEmployeeName()));
        arrList2.stream().forEach(i -> System.out.println(i));
        
// Calling Static functions defined in interfaces.        
        System.out.println(InterfaceThree.func3());
    }        
}

@FunctionalInterface
interface InterfaceOne {
    void func1();
}

@FunctionalInterface
interface InterfaceTwo extends InterfaceOne {
// We get the func1() from the parent class    
//    void func1();
}

interface InterfaceThree {
    static String func3() {
        return "Static method in interface";
    }
}
