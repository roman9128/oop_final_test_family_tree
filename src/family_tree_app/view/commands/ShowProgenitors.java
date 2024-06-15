package family_tree_app.view.commands;

import family_tree_app.view.ConsoleUI;

public class ShowProgenitors extends Command {

    public ShowProgenitors(ConsoleUI consoleUI) {
        super("see all progenitors of a chosen person", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().showProgenitors();
    }
}
