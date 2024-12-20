import java.util.InputMismatchException;
import java.util.Scanner;

// Creates a custom exception used for menu input detection
class InvalidInputException extends Exception {
    public InvalidInputException(int number) {
        super("Invalid option. Input numbers between 1 and 4. \n"); // message for
    }
}

class InvalidSubInputException extends Exception { // Custom exception for sub menu input
    public InvalidSubInputException(int number) {
        super("Invalid option. Input numbers between 1 and 4. \n");
    }
}

class NumberNegativeException extends Exception { // Custom exception for negative number input
    public NumberNegativeException(double num) {
        super("The salary cannot be negative. \n");
    }
}

class NegativeHourException extends Exception { // Custom exception for negative hours
    public NegativeHourException(int hour) {
        super("An employee cannot have negative hours or sales. \n");
    }
}

class DuplicateEmployeeException extends Exception { // Custom exception for duplicate employees
    public DuplicateEmployeeException(String message) {
        super(message);
    }
}

public class Main {
    // Checks if the menu input is between the right numbers
    public static void InputException(int number) throws InvalidInputException {
        if (number < 1 || number > 4) {
            throw new InvalidInputException(number);
        }
    }
    // Checks if the sub menu input is between the right numbers
    public static void InputSubException(int number) throws InvalidSubInputException {
        if (number < 1 || number > 5) {
            throw new InvalidSubInputException(number);
        }
    }
    // Checks if number is not negative
    public static void NumberNegativeException(double num) throws NumberNegativeException {
        if (num < 0) {
            throw new NumberNegativeException(num);
        }
    }
    // Checks if hour number is not negative
    public static void NegativeHourException(int hour) throws NegativeHourException {
        if (hour < 0) {
            throw new NegativeHourException(hour);
        }
    }

    private static final int MAX_EMPLOYEES = 100; // Max employee count
    private static Employee[] employees = new Employee[MAX_EMPLOYEES]; // Array to store employee objects
    private static int employeesCount = 0; // Employee count


