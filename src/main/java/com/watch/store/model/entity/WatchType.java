package com.watch.store.model.entity;

public enum WatchType {

    MECHANICAL_WATCH("Mechanical watch"),
    QUARTZ_WATCH("Quartz watch"),
    SOLAR_WATCH("Solar watch");

    private final String toString;

    WatchType(String toString) {
        this.toString = toString;
    }

    public String toString() {
        return toString;
    }
}
