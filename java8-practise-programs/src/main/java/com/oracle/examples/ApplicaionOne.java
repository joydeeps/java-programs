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
import java.util.function.Consumer;
import java.util.function.Supplier;
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
// Supplier

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
        
// Using Predicate to validate.
        String[] names = {"Joydeep", "Sandeep", "Randeep", "Shubhadeep", "Praadeep"};
        Predicate<String> pred1 = name -> name.length() % 2 == 0;
        for(String s1 : names) {
            if(pred1.test(s1)) {
                System.out.println("Names with even no. of characters: " + s1);
            }
        }
        
// Predicate Joining using and(), or() and negate().   
        Integer[] numbers = {1561, 5615, 789, 465161, 64865, 64316, 7893};
        Predicate<Integer> pred2 = num -> num % 2 == 0;
        Predicate<Integer> pred3 = num -> num > 9999;
        
        for(Integer number : numbers) {
            if(pred2.and(pred3).test(number)) {
                System.out.println("Even no's and greater than 9999: " + number);
            }
            
            if(pred2.or(pred3).test(number)) {
                System.out.println("Even no's OR greater than 9999: " + number);
            }
            
            if(pred2.negate().test(number)) {
                System.out.println("Odd no's: " + number);
            }
        }

// Function Chaining        
        Function<Integer, Integer> func1 = i -> 2 * i;
        Function<Integer, Integer> func2 = i -> i *i * i;
        
        System.out.println("Function Chaining: " + func1.andThen(func2).apply(10));
        System.out.println("Function Chaining: " + func1.compose(func2).apply(10));
        
// Consumer
        String[] members = {"Joydeep", "Sandeep", "Randeep", "Shubhadeep", "Praadeep"};
        System.out.println("Printing using Consumer.!!!!!!");
        Consumer<String> con1 = (s1) -> System.out.println(s1);
        for(String member : members) {
            con1.accept(member);
        }

// Supplier
        Supplier<Double> suppl1 = () -> {
            return Math.random() * 10;
        };
        System.out.println("Random Number: " + suppl1.get());
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
@FunctionalInterface
interface InterfaceFour {
    void func4();
}    

@FunctionalInterface
interface InterfaceFive {
    void func5();
}
