package family_tree_app.view;

import java.util.Scanner;

import family_tree_app.presenter.Presenter;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu mainMenu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Let's begin");
        while (work) {
            System.out.println(mainMenu.showMenu());
            String choiceString = scanner.nextLine();
            if (checkChoice(choiceString)) {
                int choice = Integer.parseInt(choiceString);
                mainMenu.makeAction(choice);
            } else
                continue;
        }
    }

    private boolean checkChoice(String choiceString) {
        if (choiceString.matches("[0-9]*")) {
            int choice = Integer.parseInt(choiceString);
            return choice >= 1 && choice <= mainMenu.size();
        }
        return false;
    }

    public void finish() {
        System.out.println("See you later!");
        work = false;
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByAmountOfChildren() {
        presenter.sortByAmountOfChildren();
    }

    public void getList() {
        presenter.getList();
    }

    public void showMen() {
        presenter.showMen();
    }

    public void showWomen() {
        presenter.showWomen();
    }

    public void showProgenitors() {
        System.out.println("Let's see progenitors of the person:");
        System.out.println("Enter number to choose person");
        getList();
        String choiceString = scanner.nextLine();
        presenter.showProgenitors(choiceString);
    }

    public void addPerson() {
        System.out.println("Who do you want to add?");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Is this person a man or a woman?");
        System.out.println("Enter 'm' for 'man' or enter 'w' for 'woman'");
        String genderString;
        while (true) {
            genderString = scanner.nextLine();
            if (genderString.equals("m") || genderString.equals("w")) {
                break;
            } else {
                System.out.println("Try again! Just push 'm' or 'w' button");
            }
        }
        System.out.println("Do you know the birth date of this person?");
        System.out.println("Enter 'y' for 'yes' or anything else for 'no'");
        String dateOfBirth;
        String choice = scanner.nextLine();
        if (choice.equals("y")) {
            System.out.println("Enter date as YYYY-MM-DD");
            dateOfBirth = scanner.nextLine();
            presenter.addPerson(name, genderString, dateOfBirth);
        } else {
            presenter.addPerson(name, genderString, null);
        }
        getList();
    }

    public void setParents() {
        System.out.println("Who is a child?");
        getList();
        System.out.println("Enter number to choose person");
        String child = scanner.nextLine();
        System.out.println("Who is a parent?");
        getList();
        System.out.println("Enter number to choose person");
        String parent1 = scanner.nextLine();
        if (child.equals(parent1)){
            System.out.println("This person was selected as a child earlier");
            parent1 = "err";
        }
        System.out.println("If you know the another parent of this person enter number to choose him/her or enter 0 to skip");
        getList();  
        String parent2 = scanner.nextLine();
        if (parent1.equals(parent2)){
            System.out.println("This person was selected as a parent earlier");
            parent2 = "err";
        }
        if (child.equals(parent2)){
            System.out.println("This person was selected as a child earlier");
            parent2 = "err";
        }
        presenter.setParents(child, parent1, parent2);
    }

    public void setPeriodOfLife() {
        System.out.println("Whose period of life do you want to set?");
        System.out.println("Enter number to choose person");
        getList();
        String human = scanner.nextLine();
        System.out.println("Set his/her birth date: ");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Set his/her death date: ");
        String dateOfDeath = scanner.nextLine();
        presenter.setPeriodOfLife(human, dateOfBirth, dateOfDeath);
    }

    @Override
    public void print(String answer) {
        System.out.println(answer);
    }

    public void save() {
        presenter.save();
    }

    public void load() {
        presenter.load();
    }
}