package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(today.format(formatter));

        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(today.format(formatter));

        formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        System.out.println(today.format(formatter));

        formatter = DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy  hh:mm");
        System.out.println(today.format(formatter));
    }
}
/* Expected output
09/05/2021
2021-09-05
September 5, 2021
Sunday, Sep 5, 2021  10:02  display in GMT time
*/