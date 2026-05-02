
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Payroll payroll = new Payroll();

        Employee[] employees = new Employee[10];
        int count = 0;

        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Full-Time Employee");
            System.out.println("2. Add Contract Employee");
            System.out.println("3. Add Manager");
            System.out.println("4. Display Payroll");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    if (count >= employees.length) {
                        System.out.println("Employee limit reached!");
                        break;
                    }

                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter PAN: ");
                    String pan = sc.nextLine();

                    System.out.print("Enter Joining Date: ");
                    String date = sc.nextLine();

                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter Base Salary: ");
                    double base = sc.nextDouble();

                    System.out.print("Enter Role (1-SWE, 2-HR): ");
                    int r = sc.nextInt();

                    if (r == 1) {
                        System.out.print("Enter Performance Bonus: ");
                        double bonus = sc.nextDouble();

                        employees[count++] = new FullTimeEmployee(
                                name, pan, date, "SWE", id,
                                base, bonus, 0, Role.SWE);

                    } else {
                        System.out.print("Enter Hiring Commission: ");
                        double comm = sc.nextDouble();

                        employees[count++] = new FullTimeEmployee(
                                name, pan, date, "HR", id,
                                base, 0, comm, Role.HR);
                    }
                    break;

                case 2:
                    if (count >= employees.length) {
                        System.out.println("Employee limit reached!");
                        break;
                    }

                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    name = sc.nextLine();

                    System.out.print("Enter PAN: ");
                    pan = sc.nextLine();

                    System.out.print("Enter Joining Date: ");
                    date = sc.nextLine();

                    System.out.print("Enter ID: ");
                    id = sc.nextInt();

                    System.out.print("Enter Hours: ");
                    int hrs = sc.nextInt();

                    System.out.print("Enter Hourly Rate: ");
                    double rate = sc.nextDouble();

                    employees[count++] = new ContractEmployee(
                            name, pan, date, "Contract", id, hrs, rate);
                    break;

                case 3:
                    if (count >= employees.length) {
                        System.out.println("Employee limit reached!");
                        break;
                    }

                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    name = sc.nextLine();

                    System.out.print("Enter PAN: ");
                    pan = sc.nextLine();

                    System.out.print("Enter Joining Date: ");
                    date = sc.nextLine();

                    System.out.print("Enter ID: ");
                    id = sc.nextInt();

                    System.out.print("Enter Base Salary: ");
                    base = sc.nextDouble();

                    System.out.print("Enter Performance Bonus: ");
                    double bonus = sc.nextDouble();

                    System.out.print("Enter Travel Allowance: ");
                    double ta = sc.nextDouble();

                    System.out.print("Enter Education Allowance: ");
                    double edu = sc.nextDouble();

                    employees[count++] = new Manager(
                            name, pan, date, id, base, bonus, ta, edu);
                    break;

                case 4:
                    System.out.println("\n--- Payroll Details ---");
                    for (int i = 0; i < count; i++) {
                        payroll.process(employees[i]);
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
