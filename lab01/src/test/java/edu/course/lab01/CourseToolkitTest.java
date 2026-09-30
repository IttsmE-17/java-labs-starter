package edu.course.lab01;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class CourseToolkitTest {

    @Test
    void returnsTrueForEvenNumber() {
        boolean result = CourseToolkit.isEven(8);

        assertTrue(result);
    }

    @Test
    void returnsFalseForOddNumber() {
        boolean result = CourseToolkit.isEven(7);

        assertFalse(result);
    }

    @Test 
    void returnsTrueIfZeroIsEven() {
        boolean result = CourseToolkit.isEven(0);

        assertTrue(result);
    }

    @Test 
    void returnsTrueForNegativeEvenNumber() {
        boolean result = CourseToolkit.isEven(-8);

        assertTrue(result);
    }
// ################## isPrime ##################
    @Test 
    void returnsTrueForPrime() {
        boolean result = CourseToolkit.isPrime(13);

        assertTrue(result);
    }

    @Test 
    void returnsFalseForNotPrime() {
        boolean result = CourseToolkit.isPrime(9);

        assertFalse(result);
    }

    @Test 
    void returnsTrueIf2IsPrime() {
        boolean result = CourseToolkit.isPrime(2);

        assertTrue(result);
    }

    @Test 
    void returnsFalseIf1IsNotPrime() {
        boolean result = CourseToolkit.isPrime(1);

        assertFalse(result);
    }
// ################## isPalindrome ##################
    @Test 
    void returnsTrueForPalindrome() {
        boolean result = CourseToolkit.isPalindrome("sos");

        assertTrue(result);
    }

    @Test 
    void returnsFalseForNotPalindrome() {
        boolean result = CourseToolkit.isPalindrome("tool");

        assertFalse(result);
    }

    @Test
    void throwsExceptionForStringNull() {
        assertThrows(
            IllegalArgumentException.class,
            () -> CourseToolkit.isPalindrome(null)
        );
}
// ################## average ##################
    @Test 
    void returnsAverageCommon() {
        double result = CourseToolkit.average(new int[]{5, 8, 12, 20});

        assertEquals(11.25, result);
    }

    @Test 
    void returnsAverageNegative() {
        double result = CourseToolkit.average(new int[]{-10, -15, -20});

        assertEquals(-15, result);
    }

    @Test
    void throwsExceptionForNullArray() {
        assertThrows(
            IllegalArgumentException.class,
            () -> CourseToolkit.average(null)
        );
}

    @Test
    void throwsExceptionForEmptyArray() {
        assertThrows(
            IllegalArgumentException.class,
            () -> CourseToolkit.average(new int[]{})
        );
}

// ################## min-max ##################
    @Test
    void returnsMinMaxForArray() {
        int[] result = CourseToolkit.minMax(new int[]{-73, -50, 0, 56, 67});

        assertArrayEquals(new int[]{-73, 67}, result);
    }
}
