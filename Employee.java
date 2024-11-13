abstract class Employee {
    private String firstname;
    private String lastname;
    private String socialNumber;
    private String contactType;

    public Employee(String firstname, String lastname, String socialNumber, String contactType) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.socialNumber = socialNumber;
        this.contactType = contactType;
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

    public String getContactType() {
        return contactType;
    }
}
