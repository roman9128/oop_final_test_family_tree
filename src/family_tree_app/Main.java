package family_tree_app;

import family_tree_app.view.ConsoleUI;
import family_tree_app.view.View;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
    }
}
