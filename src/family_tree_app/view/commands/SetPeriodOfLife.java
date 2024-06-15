package family_tree_app.view.commands;

import family_tree_app.view.ConsoleUI;

public class SetPeriodOfLife extends Command {

    public SetPeriodOfLife(ConsoleUI consoleUI) {
        super("set lifetime of a selected person", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().setPeriodOfLife();
    }
}
