package family_tree_app.view.commands;

import family_tree_app.view.ConsoleUI;

public class Save extends Command {

    public Save(ConsoleUI consoleUI) {
        super("Save tree", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().save();
    }
}