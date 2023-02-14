package org.example;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        printTokenGeneratorRule();

        int selectedTokenLength = getTokenLengthFromUser();

        if (selectedTokenLength == 5 || selectedTokenLength == 10 || selectedTokenLength == 15) {
            tokenGenerator(selectedTokenLength);
        } else {
            printTokenGeneratorRule();
        }
    }

    private static char[] tokenGenerator(int TokenLength) {

        Random numberToken = new Random();
        int[] digitToken = new int[TokenLength];

        for (int i = 1; i <= TokenLength; i++) {
            digitToken[i - 1] = numberToken.nextInt(90) + 33;
        }

        char[] randomToken = new char[digitToken.length];
        for (int j = 1; j <= randomToken.length; j++) {
            for (int number : digitToken) {
                char character = (char) number;
                randomToken[j - 1] = character;
                j++;
            }
        }

        System.out.println(randomToken);
        return randomToken;
    }

    private static void printTokenGeneratorRule() {
        System.out.println("Please select the length of the token: 5, 10 or 15 characters.");
    }

    private static int getTokenLengthFromUser() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                return scanner.nextInt();
            } catch (InputMismatchException | NumberFormatException e) {
                e.printStackTrace();
                System.out.println("Incorrect input");
                printTokenGeneratorRule();
            }
        }
    }
}