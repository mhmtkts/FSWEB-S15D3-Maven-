package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {


    public static void main(String[] args) {

        List<Employee> employees = new LinkedList<>();

        employees.add(new Employee(1, "Ahmet", "Şirket"));
        employees.add(new Employee(1, "Ahmet", "Şirket"));
        employees.add(new Employee(2, "Mahmut", "Aktaş"));
        employees.add(new Employee(3, "Ali", "Eleman"));
        employees.add(new Employee(4, "Veli", "Alım"));
        employees.add(new Employee(4, "Veli", "Alım"));
    }

    public static List<Employee> findDuplicates(List<Employee> employees) {
        List<Employee> duplicates = new LinkedList<>();
        Map<Integer, Employee> employeeMap = new HashMap<>();

        for (Employee employee : employees) {
            if (employee == null) {
                System.out.println("Null employee detected");
                continue;
            }
            if (employeeMap.containsKey(employee.getId())) {
                duplicates.add(employee);
            } else {
                employeeMap.put(employee.getId(), employee);
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        Map<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            if (employee == null) {
                System.out.println("Null employee detected");
                continue;
            }
            if (!employeeMap.containsKey(employee.getId())) {
                employeeMap.put(employee.getId(), employee);
            }
        }
        return employeeMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        List<Employee> duplicatesEmployee = findDuplicates(employees);
        Map<Integer, Employee> uniques = findUniques(employees);

        List<Employee> onlyUniques = new LinkedList<>(uniques.values());
        onlyUniques.removeAll(duplicatesEmployee);
        return onlyUniques;
    }


}