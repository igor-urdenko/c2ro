package urdenko.igor.forc2ro.graphsvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import urdenko.igor.forc2ro.graphsvc.delegate.GraphDelegate;
import urdenko.igor.forc2ro.graphsvc.model.graph.Graph;
import urdenko.igor.forc2ro.graphsvc.model.response.BaseResponse;

@RestController
public class GraphController {
    private GraphDelegate graphDelegate;

    @RequestMapping(
            value = "graphs/random",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.GET
    )
    public ResponseEntity<BaseResponse> generateGraph() {
        BaseResponse result = graphDelegate.generateGraph();
        return new ResponseEntity<>(result, result.getStatus());
    }

    @RequestMapping(
            value = "graphs",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.POST
    )
    public ResponseEntity<BaseResponse> storeGraph(@RequestBody Graph theGraph) {
        BaseResponse result = graphDelegate.storeGraph(theGraph);
        return new ResponseEntity<>(result, result.getStatus());
    }

    @RequestMapping(
            value = "graphs/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.GET
    )
    public ResponseEntity<BaseResponse> getGraphById(@PathVariable("id") Long id) {
        BaseResponse result = graphDelegate.getGraphById(id);
        return new ResponseEntity<>(result, result.getStatus());
    }

    /* Autowired components. */

    @Autowired
    public void setGraphDelegate(GraphDelegate graphDelegate) {
        this.graphDelegate = graphDelegate;
    }
}
