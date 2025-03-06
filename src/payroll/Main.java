package payroll;

import payroll.model.FullTimeEmployee;
import payroll.model.PartTimeEmployee;
import payroll.service.PayrollSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nPayroll System Menu:");
            System.out.println("1. Add Full-Time Employee");
            System.out.println("2. Add Part-Time Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Display Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String ftName = scanner.nextLine();
                    System.out.print("Enter ID: ");
                    int ftId = scanner.nextInt();
                    System.out.print("Enter monthly salary: ");
                    double ftSalary = scanner.nextDouble();
                    payrollSystem.addEmployee(new FullTimeEmployee(ftName, ftId, ftSalary));
                    break;

                case 2:
                    System.out.print("Enter name: ");
                    String ptName = scanner.nextLine();
                    System.out.print("Enter ID: ");
                    int ptId = scanner.nextInt();
                    System.out.print("Enter hours worked: ");
                    int hoursWorked = scanner.nextInt();
                    System.out.print("Enter hourly rate: ");
                    double hourlyRate = scanner.nextDouble();
                    payrollSystem.addEmployee(new PartTimeEmployee(ptName, ptId, hoursWorked, hourlyRate));
                    break;

                case 3:
                    System.out.print("Enter Employee ID to remove: ");
                    int removeId = scanner.nextInt();
                    payrollSystem.removeEmployee(removeId);
                    break;

                case 4:
                    System.out.println("\nEmployee Details:");
                    payrollSystem.displayEmployees();
                    break;

                case 5:
                    System.out.println("Exiting Payroll System...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}