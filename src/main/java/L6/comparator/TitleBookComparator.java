package L6.comparator;

import L6.model.Book;

import java.util.Comparator;


/**
 * Сортировка книг по названию
 */
public class TitleBookComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }

}
