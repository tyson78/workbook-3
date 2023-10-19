package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        try {
            boolean done = false;
            while (!done) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the name of employee file to process: ");
                String fileName = scanner.nextLine(); // employees.csv

                if (fileName.equals("employees.csv")) {
                    System.out.println("Enter the name of the payroll file to create: ");
                    String payrollFileName = scanner.nextLine(); // payroll-sept-2023.csv

                    FileWriter fileWriter = new FileWriter(payrollFileName);
                    BufferedWriter bufWriter = new BufferedWriter(fileWriter);

                    String output;

                    FileReader fileReader = new FileReader("employees.csv");
                    BufferedReader buffReader = new BufferedReader(fileReader);

                    String input;
                    buffReader.readLine(); // reads the current line & moves on to the next line
                    while ((input = buffReader.readLine()) != null) { // while loop starts from line 2 of employees.csv
                        // System.out.println(input);
                        String[] employeeTokens = (input.toString()).split("\\|");

                        // intermediate declaration statements using var keyword
                        var employeeID = Integer.parseInt(employeeTokens[0]);
                        var employeeName = employeeTokens[1];
                        var hoursWorked = Double.parseDouble(employeeTokens[2]);
                        var payRate = Double.parseDouble(employeeTokens[3]);

                        Employee e = new Employee(employeeID, employeeName, hoursWorked, payRate);

                        System.out.printf(
                                "\nEmployeeID: %d, \nEmployeeName: %s, \nEmployeePay: %.2f \n",
                                e.getEmployeeId(), e.getName(), e.getCrossPay()
                        );
                        output = String.format("%d|%s|%.2f\n", e.getEmployeeId(), e.getName(), e.getCrossPay());
                        bufWriter.write(output);
                    }
                    buffReader.close();
                    bufWriter.close();
                    done = true;
                } else {
                    System.out.println("Please enter the correct employee file name");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}