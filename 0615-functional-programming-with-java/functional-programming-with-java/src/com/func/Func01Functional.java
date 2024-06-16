package com.func;


import java.util.List;

/**
 * desc:
 *
 * @author Young.
 */
public class Func01Functional {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 34, 56, 32, 56, 23, 3, 6, 4, 5);

        // printAllNumbersInListStructured(List.of(12, 34, 56, 32, 56, 23, 3, 6, 4, 5));
        // printAllNumbersInListFunctional(numbers);
        printEvenNumbersInListFunctional(numbers);
    }

    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
        // loop all even numbers
        numbers.stream()
                // using method reference
                // .filter(Func01Functional::isEven)
                // using lambda expression
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println);

    }

    // private static boolean isEven(Integer number) {
    //     return number % 2 == 0;
    // }

    // private static void printAllNumbersInListFunctional(List<Integer> numbers) {
    //
    //     // how to loop the numbers?
    //     numbers.stream().forEach(System.out::print);
    // }


    // private static void printAllNumbersInListStructured(List<Integer> numbers) {
    //
    //     // how to loop the numbers
    //     for (Integer number : numbers) {
    //         System.out.println(number);
    //     }
    // }

    // private static void print(Integer number) {
    //     System.out.println(number);
    // }
}
