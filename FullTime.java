class FullTime extends Employee {
    double salary;
    public FullTime(String firstname, String lastname, String socialNumber, String contactType) {
        super(firstname, lastname, socialNumber, contactType);
    }

    @Override
    public double income(){
        return salary;
    }
}