    public static void main(String[] args) {

        Scanner obj = new Scanner(System.in);

        while (true) {
            try {
                System.out.println(
                        "-------------------------" +
                                "\n| Salary system         |" +
                                "\n-------------------------" +
                                "\n|1. Register employee   |" +
                                "\n|2. Print options       |" +
                                "\n|3. Fire Employee       |" +
                                "\n|4. Exit                |" +
                                "\n-------------------------" +
                                "\nEnter command (1 to 4): "
                );
                int number = obj.nextInt();
                obj.nextLine();

                if (number == 1) {
                    try {
                        while (true) { // Prints employee submenu
                            System.out.println(
                                    "-----------------------------------" +
                                            "\n|1. Full time employee            |" +
                                            "\n|2. Part - time employee          |" +
                                            "\n|3. Commission employee           |" +
                                            "\n|4. Base employee with commission |" +
                                            "\n|5. Back                          |" +
                                            "\n-----------------------------------" +
                                            "\nEnter command (1 to 5): "
                            );
                            int num = obj.nextInt();
                            obj.nextLine();
                            if (num == 1) {
                                try {
                                    System.out.println("Enter name: ");
                                    String firstname = obj.nextLine();
                                    System.out.println("Enter last name: ");
                                    String lastname = obj.nextLine();
                                    System.out.println("Enter social number: ");
                                    String socialNumber = obj.nextLine();
                                    boolean isValid = socialNumber.matches("^\\d{6}-\\d{5}$"); // Checks if Social number matches the pattern
                                    if (!isValid) { // If not valid, prints message and breaks loop
                                        System.out.println("Invalid social number.");
                                        break;
                                    }
                                    String[] parts = socialNumber.split("-"); // Splits number at -
                                    String firstPart = parts[0];

                                    int day = Integer.parseInt(firstPart.substring(0, 2)); // Day numbers
                                    int month = Integer.parseInt(firstPart.substring(2, 4)); // Month numbers

                                    if (day > 31 || day <= 0 || month > 12 || month <=0) { // Checks if numbers are correct
                                        System.out.println("Invalid social number: Day or month out of range.");
                                        break;
                                    }
                                    System.out.println("Enter contract type (Seasonal or Annual): ");
                                    String contractType = obj.nextLine();
                                    // Checks if contract type is as needed
                                    if (!contractType.equals("Seasonal") && !contractType.equals("Annual")) {
                                        System.out.println("Invalid contract type.");
                                        break;
                                    }
                                    System.out.println("Enter base salary: ");
                                    double salary = obj.nextDouble();
                                    obj.nextLine();

                                    NumberNegativeException(salary); // Validates salary
                                    // Calls method to add full-time employee
                                    addFullTime(firstname, lastname, socialNumber, contractType, salary);
                                } catch (NumberNegativeException e) {
                                    System.out.println(e.getMessage());
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input."); // Handle input mismatch
                                }

                            } else if (num == 2) {
                                try {
                                    System.out.println("Enter name: ");
                                    String firstname = obj.nextLine();
                                    System.out.println("Enter last name: ");
                                    String lastname = obj.nextLine();
                                    System.out.println("Enter social number: ");
                                    String socialNumber = obj.nextLine();
                                    boolean isValid = socialNumber.matches("^\\d{6}-\\d{5}$"); // Checks if Social number matches the pattern
                                    if (!isValid) { // If not valid, prints message and breaks loop
                                        System.out.println("Invalid social number.");
                                        break;
                                    }
                                    String[] parts = socialNumber.split("-"); // Splits number at -
                                    String firstPart = parts[0];

                                    int day = Integer.parseInt(firstPart.substring(0, 2)); // Day numbers
                                    int month = Integer.parseInt(firstPart.substring(2, 4)); // Month numbers

                                    if (day > 31 || day <= 0 || month > 12 || month <=0) { // Checks if numbers are correct
                                        System.out.println("Invalid social number: Day or month out of range.");
                                        break;
                                    }
                                    System.out.println("Enter contract type (Seasonal or Annual): ");
                                    String contractType = obj.nextLine();
                                    if (!contractType.equals("Seasonal") && !contractType.equals("Annual")) {
                                        System.out.println("Invalid contract type.");
                                        break;
                                    }
                                    System.out.println("Enter hourly rate: ");
                                    double hourlyRate = obj.nextDouble();
                                    obj.nextLine();
                                    System.out.println("Enter hours worked: ");
                                    int hoursWorked = obj.nextInt();
                                    obj.nextLine();

                                    NumberNegativeException(hourlyRate); // Validates rate
                                    NegativeHourException(hoursWorked); // Validates hours
                                    // Call method to add part-time employee
                                    addPartTime(firstname, lastname, socialNumber, contractType, hourlyRate, hoursWorked);

                                } catch (NegativeHourException | NumberNegativeException e) {
                                    System.out.println(e.getMessage());
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input."); // Handle input mismatch
                                }
                            } else if (num == 3) {
                                try {
                                    System.out.println("Enter name: ");
                                    String firstname = obj.nextLine();
                                    System.out.println("Enter last name: ");
                                    String lastname = obj.nextLine();
                                    System.out.println("Enter social number: ");
                                    String socialNumber = obj.nextLine();
                                    boolean isValid = socialNumber.matches("^\\d{6}-\\d{5}$"); // Checks if Social number matches the pattern
                                    if (!isValid) { // If not valid, prints message and breaks loop
                                        System.out.println("Invalid social number.");
                                        break;
                                    }
                                    String[] parts = socialNumber.split("-"); // Splits number at -
                                    String firstPart = parts[0];

                                    int day = Integer.parseInt(firstPart.substring(0, 2)); // Day numbers
                                    int month = Integer.parseInt(firstPart.substring(2, 4)); // Month numbers

                                    if (day > 31 || day <= 0 || month > 12 || month <=0) { // Checks if numbers are correct
                                        System.out.println("Invalid social number: Day or month out of range.");
                                        break;
                                    }
                                    System.out.println("Enter contract type (Seasonal or Annual): ");
                                    String contractType = obj.nextLine();
                                    if (!contractType.equals("Seasonal") && !contractType.equals("Annual")) {
                                        System.out.println("Invalid contract type.");
                                        break;
                                    }
                                    System.out.println("Enter commission rate (Euro): ");
                                    double commissionRate = obj.nextDouble();
                                    obj.nextLine();
                                    System.out.println("Enter number of sales: ");
                                    int sales = obj.nextInt();
                                    obj.nextLine();

                                    NegativeHourException(sales); // Validates sales
                                    NumberNegativeException(commissionRate); // Validates rate
                                    // Call method to add commission employee
                                    addCommission(firstname, lastname, socialNumber, contractType, commissionRate, sales);
                                } catch (NegativeHourException | NumberNegativeException e) {
                                    System.out.println(e.getMessage());
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input.");
                                }
                            } else if (num == 4) {
                                try {
                                    System.out.println("Enter name: ");
                                    String firstname = obj.nextLine();
                                    System.out.println("Enter last name: ");
                                    String lastname = obj.nextLine();
                                    System.out.println("Enter social number: ");
                                    String socialNumber = obj.nextLine();
                                    boolean isValid = socialNumber.matches("^\\d{6}-\\d{5}$"); // Checks if Social number matches the pattern
                                    if (!isValid) { // If not valid, prints message and breaks loop
                                        System.out.println("Invalid social number.");
                                        break;
                                    }
                                    String[] parts = socialNumber.split("-"); // Splits number at -
                                    String firstPart = parts[0];

                                    int day = Integer.parseInt(firstPart.substring(0, 2)); // Day numbers
                                    int month = Integer.parseInt(firstPart.substring(2, 4)); // Month numbers

                                    if (day > 31 || day <= 0 || month > 12 || month <=0) { // Checks if numbers are correct
                                        System.out.println("Invalid social number: Day or month out of range.");
                                        break;
                                    }
                                    System.out.println("Enter contract type (Seasonal or Annual): ");
                                    String contractType = obj.nextLine();
                                    if (!contractType.equals("Seasonal") && !contractType.equals("Annual")) {
                                        System.out.println("Invalid contract type.");
                                        break;
                                    }
                                    System.out.println("Enter base salary: ");
                                    double baseSalary = obj.nextDouble();
                                    obj.nextLine();
                                    System.out.println("Enter commission rate per sale: ");
                                    double commissionRate = obj.nextDouble();
                                    obj.nextLine();
                                    System.out.println("Enter sales: ");
                                    int sales = obj.nextInt();
                                    obj.nextLine();

                                    NegativeHourException(sales); // Validates sales
                                    NumberNegativeException(baseSalary); // Validates salary
                                    NumberNegativeException(commissionRate); // Validates rate
                                    // Call method to add base commission employee
                                    addBaseCommission(firstname, lastname, socialNumber, contractType, baseSalary, commissionRate, sales);
                                } catch (NegativeHourException | NumberNegativeException e) {
                                    System.out.println(e.getMessage());
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input.");
                                }
                            } else if (num == 5) {
                                System.out.println("Return to menu");
                                break;
                            } else {
                                try {
                                    InputSubException(num);  // Validates submenu input
                                } catch (InvalidSubInputException e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input.");
                    }
                }
                if (number == 2) {
                    try{
                        while (true) {
                            System.out.println( // Prints print option submenu
                                    "------------------------------" +
                                            "\n|1. Print employees          |" +
                                            "\n|2. Print by position        |" +
                                            "\n|3. Print by contract        |" +
                                            "\n|4. Back                     |" +
                                            "\n------------------------------" +
                                            "\nEnter command (1 to 4): "
                            );
                            int nums = obj.nextInt();
                            obj.nextLine();
                            // Different print options based on input
                            if (nums == 1) {
                                PrintByData();
                            } if (nums == 2){
                                PrintByPosition();
                            } if (nums == 3) {
                                PrintByContract();
                            } if (nums == 4) {
                                System.out.println("Return to menu");
                                break;
                            } else {
                                try {
                                    InputException(nums); // Validates input
                                } catch (InvalidInputException e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                        }
                    }catch (InputMismatchException e) {
                        System.out.println("Invalid input.");
                    }

                }if (number == 3) {
                    fireEmployee(obj); // Calls method to fire employee

                }if (number == 4) {
                    System.out.println("Thank you have a great day! \nExiting...");
                    obj.close();
                    System.exit(0); // Exits the program
                } else {
                    try {
                        InputException(number); // Validates input number
                    } catch (InvalidInputException e) {
                        System.out.println(e.getMessage()); // Print error message from exception
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
                obj.nextLine();
            }
        }
    }

    // Method which checks if an employee with the given social number already exists in the employees array
    protected static boolean employeeExist(String socialNumber) {
        for (int i = 0; i < socialNumber.length(); i++) {
            // Checks if social number matches
            if (employees[i] != null && employees[i].getSocialNumber().equals(socialNumber)) {
                return true;
            }
        }
        return false;
    }
    // Method for adding a new Full-Time Employee to the system
    protected static void addFullTime(String firstname, String lastname, String socialNumber, String contractType, double salary) {
        try {
            if (employeeExist(socialNumber)) { // Checks if an employee already exists
                throw new DuplicateEmployeeException("An Employee with the social number " + socialNumber + " already exists");
            }
            if (employeesCount < MAX_EMPLOYEES) { // Checks if there is a room to add a new employee
                String position = "Full Time Employee";
                employees[employeesCount++] = new FullTime(firstname, lastname, socialNumber, contractType, salary, position); // Add employee
                System.out.println("Full Time Employee successfully added.");
            } else {
                System.out.println("Employees are already full.");
            }
        } catch (DuplicateEmployeeException e) {
            System.out.println(e.getMessage()); // Print duplicate employee error message
        }
    }
    // Method for adding a new Part-Time Employee to the system
    protected static void addPartTime(String firstname, String lastname, String socialNumber, String contractType,double hourlyRate, int hoursWorked) {
        try {
            if (employeeExist(socialNumber)) { // Checks if an employee already exists
                throw new DuplicateEmployeeException("An Employee with the social number " + socialNumber + " already exists");
            }
            if (employeesCount < MAX_EMPLOYEES) { // Checks if there is a room to add a new employee
                String position = "Part Time Employee";
                employees[employeesCount++] = new PartTime(firstname, lastname, socialNumber, contractType, position, hourlyRate, hoursWorked); // Add employee
                System.out.println("Part Time Employee successfully added.");
            } else {
                System.out.println("Employees are already full.");
            }
        } catch (DuplicateEmployeeException e) {
            System.out.println(e.getMessage()); // Print duplicate employee error message
        }
    }
    // Method for adding a new Commission employee
    protected static void addCommission(String firstname, String lastname, String socialNumber, String contractType, double commissionRate, int sales) {
        try {
            if (employeeExist(socialNumber)) {
                throw new DuplicateEmployeeException("An Employee with the social number " + socialNumber + " already exists");
            }
            if (employeesCount < MAX_EMPLOYEES) {
                String position = "Commission Employee";
                employees[employeesCount++] = new Commission(firstname, lastname, socialNumber, contractType, position, commissionRate, sales);
                System.out.println("Commission Employee successfully added.");
            } else {
                System.out.println("Employees are already full.");
            }
        } catch (DuplicateEmployeeException e) {
            System.out.println(e.getMessage());
        }
    }
    // Method for adding a new Base commission employee
    protected static void addBaseCommission(String firstname, String lastname, String socialNumber, String contractType, double baseSalary, double commissionRate, int sales) {
        try {
            if (employeeExist(socialNumber)) {
                throw new DuplicateEmployeeException("An Employee with the social number " + socialNumber + " already exists");
            }
            if (employeesCount < MAX_EMPLOYEES) {
                String position = "Base Employee with Commission";
                employees[employeesCount++] = new BaseCommission(firstname, lastname, socialNumber, contractType, position, baseSalary, commissionRate, sales);
                System.out.println("Base Commission Employee successfully added.");
            } else {
                System.out.println("Employees are already full.");
            }
        } catch (DuplicateEmployeeException e) {
            System.out.println(e.getMessage());
        }
    }
    // Prints details of all employees in the system
    protected static void PrintByData() {
        if (employeesCount == 0) { // Checks if there are no employees
            System.out.println(
                            "============================================\n" +
                            "|         No Employees added.              |\n" +
                            "============================================"
            );
            return;
        }
        System.out.println(
                "============================================\n" +
                        "|         Employee Information             |\n" +
                        "============================================"
        );
        // Loops through employees and prints details from each class
        for (int i = 0; i < employeesCount; i++) {
            System.out.print(employees[i].toString());
        }
    }
    // Prints position of all employees in the system
    protected static void PrintByPosition() {
        if (employeesCount == 0) {
            System.out.println(
                    "============================================\n" +
                            "|         No Employees added.              |\n" +
                            "============================================"
            );
            return;
        }
        System.out.println(
                "============================================\n" +
                        "|         Employee Position                |\n" +
                        "============================================"
        );
        // Loops through employees and prints positions details from each class
        for (int i = 0; i < employeesCount; i++) {
            System.out.print(employees[i].getPositionType());
        }
    }
    // Prints contracts of all employees in the system
    protected static void PrintByContract() {
        if (employeesCount == 0) {
            System.out.println(
                    "============================================\n" +
                            "|         No Employees added.              |\n" +
                            "============================================"
            );
            return;
        }
        System.out.println(
                "============================================\n" +
                        "|         Employee Position                |\n" +
                        "============================================"
        );
        // Loops through employees and prints contract details from each class
        for (int i = 0; i < employeesCount; i++) {
            System.out.print(employees[i].getContractType());
        }
    }
    // Method to fire an employees
    protected static void fireEmployee(Scanner obj) {
        if (employeesCount == 0) {
            System.out.println(
                    "============================================\n" +
                    "|      No employees to fire... Bummer      |\n" +
                    "============================================"
            );
            return;
        }
        System.out.println("============================================");

        int identification = 0; // Variable to display employee numbering
        for (int i = 0; i < employeesCount; i++) { // Display all employees with numbering
            identification++;
            System.out.println(
                    identification + ". " + employees[i].getPositionType()
            );
        }
        System.out.println("Enter which employee to delete: ");
        int deleteId = obj.nextInt() - 1; // Subtracts 1 for zero-based indexing
        obj.nextLine();

        if (deleteId >= 0 && deleteId < employeesCount) { // Validates range
            for (int i = deleteId; i < employeesCount - 1; i++) { // Shifts employees in the array to fill the gap
                employees[i] = employees[i + 1];
            }
            employees[employeesCount - 1] = null; // Nullify the last entry
            employeesCount--; // Decreases employee count
            System.out.println("Employee successfully Fired.");
        } else {
            System.out.println("Invalid Employee input."); // Invalid index entered
        }
    }
}


