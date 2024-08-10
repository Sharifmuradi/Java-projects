package model;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.*;

public class PhoneBook {
    private static ArrayList<Contact> contacts = new ArrayList<>();
    Scanner scanner =new Scanner(System.in);
    public  void run() {
        while (true) {
            String input = menu();
            if (processMenuSelection(input, scanner)) {
                break;
            }
        }
    }
    private  boolean processMenuSelection(String input, Scanner scanner) {
        switch (input) {
            case "0":
                System.out.println("Exiting the application");
                return true;
            case "1":
                addContact(scanner);
                break;
            case "2":
                showContacts();
                break;
            case "3":
                searchContact();
                break;
            case "4":
                deleteContact();
                break;
            case "5":
                updateContact();
                break;
            default:
                System.out.println("Invalid selection.");
        }
        return false;
    }
    private  void addContact(Scanner scanner) {
        try {
             // Consume newline
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
                System.out.println("Enter your number:");
                long number = scanner.nextLong();
                scanner.nextLine();
                PersonalContact personalContact = new PersonalContact(name ,number);
                personalContact.setFamily(family);
                contacts.add(personalContact);
            }else {
                System.out.println("Enter name:");
                String name = scanner.nextLine();
                System.out.println("Enter your number:");
                long number = scanner.nextLong();
                scanner.nextLine();
                System.out.println("Enter fax number: ");
                String fax = scanner.nextLine();
                BusinessContact businessContact = new BusinessContact(name ,number);
                businessContact.setFax(fax);
                contacts.add(businessContact);
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid contact type. Please enter either 'PERSONAL' or 'BUSINESS'.");
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine();  // Clear the invalid input
        }
    }
    private  void showContacts(){
        if (contacts.isEmpty()){
            System.out.println("Phonebook is empty! ");
        }else {
            System.out.println("All Contacts: ");
            for (Contact contact : contacts){
                System.out.println(contact);
            }
        }
    }
    private void searchContact(){
        System.out.println("Search by:");
        System.out.println("1. Name");
        System.out.println("2. Number");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        switch (choice){
            case 1:
                searchByName();
                break;
            case 2:
                searchByNumber();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
    private void searchByName(){
        System.out.println("Enter the name to search: ");
        String name = scanner.nextLine().trim();

        List<Contact> results = contacts.stream()
                .filter(contact -> contact.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());

        if(results.isEmpty()){
            System.out.println("No contact found with the name: " + name);
        }else {
            results.forEach(System.out::println);
        }

//        boolean found = false;
//        for (Contact contact:contacts){
//            if(contact.getName().equalsIgnoreCase(name)){
//                System.out.println(contact);
//                found=true;
//            }
//        }
//        if (!found){
//            System.out.println("No contact found with the name: " + name);
//        }
    }
    private void searchByNumber() {
        System.out.print("Enter the number to search: ");
        long number;

        try {
            number = scanner.nextLong();
            scanner.nextLine(); // Consume newline

            boolean found = false;
            for (Contact contact : contacts) {
                if (contact.getNumber() == number) {
                    System.out.println(contact);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No contact found with the number: " + number);
            }
        } catch (Exception e) {
            System.out.println("Invalid number format.");
            scanner.nextLine(); // Clear the invalid input
        }
    }
    private void deleteContact(){
        if (contacts.isEmpty()){
            System.out.println("Phonebook is empty. No contacts to delete.");
            return;
        }
        System.out.println("Enter the name or number of the contact to delete:");
        String input = scanner.nextLine();
        Contact contactToDelete = null;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(input) || String.valueOf(contact.getNumber()).equals(input)) {
                contactToDelete = contact;
                break;
            }
        }
        if (contactToDelete != null) {
            contacts.remove(contactToDelete);
            System.out.println("Contact " + contactToDelete.getName() + " deleted successfully.");
        } else {
            System.out.println("No contact found with the given name or number.");
        }
    }
    private void updateContact(){
        if (contacts.isEmpty()){
            System.out.println("Phonebook is empty! No contacts to update.");
        }
        System.out.println("Enter the name or number of the contact you want to update: ");
        String searchTerm= scanner.nextLine();

        Contact contactToUpdate = null;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(searchTerm) || String.valueOf(contact.getNumber()).equals(searchTerm)) {
                contactToUpdate = contact;
                break;
            }
        }
        if (contactToUpdate == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Current contact info: " + contactToUpdate);
        System.out.println("Enter new name (leave blank to keep current): ");
        String newName = scanner.nextLine();
        if (!newName.isBlank()) {
            contactToUpdate.setName(newName);
        }
        System.out.println("Enter new number (leave blank to keep current): ");
        String newNumber = scanner.nextLine();

        if (!newNumber.isBlank()) {
            try {
                contactToUpdate.setNumber(Long.parseLong(newNumber));
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Number not updated.");
            }
        }
        if (contactToUpdate instanceof PersonalContact) {
            System.out.println("Enter new family (leave blank to keep current): ");
            String newFamily = scanner.nextLine();
            if (!newFamily.isBlank()) {
                ((PersonalContact) contactToUpdate).setFamily(newFamily);
            }
        }
        if (contactToUpdate instanceof BusinessContact) {
            System.out.println("Enter new fax (leave blank to keep current): ");
            String newFax = scanner.nextLine();
            if (!newFax.isBlank()) {
                ((BusinessContact) contactToUpdate).setFax(newFax);
            }
        }
        System.out.println("Contact updated successfully!");
    }
    private String menu() {
        System.out.println("\n");
        System.out.println("Application Telephone \n");
        System.out.println("---------Menu---------");
        System.out.println("0. Exit");
        System.out.println("1. Add new number");
        System.out.println("2. Show registered numbers");
        System.out.println("3. Search numbers");
        System.out.println("4. Delete a contact");
        System.out.println("5. Update a contact");
        System.out.println("-------------------------------------------");
        System.out.println("Select a menu item:");
        return scanner.nextLine();
    }
}
