package com.watch.store.model.entity;

import com.watch.store.model.exception.IncorrectDataException;

public class QuartzWatch extends WristWatch {
    private static final WatchType TYPE = WatchType.QUARTZ_WATCH;
    private Integer errorCountingSecondsPerMonth;

    public QuartzWatch(String title, String price, Color color, String arrivalDate,
                       String manufacturer, int errorInCountingSecondsPerMonth, Integer strapLength) throws IncorrectDataException {
        super(title, price, color, arrivalDate, manufacturer, strapLength);
        setType(TYPE);
        this.errorCountingSecondsPerMonth = errorInCountingSecondsPerMonth;
    }

    public Integer getErrorCountingSecondsPerMonth() {
        return errorCountingSecondsPerMonth;
    }

    public void setErrorCountingSecondsPerMonth(Integer errorCountingSecondsPerMonth) {
        this.errorCountingSecondsPerMonth = errorCountingSecondsPerMonth;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + "error in seconds per month: " +
                errorCountingSecondsPerMonth + " s/m";
    }
}
