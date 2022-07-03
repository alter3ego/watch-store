package com.watch.store.model.entity;

import com.watch.store.model.exception.IncorrectDataException;

import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Watch {
    private String title;
    private WatchType type;
    private BigDecimal price;
    private Color color;
    private LocalDate arrivalDate;
    private String manufacturer;

    public String getTitle() {
        return title;
    }

    public WatchType getType() {
        return type;
    }

    public void setType(WatchType type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) throws IncorrectDataException {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            this.arrivalDate = LocalDate.parse(arrivalDate, formatter);
        } catch (DateTimeException e) {
            throw new IncorrectDataException();
        }
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Watch(String title, WatchType type, BigDecimal price, Color color, LocalDate arrivalDate, String manufacturer) {
        this.title = title;
        this.type = type;
        this.price = price;
        this.color = color;
        this.arrivalDate = arrivalDate;
        this.manufacturer = manufacturer;
    }

    public Watch() {
    }

    public Watch(String title, String price, Color color, String arrivalDate, String manufacturer) throws IncorrectDataException {
        this.title = title;
        this.color = color;
        try {
            this.price = new BigDecimal(price);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            this.arrivalDate = LocalDate.parse(arrivalDate, formatter);
        } catch (NumberFormatException | DateTimeException e) {
            throw new IncorrectDataException();
        }
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return title + ", " +
                type + ", " +
                price + " UAH, " +
                color + ", " +
                arrivalDate + ", " +
                manufacturer;
    }
}
