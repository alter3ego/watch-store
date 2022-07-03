package com.watch.store.view;

import com.watch.store.model.entity.Watch;

import java.math.BigDecimal;
import java.util.List;

public interface View {
    void start();

    void mainMenu();

    void wrongInput();

    void shutdown();

    void orderByMenu(boolean sortDescending);

    void applicationError();

    void printProductList(List<Watch> products);

    void totalCostRepresentation(BigDecimal totalCost);

    void greetingsWatchCommand();

    void inputField(String field);

    void addMechanicalWatchMenu();

    void addQuartzWatchMenu();

    void addSolarWatchMenu();

    void successfullyAdded();

    void addError();
}
