abstract class Employee {
    private String firstname; // first name for the employee
    private String lastname; // last name for the employee
    private String socialNumber; // employees social number
    private String contractType; // employees contract time
    private String Position; // employees job position

    // A Constructor to initialize employee attributes
    public Employee(String firstname, String lastname, String socialNumber, String contractType, String Position) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.socialNumber = socialNumber;
        this.contractType = contractType;
        this.Position = Position;
    }
    
    public abstract String getPositionType(); // Abstract method to get employees position
    public abstract String getContractType(); // Abstract method to get employees contract
    public abstract double income(); // Abstract method to get employees income

    // ----------- Getters
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
