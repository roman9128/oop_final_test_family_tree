package family_tree_app.model.family_tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import family_tree_app.model.human.Gender;
import family_tree_app.model.human.comparators.ComparatorByAge;
import family_tree_app.model.human.comparators.ComparatorByAmountOfChildren;
import family_tree_app.model.human.comparators.ComparatorByName;

public class Tree<T extends FamilyTreeEntry<T>> implements FamilyTree<Tree<T>>, Iterable<T> {
    private List<T> familyTree;

    public Tree() {
        this(new ArrayList<>());
    }

    public Tree(List<T> familyTree) {
        this.familyTree = familyTree;
    }

    public void addToTree(T human) {
        familyTree.add(human);
    }

    public String showMen() {
        if (familyTree == null) {
            return "No info";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("Men in this family tree: ");
        for (T human : familyTree) {
            if (human.getGender() == Gender.Male) {
                builder.append(human.getName());
                builder.append(", ");
            }
        }
        if (builder.length() == 0) {
            return "No men in this family tree";
        } else {
            builder.deleteCharAt(builder.length() - 1);
            builder.deleteCharAt(builder.length() - 1);
            return builder.toString();
        }
    }

    public String showWomen() {
        if (familyTree == null) {
            return "No info";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("Women in this family tree: ");
        for (T human : familyTree) {
            if (human.getGender() == Gender.Female) {
                builder.append(human.getName());
                builder.append(", ");
            }
        }
        if (builder.length() == 0) {
            return "No women in this family tree";
        } else {
            builder.deleteCharAt(builder.length() - 1);
            builder.deleteCharAt(builder.length() - 1);
            return builder.toString();
        }
    }

    @Override
    public String toString() {

        if (familyTree == null) {
            return "No info";
        }
        int position = 1;
        StringBuilder builder = new StringBuilder();
        builder.append("This family tree contains:\n");
        for (T human : familyTree) {
            builder.append(position);
            builder.append(" - ");
            builder.append(human.getName());
            builder.append(" (");
            if (human.getDateOfDeath() != null) {
                builder.append("died at the age of ");
            }
            if (human.getAge() > 120) {
                builder.append("unknown age");
            } else {
                builder.append(human.getAge());
                builder.append(" y.o.");
            }
            if (human.getDateOfDeath() != null) {
                builder.append(", had ");
            } else {
                builder.append(", has ");
            }
            builder.append(human.getChildren().size());
            builder.append(" child(ren))\n");
            position++;
        }
        return builder.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new HumanIterator<>(familyTree);
    }

    public void sortByName() {
        familyTree.sort(new ComparatorByName<>());
    }

    public void sortByAge() {
        familyTree.sort(new ComparatorByAge<>());
    }

    public void sortByAmountOfChildren() {
        familyTree.sort(new ComparatorByAmountOfChildren<>());
    }

    public List<T> getFamilyTree() {
        return familyTree;
    }
}