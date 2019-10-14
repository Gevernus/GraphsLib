package org.graphs.graph;

class Path<T> {
    private final int level;
    private final SimpleEdge<T> edge;

    Path(int level, SimpleEdge<T> edge) {
        this.level = level;
        this.edge = edge;
    }

    int getLevel() {
        return level;
    }

    SimpleEdge<T> getEdge() {
        return edge;
    }
}
