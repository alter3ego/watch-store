package com.watch.store.model.service.impl;

import com.watch.store.model.dao.Dao;
import com.watch.store.model.entity.Watch;
import com.watch.store.model.service.ProductService;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {
    private final Dao dao;

    public ProductServiceImpl(Dao dao) {
        this.dao = dao;
    }

    @Override
    public List<Watch> getAllProducts() {
        return dao.getProducts();
    }

    @Override
    public List<Watch> getProductOrderByPrice(boolean sortDescending) {
        List<Watch> products = dao.getProducts();
        return products.stream()
                .sorted(
                        sortDescending ?
                                Comparator.comparing(Watch::getPrice) :
                                Comparator.comparing(Watch::getPrice).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public List<Watch> getProductOrderByColor(boolean sortDescending) {
        List<Watch> products = dao.getProducts();
        return products.stream()
                .sorted(
                        sortDescending ?
                                Comparator.comparing(Watch::getColor) :
                                Comparator.comparing(Watch::getColor).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public List<Watch> getProductOrderByDate(boolean sortDescending) {
        List<Watch> products = dao.getProducts();
        return products.stream()
                .sorted(
                        sortDescending ?
                                Comparator.comparing(Watch::getArrivalDate) :
                                Comparator.comparing(Watch::getArrivalDate).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public BigDecimal getTotalCost() {
        List<Watch> products = dao.getProducts();
        return products.stream()
                .map(Watch::getPrice).reduce(BigDecimal::add)
                .orElse(BigDecimal.valueOf(0));
    }

    @Override
    public void addNewWatch(Watch watch) {
        dao.addProduct(watch);
    }
}

