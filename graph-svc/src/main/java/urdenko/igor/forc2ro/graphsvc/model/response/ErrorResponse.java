package urdenko.igor.forc2ro.graphsvc.model.response;

import org.springframework.http.HttpStatus;

/**
 * Defines the error response after performed operation on the received request.
 **/
public class ErrorResponse extends BaseResponse {
    /**
     * Constructs the error response with given {@code status} and {@code message}.
     * @param status The HTTP status code of the response.
     * @param message The error message.
     **/
    public ErrorResponse(HttpStatus status, String message) {
        super(status, message);
    }

    /**
     * Constructs the default error response with HTTP status 500 (Internal server error) and default message.
     **/
    public ErrorResponse() {
        super(HttpStatus.INTERNAL_SERVER_ERROR, "Unknown error");
    }
}
