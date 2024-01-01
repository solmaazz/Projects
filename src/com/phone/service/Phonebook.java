package com.phone.service;

import com.phone.model.BusinessContact;
import com.phone.model.Contact;
import com.phone.model.PersonalContact;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Phonebook implements AutoCloseable {
    private  ArrayList<Contact> contacts = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    private void printMenu() {
        System.out.println("**** Menu **** ");
        System.out.println("---- 1. Add new contact ");
        System.out.println("---- 2. Display all contact ");
        System.out.println("---- 3. Search and print by name");
        System.out.println("---- 4. Search and print by family");
        System.out.println("---- 5. Search and edit by name ");
        System.out.println("---- 6. Delete contact ");
        System.out.println("---- 0. Exit \n");
    }
    private void displayAllContact() {
        if(contacts.isEmpty()){
            System.out.println("phone book is empty!");
        }
        else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }
    private   void addContact(){

        System.out.println("**** Contact Type **** ");
        System.out.println(" 1. PERSONAL ");
        System.out.println(" 2. BUSINESS ");
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if(choice==1){
            String name = getUserInput("Enter name:");
            String family = getUserInput("Enter family:");
            String number = getUserInput("Enter number:");
            PersonalContact personalContact=new PersonalContact(name,number);
            personalContact.setFamily(family);
            contacts.add(personalContact);
            System.out.println("PersonalContact added successfully!");
        } else {
            String name = getUserInput("Enter name:");
            String number = getUserInput("Enter number:");
            String fax = getUserInput("Enter Fax number:");
            BusinessContact businessContact= new BusinessContact(name,number);
            businessContact.setFax(fax);
            contacts.add(businessContact);
            System.out.println("BusinessContact added successfully!");
        }
    }

    private String getUserInput(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public void run(){
        int input;
        do {
            printMenu();
            System.out.println("Enter your choice: ");
            input = scanner.nextInt();
            scanner.nextLine();
            switch (input) {
                case 1:
                    addContact();
                    break;
                case 2:
                    displayAllContact();
                    break;
                case 3:
                   searchByName();
                    break;
                case 4:
                    searchByFamily();
                    break;
                case 5:
                    searchAndEditByName();
                    break;
                case 6:
                    searchAndDeleteContactsByName();
                    break;
                case 0:
                    System.out.println(" Exiting...! ");
                    break;
                default:
                    System.out.println(" *** Invalid number ***");
            }
        } while (input!= 0);
        scanner.close();
    }

    private void searchAndDeleteContactsByName() {
        String name= getUserInput("Enter the name:");
        contacts.removeIf(contact ->contact.getName().equalsIgnoreCase(name) );
 //       List<Contact> contactsToDelete =new ArrayList<>();
 //      contactsToDelete = contacts.stream()
//               .filter(contact -> contact.getName().equalsIgnoreCase(name))
//                .collect(Collectors.toList());

/*        for (Contact contact : contacts){
            if(contact.getName().equalsIgnoreCase(name)){
                contactsToDelete.add(contact);
            }
        }*/

        //       if(!contactsToDelete.isEmpty()){
        //        contacts.removeAll(contactsToDelete);
 //       }
    }
    private void searchAndEditByName() {
        String name= getUserInput("Enter the name:");
        for(Contact contact: contacts){
            if(contact.getName().equalsIgnoreCase(name)){
                String number= getUserInput("Enter new number:");
                contact.setNumber(number);
                if(contact instanceof PersonalContact personalContact){
                    String family= getUserInput("Enter new family:");
                    personalContact.setFamily(family);
                }else if(contact instanceof BusinessContact businessContact){
                    String fax= getUserInput("Enter new fax:");
                    businessContact.setFax(fax);
                }
            }
        }
    }

    private void searchByFamily() {
        String family= getUserInput("Enter the family:");
        contacts.stream()
                .filter(contact -> contact instanceof PersonalContact)
                .map(contact -> ((PersonalContact) contact))
                .filter(personalContact -> personalContact.getFamily().equalsIgnoreCase(family))
                .forEach(System.out::println);

//        for (Contact contact : contacts) {
//            if (contact instanceof PersonalContact personalContact){
//                if(personalContact.getFamily().equalsIgnoreCase(family)){
//                    System.out.println(contact);
//                }
//            }
//        }

    }

    private void searchByName() {
        String name= getUserInput("Enter the name:");
        contacts.stream()
                .filter(contact -> contact.getName().equalsIgnoreCase(name))
                .forEach(System.out::println);

//        for (Contact contact : contacts) {
//            if(contact.getName().equalsIgnoreCase(name)){
//                System.out.println(contact);
//            }
//
//        }
    }

    @Override
    public void close()  {
        scanner.close();
        System.out.println(" close! ");
    }
}

