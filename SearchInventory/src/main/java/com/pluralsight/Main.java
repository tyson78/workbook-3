package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // ArrayList<Product> inventory = getInventory();
        //System.out.println(inventory);

        ArrayList<Product> inventory = readInventory();
        System.out.println(inventory);

        inventory.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                // return o1.getName().length() - o2.getName().length();
                return (int)(100*o1.getPrice() - 100*o2.getPrice());
                // return o2.getId()- o1.getId();
            }
        });

        Collections.shuffle(inventory);

        for (Product p : inventory) {
            System.out.println("Name: " + p.getName() + " ID: "
                    + p.getId() + " Price: " + p.getPrice());
        }
    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(01, "Candy", 1.50));
        products.add(new Product(02, "M&M", 1.00));
        products.add(new Product(03, "Sour Patch", 2.0));
        products.add(new Product(04, "Lays", 3.50));
        products.add(new Product(05, "Hot Cheetos", 4.50));

        return products;
    }

    public static ArrayList<Product> readInventory() {
        ArrayList<Product> products = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader("products.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String input = null;
            // reads data from products.csv
            while ((input = bufferedReader.readLine()) != null){
                // 45, old shoes, 1000
                // 75, turtle, 10.05
                // 14, monopoly, 4.25
                String[] fields = input.split(",");
                // fields = {45, old shoes, 1000}
                // fields = {75, turtle, 10.05}
                // fields = {14, monopoly, 4.25}

                var pID = Integer.parseInt(fields[0]);
                var pName = fields[1].trim();
                var pPrice = Double.parseDouble(fields[2]);

                Product p = new Product(pID, pName, pPrice);

                // adds each product to arraylist
                products.add(p);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
}