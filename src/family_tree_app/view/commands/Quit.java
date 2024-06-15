package family_tree_app.view.commands;

import family_tree_app.view.ConsoleUI;

public class Quit extends Command {

    public Quit(ConsoleUI consoleUI) {
        super("Quit", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().finish();
    }
}