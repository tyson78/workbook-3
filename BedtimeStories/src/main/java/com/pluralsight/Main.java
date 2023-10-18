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
            String fileName = null;
            boolean done = false;

            while (!done) {
                String choice = scanner.nextLine().toLowerCase();

                switch (choice) {
                    case "1", "goldilocks":
                        fileName = "goldilocks.txt";
                        done = true;
                        break;
                    case "2", "hansel and gretel":
                        fileName = "hansel_and_gretel.txt";
                        done = true;
                        break;
                    case "3", "marry had a little lamb":
                        fileName = "mary_had_a_little_lamb.txt";
                        done = true;
                        break;
                    default:
                        System.out.println("Please enter a number between 1 and 3: ");
                }
            }

            f1 = new FileInputStream(fileName);
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