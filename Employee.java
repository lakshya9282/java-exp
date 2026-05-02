
import java.util.*;

// Enum for Role
enum Role {
    SWE, HR, MANAGER
}

// Abstract Employee Class
abstract class Employee {

    private String name;
    private String panNo;
    private String joiningDate;
    private String designation;
    private int empId;

    public Employee(String name, String panNo, String joiningDate,
            String designation, int empId) {
        this.name = name;
        this.panNo = panNo;
        this.joiningDate = joiningDate;
        this.designation = designation;
        this.empId = empId;
    }

    public abstract double calcCTC();

    public void display() {
        System.out.println("\nID: " + empId
                + " | Name: " + name
                + " | Role: " + designation);
    }
}

// Full Time Employee
class FullTimeEmployee extends Employee {

    protected double baseSalary;
    protected double perfBonus;
    protected double hiringCommission;
    protected Role role;

    public FullTimeEmployee(String name, String panNo, String joiningDate,
            String designation, int empId,
            double baseSalary, double perfBonus,
            double hiringCommission, Role role) {

        super(name, panNo, joiningDate, designation, empId);
        this.baseSalary = baseSalary;
        this.perfBonus = perfBonus;
        this.hiringCommission = hiringCommission;
        this.role = role;
    }

    @Override
    public double calcCTC() {
        switch (role) {
            case SWE:
                return baseSalary + perfBonus;
            case HR:
                return baseSalary + hiringCommission;
            default:
                return baseSalary;
        }
    }
}

// Contract Employee
class ContractEmployee extends Employee {

    private int noOfHours;
    private double hourlyRate;

    public ContractEmployee(String name, String panNo, String joiningDate,
            String designation, int empId,
            int noOfHours, double hourlyRate) {

        super(name, panNo, joiningDate, designation, empId);
        this.noOfHours = noOfHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calcCTC() {
        return noOfHours * hourlyRate;
    }
}

// Manager Class
class Manager extends FullTimeEmployee {

    private double travelAllowance;
    private double eduAllowance;

    public Manager(String name, String panNo, String joiningDate,
            int empId, double baseSalary, double perfBonus,
            double travelAllowance, double eduAllowance) {

        super(name, panNo, joiningDate, "Manager", empId,
                baseSalary, perfBonus, 0, Role.MANAGER);

        this.travelAllowance = travelAllowance;
        this.eduAllowance = eduAllowance;
    }

    @Override
    public double calcCTC() {
        return baseSalary + perfBonus + travelAllowance + eduAllowance;
    }
}

// Payroll Class
class Payroll {

    public void process(Employee emp) {
        emp.display();
        System.out.println("CTC: ₹" + emp.calcCTC());
        System.out.println("------------------------");
    }
}
