class BaseCommission extends Employee {
    private double baseSalary;
    private double commissionRate;
    private int sales;

    public BaseCommission(String firstname, String lastname, String socialNumber, String contractType, String position,double baseSalary, double commissionRate, int sales) {
        super(firstname, lastname, socialNumber, contractType, position);
        this.baseSalary = baseSalary;
        this.commissionRate = commissionRate;
        this.sales = sales;
    }

    @Override
    public double income() {
        return baseSalary + (commissionRate * sales) + (baseSalary * 0.10);
    }

    @Override
    public String getEmployeeData() {
        return
                "Name: " + getFirstname() + " " + getLastname() + "\n" +
                "Position: " + getPosition() + "\n" +
                "Base Salary: " + baseSalary + "Euro\n" +
                "Commission per Sale: " + commissionRate + "Euro\n" +
                "Bonus: 10%\n" +
                "Salary: " + income() + "Euro\n" +
                "Social Number: " + getSocialNumber() + "\n" +
                "====================================\n";
    }
}
