package com.pluralsight.NorthwindTradersSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class NorthwindApplicationCLI implements CommandLineRunner {

    private final ProductDAO productDAO;
    private final Scanner keyboard;
    private static boolean isRunning = true;

    @Autowired
    public NorthwindApplicationCLI(ProductDAO productDAO) {
        this.productDAO = productDAO;
        this.keyboard = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {
        while (isRunning) {
            System.out.println("Select an option from the choices below.");
            System.out.println("1) List all products");
            System.out.println("2) Add new product");
            System.out.println("3) Close program");
            System.out.print("Enter choice here: ");
            int input = keyboard.nextInt();
            keyboard.nextLine();

            switch (input) {
                case 1 -> productDAO.getAll().forEach(System.out::println);
                case 2 -> {
                    System.out.print("Enter product id: ");
                    int productID = keyboard.nextInt();
                    keyboard.nextLine();
                    System.out.print("\nEnter product name: ");
                    String productName = keyboard.nextLine();
                    System.out.print("\nEnter product category: ");
                    String productCategory = keyboard.nextLine();
                    System.out.print("\nEnter product price: $");
                    double productPrice = keyboard.nextDouble();
                    keyboard.nextLine();
                    productDAO.add(new Product(productID, productName, productCategory, productPrice));
                }
                case 3 -> {
                    System.out.println("closing program");
                    isRunning = false;
                    keyboard.close();
                    System.exit(0);
                }
                default -> System.out.println("bad input");
            }
        }
    }
}
