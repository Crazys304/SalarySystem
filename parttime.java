class parttime extends employee {
    private double hourlyRate;
    private int hoursWorked;

    public parttime(String firstname, String lastname, String socialnumber, String contacttype, double hourlyRate, int hoursWorked) {
        super(firstname, lastname, socialnumber, contacttype);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double income() {
        return hourlyRate * hoursWorked;
    }
}
