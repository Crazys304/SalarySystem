import java.util.InputMismatchException;
import java.util.Scanner;

// Creates a custom exception used for menu input detection
class InvalidInputException extends Exception {
    public InvalidInputException(int number) {
        super("Invalid option. Input numbers between 1 and 4. \n"); // message for
    }
}

class InvalidSubInputException extends Exception {
    public InvalidSubInputException(int number) {
        super("Invalid option. Input numbers between 1 and 4. \n");
    }
}

class NumberNegativeException extends Exception {
    public NumberNegativeException(double num) {
        super("The salary cannot be negative. \n");
    }
}

class NegativeHourException extends Exception {
    public NegativeHourException(int hour) {
        super("An employee cannot have negative hours or sales. \n");
    }
}

class DuplicateEmployeeException extends Exception {
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

    public static void InputSubException(int number) throws InvalidSubInputException {
        if (number < 1 || number > 5) {
            throw new InvalidSubInputException(number);
        }
    }

    public static void NumberNegativeException(double num) throws NumberNegativeException {
        if (num < 0) {
            throw new NumberNegativeException(num);
        }
    }

    public static void NegativeHourException(int hour) throws NegativeHourException {
        if (hour < 0) {
            throw new NegativeHourException(hour);
        }
    }

    private static final int MAX_EMPLOYEES = 100;
    private static Employee[] employees = new Employee[MAX_EMPLOYEES];
    private static int employeesCount = 0;


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
                        while (true) {
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
                                    boolean isValid = socialNumber.matches("^\\d{6}-\\d{5}$");
                                    if (!isValid) {
                                        System.out.println("Invalid social number.");
                                        break;
                                    }
                                    System.out.println("Enter contract type (Seasonal or Annual): ");
                                    String contractType = obj.nextLine();
                                    if (!contractType.equals("Seasonal") && !contractType.equals("Annual")) {
                                        System.out.println("Invalid contract type.");
                                        break;
                                    }
                                    System.out.println("Enter base salary: ");
                                    double salary = obj.nextDouble();
                                    obj.nextLine();

                                    NumberNegativeException(salary);

                                    addFullTime(firstname, lastname, socialNumber, contractType, salary);
                                } catch (NumberNegativeException e) {
                                    System.out.println(e.getMessage());
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input.");
                                }

                            } else if (num == 2) {
                                try {
                                    System.out.println("Enter name: ");
                                    String firstname = obj.nextLine();
                                    System.out.println("Enter last name: ");
                                    String lastname = obj.nextLine();
                                    System.out.println("Enter social number: ");
                                    String socialNumber = obj.nextLine();
                                    boolean isValid = socialNumber.matches("^\\d{6}-\\d{5}$");
                                    if (!isValid) {
                                        System.out.println("Invalid social number.");
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

                                    NumberNegativeException(hourlyRate);
                                    NegativeHourException(hoursWorked);

                                    addPartTime(firstname, lastname, socialNumber, contractType, hourlyRate, hoursWorked);

                                } catch (NegativeHourException | NumberNegativeException e) {
                                    System.out.println(e.getMessage());
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input.");
                                }
                            } else if (num == 3) {
                                try {
                                    System.out.println("Enter name: ");
                                    String firstname = obj.nextLine();
                                    System.out.println("Enter last name: ");
                                    String lastname = obj.nextLine();
                                    System.out.println("Enter social number: ");
                                    String socialNumber = obj.nextLine();
                                    boolean isValid = socialNumber.matches("^\\d{6}-\\d{5}$");
                                    if (!isValid) {
                                        System.out.println("Invalid social number.");
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

                                    NegativeHourException(sales);
                                    NumberNegativeException(commissionRate);

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
                                    boolean isValid = socialNumber.matches("^\\d{6}-\\d{5}$");
                                    if (!isValid) {
                                        System.out.println("Invalid social number.");
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
                                    System.out.println("Enter commission rate: ");
                                    double commissionRate = obj.nextDouble();
                                    obj.nextLine();
                                    System.out.println("Enter sales: ");
                                    int sales = obj.nextInt();
                                    obj.nextLine();

                                    NegativeHourException(sales);
                                    NumberNegativeException(baseSalary);
                                    NumberNegativeException(commissionRate);

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
                                    InputSubException(num);
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
                            System.out.println(
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
                                    InputException(nums);
                                } catch (InvalidInputException e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                        }
                    }catch (InputMismatchException e) {
                        System.out.println("Invalid input.");
                    }

                }if (number == 3) {
                    fireEmployee(obj);

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

    protected static boolean employeeExist(String socialNumber) {
        for (int i = 0; i < socialNumber.length(); i++) {
            if (employees[i] != null && employees[i].getSocialNumber().equals(socialNumber)) {
                return true;
            }
        }
        return false;
    }

    protected static void addFullTime(String firstname, String lastname, String socialNumber, String contractType, double salary) {
        try {
            if (employeeExist(socialNumber)) {
                throw new DuplicateEmployeeException("An Employee with the social number " + socialNumber + " already exists");
            }

            if (employeesCount < MAX_EMPLOYEES) {
                String position = "Full Time Employee";
                employees[employeesCount++] = new FullTime(firstname, lastname, socialNumber, contractType, salary, position);
                System.out.println("Full Time Employee successfully added.");
            } else {
                System.out.println("Employees are already full.");
            }
        } catch (DuplicateEmployeeException e) {
            System.out.println(e.getMessage());
        }
    }

    protected static void addPartTime(String firstname, String lastname, String socialNumber, String contractType,double hourlyRate, int hoursWorked) {
        try {
            if (employeeExist(socialNumber)) {
                throw new DuplicateEmployeeException("An Employee with the social number " + socialNumber + " already exists");
            }


            if (employeesCount < MAX_EMPLOYEES) {
                String position = "Part Time Employee";
                employees[employeesCount++] = new PartTime(firstname, lastname, socialNumber, contractType, position, hourlyRate, hoursWorked);
                System.out.println("Part Time Employee successfully added.");
            } else {
                System.out.println("Employees are already full.");
            }
        } catch (DuplicateEmployeeException e) {
            System.out.println(e.getMessage());
        }
    }

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

    protected static void PrintByData() {
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
                        "|         Employee Information             |\n" +
                        "============================================"
        );
        for (int i = 0; i < employeesCount; i++) {
            System.out.print(employees[i].toString());
        }
    }
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
        for (int i = 0; i < employeesCount; i++) {
            System.out.print(employees[i].getPositionType());
        }
    }
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
        for (int i = 0; i < employeesCount; i++) {
            System.out.print(employees[i].getContractType());
        }
    }

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

        int identification = 0;
        for (int i = 0; i < employeesCount; i++) {
            identification++;
            System.out.println(
                    identification + ". " + employees[i].getPositionType()
            );
        }
        System.out.println("Enter which employee to delete: ");
        int deleteId = obj.nextInt() - 1;
        obj.nextLine();

        if (deleteId >= 0 && deleteId < employeesCount) {
            for (int i = deleteId; i < employeesCount - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[employeesCount - 1] = null;
            employeesCount--;
            System.out.println("Employee successfully Fired.");
        } else {
            System.out.println("Invalid Employee input.");
        }
    }
}


