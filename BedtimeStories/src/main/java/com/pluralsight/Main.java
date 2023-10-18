package com.pluralsight;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Which story would you like to read? (enter a number)" +
                    "\n1. goldilocks.txt " + "\n2. hansel_and_gretel.txt " + "\n3. mary_had_a_little_lamb"
            );

            FileInputStream f1 = null;
            boolean done = false;

            while (!done) {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("1. goldilocks.txt");
                        f1 = new FileInputStream("goldilocks.txt");
                        done = true;
                        break;
                    case 2:
                        System.out.println("2. hansel_and_gretel.txt");
                        f1 = new FileInputStream("hansel_and_gretel.txt");
                        done = true;
                        break;
                    case 3:
                        System.out.println("3. mary_had_a_little_lamb");
                        f1 = new FileInputStream("mary_had_a_little_lamb.txt");
                        done = true;
                        break;
                    default:
                        System.out.println("Please enter a number between 1 and 3: ");
                }
            }
            Scanner fileScanner = new Scanner(f1);
            System.out.println(f1);

            int lineNum = 1;
            String input;
            while (fileScanner.hasNextLine()) {
                input = fileScanner.nextLine();
                System.out.println(lineNum++ + "." + input);
            }
            fileScanner.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}