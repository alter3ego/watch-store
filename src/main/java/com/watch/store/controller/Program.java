package com.watch.store.controller;

import com.watch.store.view.LineByLineView;
import com.watch.store.view.View;

public class Program {
    private final View view = LineByLineView.getInstance();
    private final CommandManager manager = new CommandManager();

    public void run() {
        view.start();
        manager.run();
    }
}
