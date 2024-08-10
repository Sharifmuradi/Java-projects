package model;

public class BusinessContact extends Contact{
    private String fax;

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public BusinessContact(String name, long number) {
        super(name, number, ContactType.BUSINESS);
    }

    @Override
    public String toString() {
        return super.toString() + ", Fax: " + fax;
    }
}
