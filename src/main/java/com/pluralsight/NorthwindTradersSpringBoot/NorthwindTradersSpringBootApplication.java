package com.pluralsight.NorthwindTradersSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class NorthwindTradersSpringBootApplication {

    private static ProductDAO productDAO;

	public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(NorthwindTradersSpringBootApplication.class, args);

        productDAO = context.getBean(SimpleProductDAO.class);

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Select an option from the choices below.");
        System.out.println("1) List all products");
        //System.out.println("2) Add new product");
        System.out.print("Enter choice here: ");
        int input = keyboard.nextInt();
        keyboard.nextLine();

        switch (input) {
            case 1 -> productDAO.getAll().stream().forEach(System.out::println);
            //case 2 -> productDAO.add(Product product);
            default -> System.out.println("bad input");
        }
	}

}
