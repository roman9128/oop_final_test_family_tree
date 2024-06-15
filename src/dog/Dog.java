package dog;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import family_tree_app.model.family_tree.FamilyTreeEntry;
import family_tree_app.model.human.Gender;

public class Dog implements FamilyTreeEntry<Dog> {

    private String name;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Dog mother;
    private Dog father;
    private List<Dog> children;

    public Dog(String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath, Dog mother, Dog father,
            List<Dog> children) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.mother = mother;
        this.father = father;
        this.children = children;
    }

    public Dog(String name, Gender gender) {
        this(name, gender, null, null, null, null, null);
    }

    public int getAge() {
        if (dateOfDeath == null) {
            return getPeriod(dateOfBirth, LocalDate.now());
        } else {
            return getPeriod(dateOfBirth, dateOfDeath);
        }
    }

    private int getPeriod(LocalDate dateOfBirth, LocalDate dateOfDeath) {
        if (dateOfBirth == null) {
            dateOfBirth = LocalDate.of(1900, 1, 1);
        }
        Period period = Period.between(dateOfBirth, dateOfDeath);
        return period.getYears();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public Dog getMother() {
        return mother;
    }

    public Dog getFather() {
        return father;
    }

    public void setParent(Dog parent) {
        if (parent.gender == Gender.Female) {
            this.mother = parent;
        } else {
            this.father = parent;
        }
        parent.setChildren(this);
    }

    public List<Dog> getChildren() {
        if (children == null) {
            children = new ArrayList<Dog>();
        }
        return children;
    }

    public void setChildren(Dog dog) {
        if (children == null) {
            children = new ArrayList<Dog>();
            this.children.add(dog);
        } else {
            if (children.contains(dog)) {
                return;
            } else {
                this.children.add(dog);
            }
        }
        dog.setParent(this);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Dog: [");
        builder.append("name: ");
        builder.append(name);
        builder.append(", gender: ");
        builder.append(gender);
        builder.append("]");
        return builder.toString();
    }
}