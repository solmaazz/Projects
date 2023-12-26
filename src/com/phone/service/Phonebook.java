package com.phone.service;

import com.phone.model.BusinessContact;
import com.phone.model.Contact;
import com.phone.model.PersonalContact;
import java.util.ArrayList;
import java.util.Scanner;
public class Phonebook implements AutoCloseable {
    private  ArrayList<Contact> contacts = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    private void printMenu() {
        System.out.println("**** Menu **** ");
        System.out.println("---- 1. Add new contact ");
        System.out.println("---- 2. Display all contact ");
        System.out.println("---- 3. Search ");
        System.out.println("---- 4. Edit contact ");
        System.out.println("---- 5. Delete contact ");
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
    private   void addContact(Scanner scanner){

        System.out.println("**** Contact Type **** ");
        System.out.println(" 1. PERSONAL ");
        System.out.println(" 2. BUSINESS ");
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if(choice==1){
            System.out.println("Enter name:");
            String name = scanner.nextLine();
            System.out.println("Enter family:");
            String family = scanner.nextLine();
            System.out.println("Enter number:");
            String number = scanner.nextLine();
            PersonalContact personalContact=new PersonalContact(name,number);
            personalContact.setFamily(family);
            contacts.add(personalContact);
            System.out.println("PersonalContact added successfully!");
        } else {
            System.out.println("Enter name:");
            String name = scanner.nextLine();
            System.out.println("Enter number:");
            String number = scanner.nextLine();
            System.out.println("Enter Fax number:");
            String fax = scanner.nextLine();
            BusinessContact businessContact= new BusinessContact(name,number);
            businessContact.setFax(fax);
            contacts.add(businessContact);
            System.out.println("BusinessContact added successfully!");
        }
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
                    addContact(scanner);
                    break;
                case 2:
                    displayAllContact();
                    break;
                case 3:
                    System.out.println("search");
                    break;
                case 4:
                    System.out.println("edit");
                    break;
                case 5:
                    System.out.println("delete");
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
    @Override
    public void close()  {
        scanner.close();
        System.out.println(" close! ");
    }
}

