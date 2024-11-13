abstract class Employee {
    private String firstname;
    private String lastname;
    private String socialNumber;
    private String contractType;

    public Employee(String firstname, String lastname, String socialNumber, String contractType) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.socialNumber = socialNumber;
        this.contractType = contractType;
    }

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

    public String getContractType() {
        return contractType;
    }
}
