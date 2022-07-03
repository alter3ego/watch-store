package com.watch.store.controller.command;

import com.watch.store.model.entity.Watch;
import com.watch.store.model.service.ProductService;
import com.watch.store.view.View;

import java.util.List;
import java.util.Scanner;

public class AllProductsCommand extends AbstractCommand {

    public AllProductsCommand(ProductService productService, View view, Scanner scanner) {
        super(productService, view, scanner);
    }

    @Override
    public boolean execute() {
        List<Watch> allProduct = getProductService().getAllProducts();
        getView().printProductList(allProduct);
        return true;
    }
}
