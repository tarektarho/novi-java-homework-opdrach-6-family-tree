package nl.novi;

public class Main {
    public static void main(String[] args) {
        // Create a family
        Person grandParent = new Person("Jack", "Doe", 65, "Male");
        Person father = new Person("John", "Doe", 40, "Male");
        Person mother = new Person("Jane", "Doe", 35, "Female");
        Person firstChildEmily = new Person("Emily", "Doe", 10, "Female");
        Person secondChildTom = new Person("Tom", "Doe", 8, "Male");


        // Add parents and children
        father.addChild(firstChildEmily);
        father.addChild(secondChildTom);
        mother.addChild(firstChildEmily);
        mother.addChild(secondChildTom);

        father.setPartner(mother);
        mother.setPartner(father);

        father.setFather(grandParent);

        // Add this line to link John as Jack's child
        grandParent.addChild(father); // This is crucial!

        // Add siblings
        firstChildEmily.addSibling(secondChildTom);
        secondChildTom.addSibling(firstChildEmily);

        // Create and Pets
        Pet dog = new Pet("Max", 3, "Dog");
        Pet cat = new Pet("Whiskers", 2, "Cat");
        dog.setOwner(father);
        cat.setOwner(mother);

        firstChildEmily.addPet(dog);
        secondChildTom.addPet(cat);

        // Display the family tree
        System.out.println("Family Tree:");
        System.out.println("Father: " + father);
        System.out.println("Mother: " + mother);
        System.out.println("Children: " + father.getChildren());
        System.out.println("Grandchildren of " + grandParent + ": " + grandParent.getGrandChildren());
        System.out.println("Pets of " + firstChildEmily + ": " + firstChildEmily.getPets());
        System.out.println("Pets of " + secondChildTom + ": " + secondChildTom.getPets());

    }
}
