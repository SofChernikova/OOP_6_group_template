package L7;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;


@Getter
@Setter
public class ExamplePartCollection<T> {
    private ExamplePartCollection<T> previous;
    private ExamplePartCollection<T> next;
    private  T value;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExamplePartCollection<T> that = (ExamplePartCollection<T>) o;
        return Objects.equals(value, that.value);
    }

}
