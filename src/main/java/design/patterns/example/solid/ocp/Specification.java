package design.patterns.example.solid.ocp;

public interface Specification<T> {
    boolean isSatisfied(T item);
}
