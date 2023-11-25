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

    @Test
    public void testSearchExistingandExit() {
        // Arrange
        String searchInput = "2\n1\nAshish\nGatsy\n0\n0\n0\n"; // Simulate searching for a user and then exiting

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
        String expectedOutput = "Do you want to search beased on name or based on phone?\n" +
                "Give '1' or '2' or anser '0' to return to main menu.\n" +
                "Give Name: \n" +
                "Give Surname: \n" +
                "----There is a contact for the information you gave----\n" +
                "Name:";
        String actualstring = outputStream.toString().trim();
//        setfileUp();
//        System.out.println(actualstring);
//        tearDown();
        assertTrue(actualstring.contains(expectedOutput));
    }

    @Test
    public void testSearchExisting1andExit() {
        // Arrange
        String searchInput = "2\n1\nAshish\nGatreddi\n0\n0\n0\n"; // Simulate searching for a user and then exiting

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
        String expectedOutput = "Do you want to search beased on name or based on phone?\n" +
                "Give '1' or '2' or anser '0' to return to main menu.\n" +
                "Give Name: \n" +
                "Give Surname: \n" +
                "----There is a contact for the Name you gave----\n" +
                "Name:";
        String actualstring = outputStream.toString().trim();
//        setfileUp();
//        System.out.println(actualstring);
//        tearDown();
        assertTrue(actualstring.contains(expectedOutput));
    }

    @Test
    public void testSearchExisting2andExit() {
        // Arrange
        String searchInput = "2\n1\nAsh\nGatsy\n0\n0\n0\n"; // Simulate searching for a user and then exiting

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
        String expectedOutput = "Do you want to search beased on name or based on phone?\n" +
                "Give '1' or '2' or anser '0' to return to main menu.\n" +
                "Give Name: \n" +
                "Give Surname: \n" +
                "----There is a contact for the Surname you gave----\n" +
                "Name:";
        String actualstring = outputStream.toString().trim();
//        setfileUp();
//        System.out.println(actualstring);
//        tearDown();
        assertTrue(actualstring.contains(expectedOutput));
    }

    @Test
    public void testSearchExisting3andExit() {
        // Arrange
        String searchInput = "2\n2\n56\n65\n0\n0\n0\n"; // Simulate searching for a user and then exiting

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
        String expectedOutput = "Do you want to search beased on name or based on phone?\n" +
                "Give '1' or '2' or anser '0' to return to main menu.\n" +
                "Give Phone number: \n" +
                "Give mobile number: \n" +
                "----There is a contact for the Phone and Mobile number you gave----\n" +
                "Name:";
        String actualstring = outputStream.toString().trim();
//        setfileUp();
//        System.out.println(actualstring);
//        tearDown();
        assertTrue(actualstring.contains(expectedOutput));
    }

    @Test
    public void testSearchExisting4andExit() {
        // Arrange
        String searchInput = "2\n2\n56\n312\n0\n0\n0\n"; // Simulate searching for a user and then exiting

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
        String expectedOutput = "Do you want to search beased on name or based on phone?\n" +
                "Give '1' or '2' or anser '0' to return to main menu.\n" +
                "Give Phone number: \n" +
                "Give mobile number: \n" +
                "----There is a contact for the Phone number you gave----\n" +
                "Name:";
        String actualstring = outputStream.toString().trim();
//        setfileUp();
//        System.out.println(actualstring);
//        tearDown();
        assertTrue(actualstring.contains(expectedOutput));
    }

    @Test
    public void testSearchExisting5andExit() {
        // Arrange
        String searchInput = "2\n2\n312\n65\n0\n0\n0\n"; // Simulate searching for a user and then exiting

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
        String expectedOutput = "Do you want to search beased on name or based on phone?\n" +
                "Give '1' or '2' or anser '0' to return to main menu.\n" +
                "Give Phone number: \n" +
                "Give mobile number: \n" +
                "----There is a contact for the Phone number you gave----\n" +
                "Name:";
        String actualstring = outputStream.toString().trim();
//        setfileUp();
//        System.out.println(actualstring);
//        tearDown();
        assertTrue(actualstring.contains(expectedOutput));
    }

    @Test
    public void testSearchExisting6andExit() {
        // Arrange
        String searchInput = "2\n2\n-1\n-1\n0\n0\n0\n"; // Simulate searching for a user and then exiting

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
        String expectedOutput = "Do you want to search beased on name or based on phone?\n" +
                "Give '1' or '2' or anser '0' to return to main menu.\n" +
                "Give Phone number: \n" +
                "Give mobile number: \n" +
                "-------------------\n" +
                "You gave wrong information.\n" +
                "-------------------";
        String actualstring = outputStream.toString().trim();
//        setfileUp();
//        System.out.println(actualstring);
//        tearDown();
        assertTrue(actualstring.contains(expectedOutput));
    }

    @Test
    public void testSearchExisting7andExit() {
        // Arrange
        String searchInput = "2\n2\n-1\n65\n0\n0\n0\n"; // Simulate searching for a user and then exiting

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
        String expectedOutput = "Do you want to search beased on name or based on phone?\n" +
                "Give '1' or '2' or anser '0' to return to main menu.\n" +
                "Give Phone number: \n" +
                "Give mobile number: \n" +
                "----There is a contact for the Mobile number you gave----\n" +
                "Name:";
        String actualstring = outputStream.toString().trim();
//        setfileUp();
//        System.out.println(actualstring);
//        tearDown();
        assertTrue(actualstring.contains(expectedOutput));
    }

    @Test
    public void testSearchExisting8andExit() {
        // Arrange
        String searchInput = "2\n2\n56\n-1\n0\n0\n0\n"; // Simulate searching for a user and then exiting

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
        String expectedOutput = "Do you want to search beased on name or based on phone?\n" +
                "Give '1' or '2' or anser '0' to return to main menu.\n" +
                "Give Phone number: \n" +
                "Give mobile number: \n" +
                "----There is a contact for the Phone number you gave----\n" +
                "Name: Ashish\n" +
                "Surname: Gatsy\n" +
                "Mobile: 56\n" +
                "Phone: 65\n" +
                "Email: a@gmail.com\n" +
                "Street: str2\n" +
                "Street_Number: 2\n" +
                "Town: town2\n" +
                "ZipCode: 50602\n" +
                "-------------------\n" +
                "Do you want to search beased on name or based on phone?";
        String actualstring = outputStream.toString().trim();
//        setfileUp();
//        System.out.println(actualstring);
//        tearDown();
        assertTrue(actualstring.contains(expectedOutput));
    }

    @Test
    public void testChange1Exit() {
        // Arrange
        String searchInput = "4\n 1\n Tempb\n Tsurb\n tempa\n tsura\n 888\n 999\n tempa@gmail.com\n tastreet\n 2023\n tempatown\n 20023\n 0\n 0\n 0\n"; // Simulate searching for a user and then exiting
//        String searchInput = String.format("4\n1\nabafwsf\naobbwfw\n0\n0\n0\n");
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

        String searchInput1 = "4\n 1\n tempa\n tsura\n Tempb\n Tsurb\n 888\n 999\n tempa@gmail.com\n tastreet\n 2023\n tempatown\n 20023\n 0\n 0\n 0\n";
        InputStream originalSystemIn1 = System.in; // Store the original System.in
        System.setIn(new ByteArrayInputStream(searchInput1.getBytes()));

        ByteArrayOutputStream outputStream1 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream1));

        // Act
        try (Scanner scanner = new Scanner(System.in)) {
            Main.main(new String[]{});
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // Restore the original System.in after the test
            System.setIn(originalSystemIn1);
        }
        // Assert
        String expectedOutput = "Do you want to edit a contact based on the name or Phone number?\n" +
                "Give '1', '2' or '0' to return to main menu.\n" +
                "Give Name: \n" +
                "Give Surname: \n" +
                "----There is a contact for the information you gave----\n" +
                "Name: Tempb\n" +
                "Surname: Tsurb\n" +
                "Mobile: 888\n" +
                "Phone: 999\n" +
                "Email: tempa@gmail.com\n" +
                "Street: tastreet\n" +
                "Street_Number: 2023\n" +
                "Town: tempatown\n" +
                "ZipCode: 20023\n" +
                "-------------------\n" +
                "----Edit Information----\n" +
                "Change the information Name: Tempb, to:\n" +
                "Change the information Surname: Tsurb, to:\n" +
                "Change the information Mobile: 888, to:\n" +
                "Change the information Phone: 999, to:\n" +
                "Change the information Email: tempa@gmail.com, to:\n" +
                "Change the information Street: tastreet, to:\n" +
                "Change the information Street_Number: 2023, to:\n" +
                "Change the information Town: tempatown, to:\n" +
                "Change the information ZipCode: 20023, to:\n" +
                "Contact change is completed.\n" +
                "Do you want to edit a contact based on the name or Phone number?\n" +
                "Give '1', '2' or '0' to return to main menu.\n" +
                "Do you want to edit a contact based on the name or Phone number?\n" +
                "Give '1', '2' or '0' to return to main menu.";
        String expectedOutput1 = "Do you want to edit a contact based on the name or Phone number?\n" +
                "Give '1', '2' or '0' to return to main menu.\n" +
                "Give Name: \n" +
                "Give Surname: \n" +
                "----There is a contact for the information you gave----\n" +
                "Name: tempa\n" +
                "Surname: tsura\n" +
                "Mobile: 888\n" +
                "Phone: 999\n" +
                "Email: tempa@gmail.com\n" +
                "Street: tastreet\n" +
                "Street_Number: 2023\n" +
                "Town: tempatown\n" +
                "ZipCode: 20023\n" +
                "-------------------\n" +
                "----Edit Information----\n" +
                "Change the information Name: tempa, to:\n" +
                "Change the information Surname: tsura, to:\n" +
                "Change the information Mobile: 888, to:\n" +
                "Change the information Phone: 999, to:\n" +
                "Change the information Email: tempa@gmail.com, to:\n" +
                "Change the information Street: tastreet, to:\n" +
                "Change the information Street_Number: 2023, to:\n" +
                "Change the information Town: tempatown, to:\n" +
                "Change the information ZipCode: 20023, to:\n" +
                "Contact change is completed.\n" +
                "Do you want to edit a contact based on the name or Phone number?\n" +
                "Give '1', '2' or '0' to return to main menu.\n" +
                "Do you want to edit a contact based on the name or Phone number?\n" +
                "Give '1', '2' or '0' to return to main menu.";
        String actualstring = outputStream.toString().trim();
        String actualstring1 = outputStream1.toString().trim();
        setfileUp();
        System.out.println(actualstring);
        tearDown();
        assertTrue(actualstring.contains(expectedOutput) && actualstring1.contains(expectedOutput1));
    }
}
