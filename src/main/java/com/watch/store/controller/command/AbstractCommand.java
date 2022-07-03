package com.watch.store.controller.command;

import com.watch.store.model.service.ProductService;
import com.watch.store.view.View;

import java.util.Scanner;

abstract public class AbstractCommand implements Command {
    private final ProductService productService;
    private final Scanner scanner;
    private final View view;

    AbstractCommand(ProductService productService, View view, Scanner scanner) {
        this.productService = productService;
        this.view = view;
        this.scanner = scanner;
    }

    public ProductService getProductService() {
        return productService;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public View getView() {
        return view;
    }
}
