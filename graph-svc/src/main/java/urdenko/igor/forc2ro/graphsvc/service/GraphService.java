package urdenko.igor.forc2ro.graphsvc.service;

import urdenko.igor.forc2ro.graphsvc.model.graph.Graph;

/** Graph service methods declaration. **/
public interface GraphService {
    /** Generates graph with random number of nodes and edges. **/
    Graph generateGraph();

    /**
     * Generates graph with given number of nodes and edges.
     * @param howManyNodes The number of nodes to generate.
     * @param howManyEdges The number of Edges to generate.
     **/
    Graph generateGraph(int howManyNodes, int howManyEdges);

    /**
     * Stores the given graph into database.
     * If the graph was successfully stored in the DB the method returns graph ID; otherwise returns {@code null}.
     * @param theGraph The graph object to store in the DB.
     * @return stored graph {@code id} or {@code null} in case of any error.
     * TODO: Define possible checked exceptions to throw.
     **/
    String storeGraph(Graph theGraph);

    /**
     * Finds graph with given {@code id} in the database.
     * @param id The ID of the graph to find in the DB.
     * @return The graph object if it was found or {@code null}.
     * TODO: Define possible checked exceptions to throw.
     **/
    Graph getGraphById(String id);
}
