package family_tree_app.view.commands;

import family_tree_app.view.ConsoleUI;

public class SetParents extends Command {

    public SetParents(ConsoleUI consoleUI) {
        super("set a parent(s) - child link", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().setParents();
    }
}
