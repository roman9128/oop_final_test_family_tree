package family_tree_app.view.commands;

import family_tree_app.view.ConsoleUI;

public class AddPerson extends Command {

    public AddPerson(ConsoleUI consoleUI) {
        super("add person to a tree", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addPerson();
    }
}
