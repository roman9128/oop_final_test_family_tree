package family_tree_app.model.family_tree;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<T> implements Iterator<T> {

    private int i;
    private List<T> familyTree;

    public HumanIterator(List<T> familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public boolean hasNext() {
        return familyTree.size() > i;
    }

    @Override
    public T next() {
        return familyTree.get(i++);
    }
}
