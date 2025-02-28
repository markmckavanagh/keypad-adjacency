
import static org.junit.jupiter.api.Assertions.*;

import org.example.PhoneNumberProcessor;
import org.junit.jupiter.api.Test;

public class PhoneNumberProcessorTest {

    @Test
    public void testPhoneNumberShouldBeEasyToDial() {
        String phoneNumber = "1236547898";
        assertTrue(PhoneNumberProcessor.isEasyToDial(phoneNumber));
    }

    @Test
    public void testPhoneNumberWithSameDigitsConsecutivelyIsEasyToDial() {
        String phoneNumber = "1111111111";
        assertTrue(PhoneNumberProcessor.isEasyToDial(phoneNumber));
    }

    @Test
    public void testPhoneNumberShouldNotBeEasyToDial() {
        String phoneNumber = "1991234567";
        assertFalse(PhoneNumberProcessor.isEasyToDial(phoneNumber));
    }

    @Test
    public void testNullInputThrowsException() {
        String phoneNumber = null;
        Throwable ex = assertThrows(RuntimeException.class, () -> PhoneNumberProcessor.isEasyToDial(phoneNumber));
        assertEquals(ex.getMessage(), "Phone number is null or empty");
    }

    @Test
    public void testEmptyStringInputThrowsException() {
        String phoneNumber = "";
        Throwable ex = assertThrows(RuntimeException.class, () -> PhoneNumberProcessor.isEasyToDial(phoneNumber));
        assertEquals(ex.getMessage(), "Phone number is null or empty");
    }

    @Test
    public void testNonDigitsThrowsException() {
        String phoneNumber = "Rubbish";
        Throwable ex = assertThrows(RuntimeException.class, () -> PhoneNumberProcessor.isEasyToDial(phoneNumber));
        assertEquals(ex.getMessage(), "Phone number does not contain only digits");
    }

    @Test
    public void testMixtureOfNumbersAndCharactersThrowsException() {
        String phoneNumber = "123-456-abc0";
        Throwable ex = assertThrows(RuntimeException.class, () -> PhoneNumberProcessor.isEasyToDial(phoneNumber));
        assertEquals(ex.getMessage(), "Phone number does not contain only digits");
    }


    @Test
    public void testPhoneNumberStartingWithPlusAndNonDigitsThrowsException() {
        String phoneNumber = "+12-34abc567";
        Throwable ex = assertThrows(RuntimeException.class, () -> PhoneNumberProcessor.isEasyToDial(phoneNumber));
        assertEquals(ex.getMessage(), "Phone number does not contain only digits");
    }

    @Test
    public void testPhoneNumberWithDashesAndSpacesIsEasyToDial() {
        String phoneNumber = "(123) 654-7890";
        assertTrue(PhoneNumberProcessor.isEasyToDial(phoneNumber));
    }

    @Test
    public void testPhoneNumberWithPlusAtStartIsEasyToDial() {
        String phoneNumber = "+1236547899";
        assertTrue(PhoneNumberProcessor.isEasyToDial(phoneNumber));
    }

    @Test
    public void testPhoneNumberWithExactly15DigitsIsEasyToDial() {
        String phoneNumber = "123654789087456";
        assertTrue(PhoneNumberProcessor.isEasyToDial(phoneNumber));
    }

    @Test
    public void testPhoneNumberWithExactly10DigitsIsEasyToDial() {
        String phoneNumber = "0987456985";
        assertTrue(PhoneNumberProcessor.isEasyToDial(phoneNumber));
    }

    @Test
    public void testPhoneNumberWithLessThan10DigitsThrowsException() {
        String phoneNumber = "1234567";
        Throwable ex = assertThrows(RuntimeException.class, () -> PhoneNumberProcessor.isEasyToDial(phoneNumber));
        assertEquals(ex.getMessage(), "Phone number length should be between 10 and 15 digits");
    }

    @Test
    public void testPhoneNumberWithMoreThan15DigitsThrowsException() {
        String phoneNumber = "1234567890123456";
        Throwable ex = assertThrows(RuntimeException.class, () -> PhoneNumberProcessor.isEasyToDial(phoneNumber));
        assertEquals(ex.getMessage(), "Phone number length should be between 10 and 15 digits");
    }

    @Test
    public void testPhoneNumberWithOnlyFormattingCharactersThrowsException() {
        String phoneNumber = "( ) -";
        Throwable ex = assertThrows(RuntimeException.class, () -> PhoneNumberProcessor.isEasyToDial(phoneNumber));
        assertEquals(ex.getMessage(), "Phone number does not contain only digits");
    }
}
