package org.graphs;

import org.graphs.graph.DirectedGraph;
import org.graphs.graph.SimpleEdge;
import org.graphs.graph.UndirectedGraph;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TestSuite {
    private String v1 = "v1";
    private String v2 = "v2";
    private String v3 = "v3";
    private String v4 = "v4";

    /**
     * Tests equals/hashCode methods for directed graphs.
     */
    @Test
    public void testDirectedGraph() {
        DirectedGraph<String> graph = new DirectedGraph<>();
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addEdge(v1, v2);
        graph.addEdge(v2, v3);
        graph.addEdge(v3, v1);

        DirectedGraph<String> graph2 = new DirectedGraph<>();
        graph2.addVertex(v4);
        graph2.addVertex(v3);
        graph2.addVertex(v2);
        graph2.addVertex(v1);
        graph2.addEdge(v3, v1);
        graph2.addEdge(v2, v3);
        graph2.addEdge(v1, v2);

        DirectedGraph<String> graph3 = new DirectedGraph<>();
        graph3.addVertex(v4);
        graph3.addVertex(v3);
        graph3.addVertex(v2);
        graph3.addVertex(v1);
        graph3.addEdge(v3, v1);
        graph3.addEdge(v2, v3);

        assertEquals(graph2, graph);
        assertNotEquals(graph3, graph2);

        assertEquals(graph2.hashCode(), graph.hashCode());
    }

    /**
     * Tests equals/hashCode methods for undirected graphs.
     */
    @Test
    public void testUndirectedGraph() {
        UndirectedGraph<String> graph = new UndirectedGraph<>();
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addEdge(v1, v2);
        graph.addEdge(v2, v3);
        graph.addEdge(v3, v1);

        UndirectedGraph<String> graph2 = new UndirectedGraph<>();
        graph2.addVertex(v4);
        graph2.addVertex(v3);
        graph2.addVertex(v2);
        graph2.addVertex(v1);
        graph2.addEdge(v1, v3);
        graph2.addEdge(v2, v3);
        graph2.addEdge(v1, v2);

        UndirectedGraph<String> graph3 = new UndirectedGraph<>();
        graph3.addVertex(v4);
        graph3.addVertex(v3);
        graph3.addVertex(v2);
        graph3.addVertex(v1);
        graph3.addEdge(v3, v1);
        graph3.addEdge(v2, v3);
        graph2.addEdge(v2, v1);

        assertEquals(graph2, graph);
        assertNotEquals(graph3, graph2);

        assertEquals(graph2.hashCode(), graph.hashCode());
    }

    /**
     * Tests addVertex/addEdge methods for undirected graphs
     */
    @Test
    public void testAddVertexAndEdgesUndirected() {
        UndirectedGraph<String> graph = new UndirectedGraph<>();
        assertTrue(graph.addVertex(v1));
        assertTrue(graph.addVertex(v2));
        assertTrue(graph.addVertex(v3));
        assertFalse(graph.addVertex(v3));
        assertFalse(graph.addVertex(null));

        assertTrue(graph.addEdge(v1, v2));
        assertTrue(graph.addEdge(v2, v3));
        assertFalse(graph.addEdge(v1, v2));
        assertFalse(graph.addEdge(v2, v1));
        assertFalse(graph.addEdge(v1, v4));
        assertFalse(graph.addEdge(v4, v2));
    }

    /**
     * Tests addVertex/addEdge methods for directed graphs
     */
    @Test
    public void testAddVertexAndEdgesDirected() {
        DirectedGraph<String> graph = new DirectedGraph<>();
        assertTrue(graph.addVertex(v1));
        assertTrue(graph.addVertex(v2));
        assertTrue(graph.addVertex(v3));
        assertFalse(graph.addVertex(v3));
        assertFalse(graph.addVertex(null));

        assertTrue(graph.addEdge(v1, v2));
        assertTrue(graph.addEdge(v2, v3));
        assertFalse(graph.addEdge(v1, v2));
        assertTrue(graph.addEdge(v2, v1));
        assertFalse(graph.addEdge(v1, v4));
        assertFalse(graph.addEdge(v4, v2));
    }

    /**
     * Tests getPath method for undirected graphs
     */
    @Test
    public void testPathUndirected() {
        UndirectedGraph<String> graph = new UndirectedGraph<>();
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addEdge(v1, v2);
        graph.addEdge(v1, v3);
        graph.addEdge(v2, v3);
        graph.addEdge(v3, v4);

        Object[] path = graph.getPath(v1, v4).stream().map(SimpleEdge::getTarget).toArray();
        assertTrue(Arrays.equals(path, new String[]{v2, v3, v4}) || Arrays.equals(path, new String[]{v3, v4}));

        path = graph.getPath(v4, v1).stream().map(SimpleEdge::getTarget).toArray();
        assertTrue(Arrays.equals(path, new String[]{v3, v2, v1}) || Arrays.equals(path, new String[]{v3, v1}));
    }

    /**
     * Tests getPath method for directed graphs
     */
    @Test
    public void testPathDirected() {
        DirectedGraph<String> graph = new DirectedGraph<>();
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addEdge(v1, v2);
        graph.addEdge(v1, v3);
        graph.addEdge(v2, v3);
        graph.addEdge(v3, v4);

        Object[] path = graph.getPath(v1, v4).stream().map(SimpleEdge::getTarget).toArray();
        assertTrue(Arrays.equals(path, new String[]{v2, v3, v4}) || Arrays.equals(path, new String[]{v3, v4}));

        path = graph.getPath(v4, v1).stream().map(SimpleEdge::getTarget).toArray();
        assertArrayEquals(path, new String[]{});
    }
}
