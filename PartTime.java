class PartTime extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTime(String firstname, String lastname, String socialnumber, String contractType, double hourlyRate, int hoursWorked) {
        super(firstname, lastname, socialnumber, contractType);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double income() {
        return hourlyRate * hoursWorked;
    }
}
