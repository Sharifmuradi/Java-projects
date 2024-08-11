package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomerSystem {
    private static ArrayList<Customer> customerSystems= new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    String input;
    public  void run() {
        while (true) {
            String input = menu();
            if (CustomerManagementSystem(input, scanner)) {
                break;
            }
        }
    }
    public boolean CustomerManagementSystem(String input, Scanner scanner){

        switch(input){
            case "6":
                System.out.println("Exiting the application");
                return true;
            case "1":
                addCustomer(scanner);
                break;
            case "2":
                showCustomer();
                break;
            case "3":
                searchCustomer();
                break;
            case "4":
                deleteCustomer();
                break;
            case "5":
                updateCustomer();
                break;



        }


        return false;
    }

    private void addCustomer(Scanner scanner){
        System.out.println("Enter contact type :" +
                "\n1.PERSONAL, " +
                "\n2.BUSINESS(2 or other numbers):");
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice==1){
            System.out.println("Enter name:");
            String name = scanner.nextLine();
            System.out.println("Enter family:");
            String family = scanner.nextLine();
            System.out.println("Enter your passportNumber:");
            int passportNumber = scanner.nextInt();
            System.out.println("Enter your nationalCode");
            int nationalCode = scanner.nextInt();
            scanner.nextLine();
            IndividualCustomer individualCustomer=new IndividualCustomer(name,family,passportNumber,nationalCode);
            customerSystems.add(individualCustomer);
        }else {
            System.out.println("Enter name:");
            String name = scanner.nextLine();
            System.out.println("Enter address:");
            String address = scanner.nextLine();
            System.out.println("Enter your faxNumber:");
            int faxNumber = scanner.nextInt();
            scanner.nextLine();
            CorporateCustomer corporateCustomer = new CorporateCustomer(name,address,faxNumber);
            customerSystems.add(corporateCustomer);

        }
    }
    private void showCustomer(){
        if(customerSystems.isEmpty()){
            System.out.println("There are no Customers.");
        }else {
            System.out.println("All Customer:");
            customerSystems.forEach(System.out::println);
        }

    }

    private void searchCustomer(){

        System.out.println("Enter the name to search:");
        String name = scanner.nextLine();
        List<Customer>  customerToSearch = customerSystems.stream()
                .filter(customer -> customer.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
        if(customerSystems.isEmpty()){
            System.out.println("No customer found with the name: " + name);
        }else {
            System.out.println("Customers found:");
            customerToSearch.forEach(System.out::println);
        }
    }
    private void deleteCustomer(){
        System.out.println("Enter the name to delete : ");
        String name = scanner.nextLine().trim();
        List<Customer> customerToDelete = customerSystems.stream()
                .filter(customer -> customer.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
        if (customerToDelete.isEmpty()) {
            System.out.println("No customer found with the name: " + name);
        } else {
            customerSystems.removeAll(customerToDelete);
            System.out.println("Deleted " + customerToDelete.size() + " customer(s) with the name: " + name);
        }

    }

    private void updateCustomer(){
        if(customerSystems.isEmpty()){
            System.out.println("CustomerSystem is empty! No customer to update.");
        }
        System.out.println("Enter the name  of the customer you want to update:");
        String name = scanner.nextLine();
        Customer customerToUpdate = customerSystems.stream()
                .filter(customer -> customer.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
        if(customerToUpdate==null){
            System.out.println("Customer not found.");
           // return;
        }
        System.out.println("Current customer info: " + customerToUpdate);

        System.out.println("Enter new name (leave blank to keep current): ");
        String newName = scanner.nextLine().trim();
        if(!newName.isBlank()){
            customerToUpdate.setName(newName);
        }
        System.out.println("Customer updated successfully!");
    }

    private String menu(){
        System.out.println(" ");
        System.out.println("      CustomerSystem    ");
        System.out.println("Menu    ");
        System.out.println("Select the type of Customer:");
        System.out.println("1. Add new Customer");
        System.out.println("2. Show registered Customer");
        System.out.println("3. Search Customer");
        System.out.println("4. Delete a Customer");
        System.out.println("5. Update a Customer");
        System.out.println("6. Exit");
        return scanner.nextLine();
    }


}
