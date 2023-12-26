package com.phone.model;

public abstract class Contact {
    private String name;
    private String number;
    private final ContactType type;
    private String numberType;

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", type=" + type +
                ", numberType='" + numberType + '\''+ ","
                ;
    }
    public Contact(String name, String number, ContactType type) {
        this.name = name;
        this.number = number;
        this.type = type;
    }
    private String capitalizeFirstCharacter(String str){
        if(str!=null && !str.isEmpty()){
            return Character.toUpperCase(str.charAt(0))+ str.substring(1);
        }
        return str;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public ContactType getType() {
        return type;
    }
    public String getNumberType() {
        return numberType;
    }
    public void setNumberType(String numberType) {
        this.numberType = numberType;
    }
}
