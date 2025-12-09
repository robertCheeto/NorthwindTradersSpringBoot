package com.pluralsight.NorthwindTradersSpringBoot;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
public class SimpleProductDAO implements ProductDAO {
    private List<Product> products;

    public SimpleProductDAO(){
        this.products = new ArrayList<>();
        this.products.add(new Product(001, "Apple", "fruit", 5.99));
        this.products.add(new Product(002, "Carrots", "vegetable", 3.99));
        this.products.add(new Product(003, "Cereal", "breakfast", 4.99));
        this.products.add(new Product(004, "Dr. Pepper", "soft drinks", 3.29));

    }

    @Override
    public void add(Product product) {
        this.products.add(product);
    }

    @Override
    public List<Product> getAll() {
        return this.products;
    }
}
