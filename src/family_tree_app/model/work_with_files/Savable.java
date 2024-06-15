package family_tree_app.model.work_with_files;

import java.io.Serializable;

import family_tree_app.model.family_tree.FamilyTree;

public interface Savable<F extends FamilyTree<F>> {

    boolean save(Serializable serializable, String filePath);
    boolean save(F tree);
    Object read(String filePath);
    F read();
}