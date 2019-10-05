package urdenko.igor.forc2ro.graphsvc.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import urdenko.igor.forc2ro.graphsvc.model.graph.Graph;
import urdenko.igor.forc2ro.graphsvc.model.response.BaseResponse;
import urdenko.igor.forc2ro.graphsvc.model.response.GraphResponse;
import urdenko.igor.forc2ro.graphsvc.service.GraphService;

/**
 *
 **/
@Component
public class GraphDelegate {
    private GraphService graphService;

    /**  **/
    public BaseResponse generateGraph() {
        GraphResponse response = new GraphResponse();
        Graph g = graphService.generateGraph();

        response.setGraph(g);
        response.setStatus(HttpStatus.OK);
        response.setMessage(String.format("Successfully generated a graph with %d nodes and %d edges.", g.getNodesCount(), g.getEdgesCount()));

        return response;
    }

    /**  **/
    public BaseResponse storeGraph(Graph theGraph) {
        return null;
    }

    /**  **/
    public BaseResponse getGraphById(Long id) {
        return null;
    }

    /* Autowired components. */

    @Autowired
    public void setGraphService(GraphService graphService) {
        this.graphService = graphService;
    }
}
