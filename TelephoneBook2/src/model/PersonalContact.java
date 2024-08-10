package model;

public class PersonalContact  extends Contact{
    private  String family ;

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public PersonalContact(String name, long number) {
        super(name, number, ContactType.PERSONAL);
    }

    @Override
    public String toString() {
        return super.toString() + ", Family: " + family;
    }
}
