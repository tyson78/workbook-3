package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        try {
            FileReader fileReader = new FileReader("employees.csv");
            BufferedReader buffReader = new BufferedReader(fileReader);
            String input;
            buffReader.readLine(); // reads the current line & moves on to the next line
            while((input = buffReader.readLine()) != null) { // while loop starts from line 2 of employees.csv
                // System.out.println(input);
                String[] words = (input.toString()).split("\\|");

                // intermediate declaration statements using var keyword
                var employeeID = Integer.parseInt(words[0]);
                var employeeName = words[1];
                var hoursWorked = Double.parseDouble(words[2]);
                var payRate = Double.parseDouble(words[3]);

                Employee e = new Employee(employeeID, employeeName, hoursWorked, payRate);

                System.out.printf(
                        "\nEmployeeID: %d, \nEmployeeName: %s, \nEmployeePay: %.2f \n",
                        e.getEmployeeId(), e.getName(), e.getCrossPay()
                );
            }
            buffReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}