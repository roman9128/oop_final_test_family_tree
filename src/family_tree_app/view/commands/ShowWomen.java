package family_tree_app.view.commands;

import family_tree_app.view.ConsoleUI;

public class ShowWomen extends Command {
    
    public ShowWomen(ConsoleUI consoleUI) {
        super("see all women of the family", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().showWomen();
    }
}