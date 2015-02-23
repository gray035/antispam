package main.Factory.ch03;

import java.util.Collection;
import java.util.Set;

/**
 * Created by yangshenneng on 15/2/14.
 */
public class RightInstrumentedHashSet<E> extends ForwardingSet<E> {
    //The number of attempted element insertions
    private int addCount = 0;

    public RightInstrumentedHashSet(Set<E> set) {super(set);}

    @Override
    public boolean add(E e) {
        addCount ++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        addCount += collection.size();
        return super.addAll(collection);
    }

    public int getAddCount() {
        return addCount;
    }
}
