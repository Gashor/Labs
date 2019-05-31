package com.filatov;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator {

    private static final Logger log = LogManager.getLogger(Calculator.class);

    public static int sum(int first, int second){
        int result = first + second;
        log.debug(String.format("SUM: first: %d, second: %d, result: %d", first, second, result));
        return result;
    }

    public static int minus(int first, int second){
        int result = first - second;
        log.info(String.format("MINUS: first: %d, second: %d, result: %d", first, second, result));
        return result;
    }

    public static int multiply(int first, int second){
        int result = first * second;
        log.warn(String.format("MULTIPLY: first: %d, second: %d, result: %d", first, second, result));
        return result;
    }

    public static int divide(int first, int second){
        int result = 0;

        try {
            result = first / second;
        }catch (ArithmeticException e){
            log.fatal("DIVISION BY ZERO");
            throw e;
        }

        log.error(String.format("DIVIDE: first: %d, second: %d, result: %d", first, second, result));
        return result;
    }
}
