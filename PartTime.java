class PartTime extends Employee {
    private double hourlyRate; // Per hour pay for the Part Time employee
    private int hoursWorked; // Hours worked by the Part Time employee

    // A constructor to initialize attributes, including hourlyRate and hoursWorked
    public PartTime(String firstname, String lastname, String socialnumber, String contractType, String position,double hourlyRate, int hoursWorked) {
        super(firstname, lastname, socialnumber, contractType, position);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    // Overrides the abstract income method from Employee to provide the income for this employee
    @Override
    public double income() {
        return hourlyRate * hoursWorked;
    }

    // Overrides the abstract toString method from Employee to provide the details of this employee
    @Override
    public String toString() {
        return super.toString() +
                "Position: " + getPosition() + "\n" +
                "Number of hours worked: " + hoursWorked + "\n" +
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
