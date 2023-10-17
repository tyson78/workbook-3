package com.pluralsight;

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] quotes = new String[]{"There are always survivors at a massacre. Among the victors, if nowhere else.", "We all have a few failures under our belt. It's what makes us ready for the successes.", "The only joy in the world is to begin.", "You are not superior just because you see the world in an odious light.", "Art has never been made while thinking of art.", "Getting caught is the mother of invention.", "Furious activity is no substitute for understanding.", "Observe your enemies, for they first find out your faults.", "You might as well fall flat on your face as lean over too far backward.", "Everybody lies, but it doesn't matter because nobody listens."};
        boolean done = false;

        while (!done) {
            System.out.println("Enter a number between 1 and 10");
            int value = scanner.nextInt() - 1;

            try {
                System.out.println(quotes[value]);
                done = true;
            } catch (Exception var6) {
                System.out.println("Your number was out of range!");
                System.out.println(var6);
            }
        }

    }
}
