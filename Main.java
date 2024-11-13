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

            //}
        }
    }
}

