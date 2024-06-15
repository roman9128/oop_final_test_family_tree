package family_tree_app.view.commands;

import family_tree_app.view.ConsoleUI;

public class GetList extends Command {

    public GetList(ConsoleUI consoleUI) {
        super("see all family members", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getList();
    }
}
