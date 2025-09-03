package com.usfws.dag;

public class Vertex {
    public long id;

    public Vertex(long id) {
        this.id = id;
    }

    // Compares vertexes bases on ID
    public boolean equals(Object otherObject) {
        if (otherObject == null) {
            return false;
        }

        if (!(otherObject instanceof Vertex)) {
            return false;
        }

        Vertex otherVertex = (Vertex) otherObject;

        return this.id == otherVertex.id;
    }

    // So we can retrieve the ID easier
    public int hashCode() {
        return Long.valueOf(id).hashCode();
    }
}