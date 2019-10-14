package org.graphs.graph;

import org.graphs.Graph;

import java.util.*;

/**
 * Graphs main logic class
 *
 * @param <T> Vertex type
 */
public abstract class AbstractGraph<T> implements Graph<T> {
    protected Map<T, Set<SimpleEdge<T>>> vertices = new HashMap<>();

    @Override
    public boolean addVertex(T vertex) {
        if (vertex != null) {
            Set<SimpleEdge<T>> edges = vertices.get(vertex);
            if (edges == null) {
                edges = new HashSet<>();
                vertices.put(vertex, edges);
                return true;
            }
        }
        return false;
    }

    @Override
    public abstract boolean addEdge(T source, T target);

    @Override
    public List<SimpleEdge<T>> getPath(T source, T target) {
        if (vertices.containsKey(source) && vertices.containsKey(target)) {
            List<SimpleEdge<T>> list = new ArrayList<>();
            Set<T> visited = new LinkedHashSet<>();
            Stack<Path<T>> stack = new Stack<>();
            int level = -1;
            stack.push(new Path<>(level, new SimpleEdge<>(null, source)));
            while (!stack.isEmpty()) {
                Path<T> path = stack.pop();
                if (path.getLevel() >= 0) {
                    list.add(path.getLevel(), path.getEdge());
                    level = path.getLevel();
                }
                level++;
                T vertex = path.getEdge().getTarget();
                if (!visited.contains(vertex)) {
                    visited.add(vertex);
                    for (SimpleEdge<T> vertexEdge : vertices.get(vertex)) {
                        if (vertexEdge.getTarget().equals(target)) {
                            list.add(level, vertexEdge);
                            return list.subList(0, level + 1);
                        }
                        stack.push(new Path<>(level, vertexEdge));
                    }
                }
            }
            return list.isEmpty() ? list : list.subList(0, level + 1);
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractGraph<?> that = (AbstractGraph<?>) o;
        return Objects.equals(vertices, that.vertices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertices);
    }
}
