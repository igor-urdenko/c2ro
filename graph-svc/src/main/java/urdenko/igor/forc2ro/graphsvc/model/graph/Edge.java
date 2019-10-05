package urdenko.igor.forc2ro.graphsvc.model.graph;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * The Graph edge.
 **/
@Getter
@Setter
public class Edge implements Serializable {
    private static final long serialVersionUID = 20191005L;

    private float weight;

    private boolean isDirected;
    private boolean isLoop;

    private Node from;
    private Node to;

    /** Constructs an empty Edge. **/
    public Edge() {}

    /**
     * Constructs an edge between {@code from} and {@code to} nodes.
     * If the edge is NOT directed ({@code isDirected == false}), then this edge implements
     * both directions: {@code from -> to} and {@code to -> from}.
     * If {@code from} node is the same as {@code to} node that means this edge is a loop
     * and {@code isLoop} is set to {@code true}.
     * 
     * @param from The starting {@code node} of the edge.
     * @param to The ending {@code node} of the edge.
     * @param weight The weight of the edge.
     * @param isDirected If this parameter is {@code true}, then the edge has a {@code from -> to} direction.
     **/
    public Edge(Node from, Node to, float weight, boolean isDirected) {
        this.from = from;
        this.to = to;
        this.weight = weight;
        this.isDirected = isDirected;
        this.isLoop = from.equals(to);
    }

    /**
     * Constructs a not directed edge between {@code from} and {@code to} nodes.
     *
     * @param from The starting {@code node} of the edge.
     * @param to The ending {@code node} of the edge.
     * @param weight The weight of the edge.
     * @see Edge#Edge(Node, Node, float, boolean)
     **/
    public Edge(Node from, Node to, float weight) {
        this(from, to, weight, false);
    }
}
