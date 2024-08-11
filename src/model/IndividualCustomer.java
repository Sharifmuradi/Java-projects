package model;

public class IndividualCustomer extends Customer{
    private String family;
    private int passportNumber;
    private int nationalCode;

    public IndividualCustomer(String name ,String family ,int passportNumber,int nationalCode) {
        super(name,ContactsType.PERSONAL_EMAIL,ContactsType.PERSONAL_PHONE_NUMBER);
        this.family = family;
        this.passportNumber = passportNumber;
        this.nationalCode = nationalCode;
    }
    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }
    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }
    public int getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(int nationalCode) {
        this.nationalCode = nationalCode;
    }

}
