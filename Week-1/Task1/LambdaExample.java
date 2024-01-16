package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class LambdaExample {

    public static void main(final String[] args) {

        final UsersRepository repository = new UsersRepository();
        final myPredicates myPredicates = new myPredicates();
        final myComparators myComparators = new myComparators();

        banner("Listing all users");
        repository.select(null, null);

        banner("Listing all active users");
        repository.select(myPredicates.activeUsers(), null);

        banner("Listing all active users - lambda");
        repository.select(user -> user.active, null);
        
        banner("Listing users with age > 5 sorted by name");
        repository.select(myPredicates.greaterThan(5), myComparators.SortByName());

        banner("Listing users with age > 5 sorted by name - lambda");
        repository.select( user -> user.age > 5, (u1, u2) -> u1.name.compareTo(u2.name) );

        banner("Listing users with age < 10 sorted by age");
        repository.select(myPredicates.smallerThan(10), myComparators.sortByAge() );

        banner("Listing users with age < 10 sorted by age - lambda");
        repository.select(user -> user.age < 10, (u1, u2)-> u1.age - u2.age);

        banner("Listing active users sorted by name");
        repository.select(myPredicates.activeUsers(), myComparators.SortByName());

        banner("Listing active users sorted by name - lambda");
        repository.select(user -> user.active, (u1, u2) -> u1.name.compareTo(u2.name));

        banner("Listing active users with age > 8 sorted by name");
        repository.select(myPredicates.activeUsersGreaterThan(8), myComparators.SortByName());

        banner("Listing active users with age > 8 sorted by name - lambda");
        repository.select(user -> user.active && user.age > 8, (u1, u2) -> u1.name.compareTo(u2.name));

    }

    private static void banner(final String m) {
        System.out.println("#### " + m + " ####");
    }
    
}

class UsersRepository {
    List<User> users;
    UsersRepository() {
        users = Arrays.asList(
            new User("Seven", 7, true),
            new User("Four", 4, false),
            new User("Eleven", 11, true),
            new User("Three", 3, true),
            new User("Nine", 9, false),
            new User("One", 1, true),
            new User("Twelve", 12, true));
    }

    void select(final Predicate<User> filter, final Comparator<User> order) {
        Stream<User> usersStream = users.stream();

        if (filter != null) {
            usersStream = usersStream.filter(filter);
        }
        if (order != null) {
            usersStream = usersStream.sorted(order);
        }
        usersStream.forEach(System.out::println);
    }
}

class User {
    String name;
    int age;
    boolean active;

    User(final String name, final int age, boolean active) {
        this.name = name;
        this.age = age;
        this.active = active;
    }

    @Override
    public String toString() {
        return name + "\t| " + age;
    }
}

class myPredicates {
    myPredicates(){}
    public Predicate<User> activeUsers(){
        Predicate<User> activeUserPredicate = new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.active;
            }
        };
        return activeUserPredicate;
    }
    public Predicate<User> activeUsersGreaterThan(int age){
        Predicate ActiveAgePredicate = new Predicate<User>() {
            @Override
            public boolean test(User user) {

                return user.active && user.age > age;
            }
        };
        return ActiveAgePredicate;
    }
    public Predicate<User> greaterThan(int age){
        Predicate agePredicate = new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.age > age;
            }
        };
        return agePredicate;
    }
    public Predicate<User> smallerThan(int age){
        Predicate agePredicate = new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.age < age;
            }
        };
        return agePredicate;
    }
}

class myComparators{
    myComparators(){};
    public Comparator<User> SortByName() {
        Comparator<User> sort = new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.name.compareTo(u2.name);
            }
        };
        return sort;
    }
    public Comparator<User> sortByAge(){
        Comparator<User> sort = new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.age - u2.age;
            }
        };
        return sort;
    }

}
