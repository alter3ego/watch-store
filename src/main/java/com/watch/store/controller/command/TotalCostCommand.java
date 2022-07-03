package com.watch.store.controller.command;

import com.watch.store.model.service.ProductService;
import com.watch.store.view.View;

import java.math.BigDecimal;
import java.util.Scanner;

public class TotalCostCommand extends AbstractCommand {

    public TotalCostCommand(ProductService productService, View view, Scanner scanner) {
        super(productService, view, scanner);
    }

    @Override
    public boolean execute() {
        BigDecimal totalCost = getProductService().getTotalCost();
        getView().totalCostRepresentation(totalCost);
        return true;
    }
}
