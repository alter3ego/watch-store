package com.watch.store.model.entity;

import com.watch.store.model.exception.IncorrectDataException;

public abstract class WristWatch extends Watch {
    private Integer strapLength;

    public WristWatch(String title, String price, Color color, String arrivalDate,
                      String manufacturer, Integer strapLength) throws IncorrectDataException {
        super(title, price, color, arrivalDate, manufacturer);
        this.strapLength = strapLength;
    }

    public Integer getStrapLength() {
        return strapLength;
    }

    public void setStrapLength(Integer strapLength) {
        this.strapLength = strapLength;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + "strap length: " +
                strapLength + " mm";
    }
}
