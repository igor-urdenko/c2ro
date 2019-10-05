package urdenko.igor.forc2ro.graphsvc.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * Defines the REST service response the ID of the created Graph object as JSON.
 **/
@Getter
@Setter
public class CreatedGraphResponse extends BaseResponse implements Serializable {
    private static final long serialVersionUID = 20191005L;

    @JsonProperty("id")
    private String id;

    /**
     * Constructs response with given graph ID.
     * @param id The ID of the created graph.
     **/
    public CreatedGraphResponse(String id) {
        super(HttpStatus.CREATED, "Successfully created graph and stored in DB with ID [" + id + "].");
        this.id = id;
    }

    /**
     * Constructs response with given parameters.
     * @param status HTTP status code of the request.
     * @param message The message.
     * @param id The ID of the created graph.
     **/
    public CreatedGraphResponse(HttpStatus status, String message, String id) {
        super(status, message);
        this.id = id;
    }
}
