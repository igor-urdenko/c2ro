package urdenko.igor.forc2ro.graphsvc.model.graph;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Implements tests for Node class.
 * @see Node
 **/
public class NodeTest {
    private Node subject;
    private long subjectId;
    private String subjectLabel;

    @Before
    public void setUp() {
        Random rnd = new Random();

        this.subjectId = rnd.nextLong();
        this.subjectLabel = "Node-" + this.subjectId;

        subject = new Node(subjectId, subjectLabel);
    }

    @Test
    public void gettersWork() {
        assertThat(subject.getId()).isEqualTo(this.subjectId);
        assertThat(subject.getLabel()).isEqualTo(this.subjectLabel);
    }

    @Test
    public void settersWork() {
        subject.setId(-990L);
        subject.setLabel("New Label");
        assertThat(subject.getId()).isNotEqualTo(this.subjectId);
        assertThat(subject.getLabel()).isNotEqualTo(this.subjectLabel);
        assertThat(subject.getId()).isEqualTo(-990L);
        assertThat(subject.getLabel()).isEqualTo("New Label");
    }

    @Test
    public void hashCodeCalculatesAsExpected() {
        assertThat(subject.hashCode()).isEqualTo(expectedHashCode());
    }

    @Test
    public void equalsWorksCorrectly() {
        Node testNode = new Node(this.subjectId, this.subjectLabel);
        Node sameNode = subject;

        assertThat(subject.equals(new Object())).isFalse();
        assertThat(subject.equals(testNode)).isTrue();
        assertThat(subject.equals(sameNode)).isTrue();
    }

    @Test
    public void toStringReturnsNodeIdInBrackets() {
        String expectedString = String.format("{%d}", this.subjectId);
        assertThat(subject.toString()).isEqualTo(expectedString);
    }

    /**
     * Calculates hash code of the node as it is implemented in the {@code Node} class.
     * If the {@code hashCode} method in the {@code Node} class will change this test is expected to fail.
     * @return hash code of the node.
     **/
    private int expectedHashCode() {
        int hash = (int)subjectId;
        for (char ch : subjectLabel.toCharArray()) {
            hash += ch;
        }
        return hash;
    }
}
