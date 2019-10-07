package urdenko.igor.forc2ro.graphsvc.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import urdenko.igor.forc2ro.graphsvc.model.graph.Graph;
import urdenko.igor.forc2ro.graphsvc.model.response.BaseResponse;
import urdenko.igor.forc2ro.graphsvc.model.response.CreatedGraphResponse;
import urdenko.igor.forc2ro.graphsvc.model.response.GraphResponse;
import urdenko.igor.forc2ro.graphsvc.service.GraphService;

/**
 * Delegates requests from {@code GraphController} to {@code GraphService}.
 **/
@Component
public class GraphDelegate {
    private GraphService graphService;

    /**
     * Returns generated graph with random number of nodes and edges.
     * @return generated graph with random number of nodes and edges.
     **/
    public BaseResponse generateGraph() {
        GraphResponse response = new GraphResponse();
        Graph g = graphService.generateGraph();

        response.setGraph(g);
        response.setStatus(HttpStatus.OK);
        response.setMessage(String.format("Successfully generated a graph with %d nodes and %d edges.", g.getNodesCount(), g.getEdgesCount()));

        return response;
    }

    /**
     * Returns generated graph with given number of nodes and edges.
     * @param howManyNodes The number of nodes to generate.
     * @param howManyEdges The number of edges to generate.
     * @return generated graph with given number of nodes and edges.
     **/
    public BaseResponse generateGraph(int howManyNodes, int howManyEdges) {
        GraphResponse response = new GraphResponse();
        Graph g = graphService.generateGraph(howManyNodes, howManyEdges);

        response.setGraph(g);
        response.setStatus(HttpStatus.OK);
        response.setMessage(String.format("Successfully generated a graph with %d nodes and %d edges.", howManyNodes, howManyEdges));

        return response;
    }

    /**
     * Stores given graph in the database.
     * @param theGraph The graph object to store.
     * @return response with stored graph ID.
     **/
    public BaseResponse storeGraph(Graph theGraph) {
        return new CreatedGraphResponse(graphService.storeGraph(theGraph));
    }

    /**
     * Retrieves graph from database by the given ID.
     * @param id The ID of he graph to retrieve.
     * @return response with the graph given ID from database, HTTP status and message.
     **/
    public BaseResponse getGraphById(String id) {
        GraphResponse response = new GraphResponse();
        Graph g = graphService.getGraphById(id);

        if (g != null) {
            response.setGraph(g);
            response.setStatus(HttpStatus.OK);
            response.setMessage("Successfully retrieved graph by ID.");
        } else {
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setMessage("Graph not found.");
        }
        return response;
    }

    /* Autowired components. */

    @Autowired
    public void setGraphService(GraphService graphService) {
        this.graphService = graphService;
    }
}
