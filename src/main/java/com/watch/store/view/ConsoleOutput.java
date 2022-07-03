package com.watch.store.view;

import com.watch.store.model.entity.Watch;

import java.util.Arrays;
import java.util.List;

public class ConsoleOutput implements Output {
    @Override
    public void printText(String message) {
        System.out.println(message);
    }

    public void printText(String... messages) {
        Arrays.stream(messages).forEach(x -> System.out.print(x + " "));
        System.out.println();
    }

    @Override
    public void printCommand(String command, String comment) {
        String text = String.format("'%s' - %s", command, comment);
        printText(text);
    }

    @Override
    public void printWatchList(List<Watch> list) {
        list.forEach(w -> printText(w.toString()));
    }
}
