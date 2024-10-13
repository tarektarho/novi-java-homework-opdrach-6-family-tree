package nl.novi;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {
    Pet dog = new Pet("Max", 3, "Dog");

    @Test
    void getName() {
        assertEquals("Max", dog.getName());
    }

    @Test
    void getAge() {
        assertEquals(3, dog.getAge());
    }

    @Test
    void getSpecies() {
        assertEquals("Dog", dog.getSpecies());
    }

    @Test
    void getOwner() {
        Person person = new Person("Joost", "Bakker", 45, "Male");
        dog.setOwner(person);
        assertEquals(person, dog.getOwner());
    }

    @Test
    void setName() {
        dog.setName("Pukkie");
        assertEquals("Pukkie", dog.getName());
    }

    @Test
    void setAge() {
        dog.setAge(5);
        assertEquals(5, dog.getAge());
    }

    @Test
    void setSpecies() {
        dog.setSpecies("Cat");
        assertEquals("Cat", dog.getSpecies());
    }

    @Test
    void setOwner() {
        Person person = new Person("Jan", "Jansen", 45, "Male");
        dog.setOwner(person);
        assertEquals(person, dog.getOwner());
    }

    @Test
    void testToString() {
        assertEquals("Max (Dog)", dog.toString());
    }
}