package nl.novi;

public interface IPet {
    public String getName();
    public int getAge();
    public String getSpecies();
    public Person getOwner();
    public void setName(String name);
    public void setAge(int age);
    public void setSpecies(String species);
    public void setOwner(Person owner);
}
