package family_tree_app.model;

import java.time.LocalDate;
import java.util.List;

import family_tree_app.model.family_tree.Tree;
import family_tree_app.model.human.Gender;
import family_tree_app.model.human.Human;
import family_tree_app.model.work_with_files.Savable;

public class Service {
    private Tree<Human> tree;
    private Savable<Tree<Human>> savable;

    public Service() {
        tree = new Tree<>();
    }

    public void addPerson(String name, Gender gender, LocalDate dateOfBirth) {
        Human human = new Human(name, gender, dateOfBirth);
        tree.addToTree(human);
    }

    public void setParents(Human child, Human parent1, Human parent2) {
        if (parent1 != null && parent2 != null){
            child.setParents(parent1, parent2);
        } else if(parent1 == null && parent2 != null){
            child.setParent(parent2);
        } else if (parent2 == null && parent1 != null){
            child.setParent(parent1);
        } else return;
    }

    public void setPeriodOfLife(Human human, LocalDate dateOfBirth, LocalDate dateOfDeath) {
        human.setDateOfBirth(dateOfBirth);
        human.setDateOfDeath(dateOfDeath);
    }

    public String showProgenitors(Human human) {
        if (human == null){
            return "Incorrect input";
        }
        return human.showProgenitors();
    }

    public String showMen() {
        return tree.showMen();
    }

    public String showWomen() {
        return tree.showWomen();
    }

    public String getList() {
        return tree.toString();
    }

    public List<Human> getArrayList() {
        return tree.getFamilyTree();
    }

    public void sortByName() {
        tree.sortByName();
    }

    public void sortByAge() {
        tree.sortByAge();
    }

    public void sortByAmountOfChildren() {
        tree.sortByAmountOfChildren();
    }

    public void setSavable(Savable<Tree<Human>> savable) {
        this.savable = savable;
    }

    public boolean save() {
        if (savable == null) {
            return false;
        }
        return savable.save(tree);
    }

    public boolean load() {
        if (savable == null) {
            return false;
        }
        tree = savable.read();
        return true;
    }
}