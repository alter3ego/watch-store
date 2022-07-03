package com.watch.store.controller;

import com.watch.store.controller.command.*;
import com.watch.store.model.dao.ProductDB;
import com.watch.store.model.service.ProductService;
import com.watch.store.model.service.impl.ProductServiceImpl;
import com.watch.store.util.CommandNames;
import com.watch.store.view.LineByLineView;
import com.watch.store.view.View;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandRegistry {
    private static CommandRegistry instance;
    private final Map<String, Command> commands = new HashMap<>();
    private static final ProductService PRODUCT_SERVICE = new ProductServiceImpl(ProductDB.getInstance());
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final View VIEW = LineByLineView.getInstance();

    private CommandRegistry() {
        commands.put(CommandNames.ALL_PRODUCTS, new AllProductsCommand(PRODUCT_SERVICE, VIEW, SCANNER));
        commands.put(CommandNames.TERMINATE, new TerminateCommand(PRODUCT_SERVICE, VIEW, SCANNER));
        commands.put(CommandNames.TOTAL_COST, new TotalCostCommand(PRODUCT_SERVICE, VIEW, SCANNER));
        commands.put(CommandNames.ADD_PRODUCT, new AddCWatchCommand(PRODUCT_SERVICE, VIEW, SCANNER));
        commands.put(CommandNames.SORT, new AllProductsOrderByCommand(PRODUCT_SERVICE, VIEW, SCANNER));
    }

    public Command getCommand(String input) {
        Command command = commands.get(input);
        if (command == null) {
            command = new UnknownCommand(PRODUCT_SERVICE, VIEW, SCANNER);
        }
        return command;
    }

    public static CommandRegistry getInstance() {
        if (instance == null) {
            instance = new CommandRegistry();
        }
        return instance;
    }
}
