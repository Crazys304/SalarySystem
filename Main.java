import java.util.Scanner;

// Creates a custom exception used for menu input detection
class InvalidInputException extends Exception {
    public InvalidInputException(int number) {
        super("Invalid option. Input numbers between 1 and 6. \n"); // message for
    }
}

public class Main {
    // Checks if the menu input is between the right numbers
    public static void InputException(int number) throws InvalidInputException {
        if (number < 1 || number > 6) {
            throw new InvalidInputException(number);
        }
    }

    private static final int MAX_EMPLOYEES = 200;
    private static Employee[] employees = new Employee[MAX_EMPLOYEES];
    private static int employeesCount = 0;

    public static void main(String[] args) {

        Scanner obj = new Scanner(System.in);

        while (true) {
            //try {
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
                    while (true){
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
                            System.out.println("Enter name: ");
                            String firstname = obj.nextLine();
                            System.out.println("Enter last name: ");
                            String lastname = obj.nextLine();
                            System.out.println("Enter social number: ");
                            String socialNumber = obj.nextLine();
                            System.out.println("Enter contract type: ");
                            String contractType = obj.nextLine();
                            System.out.println("Enter salary: ");
                            double salary = obj.nextDouble();
                            obj.nextLine();
                            employees[employeesCount] = new FullTime(firstname, lastname, socialNumber, contractType);
                            employeesCount++;
                            System.out.println("Full time employee added successfully!");
                        }if (num == 2) {
                            System.out.println("Enter name: ");
                            String firstname = obj.nextLine();
                            System.out.println("Enter last name: ");
                            String lastname = obj.nextLine();
                            System.out.println("Enter social number: ");
                            String socialNumber = obj.nextLine();
                            System.out.println("Enter contract type: ");
                            String contractType = obj.nextLine();
                            System.out.println("Enter hourly rate: ");
                            double hourlyRate = obj.nextDouble();
                            obj.nextLine();
                            System.out.println("Enter hours worked: ");
                            int hoursWorked = obj.nextInt();
                            obj.nextLine();
                            employees[employeesCount] = new PartTime(firstname, lastname, socialNumber, contractType, hourlyRate, hoursWorked);
                            employeesCount++;
                            System.out.println("Part-time employee added successfully!");
                        } if (num == 3) {
                            System.out.println("Enter name: ");
                            String firstname = obj.nextLine();
                            System.out.println("Enter last name: ");
                            String lastname = obj.nextLine();
                            System.out.println("Enter social number: ");
                            String socialNumber = obj.nextLine();
                            System.out.println("Enter contract type: ");
                            String contractType = obj.nextLine();
                            System.out.println("Enter commission rate: ");
                            double commissionRate = obj.nextDouble();
                            obj.nextLine();
                            System.out.println("Enter sales: ");
                            int sales = obj.nextInt();
                            obj.nextLine();
                            employees[employeesCount] = new Commission(firstname, lastname, socialNumber, contractType, commissionRate, sales);
                            employeesCount++;
                            System.out.println("Commission employee added successfully!");
                        } if (num == 4) {
                            System.out.println("Enter name: ");
                            String firstname = obj.nextLine();
                            System.out.println("Enter last name: ");
                            String lastname = obj.nextLine();
                            System.out.println("Enter social number: ");
                            String socialNumber = obj.nextLine();
                            System.out.println("Enter contract type: ");
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
                            employees[employeesCount] = new BaseCommission(firstname, lastname, socialNumber, contractType, baseSalary, commissionRate, sales);
                            employeesCount++;
                            System.out.println("Base Commission employee added successfully!");
                        } if (num == 5) {
                            System.out.println("Back to menu");
                            break;
                        }
                        
                        else {
                            System.out.println("Invalid option. Input numbers between 1 and 5. \n");
                        }
                    }
                } if (number == 2) {

                } if (number == 3) {

                } if (number == 4) {

                } if (number == 5) {
                System.out.println("Thank you have a great day! \nExiting...");
                obj.close();
                System.exit(0); // Exits the program
            }
            //}
        }
    }
}

