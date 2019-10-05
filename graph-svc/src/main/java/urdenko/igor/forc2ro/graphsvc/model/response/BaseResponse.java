package urdenko.igor.forc2ro.graphsvc.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * Defines the base elements of the REST service response after performed operation on the received request.
 * The {@code status} defines the HTTP status of the performed operation.
 * The {@code message} defines the informational message of the response.
 **/
@Getter
@Setter
@AllArgsConstructor
public abstract class BaseResponse implements Serializable {
    private static final long serialVersionUID = 20191005L;

    @JsonProperty("status")
    protected HttpStatus status;

    @JsonProperty("message")
    protected String message;
}
