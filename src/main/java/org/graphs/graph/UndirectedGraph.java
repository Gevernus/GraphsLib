package org.graphs.graph;

/**
 * Graph with 2 ways connections
 *
 * @param <T> Vertex type
 */
public class UndirectedGraph<T> extends AbstractGraph<T> {
    @Override
    public boolean addEdge(T source, T target) {
        if (vertices.containsKey(source) && vertices.containsKey(target)) {
            boolean added = vertices.get(source).add(new SimpleEdge<>(source, target));
            if (!added) {
                return false;
            }
            return vertices.get(target).add(new SimpleEdge<>(target, source));
        }
        return false;
    }
}
