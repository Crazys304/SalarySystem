abstract class Employee {
    private String firstname;
    private String lastname;
    private String socialNumber;
    private String contractType;
    private String Position;

    public Employee(String firstname, String lastname, String socialNumber, String contractType, String Position) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.socialNumber = socialNumber;
        this.contractType = contractType;
        this.Position = Position;
    }
    
    public abstract String getPositionType();
    public abstract String getContractType();
    public abstract double income();

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getSocialNumber() {
        return socialNumber;
    }

    public String getContract() {
        return contractType;
    }

    public String getPosition() {
        return Position;
    }
    @Override
    public String toString() {
        return "Name: " + getFirstname() + " " + getLastname() + '\n' +
                "Social number: " + getSocialNumber() + '\n';
    }
}
