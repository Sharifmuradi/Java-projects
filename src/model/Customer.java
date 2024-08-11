package model;

public abstract class Customer {
    private String name;
    private  ContactsType number=null;
    private ContactsType email=null;

    public Customer(String name, ContactsType number, ContactsType email){
        this.name =name;
        this.number =number;
        this.email =email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", email=" + email +
                '}';
    }
}
