package urdenko.igor.forc2ro.graphsvc.model.graph.exception;

/**
 * Indicates the error occurred during performing an operation on graph.
 * @see urdenko.igor.forc2ro.graphsvc.model.graph.Graph
 **/
public class GraphException extends Exception {
    /** Constructs default graph exception that indicates unknown error. **/
    public GraphException() {
        super("An unknown error occurred during performing operation on graph.");
    }

    /**
     * Constructs graph exception with given {@code message}.
     * @param message The error message.
     **/
    public GraphException(String message) {
        super(message);
    }

    /**
     * Constructs graph exception with given {@code message} and {@code cause}.
     * @param message The error message.
     * @param cause The cause exception.
     **/
    public GraphException(String message, Throwable cause) {
        super(message, cause);
    }
}
