package org.example.ocp;

public interface Specification<T> {
    boolean isSatisfied(T item);
}
