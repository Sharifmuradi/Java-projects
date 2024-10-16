package managers;

import models.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

public class InputManager {
    private Scanner scanner;
    public InputManager () {
        this.scanner = new Scanner(System.in);
    }
    private String readName (){
        String name = "";
        while (true){
            System.out.println("Enter name of the Product (Shouldn't be empty or null ) = ");
            name = scanner.nextLine();
            if (name.equals("")) System.err.println("Shouldn't be empty or null!!!!");
            else break;
        }
        return name;
    }
    private long readCoordinateX (){
        long x = 0l;
        while (true){
            try {
                System.out.println("Enter Coordinates X (Should be smaller than 495) = ");
                String x1 = scanner.nextLine();
                if (x1.equals(""))throw new Exception ("Can't be empty!!!");
                x = Long.parseLong(x1);
                if (x > 495)throw new Exception ("Should be smaller than 495!!!!");
                else break;
            }catch (NumberFormatException exception ){
                System.err.println("Should be a number !!!!!");
            }catch (Exception exception){
                System.err.println(exception.getMessage());
            }
        }
        return x;
    }
    private Integer  readCoordinatesY (){
        Integer y = 0;
        while (true){
            try{
                System.out.println("Enter Coordinates Y (Should be greater than -226) = ");
                String y1 = scanner.nextLine();
                if (y1.equals("")) throw new Exception("Can't be empty!!!");
                y = Integer.parseInt(y1);
                if (y < -226)throw new Exception("Should be greater than -226 !!!!!!");
                else break;
            }catch (NumberFormatException exception ){
                System.err.println("Should be a number!!!");
            }catch (Exception exception ){
                System.err.println(exception.getMessage());
            }
        }
        return y;
    }
    private Coordinates readCoordinates(){
        return new Coordinates (readCoordinateX(),readCoordinatesY());
    }
    private Date readCreationDate (){
        return new Date();
    }
    private Double readPrice (){
        Double price = 0d;
        while(true){
            try{
                System.out.println("Enter price of the product (Should be greater than 0) = ");
                String p = scanner.nextLine();
                if (p.equals(""))throw new Exception ("Shouldn't be empty !!!!!");
                price = Double.parseDouble(p);
                if (price < 0) throw new Exception ("Should be greater than 0 !!!!");
                else break;
            }catch (NumberFormatException exception ){
                System.err.println("Should be a number!!!!");
            }catch (Exception exception ){
                System.err.println(exception.getMessage());
            }
        }
        return price;
    }
    private UnitOfMeasure readUnitOfMeasure (){
        UnitOfMeasure unit;
        while (true){
            System.out.println("Enter unit of measure of the Product (CENTIMETERS, PCS, MILLIGRAMS)[Can be empty]  = ");
            String u = scanner.nextLine();
            if (u.equals("")) {
                unit = null;
                break;
            }
            try {
                unit = UnitOfMeasure.valueOf(u.toUpperCase());
                break;
            }catch (IllegalArgumentException exception ){
                System.err.println("Invalid unit of measure!!!!");
            }
        }
        return unit;
    }
    private boolean isOwnerWantedToBeAdded (){
        while(true){
            try{
                System.out.println("Enter (1) if you want to add Owner and (2) if you don't want to enter Owner = ");
                String answer = scanner.nextLine();
                if (answer.equals(""))throw new Exception("Please answer !!!!");
                int choice = Integer.parseInt(answer);
                return choice == 1;
            }catch (NumberFormatException exception){
                System.out.println("Invalid input!!!!");
            } catch (Exception exception ){
                System.err.println(exception.getMessage());
            }
        }
    }
    private String readOwnerName (){
        String name  = "";
        while (true){
            System.out.println("Enter name of the Owner (Shouldn't be empty = ");
            name = scanner.nextLine();
            if (name.equals("")) System.err.println("Shouldn't be empty !!!!!");
            else break;
        }
        return name;
    }
    private LocalDate readOwnerBirthday (){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthday = null;
        while (true){
            try {
                System.out.println("Enter Owner s birthday in this format (yyyy-MM-dd) [Shouldn't be empty] = ");
                String date = scanner.nextLine();
                if(date.equals(""))throw new Exception ("Can't be empty or null!!!!");
                birthday = LocalDate.parse(date, formatter);
                break;
            }catch (DateTimeParseException exception ){
                System.err.println("Should be in this format (yyyy-MM-dd) make sure to input everything correctly!!!");
            }catch (Exception exception){
                System.err.println(exception.getMessage());
            }

        }
        return birthday;
    }
    private Integer readOwnerWeight (){
        Integer weight = 0 ;
        while (true){
            try {
                System.out.println("Enter weight of the Owner (Should be greater than 0) = ");
                String w = scanner.nextLine();
                if (w.equals("")) throw new Exception ("Can't be empty or null !!!!!");
                weight = Integer.parseInt(w);
                if (weight <= 0) throw new Exception ("Should be greater than 0");
                break;
            }catch (NumberFormatException exception ){
                System.err.println("Should be a number !!!!!");
            }catch (Exception exception){
                System.err.println(exception.getMessage());
            }
        }
        return weight;
    }
    private boolean isLocationWantedToBeAdded (){
        while(true){
            try{
                System.out.println("Enter (1) if you want to add Location and (2) if you don't want to enter Location = ");
                String answer = scanner.nextLine();
                if (answer.equals(""))throw new Exception("Please answer !!!!");
                int choice = Integer.parseInt(answer);
                return choice == 1;
            }catch (NumberFormatException exception){
                System.out.println("Invalid input!!!!");
            } catch (Exception exception ){
                System.err.println(exception.getMessage());
            }
        }
    }
    private Double readLocationX (){
        Double x = 0d;
        while (true){
            try{
                System.out.println("Enter Location x (Shouldn't be empty) = ");
                String x1 = scanner.nextLine();
                if( x1.equals(""))throw new Exception("Shouldn't be empty!!!");
                x = Double.parseDouble(x1);
                break;
            }catch (NumberFormatException exception){
                System.err.println("Should be a number !!!");
            }catch (Exception exception){
                System.err.println(exception.getMessage());
            }
        }
        return x;
    }
    private double readLocationY(){
        double y = 0d;
        while (true){
            try{
                System.out.println("Enter Location y (Shouldn't be empty) = ");
                String y1 = scanner.nextLine();
                if( y1.equals(""))throw new Exception("Shouldn't be empty!!!");
                y = Double.parseDouble(y1);
                break;
            }catch (NumberFormatException exception){
                System.err.println("Should be a number !!!");
            }catch (Exception exception){
                System.err.println(exception.getMessage());
            }
        }
        return y;
    }
    private String readLocationName (){
        String name = "";
        while (true){
            System.out.println("Enter Location name (Shouldn't be empty ) = ");
            name = scanner.nextLine();
            if (name.equals("")) System.err.println("shouldn't be empty !!!!");
            else break;
        }
        return name;
    }
    private Location readLocation (){
        if (isLocationWantedToBeAdded()) return new Location(readLocationX(),readLocationY(),readLocationName());
        else return null;
    }
    private Person readOwner (){
        if (isOwnerWantedToBeAdded()) return new Person(readOwnerName(),readOwnerBirthday(),readOwnerWeight(),readLocation());
        else return null;
    }
    public Product readProduct (){
        return new Product(readName(),readCoordinates(),readCreationDate(),readPrice(),readUnitOfMeasure(),readOwner());
    }
    public String readCommand (){
        System.out.println("Enter a command (help to get help) = ");
        return scanner.nextLine();
    }
}
