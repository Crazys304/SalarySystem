class basecommision extends employee{
    private double baseSalary;
    private double commissionRate;
    private int sales;

    public basecommision(String firstname, String lastname, String socialNumber, String contactType, double baseSalary, double commissionRate, int sales) {
        super(firstname, lastname, socialNumber, contactType);
        this.baseSalary = baseSalary;
        this.commissionRate = commissionRate;
        this.sales = sales;
    }

    @Override
    public double income() {
        return baseSalary + (commissionRate * sales);
    }
}
