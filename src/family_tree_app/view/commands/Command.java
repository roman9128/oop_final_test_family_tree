package family_tree_app.view.commands;

import family_tree_app.view.ConsoleUI;

public abstract class Command {

    private String desc;
    private ConsoleUI consoleUI;

    public Command(String desc, ConsoleUI consoleUI) {
        this.desc = desc;
        this.consoleUI = consoleUI;
    }

    public String getDesc() {
        return desc;
    }

    ConsoleUI getConsoleUI() {
        return consoleUI;
    }

    public abstract void execute();
}