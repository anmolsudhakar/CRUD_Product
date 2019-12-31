package com.stackroute.basics.commander.test;

import com.stackroute.basics.Palindrome;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalindromeAppTests {
    private ByteArrayOutputStream outStream;
    private Palindrome palindrome;

    @BeforeEach
    public void setup() {
        palindrome = new Palindrome();
        outStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outStream));
    }

    @AfterEach
    public void tearDown() {
        palindrome = null;
        outStream = null;
    }

    @Test
    public void givenPalindromeIntegerStringThenReturnAStringResult() {
        System.setIn(new ByteArrayInputStream("9999999999694448232002328444969999999999".getBytes()));
        palindrome.getValue();
        assertEquals("9999999999694448232002328444969999999999 is a palindrome", outStream.toString().trim().replaceAll(".*\n", ""), "Check the logic in the method getValue, palindromeValidator");
    }

    @Test
    public void givenNonPalindromeIntegerStringThenReturnAStringResult() {
        System.setIn(new ByteArrayInputStream("99999999996944482320023284449699999999".getBytes()));
        palindrome.getValue();
        assertEquals("99999999996944482320023284449699999999 is not a palindrome", outStream.toString().trim().replaceAll(".*\n", ""), "Check the logic in the method getValue, palindromeValidator");
    }

    @Test
    public void givenNegativeIntegerStringThenReturnAStringError() {
        System.setIn(new ByteArrayInputStream("-10002".getBytes()));
        palindrome.getValue();
        assertEquals("Wrong input give proper positive integer", outStream.toString().trim().replaceAll(".*\n", ""), "Write condition to check whether input is negative");
    }

    @Test
    public void givenAlphaNumericStringThenReturnAStringError() {
        System.setIn(new ByteArrayInputStream("Palindrome".getBytes()));
        palindrome.getValue();
        assertEquals("Wrong input give proper positive integer", outStream.toString().trim().replaceAll(".*\n", ""), "write condition to check input has character");
        System.setIn(new ByteArrayInputStream("111b11".getBytes()));
        palindrome.getValue();
        assertEquals("Wrong input give proper positive integer", outStream.toString().trim().replaceAll(".*\n", ""), "write condition to check input has character");
        System.setIn(new ByteArrayInputStream("a121".getBytes()));
        palindrome.getValue();
        assertEquals("Wrong input give proper positive integer", outStream.toString().trim().replaceAll(".*\n", ""), "write condition to check input has character");
    }

    @Test
    public void givenBlankStringThenReturnAStringError() {
        System.setIn(new ByteArrayInputStream("\n".getBytes()));
        palindrome.getValue();
        assertEquals("Wrong input give proper positive integer", outStream.toString().trim().replaceAll(".*\n", ""), "Write condition to check whether input is empty ");
    }

}
