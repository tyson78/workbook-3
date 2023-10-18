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
                System.out.println(input);
                String[] words = (input.toString()).split("\\|");
                Employee e = new Employee(Integer.parseInt(words[0]),
                        words[1], Double.parseDouble(words[2]),
                        Double.parseDouble(words[3]));
                System.out.printf(
                        "EmployeeID: %d, EmployeeName: %s, EmployeePay: %f \n",
                        e.getEmployeeId(), e.getName(), e.getCrossPay()
                );
            }
            buffReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}