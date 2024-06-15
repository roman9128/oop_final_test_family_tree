package family_tree_app.model.human.comparators;

import java.util.Comparator;

import family_tree_app.model.family_tree.FamilyTreeEntry;

public class ComparatorByAmountOfChildren<T extends FamilyTreeEntry<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getChildren().size(), o2.getChildren().size());
    }
}