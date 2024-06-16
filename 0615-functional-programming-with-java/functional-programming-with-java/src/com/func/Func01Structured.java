package com.func;


import java.util.List;

/**
 * desc:
 *
 * @author Young.
 */
public class Func01Structured {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 34, 56, 32, 56, 23, 3, 6, 4, 5);
        // printAllNumbersInListStructured(numbers);
        printEvenNumbersInListStructured(numbers);
    }

    private static void printEvenNumbersInListStructured(List<Integer> numbers) {

        // print all even numbers
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                System.out.println(number);
            }
        }


    }

    private static void printAllNumbersInListStructured(List<Integer> numbers) {

        // how to loop the numbers
        for (Integer number : numbers) {
            System.out.println(number);
        }
    }

}
