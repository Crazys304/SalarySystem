class FullTime extends Employee {
    double salary;
    public FullTime(String firstname, String lastname, String socialNumber, String contractType) {
        super(firstname, lastname, socialNumber, contractType);
    }

    @Override
    public double income(){
        return salary;
    }
}
