package org.graphs.graph;

import java.util.Objects;

/**
 * Main edge interface
 */
public class SimpleEdge<T> {
    private final T source;
    private final T target;

    SimpleEdge(T source, T target) {
        this.source = source;
        this.target = target;
    }

    public T getSource() {
        return source;
    }

    public T getTarget() {
        return target;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleEdge<?> edge = (SimpleEdge<?>) o;
        return Objects.equals(source, edge.source) &&
                Objects.equals(target, edge.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, target);
    }
}
