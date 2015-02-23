package main.Factory.ch03;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by yangshenneng on 15/2/14.
 * inappropriate 不当
 * inheritance 遗产
 * insertions 插入
 * broken inappropriate use of inheritance
 * a bad example
 */
public class InstrumentedHashSet<E> extends HashSet<E> {
    //The number of attempted element insertions
    private int addCount = 0;

    public InstrumentedHashSet() {}

    public InstrumentedHashSet(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

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
