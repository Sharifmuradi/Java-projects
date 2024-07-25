import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TelephoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Long> numbers = new ArrayList<>();
        List<String> names = new ArrayList<>();

        while (true) {
            System.out.println("Application Telephone ");
            System.out.println("");
            System.out.println("---------Menu---------");
            System.out.println("1. Add new number");
            System.out.println("2. Show registered numbers");
            System.out.println("3. Exit");
            System.out.println("-------------------------------------------");
            System.out.println("Select a menu item:");
            String input = scanner.nextLine();

            if (input.equals("1")) {
                try {
                    System.out.println("Enter your number:");
                    long number = scanner.nextLong();
                    scanner.nextLine(); // Consume the newline left-over
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    numbers.add(number);
                    names.add(name);
                }catch (Exception e){
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine(); // Clear the invalid input
                }
            } else if (input.equals("2")) {
                System.out.println("Showing registered numbers:");
                for (int i = 0; i < numbers.size(); i++) {
                    System.out.format("Number: %d, Name: %s\n", numbers.get(i), names.get(i));
                }
            } else if (input.equals("3")) {
                System.out.println("Exiting the application");
                break;
            } else {
                System.out.println("Invalid selection.");
            }
        }
        scanner.close();
    }
}