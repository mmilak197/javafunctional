package streams;

import imperative.Main;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static streams._Stream.Gender.*;


public class _Stream {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE),
                new Person("Mateusz", MALE)

        );

        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);
        // in this case we check if gender all people is FEMALE
        boolean containsOnlyFemals = people.stream()
                .allMatch(personPredicate);

        System.out.println(containsOnlyFemals);

        // in this case we check if is one or more person which gender is FEMALE
        boolean containsOneOrMoreFemals = people.stream()
                .anyMatch(personPredicate);

        System.out.println(containsOneOrMoreFemals);

        Predicate<Person> personPredicateV2 = person -> PREFER_NOT_TO_SAY.equals(person.gender);

        // in this case we check if anybody has PREFER_NOT_TO_SAY gender
        boolean containsNonePerferNotToSay = people.stream()
                .noneMatch(personPredicateV2);

        System.out.println(containsNonePerferNotToSay);


        // in tihs case we get people who have name shorter or equal 5 chars
        // in shortcut we get people which match to Predicate
        System.out.println("People which name is shorter or equal 5 chars");
        List<Person> peopleWhichNameIsShorterOrEqual5Chars = people.stream()
                .takeWhile(person -> person.name.length() <= 5)
                .collect(Collectors.toList());

        peopleWhichNameIsShorterOrEqual5Chars.stream()
                .forEach(System.out::println);

        // in this case we get people who have name longer then 6 chars
        // in shortcut we get people which doesn't match to Predicate
        // this method is opposite to takeWhile()
        // another examples https://www.geeksforgeeks.org/stream-dropwhile-method-in-java-with-examples/
        System.out.println("People which name is  longer than 5 chars");
        List<Person> peopleWhichNameIsLongerThan5Chars = people.stream()
                .dropWhile(person -> person.name.length() <= 5)
                .collect(Collectors.toList());

        peopleWhichNameIsLongerThan5Chars.stream()
                .forEach(System.out::println);


        List<Integer> numbers = List.of(4, 6, 8, 4, 3, 5, 9);

        // in this case we use peek(). This functional interface take Consumer the same as forEach()
        // so use peek() and forEach() we can print all number
        // but is big diffrence between peek() and forEach()
        // forEach() is terminate method which means after use stream is closed
        // however peek() is not terminate method so we can use it to print number before filter
        // https://programuj.pl/blog/java8-strumienie-cz3-peek-map-collect
        numbers.stream()
                .peek(it -> System.out.println("Before filter " + it))
                .filter(number -> number > 4)
                .forEach(n -> System.out.println("After filter " + n));


        // forEachOrder make the same what forEach but
        // if we use paraller streams forEachOrder process data from stream according order in stream
        // but forEach in this case doesn't guarantee so order can be another then original
        // https://howtodoinjava.com/java8/java-stream-foreachordered/
        people.stream()
                .forEachOrdered(System.out::println);

    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
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
