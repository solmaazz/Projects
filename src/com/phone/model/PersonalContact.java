package com.phone.model;
public class PersonalContact extends Contact{
    private String family;
    public String getFamily() {
        return family;
    }
    public void setFamily(String family) {
        this.family = family;
    }
    @Override
    public String toString() {
        return "PersonalContact{" + super.toString() +
                "family='" + family + '\'' +
                '}';
    }
    public PersonalContact(String name, String number) {
        super(name,number,ContactType.PERSONAL);
    }

}
