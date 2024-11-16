class Commission extends Employee {
    protected double commissionRate; // commission pay for the Commission employee
    protected int sales; // Commission employees made sales

    // A constructor to initialize attributes, including commissionRate and sales
    public Commission(String firstname, String lastname, String socialNumber, String contractType, String position,double commissionRate, int sales) {
        super(firstname, lastname, socialNumber, contractType, position);
        this.commissionRate = commissionRate;
        this.sales = sales;
    }

    // Overrides the abstract income method from Employee to provide the income for this employee
    @Override
    public double income() {
        return commissionRate * sales;
    }

    // Overrides the abstract toString method from Employee to provide the details of this employee
    @Override
    public String toString() {
        return super.toString() +
                    "Position: " + getPosition() + "\n" +
                    "Number of Sales: " + sales + "\n" +
                    "Commission: " + commissionRate + " Euro\n" +
                    "Salary: " + income() + " Euro\n" +
                "============================================\n";
    }

    // Overrides the abstract getPositionType method from Employee to provide the Position details of this employee
    @Override
    public String getPositionType() {
        return getFirstname() + " " + getLastname() + " - " + getPosition()+ "\n" +
                "============================================\n";
    }

    // Overrides the abstract getContractType method from Employee to provide the Contract details of this employee
    @Override
    public String getContractType() {
        return getFirstname() + " " + getLastname() + " - " + getContract() + "\n" +
                "============================================\n";
    }
}
