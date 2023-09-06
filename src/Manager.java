public class Manager extends Employee {
    private double bonus;

    public Manager(String name, String id, double salary, String socialNumber) {
        super(name, id, salary, socialNumber);
        this.bonus = 0;
    }

    public void addBonus(double bonus) {
        this.bonus += bonus;
    }

    @Override
    public double pay() {
        double payThisMonth = salary + this.bonus;
        this.bonus = 0;
        return payThisMonth;
    }

    @Override
    public String toString() {
        return " " + id +
                " salary manager: " + pay() +
                " social number: " + socialNumber;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
