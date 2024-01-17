package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample {

    public static void main(final String[] args) {

        List<Author> authors = Library.getAuthors();
        
        banner("Authors information");
        Consumer<Author> authorPrintConsumer = new Consumer<Author>() {
            @Override
            public void accept(Author author) {
                System.out.println(author);
            }
        };
        authors
            .stream()
            .forEach(authorPrintConsumer);

        banner("Authors information - lambda");
        authors
            .stream()
            .forEach(System.out::println);

        banner("Active authors");
        Predicate activeAuthors = new Predicate<Author>() {
            @Override
            public boolean test(Author a) {
                return a.active;
            }
        };
        authors.stream().filter(activeAuthors).forEach(authorPrintConsumer);

        banner("Active authors - lambda");
        authors.stream().filter(author -> author.active).forEach(System.out::println);

        banner("Active books for all authors");
        Predicate activeBook = new Predicate<Book>() {
            @Override
            public boolean test(Book b) {
                return b.published;
            }
        };
        Consumer bookConsumer = new Consumer<Book>() {
            @Override
            public void accept(Book b) {
                System.out.println(b);
            }
        };
        Function<Author, Stream<Book>> booksStream = new Function<Author, Stream<Book>>() {
            @Override
            public Stream<Book> apply(Author author) {
                return author.books.stream();
            }
        };
        authors.stream()
                .flatMap(booksStream)
                .filter(activeBook)
                .forEach(bookConsumer);

        banner("Active books for all authors - lambda");
        authors.stream()
                .flatMap(author -> author.books.stream())
                .filter(book -> book.published).
                forEach(System.out::println);


        banner("Average price for all books in the library");
        Function<Book, Integer> bookPrice = new Function<Book, Integer>() {
            @Override
            public Integer apply(Book book) {
                return book.price;
            }
        };
        List<Integer> priceList = authors.stream()
                .flatMap(booksStream)
                .map(bookPrice)
                .collect(Collectors.toList());
        calcAvg(priceList);

        banner("Average price for all books in the library - lambda");
        List<Integer> priceList2 = authors.stream()
                .flatMap(author -> author.books.stream())
                .map(book -> book.price)
                .collect(Collectors.toList());
        calcAvg(priceList2);

        banner("Active authors that have at least one published book");
        Predicate<Author> activeUser = new Predicate<Author>() {
            @Override
            public boolean test(Author author) {
                return author.active;
            }
        };
        Predicate<Author> hasPublishedBooks = new Predicate<Author>() {
            @Override
            public boolean test(Author author) {
                return author.books.stream().anyMatch(book -> book.published);
            }
        };
        authors.stream()
                .filter( activeUser )
                .filter(hasPublishedBooks)
                .forEach(System.out::println);

        banner("Active authors that have at least one published book - lambda");
        authors.stream()
                .filter( author -> author.active )
                .filter(author -> author.books.stream().anyMatch(book -> book.published))
                .forEach(System.out::println);

    }

    private static void calcAvg(List<Integer> priceList) {
        int n = priceList.size();
        double sum = priceList.stream().reduce(0, (a, b) -> a+b);
        double average = sum / n;
        System.out.println("Average price for all books : " + average + "$");
    }

    private static void banner(final String m) {
        System.out.println("#### " + m + " ####");
    }
}


class Library {
    public static List<Author> getAuthors() {
        return Arrays.asList(
            new Author("Author A", true, Arrays.asList(
                new Book("A1", 100, true),
                new Book("A2", 200, true),
                new Book("A3", 220, true))),
            new Author("Author B", true, Arrays.asList(
                new Book("B1", 80, true),
                new Book("B2", 80, false),
                new Book("B3", 190, true),
                new Book("B4", 210, true))),
            new Author("Author C", true, Arrays.asList(
                new Book("C1", 110, true),
                new Book("C2", 120, false),
                new Book("C3", 130, true))),
            new Author("Author D", false, Arrays.asList(
                new Book("D1", 200, true),
                new Book("D2", 300, false))),
            new Author("Author X", true, Collections.emptyList()));
    }
}

class Author {
    String name;
    boolean active;
    List<Book> books;

    Author(String name, boolean active, List<Book> books) {
        this.name = name;
        this.active = active;
        this.books = books;
    }

    @Override
    public String toString() {
        return name + "\t| " + (active ? "Active" : "Inactive");
    }
}

class Book {
    String name;
    int price;
    boolean published;

    Book(String name, int price, boolean published) {
        this.name = name;
        this.price = price;
        this.published = published;
    }

    @Override
    public String toString() {
        return name + "\t| " + "\t| $" + price + "\t| " + (published ? "Published" : "Unpublished");
    }
}
