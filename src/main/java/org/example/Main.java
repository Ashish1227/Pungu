package org.example;
import java.util.Arrays;
import java.util.Scanner;

import org.example.Print;
import org.example.Add;
import org.example.Search;
import org.example.Change;
import org.example.Delete;

import java.io.*;
import java.net.*;
import java.util.*;
import java.nio.charset.Charset;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
//public class Main {
//    public static String hello(){ //simply returns "Hello World"
//        return "Hello World";
//    }
//    public static void main(String[] args) {
//        // Press Alt+Enter with your caret at the highlighted text to see how
//        // IntelliJ IDEA suggests fixing it.
//        Main.hello();
//    }
//}
//public class Main {
//    public static void main(String[] args) throws IOException {
//
//        Scanner input = new Scanner(System.in);
//        int exit = 0;
//        int answer;
//        //we will loop until user wants to exit the application
//        do {
//            System.out.println("--------Welcome to Address Book---------");
//            System.out.println("Enter '1' to Add contact");
//            System.out.println("Enter '2' to Search contact");
//            System.out.println("Enter '3' to Print contact");
//            System.out.println("Enter '4' to Edit contact");
//            System.out.println("Enter '5' to Delete contact");
//            System.out.println("Enter '0' to Exit");
//            System.out.println("Do you want to print contacts, add contact, search for contact, edit contact or delete contact?");
//            System.out.println("Answer with '1', '2', '3', '4', '5' or '0' to exit application.");
//            try {//we handle the input of the user
//                answer = input.nextInt();
//            } catch (NumberFormatException e) {
//                //e.printStackTrace();
//                answer = -1;
//            }
//            if(answer == 1)//according to user's input we go to each class
//
//                Add.add_contact(input);
//            else if(answer == 2)
//                Search.choose_field(input);
//            else if(answer == 3)
//                Print.show_contacts();
//            else if(answer == 4)
//                Change.choose_field();
//            else if(answer == 5)
//                Delete.choose_field(input);
//
//
//        }while(answer != exit);
//        System.out.println("Application terminating...");
//    }
//}
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static String hello(){ //simply returns "Hello World"
        return "Hello World";
    }
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int exit = 0;
        int answer;
        try {
            do {
                int k=-1;
                k = printMenu();
                try {
                    answer = getUserInput(input);
                } catch (InputMismatchException e) {
                    //e.printStackTrace();
                    answer = -1;
                    input.next(); // Consume the invalid input to avoid an infinite loop
                }

                performAction(answer, input);
            } while (answer != exit);

            System.out.println("Application terminating...");
        } finally {
            input.close();
        }
        Main.hello();
    }

    private static int printMenu() {
        System.out.println("--------Welcome to Address Book---------");
        System.out.println("Enter '1' to Add contact");
        System.out.println("Enter '2' to Search contact");
        System.out.println("Enter '3' to Print contact");
        System.out.println("Enter '4' to Edit contact");
        System.out.println("Enter '5' to Delete contact");
        System.out.println("Enter '0' to Exit");
        System.out.println("Do you want to print contacts, add contact, search for contact, edit contact, or delete contact?");
        System.out.println("Answer with '1', '2', '3', '4', '5' or '0' to exit application.");
        return 0;
    }

    private static int getUserInput(Scanner input) {
        return input.nextInt();
    }

    private static void performAction(int answer, Scanner input) throws IOException {
        switch (answer) {
            case 1:
                Add.add_contact(input);
                break;
            case 2:
                Search.choose_field(input);
                break;
            case 3:
                Print.show_contacts();
                break;
            case 4:
                Change.choose_field();
                break;
            case 5:
                Delete.choose_field(input);
                break;
        }
    }
}
