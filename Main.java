import java.util.InputMismatchException;
import java.util.Scanner;

// Creates a custom exception used for menu input detection
class InvalidInputException extends Exception {
    public InvalidInputException(int number) {
        super("Invalid option. Input numbers between 1 and 5. \n"); // message for
    }
}

public class Main {
    // Checks if the menu input is between the right numbers
    public static void InputException(int number) throws InvalidInputException {
        if (number < 1 || number > 5) {
            throw new InvalidInputException(number);
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
                                "\n|2. Print employee data |" +
                                "\n|3. Print by position   |" +
                                "\n|4. Print by contract   |" +
                                "\n|5. Exit                |" +
                                "\n-------------------------" +
                                "\nEnter command (1 to 5): "
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
                                    System.out.println("Enter contract type (Seasonal or Annual): ");
                                    String contractType = obj.nextLine();
                                    System.out.println("Enter base salary: ");
                                    double salary = obj.nextDouble();
                                    obj.nextLine();

                                    addFullTime(firstname, lastname, socialNumber, contractType, salary);
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
                                    System.out.println("Enter contract type (Seasonal or Annual): ");
                                    String contractType = obj.nextLine();
                                    System.out.println("Enter hourly rate: ");
                                    double hourlyRate = obj.nextDouble();
                                    obj.nextLine();
                                    System.out.println("Enter hours worked: ");
                                    int hoursWorked = obj.nextInt();
                                    obj.nextLine();

                                    addPartTime(firstname, lastname, socialNumber, contractType, hourlyRate, hoursWorked);
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
                                    System.out.println("Enter contract type (Seasonal or Annual): ");
                                    String contractType = obj.nextLine();
                                    System.out.println("Enter commission rate (Euro): ");
                                    double commissionRate = obj.nextDouble();
                                    obj.nextLine();
                                    System.out.println("Enter number of sales: ");
                                    int sales = obj.nextInt();
                                    obj.nextLine();
                                    addCommission(firstname, lastname, socialNumber, contractType, commissionRate, sales);
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
                                    System.out.println("Enter contract type (Seasonal or Annual): ");
                                    String contractType = obj.nextLine();
                                    System.out.println("Enter base salary: ");
                                    double baseSalary = obj.nextDouble();
                                    obj.nextLine();
                                    System.out.println("Enter commission rate: ");
                                    double commissionRate = obj.nextDouble();
                                    obj.nextLine();
                                    System.out.println("Enter sales: ");
                                    int sales = obj.nextInt();
                                    obj.nextLine();
                                    addBaseCommission(firstname, lastname, socialNumber, contractType, baseSalary, commissionRate, sales);
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input.");
                                }
                            } else if (num == 5) {
                                System.out.println("Return to menu");
                                break;
                            } else {
                                System.out.println("Invalid option. Input numbers between 1 and 5. \n");
                            }
                        }
                    }catch (InputMismatchException e) {
                        System.out.println("Invalid input.");
                    }
                }
                if (number == 2) {
                    PrintByData();
                }
                if (number == 3) {
                    PrintByPosition();
                }
                if (number == 4) {
                    PrintByContract();
                }
                if (number == 5) {
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
            }catch (InputMismatchException e) {
                System.out.println("Invalid input.");
                obj.nextLine();
            }
        }
    }

    protected static void addFullTime(String firstname, String lastname, String socialNumber, String contractType, double salary) {
        if (employeesCount < MAX_EMPLOYEES) {
            String position = "Full Time Employee";
            employees[employeesCount++] = new FullTime(firstname, lastname, socialNumber, contractType, salary, position);
            System.out.println("Full Time Employee successfully added.");
        } else {
            System.out.println("Employees are already full.");
        }
    }

    protected static void addPartTime(String firstname, String lastname, String socialnumber, String contractType,double hourlyRate, int hoursWorked) {
        if (employeesCount < MAX_EMPLOYEES) {
            String position = "Part Time Employee";
            employees[employeesCount++] = new PartTime(firstname, lastname, socialnumber, contractType, position, hourlyRate, hoursWorked);
            System.out.println("Part Time Employee successfully added.");
        } else {
            System.out.println("Employees are already full.");
        }
    }

    protected static void addCommission(String firstname, String lastname, String socialNumber, String contractType, double commissionRate, int sales) {
        if (employeesCount < MAX_EMPLOYEES) {
            String position = "Commission Employee";
            employees[employeesCount++] = new Commission(firstname, lastname, socialNumber, contractType, position, commissionRate, sales);
            System.out.println("Commission Employee successfully added.");
        } else {
            System.out.println("Employees are already full.");
        }
    }

    protected static void addBaseCommission(String firstname, String lastname, String socialNumber, String contractType, double baseSalary, double commissionRate, int sales) {
        if (employeesCount < MAX_EMPLOYEES) {
            String position = "Base Employee with Commission";
            employees[employeesCount++] = new BaseCommission(firstname, lastname, socialNumber, contractType, position, baseSalary, commissionRate, sales);
            System.out.println("Base Commission Employee successfully added.");
        } else {
            System.out.println("Employees are already full.");
        }
    }

    protected static void PrintByData() {
        if (employeesCount == 0) {
            System.out.println(
                            "====================================\n" +
                            "|      No Employees added.         |\n" +
                            "====================================\n"
            );
            return;
        }System.out.println(
                "====================================\n" +
                        "|      Employee Information        |\n" +
                        "===================================="
        );
        for (int i = 0; i < employeesCount; i++) {
            System.out.print(employees[i].getEmployeeData());
        }
    }
    protected static void PrintByPosition() {
        if (employeesCount == 0) {
            System.out.println(
                    "====================================\n" +
                            "|      No Employees added.         |\n" +
                            "====================================\n"
            );
            return;
        }System.out.println(
                "====================================\n" +
                        "|      Employee Position           |\n" +
                        "===================================="
        );
        for (int i = 0; i < employeesCount; i++) {
            System.out.print(employees[i].getPositionType());
        }
    }
    protected static void PrintByContract() {
        if (employeesCount == 0) {
            System.out.println(
                    "====================================\n" +
                            "|      No Employees added.         |\n" +
                            "====================================\n"
            );
            return;
        }System.out.println(
                "====================================\n" +
                        "|      Employee Position           |\n" +
                        "===================================="
        );
        for (int i = 0; i < employeesCount; i++) {
            System.out.print(employees[i].getContractType());
        }
    }
}


