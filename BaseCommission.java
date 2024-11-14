class BaseCommission extends Commission {
    private double baseSalary;
    
    public BaseCommission(String firstname, String lastname, String socialNumber, String contractType, String position,double baseSalary, double commissionRate, int sales) {
        super(firstname, lastname, socialNumber, contractType, position, commissionRate, sales);
        this.baseSalary = baseSalary;
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
                "Base Salary: " + baseSalary + " Euro\n" +
                "Commission per Sale: " + commissionRate + " Euro\n" +
                "Bonus: 10%\n" +
                "Salary: " + income() + " Euro\n" +
                "Social Number: " + getSocialNumber() + "\n" +
                "============================================\n";
    }
    @Override
    public String getPositionType() {
        return getFirstname() + " " + getLastname() + " - " + getPosition()+ "\n" +
                "============================================\n";
    }
    @Override
    public String getContractType() {
        return getFirstname() + " " + getLastname() + " - " + getContract() + "\n" +
                "============================================\n";
    }
}
