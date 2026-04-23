package org.howard.edu.lsp.finalexam.question3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GradeCalculatorTest {

    GradeCalculator gc = new GradeCalculator();

    @Test
    void testAverage() {
        assertEquals(90.0, gc.average(90, 90, 90));
    }

    @Test
    void testLetterGrade() {
        assertEquals("A", gc.letterGrade(95));
    }

    @Test
    void testIsPassing() {
        assertTrue(gc.isPassing(70));
    }

    @Test
    void testBoundaryLow() {
        assertEquals("F", gc.letterGrade(59));
    }

    @Test
    void testBoundaryHigh() {
        assertEquals("A", gc.letterGrade(100));
    }

    @Test
    void testExceptionLow() {
        assertThrows(IllegalArgumentException.class, () -> {
            gc.average(-1, 90, 90);
        });
    }

    @Test
    void testExceptionHigh() {
        assertThrows(IllegalArgumentException.class, () -> {
            gc.average(101, 90, 90);
        });
    }
}
