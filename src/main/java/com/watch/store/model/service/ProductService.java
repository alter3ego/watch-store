package com.watch.store.model.service;

import com.watch.store.model.entity.Watch;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    List<Watch> getAllProducts();

    List<Watch> getProductOrderByPrice(boolean sortDescending);

    List<Watch> getProductOrderByColor(boolean sortDescending);

    List<Watch> getProductOrderByDate(boolean sortDescending);

    BigDecimal getTotalCost();

    void addNewWatch(Watch watch);
}
