package org.graphs.graph;

/**
 * Simple one way connections graph
 *
 * @param <T> Vertex type
 */
public class DirectedGraph<T> extends AbstractGraph<T> {
    @Override
    public boolean addEdge(T source, T target) {
        if (vertices.containsKey(source) && vertices.containsKey(target)) {
            return vertices.get(source).add(new SimpleEdge<>(source, target));
        }
        return false;
    }
}
