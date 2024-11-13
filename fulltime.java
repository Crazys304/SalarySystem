class fulltime extends employee{
    double salary;
    public fulltime(String firstname, String lastname, String socialNumber, String contactType) {
        super(firstname, lastname, socialNumber, contactType);
    }

    @Override
    public double income(){
        return salary;
    }
}
