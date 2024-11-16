class FullTime extends Employee {
    private double salary; // salary for the Full Time Employee

    // A constructor to initialize attributes, including salary
    public FullTime(String firstname, String lastname, String socialNumber, String contractType, double salary, String position) {
        super(firstname, lastname, socialNumber, contractType, position);
        this.salary = salary;
    }

    // Overrides the abstract income method from Employee to provide the income for this employee
    @Override
    public double income(){
        return salary;
    }

    // Overrides the abstract toString method from Employee to provide the details of this employee
    @Override
    public String toString() {
        return super.toString() +
                "Position: " + getPosition() + "\n" +
                "Base Salary: " + income() + " Euro\n" +
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
