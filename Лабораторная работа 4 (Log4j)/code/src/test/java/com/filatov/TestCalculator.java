package com.filatov;

import org.junit.jupiter.api.Test;
import static com.filatov.Calculator.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestCalculator {
    @Test
    public void test_that_2_plus_2_is_4(){
//        if(sum(2, 2) != 4)
//            throw new Error();

        assertEquals(4, sum(2, 2));
    }

    @Test
    public void test_that_40_minus_31_is_9(){
//        if(minus(40, 31) != 9)
//            throw new Error();

        assertEquals(9, minus(40, 31));

    }

    @Test
    public void test_that_2_multiply_by_8_is_16(){
//        if(multiply(2, 8) != 16)
//            throw new Error();

        assertEquals(16, multiply(2, 8));
    }

    @Test
    public void test_that_400_divide_by_2_is_200(){
//        if(divide(400, 2) != 200)
//            throw new Error();

        assertEquals(200, divide(400, 2));
    }

    @Test
    public void test_that_4_minus_4_is_not_2(){
//        if(minus(4, 4) == 2)
//            throw new Error();

        assertNotEquals(2, minus(4, 4));
    }
}
