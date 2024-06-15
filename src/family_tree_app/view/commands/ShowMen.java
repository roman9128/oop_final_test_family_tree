package family_tree_app.view.commands;

import family_tree_app.view.ConsoleUI;

public class ShowMen extends Command {

    public ShowMen(ConsoleUI consoleUI) {
        super("see all men of the family", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().showMen();
    }
}
