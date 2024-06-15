package family_tree_app.model.family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import family_tree_app.model.human.Gender;

public interface FamilyTreeEntry<T> extends Serializable {
    int getAge();
    String getName();
    Gender getGender();
    List<T> getChildren();
    T getFather();
    T getMother();
    LocalDate getDateOfDeath();
}