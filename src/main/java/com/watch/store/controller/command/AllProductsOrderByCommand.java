package com.watch.store.controller.command;

import com.watch.store.model.entity.Watch;
import com.watch.store.model.service.ProductService;
import com.watch.store.util.CommandNames;
import com.watch.store.view.View;

import java.util.List;
import java.util.Scanner;

public class AllProductsOrderByCommand extends AbstractCommand {
    private boolean sortDescending = true;

    public AllProductsOrderByCommand(ProductService productService, View view, Scanner scanner) {
        super(productService, view, scanner);
    }

    @Override
    public boolean execute() {
        boolean orderByMode = true;
        while (orderByMode) {
            getView().orderByMenu(sortDescending);
            String input = getScanner().nextLine();
            switch (input) {
                case (CommandNames.INVERT) -> sortDescending = !sortDescending;
                case (CommandNames.PRICE) -> {
                    List<Watch> productOrderByPrice = getProductService().getProductOrderByPrice(sortDescending);
                    getView().printProductList(productOrderByPrice);
                }
                case (CommandNames.COLOR) -> {
                    List<Watch> productOrderByColor = getProductService().getProductOrderByColor(sortDescending);
                    getView().printProductList(productOrderByColor);
                }
                case (CommandNames.DATE) -> {
                    List<Watch> productOrderByDate = getProductService().getProductOrderByDate(sortDescending);
                    getView().printProductList(productOrderByDate);
                }
                case (CommandNames.MENU) -> orderByMode = false;
                default -> getView().wrongInput();
            }
        }
        return true;
    }
}
