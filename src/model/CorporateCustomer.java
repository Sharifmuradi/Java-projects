package model;

public class CorporateCustomer extends Customer{
    private String address;
    private int faxNumber;

    public CorporateCustomer(String name, String address, int faxNumber) {
        super(name,ContactsType.WORK_EMAIL, ContactsType.WORK_PHONE_NUMBER);
        this.address = address;
        this.faxNumber = faxNumber;
    }

    public String getAddress() {
        return address;
    }

    public int getFaxNumber() {
        return faxNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFaxNumber(int faxNumber) {
        this.faxNumber = faxNumber;
    }

}
