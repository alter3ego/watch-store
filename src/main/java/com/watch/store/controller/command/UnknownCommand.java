package com.watch.store.controller.command;

import com.watch.store.model.service.ProductService;
import com.watch.store.view.View;

import java.util.Scanner;

public class UnknownCommand extends AbstractCommand {

    public UnknownCommand(ProductService productService, View view, Scanner scanner) {
        super(productService, view, scanner);
    }

    @Override
    public boolean execute() {
        getView().wrongInput();
        return true;
    }
}
