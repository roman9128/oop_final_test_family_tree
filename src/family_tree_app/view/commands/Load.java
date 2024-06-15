package family_tree_app.view.commands;

import family_tree_app.view.ConsoleUI;

public class Load extends Command {

    public Load(ConsoleUI consoleUI) {
        super("Load tree", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().load();
    }
}