package com.watch.store.view;

import com.watch.store.model.entity.Color;
import com.watch.store.model.entity.Watch;
import com.watch.store.util.PropertyManager;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.watch.store.util.CommandNames.ADD_PRODUCT;
import static com.watch.store.util.CommandNames.ALL_PRODUCTS;
import static com.watch.store.util.CommandNames.COLOR;
import static com.watch.store.util.CommandNames.DATE;
import static com.watch.store.util.CommandNames.ERROR_COUNTING_SECONDS_PER_MONTH;
import static com.watch.store.util.CommandNames.EXIT;
import static com.watch.store.util.CommandNames.INVERT;
import static com.watch.store.util.CommandNames.MANUFACTURER;
import static com.watch.store.util.CommandNames.MECHANICAL_WATCH;
import static com.watch.store.util.CommandNames.MENU;
import static com.watch.store.util.CommandNames.PRICE;
import static com.watch.store.util.CommandNames.QUARTZ_WATCH;
import static com.watch.store.util.CommandNames.SOLAR_WATCH;
import static com.watch.store.util.CommandNames.SORT;
import static com.watch.store.util.CommandNames.STRAP_LENGTH;
import static com.watch.store.util.CommandNames.TERMINATE;
import static com.watch.store.util.CommandNames.TITLE;
import static com.watch.store.util.CommandNames.TOTAL_COST;

public class LineByLineView implements View {
    private static LineByLineView instance;
    private static final PropertyManager MANAGER = PropertyManager.getInstance();
    private final Output output = new ConsoleOutput();

    @Override
    public void shutdown() {
        output.printText(message("goodbye"));
    }

    @Override
    public void start() {
        output.printText(message("program.launched"));
    }

    @Override
    public void mainMenu() {
        output.printText(message("main.menu"));
        output.printText(message("enter.command"));
        output.printCommand(ALL_PRODUCTS, message("get.list"));
        output.printCommand(SORT, message("sort.menu"));
        output.printCommand(TOTAL_COST, message("get.total.cost"));
        output.printCommand(ADD_PRODUCT, message("add.product"));
        output.printCommand(TERMINATE, message("end"));
    }

    @Override
    public void wrongInput() {
        output.printText(message("incorrect"));
    }

    @Override
    public void orderByMenu(boolean sortDescending) {
        output.printText(message("order.by.menu"));
        output.printText(message("current.sort.mode"), getCurrentSortType(sortDescending));
        output.printText(message("enter.command"));
        output.printCommand(INVERT, message("change.sort.type"));
        output.printCommand(PRICE, message("sort.by.price"));
        output.printCommand(COLOR, message("sort.by.color"));
        output.printCommand(DATE, message("sort.by.date"));
        output.printCommand(MENU, message("back.main.menu"));
    }

    @Override
    public void applicationError() {
        output.printText(message("application.error"));
    }

    @Override
    public void printProductList(List<Watch> products) {
        output.printWatchList(products);
    }

    @Override
    public void totalCostRepresentation(BigDecimal totalCost) {
        output.printText(message("total.cost"), totalCost.toString(), message("uah"));
    }

    @Override
    public void greetingsWatchCommand() {
        output.printText(message("add.watch.menu"));
        output.printText(message("select.watch.type"));
        output.printCommand(MECHANICAL_WATCH, message("add.mechanical.watch"));
        output.printCommand(QUARTZ_WATCH, message("add.quartz.watch"));
        output.printCommand(SOLAR_WATCH, message("add.sundial.watch"));
        output.printCommand(MENU, message("back.main.menu"));
    }

    @Override
    public void inputField(String field) {
        String OR_EXIT_TO_MENU = message("or.enter.start") + EXIT + message("or.enter.end");
        switch (field) {
            case (TITLE) -> output.printText(message("enter.title") , OR_EXIT_TO_MENU);
            case (PRICE) -> output.printText(message("enter.price"), OR_EXIT_TO_MENU);
            case (COLOR) -> {
                output.printText(message("enter.color"), OR_EXIT_TO_MENU);
                Arrays.stream(Color.values()).forEach(
                        x ->
                                output.printText("'" + x.ordinal() + "' " + message("for.select") + " " + x.name())
                );
            }
            case (DATE) -> output.printText(message("enter.date"), OR_EXIT_TO_MENU);
            case (MANUFACTURER) -> output.printText(message("enter.manufacturer"), OR_EXIT_TO_MENU);
            case (STRAP_LENGTH) -> output.printText(message("strap.length"), OR_EXIT_TO_MENU);
            case (ERROR_COUNTING_SECONDS_PER_MONTH) -> output.printText(message("strap.error.per.month"), OR_EXIT_TO_MENU);
            default -> applicationError();
        }
    }

    @Override
    public void addMechanicalWatchMenu() {
        output.printText(message("mechanical.watch.add.menu"));
    }

    @Override
    public void addQuartzWatchMenu() {
        output.printText(message("quartz.watch.add.menu"));
    }

    @Override
    public void addSolarWatchMenu() {
        output.printText(message("solar.watch.add.menu"));
    }

    @Override
    public void successfullyAdded() {
        output.printText(message("successfully.added"));
    }

    @Override
    public void addError() {
        output.printText(message("error.adding"));
    }

    private String getCurrentSortType(boolean sortDescending) {
        return sortDescending ? message("sort.descending") : message("sort.ascending");
    }

    private static String message(String message) {
        return MANAGER.getMessage(message);
    }

    public static LineByLineView getInstance() {
        if (instance == null) {
            instance = new LineByLineView();
        }
        return instance;
    }
}
