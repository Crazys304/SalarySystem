class PartTime extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTime(String firstname, String lastname, String socialnumber, String contractType, String position,double hourlyRate, int hoursWorked) {
        super(firstname, lastname, socialnumber, contractType, position);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double income() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public String getEmployeeData() {
        return
                "Name: " + getFirstname() + " " + getLastname() + "\n" +
                "Position: " + getPosition()+ "\n" +
                "Number of hours worked: " + hoursWorked + "\n" +
                "Salary: " + income() + " Euro\n" +
                "Social Number: " + getSocialNumber() + "\n" +
                "====================================\n";
    }
    @Override
    public String getPositionType() {
        return getFirstname() + " " + getLastname() + " - " + getPosition()+ "\n" +
                "====================================\n";
    }
    @Override
    public String getContractType() {
        return getFirstname() + " " + getLastname() + " - " + getContract() + "\n" +
                "====================================\n";
    }
}
