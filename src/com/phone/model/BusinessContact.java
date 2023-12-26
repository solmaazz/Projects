package com.phone.model;
public class BusinessContact extends Contact{
    private String fax;
    public String getFax() {
        return fax;
    }
    @Override
    public String toString() {
        return "BusinessContact{" + super.toString() +
                "fax='" + fax + '\'' +
                '}';
    }
    public void setFax(String fax) {
        this.fax = fax;
    }
    public BusinessContact(String name, String number) {
        super(name, number,ContactType.BUSINESS);
    }
}
