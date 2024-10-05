package L6.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.Objects;


@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Author implements Comparable<Author> {

    @Override
    public int compareTo(Author o) {
        if (this.equals(o)) {
            return 0;
        }
       return this.surname.compareTo(o.surname);
    }

    private String name;
    private String surname;
    private LocalDate birthDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Author author = (Author) o;
        return Objects.equals(name, author.name)
                && Objects.equals(surname, author.surname)
                && Objects.equals(birthDate, author.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDate);
    }

}
