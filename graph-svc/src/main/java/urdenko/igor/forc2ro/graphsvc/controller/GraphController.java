package urdenko.igor.forc2ro.graphsvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import urdenko.igor.forc2ro.graphsvc.delegate.GraphDelegate;
import urdenko.igor.forc2ro.graphsvc.model.graph.Graph;
import urdenko.igor.forc2ro.graphsvc.model.response.BaseResponse;

@RestController
public class GraphController {
    private GraphDelegate graphDelegate;

    /**
     * REST end point for generating a graph with random number of nodes and edges.
     * @return response containing generated graph with HTTP status code and message.
     **/
    @RequestMapping(
            value = "/graphs/random",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.GET
    )
    public ResponseEntity<BaseResponse> generateGraph() {
        BaseResponse result = graphDelegate.generateGraph();
        return new ResponseEntity<>(result, result.getStatus());
    }

    /**
     * REST end point for generating a graph with given number of nodes and edges.
     * @param howManyNodes The number of nodes to generate.
     * @param howManyEdges The number of edges to generate.
     * @return response containing generated graph with HTTP status code and message.
     **/
    @RequestMapping(
            value = "/graphs/random/{nodes}/{edges}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.GET
    )
    public ResponseEntity<BaseResponse> generateGraph(
            @PathVariable("nodes")int howManyNodes,
            @PathVariable("edges")int howManyEdges) {
        BaseResponse result = graphDelegate.generateGraph(howManyNodes, howManyEdges);
        return new ResponseEntity<>(result, result.getStatus());
    }

    /**
     * REST end point for storing given graph in DB.
     * @param theGraph The graph to store.
     * @return response with stored graph ID with HTTP status code and message.
     **/
    @RequestMapping(
            value = "/graphs",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.POST
    )
    public ResponseEntity<BaseResponse> storeGraph(@RequestBody Graph theGraph) {
        BaseResponse result = graphDelegate.storeGraph(theGraph);
        return new ResponseEntity<>(result, result.getStatus());
    }

    /**
     * REST end point for retrieving graph with given ID from DB.
     * @param id The ID of the graph to retrieve from the DB.
     * @return response with Retrieved graph with HTTP status code and message.
     **/
    @RequestMapping(
            value = "/graphs/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.GET
    )
    public ResponseEntity<BaseResponse> getGraphById(@PathVariable("id") String id) {
        BaseResponse result = graphDelegate.getGraphById(id);
        return new ResponseEntity<>(result, result.getStatus());
    }

    /* Autowired components. */

    @Autowired
    public void setGraphDelegate(GraphDelegate graphDelegate) {
        this.graphDelegate = graphDelegate;
    }
}
