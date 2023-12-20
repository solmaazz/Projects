package com.phone;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {
    private static ArrayList<String> names=new ArrayList<>();

    private static ArrayList<String> numbers=new ArrayList<>();
    private static ArrayList<Contact> contacts=new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
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
                    System.out.println("edit");
                    break;
                case 4:
                    System.out.println("delete");
                    break;
                case 5:
                    System.out.println(" Exiting...! ");
                    System.exit(0);
                    break;
                default:
                    System.out.println(" *** Invalid number. ***");
            }
        } while (input != 5);
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("**** Menu **** ");
        System.out.println("---- 1. Add new contact ");
        System.out.println("---- 2. Display all contact ");
        System.out.println("---- 0. Exit \n");
    }

    private static void displayAllContact() {
        if(contacts.isEmpty()){
            System.out.println("phone book is empty!");
        }
        else {
            for (Contact contact : contacts) {
                System.out.println("name:" + contact.name);
                System.out.println("number:" + contact.number);
            }
        }
    }

    private static void addContact(Scanner scanner){
        Contact newContacts=new Contact();
        System.out.println("enter name:");
        newContacts.name=scanner.nextLine();
//        names.add(scanner.nextLine());
        System.out.println("enter number:");
        newContacts.number=scanner.nextLine();
//        numbers.add(scanner.nextLine());
        contacts.add(newContacts);
        System.out.println("Add successfully!");
    }
}
