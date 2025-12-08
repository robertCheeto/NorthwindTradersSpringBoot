package com.pluralsight.NorthwindTradersSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class NorthwindTradersSpringBootApplication {

    private static ProductDAO productDAO;
    private static boolean isRunning = true;

	public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(NorthwindTradersSpringBootApplication.class, args);

        productDAO = context.getBean(SimpleProductDAO.class);

        Scanner keyboard = new Scanner(System.in);

        while (isRunning) {
            System.out.println("Select an option from the choices below.");
            System.out.println("1) List all products");
            System.out.println("2) Add new product");
            System.out.println("3) Close program");
            System.out.print("Enter choice here: ");
            int input = keyboard.nextInt();
            keyboard.nextLine();

            switch (input) {
                case 1 -> productDAO.getAll().stream().forEach(System.out::println);
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
