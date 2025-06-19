package cc.rcbb.design.partterns.decorator.example3;

import java.util.*;

/**
 * <p>
 * HistorySet
 * </p>
 *
 * @author rcbb.cc
 * @date 2025/6/18
 */
public class HistorySet<E> implements Set<E> {

    List<E> removeList = new ArrayList<>();
    Set<E> set = new HashSet<>();

    @Override
    public int size() {
        return set.size();
    }

    @Override
    public boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return set.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return set.iterator();
    }

    @Override
    public Object[] toArray() {
        return set.toArray(new Object[0]);
    }

    @Override
    public <E> E[] toArray(E[] e) {
        return set.toArray(e);
    }

    @Override
    public boolean add(E e) {
        return set.add(e);
    }

    @Override
    public boolean remove(Object o) {
        if (set.remove(o)) {
            removeList.add((E) o);
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return set.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return set.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return set.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public String toString() {
        return set.toString() + ", remove list :" + removeList.toString();
    }
}
