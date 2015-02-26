package main.Factory.ch10;

/**
 * Created by yangshenneng on 15/2/26.
 */
public interface SetObserver<E> {
    //Invoked when an element is added to the observable set
    void added(ObservableSet<E> set, E element);
}
