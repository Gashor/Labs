package com.filatov;

import org.junit.jupiter.api.Test;
import static com.filatov.Calculator.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestCalculator {
    @Test
    public void test_that_2_plus_2_is_4(){
        assertEquals(4, sum(2, 2));
    }

    @Test
    public void test_that_40_minus_31_is_9(){
        assertEquals(9, minus(40, 31));

    }

    @Test
    public void test_that_2_multiply_by_8_is_16(){
        assertEquals(16, multiply(2, 8));
    }

    @Test
    public void test_that_400_divide_by_2_is_200(){
        assertEquals(200, divide(400, 2));
    }

    @Test
    public void test_that_4_minus_4_is_not_2(){
        assertNotEquals(2, minus(4, 4));
    }
}
