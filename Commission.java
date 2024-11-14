class Commission extends Employee {
    protected double commissionRate;
    protected int sales;

    public Commission(String firstname, String lastname, String socialNumber, String contractType, String position,double commissionRate, int sales) {
        super(firstname, lastname, socialNumber, contractType, position);
        this.commissionRate = commissionRate;
        this.sales = sales;
    }

    @Override
    public double income() {
        return commissionRate * sales;
    }

    @Override
    public String toString() {
        return super.toString() +
                    "Position: " + getPosition() + "\n" +
                    "Number of Sales: " + sales + "\n" +
                    "Commission: " + commissionRate + " Euro\n" +
                    "Salary: " + income() + " Euro\n" +
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
