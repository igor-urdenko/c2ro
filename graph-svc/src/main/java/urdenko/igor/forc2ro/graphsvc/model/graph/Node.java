package urdenko.igor.forc2ro.graphsvc.model.graph;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Implements a node of the graph.
 * Each node contains an {@code id} and a {@code label}.
 **/
@Getter
@Setter
@AllArgsConstructor
public class Node implements Serializable {
    private static final long serialVersionUID = 20191005L;

    private long id;
    private String label;

    /**
     * Returns a hash code value for the instance.
     * @return a hash code value for the instance.
     * @see Object#hashCode()
     **/
    @Override
    public int hashCode() {
        int hash = (int)id;
        for (char ch : label.toCharArray()) {
            hash += ch;
        }
        return hash;
    }

    /**
     * Verifies if the given {@code obj} is equal to this one.
     * @param obj The object co compare with.
     * @return {@code true} if the given {@code obj} is the same as this object; otherwise returns {@code false}.
     * @see Object#equals(Object)
     **/
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Node)) {
            return false;
        }
        if (this == obj) {
            return true;
        }

        Node node = (Node)obj;
        return (this.id == node.getId() && this.label.equals(node.getLabel()));
    }

    /**
     * Returns a string representation of the instance.
     * @return a string representation of the instance.
     * @see Object#toString()
     **/
    @Override
    public String toString() {
        return String.format("{%d}", id);
    }
}
