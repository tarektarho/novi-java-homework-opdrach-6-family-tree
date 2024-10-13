package nl.novi;

import java.util.ArrayList;
import java.util.List;

public class Person implements IPerson {
    private String name;
    private String middleName;
    private String lastName;
    private String sex;
    private int age;
    private Person mother;
    private Person father;
    private List<Person> siblings = new ArrayList<>();
    private List<Person> children = new ArrayList<>();
    private List<Pet> pets = new ArrayList<>();

    private Person partner;

    public Person(String name, String lastName, int age, String sex) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }

    public Person(String name, String middleName, String lastName, int age, String sex) {
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public List<Person> getSiblings() {
        return siblings;
    }

    public List<Person> getChildren() {
        return children;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public Person getPartner() {
        return partner;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public void setPartner(Person partner) {
        this.partner = partner;
    }


    public void addParents(Person parent) {
        if (parent != null) {
            var parentSex = parent.getSex().toLowerCase();
            if (parentSex.equals("male")) {
                this.father = parent;
            } else {
                this.mother = parent;
            }
        }
    }

    public void addSibling(Person sibling) {
        if (sibling != null) {
            this.siblings.add(sibling);
        }
    }

    public void addChild(Person child) {
        if (child != null) {
            this.children.add(child);
        }
    }

    public void addPet(Pet pet) {
        if (pet != null) {
            this.pets.add(pet);
        }
    }


    public List<Person> getGrandChildren() {
        List<Person> grandChildren = new ArrayList<>();
        for (Person child : children) {
            grandChildren.addAll(child.getChildren());
        }
        return grandChildren;
    }


    public List<Pet> getGrandChildrenPets() {
        List<Pet> pets = new ArrayList<>();
        for (Person grandChild : getGrandChildren()) {
            pets.addAll(grandChild.getPets());
        }
        return pets;
    }

    public List<Person> getNieces() {
        List<Person> nieces = new ArrayList<>();
        for (Person sibling : siblings) {
            if (!sibling.getChildren().isEmpty()) {
                for (Person niece : sibling.getChildren()) {
                    if (niece.getSex().equals("Female")) {
                        nieces.add(niece);
                    }
                }
            }
        }
        return nieces;
    }

    @Override
    public String toString() {
        return name + " " + (middleName != null ? middleName + " " : "") + lastName;
    }

}
