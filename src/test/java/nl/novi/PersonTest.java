package nl.novi;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person Tarek = new Person("Tarek", "Tarho", 30, "Male");
    Person Randa = new Person("Randa", "Tarho-Mureiwed", 52, "Female");
    Person Motaz = new Person("Motaz", "Tarho", 43, "Male");
    Person Natal = new Person("Natal", "Tarho", 18, "Female");
    Person Alhaam = new Person("Alhaam","Mograbie", 75, "Female");
    Person Debbie = new Person("Debbie", "Deborah", "Verboom", 27, "Female");
    Person Jacqueline = new Person("Jacqueline", "Verboom-Quist", 60, "Female");
    Person Aaike = new Person("Aaike", "Verboom", 61, "Male");
    Person Renée = new Person("Renée", "Verboom-Schaeffer", 35, "Female");
    Person Heleen = new Person("Heleen", "Verboom-van Bellen", 87, "Female");

    @Test
    void getName() {
        assertEquals("Debbie", Debbie.getName());
    }

    @Test
    void getMiddleName() {
        assertEquals("Deborah", Debbie.getMiddleName());
    }

    @Test
    void getLastName() {
        assertEquals("Tarho", Tarek.getLastName());
    }

    @Test
    void getSex() {
        assertEquals("Male", Tarek.getSex());
    }

    @Test
    void getAge() {
        assertEquals(30, Tarek.getAge());
    }

    @Test
    void getMother() {
        Tarek.setMother(Randa);
        assertEquals(Randa, Tarek.getMother());
    }

    @Test
    void getFather() {
        Debbie.setFather(Aaike);
        assertEquals(Aaike, Debbie.getFather());
    }

    @Test
    void getSiblings() {
        Tarek.addSibling(Natal);
        assertEquals(1, Tarek.getSiblings().size());
        assertEquals(Natal, Tarek.getSiblings().get(0)); // get(0) is the first element in the list
    }

    @Test
    void getChildren() {
        Motaz.addChild(Tarek);
        Motaz.addChild(Natal);
        assertEquals(2, Motaz.getChildren().size());
        assertEquals(Tarek, Motaz.getChildren().get(0));
        assertEquals(Natal, Motaz.getChildren().get(1));
    }

    @Test
    void getPets() {
        Pet Milo = new Pet("Milo", 3, "Dog");
        Tarek.addPet(Milo);
        assertEquals(1, Tarek.getPets().size());
        assertEquals(Milo, Tarek.getPets().get(0));
    }

    @Test
    void getPartner() {
        Tarek.setPartner(Debbie);
        assertEquals(Debbie, Tarek.getPartner());
    }

    @Test
    void setName() {
        Tarek.setName("New Tarek");
        assertEquals("New Tarek", Tarek.getName());
    }

    @Test
    void setMiddleName() {
        Debbie.setMiddleName("New Deborah");
        assertEquals("New Deborah", Debbie.getMiddleName());
    }

    @Test
    void setLastName() {
        Tarek.setLastName("New Tarho");
        assertEquals("New Tarho", Tarek.getLastName());
    }

    @Test
    void setSex() {
        Tarek.setSex("Male");
        assertEquals("Male", Tarek.getSex());
    }

    @Test
    void setAge() {
        Tarek.setAge(31);
        assertEquals(31, Tarek.getAge());
    }

    @Test
    void setMother() {
        Tarek.setMother(Randa);
        assertEquals(Randa, Tarek.getMother());
    }

    @Test
    void setFather() {
        Debbie.setFather(Aaike);
        assertEquals(Aaike, Debbie.getFather());
    }

    @Test
    void setPartner() {
        Tarek.setPartner(Debbie);
        assertEquals(Debbie, Tarek.getPartner());
    }

    @Test
    void addParents() {
        Tarek.addParents(Randa);
        Tarek.addParents(Motaz);
        assertEquals(Randa, Tarek.getMother());
        assertEquals(Motaz, Tarek.getFather());
    }

    @Test
    void addParentsDoesNotAddNull() {
        Tarek.addParents(null);
        assertNull(Tarek.getMother());
        assertNull(Tarek.getFather());
    }

    @Test
    void addSibling() {
        Debbie.addSibling(Renée);
        assertEquals(1, Debbie.getSiblings().size());
        assertEquals(Renée, Debbie.getSiblings().get(0));
    }

    @Test
    void addSiblingDoesNotAddNull() {
        Debbie.addSibling(null);
        assertEquals(0, Debbie.getSiblings().size());
    }

    @Test
    void addChild() {
        Aaike.addChild(Debbie);
        assertEquals(1, Aaike.getChildren().size());
        assertEquals(Debbie, Aaike.getChildren().get(0));
    }

    @Test
    void addChildDoesNotAddNull() {
        Aaike.addChild(null);
        assertEquals(0, Aaike.getChildren().size());
    }

    @Test
    void addPet() {
        Pet Milo = new Pet("Milo", 3, "Dog");
        Tarek.addPet(Milo);
        assertEquals(1, Tarek.getPets().size());
        assertEquals(Milo, Tarek.getPets().get(0));
    }

    @Test
    void addPetDoesNotAddNull() {
        Tarek.addPet(null);
        assertEquals(0, Tarek.getPets().size());
    }

    @Test
    void getGrandChildren() {
        Randa.addChild(Tarek);
        Randa.addChild(Natal);
        Alhaam. addChild(Randa);
        assertEquals(2, Alhaam.getGrandChildren().size());
        assertEquals(Tarek, Alhaam.getGrandChildren().get(0));
        assertEquals(Natal, Alhaam.getGrandChildren().get(1));
    }

    @Test
    void getGrandChildrenPets() {
        Pet Milo = new Pet("Milo", 3, "Dog");
        Pet Ninja = new Pet("Ninja", 15, "Cat");
        Debbie.addPet(Milo);
        Renée.addPet(Ninja);
        Jacqueline.addChild(Debbie);
        Jacqueline.addChild(Renée);
        Heleen. addChild(Jacqueline);
        assertEquals(2, Heleen.getGrandChildrenPets().size());
        assertEquals(Milo, Heleen.getGrandChildrenPets().get(0));
        assertEquals(Ninja, Heleen.getGrandChildrenPets().get(1));
    }

    @Test
    void getNieces() {
        Person Guilia = new Person("Guilia", "Schaeffer", 8, "Female");
        Debbie.addSibling(Renée);
        Renée.addChild(Guilia);
        Guilia.setMother(Renée);
        assertEquals(1, Debbie.getNieces().size());
        assertEquals(Guilia, Debbie.getNieces().get(0));
    }

    @Test
    void getNiecesDoesNotAddNephews() {
        Person Sean = new Person("Sean", "Schaeffer", 10, "Male");
        Renée.addChild(Sean);
        Sean.setMother(Renée);
        Debbie.addSibling(Renée);
        assertEquals(0, Debbie.getNieces().size());
    }

    @Test
    void getNiecesDoesNotAddNieceWhenThereAreNoChildren() {
        Debbie.addSibling(Renée);
        assertEquals(0, Debbie.getNieces().size());
    }

    @Test
    void testToString() {
        assertEquals("Tarek Tarho", Tarek.toString());
        assertEquals("Debbie Deborah Verboom", Debbie.toString());
    }
}