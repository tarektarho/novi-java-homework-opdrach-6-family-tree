package nl.novi;

import java.util.List;

public interface IPerson {
    public String getName();
    public String getMiddleName();
    public String getLastName();
    public String getSex();
    public int getAge();
    public Person getMother();
    public Person getFather();
    public List<Person> getSiblings();
    public List<Person> getChildren();
    public List<Pet> getPets();

    public void setName(String name);
    public void setMiddleName(String middleName);
    public void setLastName(String lastName);
    public void setSex(String sex);
    public void setAge(int age);
    public void setMother(Person mother);
    public void setFather(Person father);

    public void addParents(Person parent);
    public void addSibling(Person sibling);
    public void addChild(Person child);
    public void addPet(Pet pet);

    public List<Person> getGrandChildren();

    public List<Pet> getGrandChildrenPets();

    public List<Person> getNieces();

    public void setPartner(Person partner);

    public Person getPartner();
}
