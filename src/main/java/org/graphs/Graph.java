package org.graphs;

import org.graphs.graph.SimpleEdge;

import java.util.List;

/**
 * Main graph interface with custom type vertices
 */
public interface Graph<T> {

    /**
     * Adds vertex to graph if not already present.
     * @param vertex vertex to add.
     * @return <code>true</code> if vertex was added.
     */
    boolean addVertex(T vertex);

    /**
     * Creates a new edge from the source vertex to the target vertex.
     * @param source source vertex of the edge.
     * @param target target vertex of the edge.
     * @return <code>true</code> if edge was added.
     */
    boolean addEdge(T source, T target);

    /**
     * Returns a list of all edges connecting source vertex to target vertex.
     * Returns <code>null</code> if vertex not present in graph
     * Returns empty list if no path
     * @param source source vertex of the edge.
     * @param target target vertex of the edge.
     * @return a list of edges between 2 vertices
     */
    List<SimpleEdge<T>> getPath(T source, T target);
}
