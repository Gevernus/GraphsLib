package org.graphs;

/**
 * Main edge interface
 * @param <T> Vertex type
 */
public interface Edge<T> {
    /**
     * Retrieves the source of this edge.
     *
     * @return source of this edge
     */
    T getSource();

    /**
     * Retrieves the target of this edge.
     *
     * @return target of this edge
     */
    T getTarget();
}
