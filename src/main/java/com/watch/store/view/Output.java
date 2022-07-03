package com.watch.store.view;

import com.watch.store.model.entity.Watch;

import java.util.List;

public interface Output {

    void printText(String message);

    void printText(String... messages);

    void printCommand(String command, String comment);

    void printWatchList(List<Watch> list);
}
