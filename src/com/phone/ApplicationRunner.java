package com.phone;
import com.phone.service.Phonebook;
import java.util.Scanner;
public class ApplicationRunner {
    public static void main(String[] args) {
        try (Phonebook phonebook = new Phonebook()){
            phonebook.run();
        }
        finally {
            System.gc();
        }
    }
}
