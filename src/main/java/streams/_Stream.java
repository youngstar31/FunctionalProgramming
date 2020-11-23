package streams;

import imperative.Main;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Aisha", Gender.FEMALE),
                new Person("Alex", Gender.MALE),
                new Person("Alice", Gender.FEMALE)
//                new Person("Neziah", Gender.PREFER_NOT_TO_SAY)

        );

        //Map -map(person -> person.name) converts every single person into just their name
        //mapToInt(String::length) - getting the length of a person's name (how many characters)
        //Collect to a set (removing duplicates)
        //Printing all the genders

//        people.stream().map(person -> person.name).mapToInt(String::length).forEach(System.out::println);

        //        Function<Person, String> personStringFunction = person -> person.name;
//        ToIntFunction<String> length = String::length; //Takes a string returns integer
//        IntConsumer println = System.out::println; //Takes integer and prints result


        Predicate<Person> personPredicate = person -> person.gender.equals(Gender.PREFER_NOT_TO_SAY);
        boolean containsOnlyFemals = people.stream()
                .noneMatch(personPredicate);
//                .anyMatch(personPredicate); //Do we have at least one female in our list?
//        .allMatch(personPredicate);  In our list do we only have females?
        System.out.println(containsOnlyFemals);


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
        MALE, FEMALE, PREFER_NOT_TO_SAY
    }
}
