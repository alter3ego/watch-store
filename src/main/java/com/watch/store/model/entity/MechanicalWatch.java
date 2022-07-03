package com.watch.store.model.entity;

import com.watch.store.model.exception.IncorrectDataException;

public class MechanicalWatch extends WristWatch {
    private static final WatchType TYPE = WatchType.MECHANICAL_WATCH;

    public MechanicalWatch(String title, String price, Color color, String arrivalDate,
                           String manufacturer, Integer strapLength) throws IncorrectDataException {
        super(title, price, color, arrivalDate, manufacturer, strapLength);
        setType(TYPE);
    }
}
