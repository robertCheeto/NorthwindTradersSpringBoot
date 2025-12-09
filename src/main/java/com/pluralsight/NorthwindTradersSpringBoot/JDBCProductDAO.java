package com.pluralsight.NorthwindTradersSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class JDBCProductDAO implements ProductDAO{

    //private final ProductDAO productDAO;
    private final DataSource dataSource;

    @Autowired
    public JDBCProductDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Autowired


    @Override
    public void add(Product product) {

    }

    @Override
    public List<Product> getAll() {
        return List.of();
    }
}
