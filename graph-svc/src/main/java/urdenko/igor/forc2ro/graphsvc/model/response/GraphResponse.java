package urdenko.igor.forc2ro.graphsvc.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import urdenko.igor.forc2ro.graphsvc.model.graph.Graph;

import java.io.Serializable;

/**
 * Defines the REST service response containing Graph object as JSON.
 **/
@Getter
@Setter
public class GraphResponse extends BaseResponse implements Serializable {
    private static final long serialVersionUID = 20191005L;

    @JsonProperty("graph")
    private Graph graph;

    /**
     * Constructs default response when there is no graph to be returned (e.g. graph with id from request was not found).
     **/
    public GraphResponse() {
        super(HttpStatus.NO_CONTENT, "No graph.");
    }
}
