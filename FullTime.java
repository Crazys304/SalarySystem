class FullTime extends Employee {
    private double salary;
    public FullTime(String firstname, String lastname, String socialNumber, String contractType, double salary, String position) {
        super(firstname, lastname, socialNumber, contractType, position);
        this.salary = salary;
    }

    @Override
    public double income(){
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Position: " + getPosition() + "\n" +
                "Base Salary: " + income() + " Euro\n" +
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
