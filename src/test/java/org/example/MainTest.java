package org.example;
import org.junit.Test;
//
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
//import org.example.Main;

import java.io.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import static org.junit.Assert.*;


public class MainTest {

    private PrintStream originalSystemOut;
    private ByteArrayOutputStream outputStream;
    private static final String OUTPUT_FILE = "test_output.txt";


    void setfileUp() {
        // Save the original System.out
        originalSystemOut = System.out;

        // Redirect System.out to a ByteArrayOutputStream
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    void tearDown() {
        // Restore the original System.out after each test
        System.setOut(originalSystemOut);

        // Save the captured output to a file
        try (FileWriter writer = new FileWriter(OUTPUT_FILE)) {
            writer.write(outputStream.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    @Test      //new test case added
    public void shouldReturnHelloWorld()
    {
        String value = Main.hello();
//        assertThrows(RuntimeException.class, () -> {
//            // If you're expecting an exception, the actual result won't be used
//            // You can add any assertion specific to the exception if needed
//            if (value != null) {
//                throw new RuntimeException();
//            }
//        });
        assertEquals(value, "Hello World");
    }


    @Test
    public void testSearchExitContact() {
        // Arrange
        String input = "0\n";  // Simulate user entering contact information and then exiting
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String expectedMenu = "--------Welcome to Address Book---------\n" +
                "Enter '1' to Add contact\n" +
                "Enter '2' to Search contact\n" +
                "Enter '3' to Print contact\n" +
                "Enter '4' to Edit contact\n" +
                "Enter '5' to Delete contact\n" +
                "Enter '0' to Exit\n" +
                "Do you want to print contacts, add contact, search for contact, edit contact, or delete contact?\n" +
                "Answer with '1', '2', '3', '4', '5' or '0' to exit application.\n" +
                "Application terminating...";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));


        // Act
        try {
            Main.main(new String[]{});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Assert
        String expectedOutput = "Application terminating...\n";
        String actualOutput = outputStream.toString().trim();
        assertEquals(expectedMenu, actualOutput);
        // Add more assertions based on your application's behavior
    }
    @Test
    public void testPrintandExit() {
        // Arrange
        String searchInput = "3\n 0\n"; // Simulate searching for a user and then exiting

        InputStream originalSystemIn = System.in; // Store the original System.in
        System.setIn(new ByteArrayInputStream(searchInput.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Act
        try (Scanner scanner = new Scanner(System.in)) {
            Main.main(new String[]{});
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // Restore the original System.in after the test
            System.setIn(originalSystemIn);
        }

        // Assert
        String expectedOutput = "/home/ashish/IdeaProjects/Pungu/src/contacts.txt\n" +
                "/home/ashish/IdeaProjects/Pungu/src\n" +
                "true\n" +
                "-------------------\n" +
                "Name:";
        String actualstring = outputStream.toString().trim();
//        setfileUp();
//        System.out.println(actualstring);
//        tearDown();
        assertTrue(actualstring.contains(expectedOutput));
    }

}
