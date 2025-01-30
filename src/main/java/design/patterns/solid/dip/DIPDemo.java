package design.patterns.solid.dip;

import org.javatuples.Triplet;
// A. High-level modules should not depend on low-level modules.
// Both should depend on abstractions.

// B. Abstractions should not depend on details.
// Details should depend on abstractions.

import java.util.ArrayList;
import java.util.List;

enum Relationship {
    CHILD,
    PARENT,
    SIBLING
}

class Person {
    public String name;
    // other attr occult

    public Person(String name) {
        this.name = name;
    }
}

// introduce abstraction
interface RelationshipBrowser {
    List<Person> findAllChildrenOf(String name);
}

// Low-level module
class Relationships implements RelationshipBrowser {
    // Triplet class requires javatuples
    private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();

    public List<Triplet<Person, Relationship, Person>> getRelations() {
        return relations;
    }

    public void addParentAndChild(Person parent, Person child) {
        this.relations.add(new Triplet<>(parent, Relationship.PARENT, child));
        this.relations.add(new Triplet<>(child, Relationship.CHILD, parent));
    }

    //    Now Low-level module depends on abstraction
    @Override
    public List<Person> findAllChildrenOf(String name) {
        return relations
                .stream()
                .filter(x -> x.getValue0().name.equals(name)
                        && x.getValue1() == (Relationship.PARENT))
                .map(Triplet::getValue2)
                .toList();
    }
}

// High-level module
class Research {

// Breaks the DIP here because depends on from a module low-level
//    public Research(Relationships relationships) {
//        // high-level: find all of john's children
//        List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();
//        relations
//                .stream()
//                .filter(x -> x.getValue0().name.equals("John")
//                        && x.getValue1() == (Relationship.PARENT))
//                .forEach(ch -> System.out.println("John has a child called " + ch.getValue2().name));
//    }

    //   Now depends on abstraction
    public Research(RelationshipBrowser relationships) {
        List<Person> children = relationships.findAllChildrenOf("John");

        for (Person child : children) {
            System.out.println("John has a child called " + child.name);
        }

    }
}


public class DIPDemo {
    //    To filter Relationships is the goal
//    Pre-requisites
//    1. Person
//    2. Relationships
//    3. Research(filter for relationships)
//    4. Main program to run
    public static void main(String[] args) {

        Person parent = new Person("John");
        Person child1 = new Person("Leonardo");
        Person child2 = new Person("Tiago");

        Relationships relationships = new Relationships();
        relationships.addParentAndChild(parent, child1);
        relationships.addParentAndChild(parent, child2);

        Research research = new Research(relationships);

// To fix the DIP problem(Dependency Inversion Principle) here we're going to introduce the interface RelationshipBrowser(abstraction)
// and all high-level and low-level modules  will depend on this interface(Research and Relationships classes will depend on RelationshipBrowser ).


    }


}
