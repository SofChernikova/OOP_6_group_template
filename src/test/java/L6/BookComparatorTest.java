package L6;

import L6.comparator.TitleBookComparator;
import L6.model.Author;
import L6.model.Book;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static L6.util.Utils.getRandomDate;
import static L6.util.Utils.getRandomInt;
import static L6.util.Utils.getRandomString;
import static org.assertj.core.api.Assertions.assertThat;


class BookComparatorTest {

    private static final String BOOK_1_TITLE = "Book test title";
    private static final String BOOK_2_TITLE = "Book title test";
    private static final String AUTHOR_1 = "Pushkin";
    private static final String AUTHOR_2 = "Tolstoy";

    private static List<Book> sortingByTitle;
    private static List<Book> sortingByTitleAndAuthor;

    @BeforeAll
    static void setUp() {
        sortingByTitle = getSortingByTitle();
        sortingByTitleAndAuthor = getSortingByTitleAndAuthor();
    }


    @Test
    @DisplayName("Сортировка только по названию")
    void sortBookByTitle(){
        var books = new ArrayList<Book>();
        books.add(new Book()
                .setTitle(BOOK_2_TITLE)
                .setPagesCount(getRandomInt())
                .setAuthor(
                        new Author()
                                .setBirthDate(getRandomDate())
                                .setName(getRandomString())
                                .setSurname(getRandomString())
                ));

        books.add(new Book()
                .setTitle(BOOK_1_TITLE)
                .setPagesCount(getRandomInt())
                .setAuthor(
                        new Author()
                                .setBirthDate(getRandomDate())
                                .setName(getRandomString())
                                .setSurname(getRandomString())
                ));

        books.sort(new TitleBookComparator());

        for (int i = 0; i < books.size(); i++) {
            assertThat(books.get(i))
                    .usingRecursiveComparison()
                    .ignoringFields("pagesCount", "author")
                    .isEqualTo(sortingByTitle.get(i));
        }
    }

    @Test
    @DisplayName("Сортировка только по количеству страниц и автору")
    void sortBookByTitleAndAuthor(){
        var books = new ArrayList<Book>();
        books.add(new Book()
                .setTitle(BOOK_2_TITLE)
                .setPagesCount(getRandomInt())
                .setAuthor(
                        new Author()
                                .setBirthDate(getRandomDate())
                                .setName(getRandomString())
                                .setSurname(AUTHOR_2)
                ));

        books.add(new Book()
                .setTitle(BOOK_1_TITLE)
                .setPagesCount(getRandomInt())
                .setAuthor(
                        new Author()
                                .setBirthDate(getRandomDate())
                                .setName(getRandomString())
                                .setSurname(AUTHOR_1)
                ));

        books.sort(Comparator.comparing(Book::getPagesCount).thenComparing(Book::getAuthor));

        for (int i = 0; i < books.size(); i++) {
            assertThat(books.get(i))
                    .usingRecursiveComparison()
                    .ignoringFields("pagesCount", "author.name", "author.birthDate")
                    .isEqualTo(sortingByTitleAndAuthor.get(i));
        }
    }

    private static List<Book> getSortingByTitle(){
        return List.of(
                new Book()
                        .setTitle(BOOK_1_TITLE)
                        .setPagesCount(getRandomInt())
                        .setAuthor(
                                new Author()
                                        .setBirthDate(getRandomDate())
                                        .setName(getRandomString())
                                        .setSurname(getRandomString())
                        ),
                new Book()
                        .setTitle(BOOK_2_TITLE)
                        .setPagesCount(getRandomInt())
                        .setAuthor(
                                new Author()
                                        .setBirthDate(getRandomDate())
                                        .setName(getRandomString())
                                        .setSurname(getRandomString())
                        )
        );
    }

    private static List<Book> getSortingByTitleAndAuthor(){
        return List.of(
                new Book()
                        .setTitle(BOOK_1_TITLE)
                        .setPagesCount(getRandomInt())
                        .setAuthor(
                                new Author()
                                        .setBirthDate(getRandomDate())
                                        .setName(getRandomString())
                                        .setSurname(AUTHOR_1)
                        ),
                new Book()
                        .setTitle(BOOK_2_TITLE)
                        .setPagesCount(getRandomInt())
                        .setAuthor(
                                new Author()
                                        .setBirthDate(getRandomDate())
                                        .setName(getRandomString())
                                        .setSurname(AUTHOR_2)
                        )
        );
    }
}