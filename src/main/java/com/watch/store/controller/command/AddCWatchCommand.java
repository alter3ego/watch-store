package com.watch.store.controller.command;

import com.watch.store.model.entity.*;
import com.watch.store.model.exception.IncorrectDataException;
import com.watch.store.model.service.ProductService;
import com.watch.store.view.View;

import java.util.*;

import static com.watch.store.util.CommandNames.*;

public class AddCWatchCommand extends AbstractCommand {
    private static final String REGEX_ANY_TEXT = "[\\s\\S\\w\\W\\d\\D]{1,40}";
    private static final String REGEX_PRICE = "(^\\d{1,12}$|^\\d{1,12}\\.\\d{1,2}$)";
    private static final String REGEX_COLOR = "[0-9]";
    private static final String REGEX_DATE = "([0-2][1-9]|[1-2][0-9]|[3][0-1])\\.([1][1-2]|[0][1-9])\\.[0-9]{4}";
    private static final String REGEX_LENGTH = "[0-9]{1,4}";

    public AddCWatchCommand(ProductService productService, View view, Scanner scanner) {
        super(productService, view, scanner);
    }

    @Override
    public boolean execute() {
        boolean watchCommandMode = true;
        while (watchCommandMode) {
            getView().greetingsWatchCommand();
            String input = getScanner().nextLine();
            switch (input) {
                case (MECHANICAL_WATCH) -> addMechanicalWatch();
                case (QUARTZ_WATCH) -> addQuartzWatch();
                case (SOLAR_WATCH) -> addSolarWatch();
                case (MENU) -> watchCommandMode = false;
                default -> getView().wrongInput();
            }
        }
        return true;
    }

    private Optional<List<String>> createBaseWatch() {
        List<String> regexList = new ArrayList<>(Arrays.asList(REGEX_ANY_TEXT,
                REGEX_PRICE, REGEX_COLOR, REGEX_DATE, REGEX_ANY_TEXT));
        List<String> fieldList = new ArrayList<>(Arrays.asList(TITLE, PRICE,
                COLOR, DATE, MANUFACTURER));
        List<String> baseWatchList = new ArrayList<>();
        for (int regexIndex = 0, fieldIndex = 0; regexIndex <= regexList.size() - 1; regexIndex++, fieldIndex++) {
            Optional<String> field = fillField(regexList.get(regexIndex), fieldList.get(fieldIndex));
            if (field.isEmpty()) {
                return Optional.empty();
            } else {
                baseWatchList.add(field.get());
            }
        }
        return Optional.of(baseWatchList);
    }

    private Optional<String> fillField(String regex, String field) {
        while (true) {
            getView().inputField(field);
            String input = getScanner().nextLine();
            if (input.equals(EXIT)) {
                return Optional.empty();
            } else if (input.matches(regex)) {
                return Optional.of(input);
            } else {
                getView().wrongInput();
            }
        }
    }

    private void addMechanicalWatch() {
        while (true) {
            getView().addMechanicalWatchMenu();
            Optional<List<String>> baseWatch = createBaseWatch();
            if (baseWatch.isPresent()) {
                Optional<String> strapLengthOptional = fillField(REGEX_LENGTH, STRAP_LENGTH);
                if (strapLengthOptional.isPresent()) {
                    Integer strapLength = Integer.valueOf(strapLengthOptional.get());
                    Watch mechanicalWatch;
                    try {
                        mechanicalWatch = new MechanicalWatch(baseWatch.get().get(0), baseWatch.get().get(1),
                                Color.values()[Integer.parseInt(baseWatch.get().get(2))],
                                baseWatch.get().get(3), baseWatch.get().get(4), strapLength);
                    } catch (IncorrectDataException e) {
                        getView().addError();
                        continue;
                    }
                    getProductService().addNewWatch(mechanicalWatch);
                    getView().successfullyAdded();
                    break;
                }
            }
            return;
        }
    }

    private void addQuartzWatch() {
        while (true) {
            getView().addQuartzWatchMenu();
            Optional<List<String>> baseWatch = createBaseWatch();
            if (baseWatch.isPresent()) {
                Optional<String> strapLengthOptional = fillField(REGEX_LENGTH, STRAP_LENGTH);
                if (strapLengthOptional.isPresent()) {
                    Optional<String> errorCountingSecondsPerMonthOptional = fillField(REGEX_LENGTH, ERROR_COUNTING_SECONDS_PER_MONTH);
                    if (errorCountingSecondsPerMonthOptional.isPresent()) {
                        int strapLength = Integer.parseInt(strapLengthOptional.get());
                        Integer errorCountingSecondsPerMonth = Integer.valueOf(errorCountingSecondsPerMonthOptional.get());
                        Watch quartzWatch;
                        try {
                            quartzWatch = new QuartzWatch(baseWatch.get().get(0), baseWatch.get().get(1),
                                    Color.values()[Integer.parseInt(baseWatch.get().get(2))],
                                    baseWatch.get().get(3), baseWatch.get().get(4), strapLength, errorCountingSecondsPerMonth);
                        } catch (IncorrectDataException e) {
                            getView().addError();
                            continue;
                        }
                        getProductService().addNewWatch(quartzWatch);
                        getView().successfullyAdded();
                        break;
                    }
                }
            }
            return;
        }
    }

    private void addSolarWatch() {
        while (true) {
            getView().addSolarWatchMenu();
            Optional<List<String>> baseWatch = createBaseWatch();
            if (baseWatch.isPresent()) {
                Watch solarWatch;
                try {
                    solarWatch = new SolarWatch(baseWatch.get().get(0), baseWatch.get().get(1),
                            Color.values()[Integer.parseInt(baseWatch.get().get(2))],
                            baseWatch.get().get(3), baseWatch.get().get(4));
                } catch (IncorrectDataException e) {
                    getView().addError();
                    continue;
                }
                getProductService().addNewWatch(solarWatch);
                getView().successfullyAdded();
                break;
            }
            return;
        }
    }
}
