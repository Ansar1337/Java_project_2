package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();
        while (true) {
            System.out.println(
                    "Введите информацию о сотруднике (фамилия, имя, возраст, пол, образование, должность, отдел):"
            );
            String surname = scanner.next();
            String name = scanner.next();
            int age = scanner.nextInt();
            String gender = scanner.next();
            String education = scanner.next();
            String position = scanner.next();
            String department = scanner.next();
            scanner.nextLine();
            employees.add(new Employee(surname, name, age, gender, education, position, department));
            System.out.print("Если хотите закончить ввод данных, введите end: ");
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
        }
        while (true) {
            System.out.println("Если не хотите менять данные, введите end: ");
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            System.out.println("Введите фамилию и имя работника, для которого хотите изменить данные");
            String surname = scanner.next();
            String name = scanner.next();
            scanner.nextLine();
            int empIndex = searchBySurname(employees, surname, name);
            if (empIndex != -1) {
                System.out.println("Меняем [Фамилия]? ");
                input = scanner.nextLine();
                if (input.equals("Да")) {
                    employees.get(empIndex).setSurname(scanner.nextLine());
                }
                System.out.println("Меняем [Имя]? ");
                input = scanner.nextLine();
                if (input.equals("Да")) {
                    employees.get(empIndex).setName(scanner.nextLine());
                }
                System.out.println("Меняем [Возраст]? ");
                input = scanner.nextLine();
                if (input.equals("Да")) {
                    employees.get(empIndex).setAge(Integer.parseInt(scanner.nextLine()));
                }
                System.out.println("Меняем [Пол]? ");
                input = scanner.nextLine();
                if (input.equals("Да")) {
                    employees.get(empIndex).setGender(scanner.nextLine());
                }
                System.out.println("Меняем [Образование]? ");
                input = scanner.nextLine();
                if (input.equals("Да")) {
                    employees.get(empIndex).setEducation(scanner.nextLine());
                }
                System.out.println("Меняем [Должность]? ");
                input = scanner.nextLine();
                if (input.equals("Да")) {
                    employees.get(empIndex).setPosition(scanner.nextLine());
                }
                System.out.println("Меняем [Отдел]? ");
                input = scanner.nextLine();
                if (input.equals("Да")) {
                    employees.get(empIndex).setDepartment(scanner.nextLine());
                }
            }
        }
        System.out.println("Список сотрудников:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static int searchBySurname(List<Employee> employees, String surname, String name) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getSurname().equals(surname) && employees.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}