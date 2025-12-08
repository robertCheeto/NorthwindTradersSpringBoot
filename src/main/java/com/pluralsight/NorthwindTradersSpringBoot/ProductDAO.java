package com.pluralsight.NorthwindTradersSpringBoot;

import java.util.List;

public interface ProductDAO {
    public void add(Product product);
    public List<Product> getAll();
}
