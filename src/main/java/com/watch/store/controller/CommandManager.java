package com.watch.store.controller;

import com.watch.store.controller.command.Command;
import com.watch.store.view.LineByLineView;
import com.watch.store.view.View;

import java.util.Scanner;

public class CommandManager {
    private final View view = LineByLineView.getInstance();
    private final Scanner scanner = new Scanner(System.in);
    private final CommandRegistry commandRegistry = CommandRegistry.getInstance();

    public void run() {
        boolean isRunning = true;

        while (isRunning) {
            view.mainMenu();
            String input = scanner.nextLine();
            Command command = commandRegistry.getCommand(input);
            isRunning = command.execute();
        }
    }
}
