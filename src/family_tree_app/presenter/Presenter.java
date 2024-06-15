package family_tree_app.presenter;

import java.time.LocalDate;
import java.util.List;

import family_tree_app.model.Service;
import family_tree_app.model.human.Gender;
import family_tree_app.model.human.Human;
import family_tree_app.model.work_with_files.FileHandler;
import family_tree_app.view.View;

public class Presenter {
    private Service service;
    private View view;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
        service.setSavable(new FileHandler<>());
    }

    public void addPerson(String name, String gender, String dateOfBirth) {
        service.addPerson(name, transferToGender(gender), transferToDate(dateOfBirth));
    }

    public void setParents(String childString, String parent1String, String parent2String) {
        try {
            Human child = transferToHuman(childString);
            Human parent1 = transferToHuman(parent1String);
            Human parent2 = transferToHuman(parent2String);
            service.setParents(child, parent1, parent2);
        } catch (Exception e) {
            System.out.println("Errare humanum est. Try again");
        }
    }

    public void setPeriodOfLife(String humanString, String dateOfBirthString, String dateOfDeathString) {
        try {
            Human human = transferToHuman(humanString);
            LocalDate dateOfBirth = transferToDate(dateOfBirthString);
            LocalDate dateOfDeath = transferToDate(dateOfDeathString);
            service.setPeriodOfLife(human, dateOfBirth, dateOfDeath);
        } catch (Exception e) {
            System.out.println("Errare humanum est. Try again");
        }
    }

    public void showProgenitors(String human) {
        String answer = service.showProgenitors(transferToHuman(human));
        view.print(answer);
    }

    public void showMen() {
        String answer = service.showMen();
        view.print(answer);
    }

    public void showWomen() {
        String answer = service.showWomen();
        view.print(answer);
    }

    public void getList() {
        String answer = service.getList();
        view.print(answer);
    }

    public void sortByName() {
        service.sortByName();
        getList();
    }

    public void sortByAge() {
        service.sortByAge();
        getList();
    }

    public void sortByAmountOfChildren() {
        service.sortByAmountOfChildren();
        getList();
    }

    public void save() {
        service.save();
    }

    public void load() {
        service.load();
    }

    private Gender transferToGender(String genderString) {
        Gender gender;
        if (genderString.equals("m")) {
            gender = Gender.Male;
        } else {
            gender = Gender.Female;
        }
        return gender;
    }

    private LocalDate transferToDate(String dateString) {
        try {
            String[] dateArr = dateString.split("-");
            int year = 1900;
            int month = 1;
            int day = 1;
            if (checkForInt(dateArr[0])) {
                year = Integer.parseInt(dateArr[0]);
            }
            if (checkForInt(dateArr[1])) {
                month = Integer.parseInt(dateArr[1]);
            }
            if (checkForInt(dateArr[2])) {
                day = Integer.parseInt(dateArr[2]);
            }
            LocalDate date_to_send = LocalDate.of(year, month, day);
            return date_to_send;
        } catch (Exception e) {
            return null;
        }
    }

    private boolean checkForInt(String string) {
        if (string.matches("[0-9]*")) {
            return true;
        }
        return false;
    }

    private Human transferToHuman(String choiceString) {
        if (checkForInt(choiceString)) {
            int choice = Integer.parseInt(choiceString);
            try {
                Human human = getArrayList().get(choice - 1);
                return human;
            } catch (Exception e) {
                return null;
            }
        } else {
            return null;
        }
    }

    private List<Human> getArrayList() {
        return service.getArrayList();
    }
}