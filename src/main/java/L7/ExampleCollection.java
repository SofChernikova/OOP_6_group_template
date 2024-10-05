package L7;

import java.util.Iterator;

public class ExampleCollection<T> implements Iterator<ExamplePartCollection<T>> {

    private ExamplePartCollection<T> head;
    private ExamplePartCollection<T> tail;
    private int size;

    public void add(){
        //добавить элемент
    }

    public ExamplePartCollection<T> delete(){
        //удалить элемент
        return null;
    }

    public ExamplePartCollection<T> delete(T value){
        //удалить элемент по значению
        // использовать equals()
        return null;
    }

    public ExamplePartCollection<T> findByValue(T value){
        //найти элемент по значению
        //использовать next() и hasNext()
        return null;
    }

    public int size(){
        return size;
    }

    public ExamplePartCollection<T> getHead() {
        return head;
    }

    public ExamplePartCollection<T> getTail() {
        return tail;
    }


    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public ExamplePartCollection<T> next() {
        return null;
    }

}
