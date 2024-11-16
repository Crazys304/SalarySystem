class BaseCommission extends Commission {
    private double baseSalary; // Base Commission employees salary

    // A constructor to initialize attributes, including baseSalary
    public BaseCommission(String firstname, String lastname, String socialNumber, String contractType, String position,double baseSalary, double commissionRate, int sales) {
        super(firstname, lastname, socialNumber, contractType, position, commissionRate, sales);
        this.baseSalary = baseSalary;
    }

    // Overrides the abstract income method from Commission to provide the income for this employee
    @Override
    public double income() {
        return baseSalary + (commissionRate * sales) + (baseSalary * 0.10);
    }

    // Overrides the abstract toString method from Commission to provide the details of this employee
    @Override
    public String toString() {
        return
                "Name: " + getFirstname() + " " + getLastname() + "\n" +
                "Social Number: " + getSocialNumber() + "\n" +
                "Position: " + getPosition() + "\n" +
                "Base Salary: " + baseSalary + " Euro\n" +
                "Commission per Sale: " + commissionRate + " Euro\n" +
                "Bonus: 10%\n" +
                "Salary: " + income() + " Euro\n" +
                "============================================\n";
    }

    // Overrides the abstract getPositionType method from Commission to provide the Position details of this employee
    @Override
    public String getPositionType() {
        return getFirstname() + " " + getLastname() + " - " + getPosition()+ "\n" +
                "============================================\n";
    }

    // Overrides the abstract getContractType method from Commission to provide the Contract details of this employee
    @Override
    public String getContractType() {
        return getFirstname() + " " + getLastname() + " - " + getContract() + "\n" +
                "============================================\n";
    }
}
