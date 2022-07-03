package com.watch.store.model.dao;

import com.watch.store.model.entity.Watch;

import java.util.List;

public interface Dao {
    List<Watch> getProducts();

    void addProducts(List<Watch> products);

    void addProduct(Watch watch);

}
