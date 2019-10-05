package urdenko.igor.forc2ro.graphsvc.model.response;

import org.springframework.http.HttpStatus;

/**
 * Defines general response after successful operation on the received request.
 **/
public class SuccessResponse extends BaseResponse {
    /**
     * Constructs default success response with HTTP status 200 (OK) and default message.
     **/
    public SuccessResponse() {
        super(HttpStatus.OK, "Successfully processed the request.");
    }
}
