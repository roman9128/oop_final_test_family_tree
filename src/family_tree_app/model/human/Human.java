package family_tree_app.model.human;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import family_tree_app.model.family_tree.FamilyTreeEntry;

public class Human implements FamilyTreeEntry<Human> {
    private String name;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Human mother;
    private Human father;
    private List<Human> children;

    public Human(String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath, Human mother, Human father,
            List<Human> children) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.mother = mother;
        this.father = father;
        this.children = children;
    }

    public Human(String name, Gender gender) {
        this(name, gender, null, null, null, null, null);
    }

    public Human(String name, Gender gender, LocalDate dateOfBirth) {
        this(name, gender, dateOfBirth, null, null, null, null);
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

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public void setParent(Human parent) {
        if (parent.gender == Gender.Female) {
            this.mother = parent;
        } else {
            this.father = parent;
        }
        parent.setChildren(this);
    }

    public void setParents(Human parent1, Human parent2) {
        if (parent1.gender == Gender.Female) {
            this.mother = parent1;
        } else {
            this.father = parent1;
        }
        if (parent2.gender == Gender.Male) {
            this.father = parent1;
        } else {
            this.mother = parent1;
        }
        parent1.setChildren(this);
        parent2.setChildren(this);
    }

    public List<Human> getChildren() {
        if (children == null) {
            children = new ArrayList<Human>();
        }
        return children;
    }

    public void setChildren(Human child) {
        if (children == null) {
            children = new ArrayList<Human>();
            this.children.add(child);
        } else {
            if (children.contains(child)) {
                return;
            } else {
                this.children.add(child);
            }
        }
        child.setParent(this);
    }

    public String getChildenNames() {
        if (children == null) {
            return "No info";
        }
        StringBuilder builder = new StringBuilder();
        for (Human human : children) {
            builder.append(human.getName());
            builder.append(", ");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Person: [");
        builder.append("name: ");
        builder.append(name);
        builder.append(", gender: ");
        builder.append(gender);
        if (dateOfBirth != null && dateOfDeath != null) {
            builder.append(", years of life: ");
            builder.append(dateOfBirth);
            builder.append(" - ");
            builder.append(dateOfDeath);
            builder.append(", lived ");
            builder.append(getAge());
            builder.append(" years");
        } else if (dateOfBirth != null && dateOfDeath == null) {
            builder.append(", born: ");
            builder.append(dateOfBirth);
            builder.append(", current age: ");
            builder.append(getAge());
        } else if (dateOfBirth == null && dateOfDeath != null) {
            builder.append(", died: ");
            builder.append(dateOfDeath);
        } else {
            builder.append(", no info about age");
        }
        builder.append(", mother: ");
        if (mother == null) {
            builder.append("No info");
        } else {
            builder.append(getMother().getName());
        }
        builder.append(", father: ");
        if (father == null) {
            builder.append("No info");
        } else {
            builder.append(getFather().getName());
        }
        builder.append(", ");
        builder.append("children: ");
        builder.append(getChildenNames());
        builder.append("]");
        return builder.toString();
    }

    public String showProgenitors() {
        return "The progenitors of " + this.getName() + " are: " + showProgenitor(this);
    }

    private String showProgenitor(Human human) {
        StringBuilder builder = new StringBuilder();
        if (human.getFather() == null) {
            builder.append("");
        } else {
            builder.append("\n- ");
            builder.append(human.getFather().getName());
            builder.append(" (");
            builder.append(human.getName());
            builder.append("'s dad)");
        }
        if (human.getMother() == null) {
            builder.append("");
        } else {
            builder.append("\n- ");
            builder.append(human.getMother().getName());
            builder.append(" (");
            builder.append(human.getName());
            builder.append("'s mom)");
        }
        if (human.getFather() == null) {
            builder.append("");
        } else {
            builder.append(showProgenitor(human.getFather()));
        }
        if (human.getMother() == null) {
            builder.append("");
        } else {
            builder.append(showProgenitor(human.getMother()));
        }
        return builder.toString();
    }
}