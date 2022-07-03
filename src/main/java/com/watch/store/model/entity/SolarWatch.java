package com.watch.store.model.entity;

import com.watch.store.model.exception.IncorrectDataException;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SolarWatch extends Watch {
    private static final WatchType TYPE = WatchType.SOLAR_WATCH;

    public SolarWatch(String title, WatchType type, BigDecimal price, Color color, LocalDate arrivalDate, String manufacturer) {
        super(title, type, price, color, arrivalDate, manufacturer);
        setType(TYPE);
    }

    public SolarWatch(String title, String price, Color color, String arrivalDate, String manufacturer) throws IncorrectDataException {
        super(title, price, color, arrivalDate, manufacturer);
        setType(TYPE);
    }
}
