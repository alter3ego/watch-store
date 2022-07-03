package com.watch.store.model.dao;

import com.watch.store.model.entity.Watch;

import java.util.ArrayList;
import java.util.List;

public class ProductDB implements Dao {
    private static ProductDB instance;
    private final List<Watch> products = FillDB.watches();

    public List<Watch> getProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public void addProducts(List<Watch> products) {
        this.products.addAll(products);
    }

    @Override
    public void addProduct(Watch watch) {
       products.add(watch);
    }

    public static ProductDB getInstance(){
        if (instance == null) {
            instance = new ProductDB();
        }
        return instance;
    }
}