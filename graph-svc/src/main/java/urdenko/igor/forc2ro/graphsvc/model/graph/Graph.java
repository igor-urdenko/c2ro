package urdenko.igor.forc2ro.graphsvc.model.graph;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import urdenko.igor.forc2ro.graphsvc.model.graph.exception.GraphException;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * The Graph data structure.
 **/
@Getter
@Setter
public class Graph implements Serializable {
    private static final long serialVersionUID = 20191005L;

    @Id
    @JsonProperty("id")
    private String graphId;

    @JsonProperty("nodes")
    private Set<Node> nodes;

    @JsonProperty("edges")
    private Set<Edge> edges;

    /** Constructs an empty graph object. **/
    public Graph() {
        this.nodes = new HashSet<>();
        this.edges = new HashSet<>();
    }

    /**
     * Adds a new node to the graph.
     * @param id The node ID.
     * @param label The node label.
     **/
    public void addNode(Long id, String label) {
        nodes.add(new Node(id, label));
    }

    /**
     * Adds a new edge between two given nodes.
     * @param from The starting node.
     * @param to The ending node.
     * @param weight The weight of the edge.
     * @param isDirected The directed edge flag.
     */
    public void addEdge(Node from, Node to, float weight, boolean isDirected) throws GraphException {
        if (from == null || to == null) {
            throw new GraphException("Cannot create an edge: empty node.");
        }
        if (!nodes.contains(from) || !nodes.contains(to)) {
            throw new GraphException("Cannot create an edge: node does not exist.");
        }
        edges.add(new Edge(from, to, weight, isDirected));
    }

    /**
     * Returns a node with given {@code nodeId} or {@code null} if node not found.
     * @param nodeId The ID of the node to find.
     * @return node with given {@code nodeId} or {@code null} if node not found.
     **/
    public Node getNode(long nodeId) {
        for (Node n : nodes) {
            if (n.getId() == nodeId) {
                return n;
            }
        }
        return null;
    }

    /**
     * Returns {@code true} if the graph contains a node with given {@code nodeId} and {@code false} otherwise.
     * @param nodeId The ID of the node to look for.
     * @return {@code true} if the graph contains a node with given {@code nodeId}; otherwise returns {@code false}.
     **/
    public boolean hasNode(long nodeId) {
        for (Node n : nodes) {
            if (n.getId() == nodeId) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns number of the nodes in the graph.
     * @return number of the nodes in the graph.
     */
    @JsonIgnore
    public int getNodesCount() {
        return nodes.size();
    }

    /**
     * Returns number of the edges in the graph.
     * @return number of the edges in the graph.
     */
    @JsonIgnore
    public int getEdgesCount() {
        return edges.size();
    }
}
