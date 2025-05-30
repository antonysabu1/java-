import java.util.Scanner;

class Employee {
    String name;
    int age;
    String phoneNumber;
    String address;
    double salary;

    Employee(String name, int age, String phoneNumber, String address, double salary) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.salary = salary;
    }

    void printSalary() {
        System.out.println("Salary: " + salary);
    }

    void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Address: " + address);
        System.out.println("Salary: " + salary);
    }
}

class Officer extends Employee {
    String specialisation;

    Officer(String name, int age, String phoneNumber, String address, double salary, String specialisation) {
        super(name, age, phoneNumber, address, salary);
        this.specialisation = specialisation;
    }

    @Override
    void printDetails() {
        System.out.println("\nOFFICER DETAILS:");
        super.printDetails();
        System.out.println("Specialisation: " + specialisation);
    }
}

class Manager extends Employee {
    String department;

    Manager(String name, int age, String phoneNumber, String address, double salary, String department) {
        super(name, age, phoneNumber, address, salary);
        this.department = department;
    }

    @Override
    void printDetails() {
        System.out.println("\nMANAGER DETAILS:");
        super.printDetails();
        System.out.println("Department: " + department);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

  
        int numOfficers = 2;
        int numManagers = 2;

        Officer[] officers = new Officer[numOfficers];
        Manager[] managers = new Manager[numManagers];

        System.out.println("=== Enter Officer Details ===");
        for (int i = 0; i < numOfficers; i++) {
            System.out.println("\nOfficer " + (i + 1));
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Age: ");
            int age = sc.nextInt(); sc.nextLine();
            System.out.print("Phone Number: ");
            String phone = sc.nextLine();
            System.out.print("Address: ");
            String address = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble(); sc.nextLine();
            System.out.print("Specialisation: ");
            String spec = sc.nextLine();

            officers[i] = new Officer(name, age, phone, address, salary, spec);
        }

        System.out.println("\n=== Enter Manager Details ===");
        for (int i = 0; i < numManagers; i++) {
            System.out.println("\nManager " + (i + 1));
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Age: ");
            int age = sc.nextInt(); sc.nextLine();
            System.out.print("Phone Number: ");
            String phone = sc.nextLine();
            System.out.print("Address: ");
            String address = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble(); sc.nextLine();
            System.out.print("Department: ");
            String dept = sc.nextLine();

            managers[i] = new Manager(name, age, phone, address, salary, dept);
        }

        sc.close();

      
        System.out.println("\n=== DISPLAYING ALL EMPLOYEE DETAILS ===");
        for (Officer o : officers) {
            o.printDetails();
            o.printSalary();
        }

        for (Manager m : managers) {
            m.printDetails();
            m.printSalary();
        }
    }
}

