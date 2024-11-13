class Commission extends Employee {
    private double commissionRate;
    private int sales;

    public Commission(String firstname, String lastname, String socialNumber, String contactType, double commissionRate, int sales) {
        super(firstname, lastname, socialNumber, contactType);
        this.commissionRate = commissionRate;
        this.sales = sales;
    }

    @Override
    public double income() {
        return commissionRate * sales;
    }
}
