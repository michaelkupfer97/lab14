public class Employee extends StaffMember {
    protected double salary;
    protected String socialNumber;

    public Employee(String name, String id, double salary, String socialNumber) {
        super(name, id);
        this.salary = salary;
        this.socialNumber = socialNumber;
    }

    public double getSalary() {
        return this.salary;
    }

    @Override
    public double pay() {
        return salary;
    }

    @Override
    public String toString() {
        return " " + id +
                " salary: " + salary +
                " social number: " + socialNumber+
                " status: "+stat;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getSocialNumber() {
        return socialNumber;
    }

    public void setSocialNumber(String socialNumber) {
        this.socialNumber = socialNumber;
    }
}
