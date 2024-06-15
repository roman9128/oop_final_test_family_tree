package family_tree_app.model.human.comparators;

import java.util.Comparator;

import family_tree_app.model.family_tree.FamilyTreeEntry;

public class ComparatorByAge<T extends FamilyTreeEntry<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getAge() - o2.getAge();
    }
}