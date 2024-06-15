package family_tree_app.view;

import java.util.ArrayList;
import java.util.List;

import family_tree_app.view.commands.AddPerson;
import family_tree_app.view.commands.Command;
import family_tree_app.view.commands.GetList;
import family_tree_app.view.commands.Load;
import family_tree_app.view.commands.Quit;
import family_tree_app.view.commands.Save;
import family_tree_app.view.commands.SetParents;
import family_tree_app.view.commands.SetPeriodOfLife;
import family_tree_app.view.commands.ShowMen;
import family_tree_app.view.commands.ShowProgenitors;
import family_tree_app.view.commands.ShowWomen;
import family_tree_app.view.commands.SortByAge;
import family_tree_app.view.commands.SortByAmountOfChildren;
import family_tree_app.view.commands.SortByName;

public class MainMenu {
    private List<Command> commands;

    public MainMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new AddPerson(consoleUI));
        commands.add(new SetParents(consoleUI));
        commands.add(new SetPeriodOfLife(consoleUI));
        commands.add(new GetList(consoleUI));
        commands.add(new ShowMen(consoleUI));
        commands.add(new ShowWomen(consoleUI));
        commands.add(new ShowProgenitors(consoleUI));
        commands.add(new SortByAge(consoleUI));
        commands.add(new SortByName(consoleUI));
        commands.add(new SortByAmountOfChildren(consoleUI));
        commands.add(new Load(consoleUI));
        commands.add(new Save(consoleUI));
        commands.add(new Quit(consoleUI));
    }

    public String showMenu() {
        StringBuilder builder = new StringBuilder();
        builder.append("Choose action\n");
        for (int i = 0; i < commands.size(); i++) {
            builder.append(i + 1);
            builder.append(" - ");
            builder.append(commands.get(i).getDesc());
            builder.append("\n");
        }
        builder.append("-------");
        return builder.toString();
    }

    public void makeAction(int choice) {
        Command command = commands.get(choice - 1);
        command.execute();
    }

    public int size() {
        return commands.size();
    }
}