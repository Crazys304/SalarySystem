class commision extends employee{
    private double commissionRate;
    private int sales;

    public commision(String firstname, String lastname, String socialNumber, String contactType, double commissionRate, int sales) {
        super(firstname, lastname, socialNumber, contactType);
        this.commissionRate = commissionRate;
        this.sales = sales;
    }

    @Override
    public double income() {
        return commissionRate * sales;
    }
}
