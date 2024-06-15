package family_tree_app.view.commands;

import family_tree_app.view.ConsoleUI;

public class SortByName extends Command {

    public SortByName(ConsoleUI consoleUI) {
        super("Sort by name", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByName();
    }
}