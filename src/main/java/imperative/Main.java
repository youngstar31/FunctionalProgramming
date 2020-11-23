package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Aisha", Gender.FEMALE),
                new Person("Alex", Gender.MALE),
                new Person("Alice", Gender.FEMALE)

        );
        //Declarative programming is when you say what you want
        System.out.println("//IMPERATIVE APPROACH");

        List<Person> females = new ArrayList<Person>();

        for (Person person : people) {
          if (Gender.FEMALE == (person.gender)) {
              females.add(person);
          }
        }

        for (Person female : females) {
            System.out.println(female);

        }

        //Imperative language is when you say how to get what you want.
        System.out.println("// DECLARATIVE APPROACH");
        Predicate<Person> personPredicate = person -> (Gender.FEMALE == (person.gender));

        List<Person> females2 = people.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());
        females2.forEach(System.out::println);

    }
    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }


    enum Gender {
        MALE, FEMALE
    }
}
