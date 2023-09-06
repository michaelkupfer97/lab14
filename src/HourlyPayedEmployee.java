public class HourlyPayedEmployee extends Employee {
    protected double workHours;

    public HourlyPayedEmployee(String name, String id, double salary, String socialNumber, double workHours) {
        super(name, id, salary, socialNumber);
        this.workHours = 0;
    }

    public void addWorkHoures(double workHours) {
        this.workHours += workHours;
    }

    @Override
    public double pay() {
        return (salary / 180) * workHours;
    }

    @Override
    public String toString() {
        return " " + id +
                " salary: " + pay() +
                " number of work hours: " + workHours +
                " social number: " + socialNumber;
    }

    public double getWorkHours() {
        return workHours;
    }

    public void setWorkHours(double workHours) {
        this.workHours = workHours;
    }
}