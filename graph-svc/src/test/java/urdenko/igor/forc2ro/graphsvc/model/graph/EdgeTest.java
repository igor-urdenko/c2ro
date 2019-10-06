package urdenko.igor.forc2ro.graphsvc.model.graph;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EdgeTest {
    @Test
    public void defaultConstructorDoesNotAssignsValues() {
        Edge subject = new Edge();

        assertThat(subject.getFrom()).isNull();
        assertThat(subject.getTo()).isNull();
        assertThat(subject.isDirected()).isFalse();
        assertThat(subject.isLoop()).isFalse();
        assertThat(subject.getWeight()).isEqualTo(0.0F);
    }

    @Test
    public void notDirectedConstructorCheck() {
        Node from = new Node(1L, "Node-From");
        Node to = new Node(2L, "Node-To");
        float weight = 1.7F;
        Edge subject = new Edge(from, to, weight);

        assertThat(subject.getFrom()).isNotNull();
        assertThat(subject.getFrom().equals(from)).isTrue();
        assertThat(subject.getTo()).isNotNull();
        assertThat(subject.getTo().equals(to)).isTrue();
        assertThat(subject.isDirected()).isFalse();
        assertThat(subject.isLoop()).isFalse();
        assertThat(subject.getWeight()).isEqualTo(weight);
    }

    @Test
    public void directedConstructorCheck() {
        Node from = new Node(1L, "Node-From");
        Node to = new Node(2L, "Node-To");
        float weight = 1.7F;
        boolean isDirected = true;

        Edge subject = new Edge(from, to, weight, isDirected);

        assertThat(subject.getFrom()).isNotNull();
        assertThat(subject.getFrom().equals(from)).isTrue();
        assertThat(subject.getTo()).isNotNull();
        assertThat(subject.getTo().equals(to)).isTrue();
        assertThat(subject.isDirected()).isTrue();
        assertThat(subject.isLoop()).isFalse();
        assertThat(subject.getWeight()).isEqualTo(weight);
    }

    @Test
    public void loopIsDetectedAfterConstruction() {
        Node from = new Node(1L, "Node-1");
        Node to = new Node(1L, "Node-1");
        float weight = 1.7F;

        Edge subject = new Edge(from, to, weight);

        assertThat(subject.getFrom()).isNotNull();
        assertThat(subject.getFrom().equals(from)).isTrue();
        assertThat(subject.getTo()).isNotNull();
        assertThat(subject.getTo().equals(to)).isTrue();
        assertThat(subject.isDirected()).isFalse();
        assertThat(subject.isLoop()).isTrue();
        assertThat(subject.getWeight()).isEqualTo(weight);
    }

    @Test
    public void settersAndGettersWork() {
        Node from = new Node(1L, "Node-From");
        Node to = new Node(2L, "Node-To");
        float weight = 1.7F;

        Edge subject = new Edge();

        subject.setFrom(from);
        subject.setTo(to);
        subject.setWeight(weight);
        subject.setDirected(true);
        subject.setLoop(true);

        assertThat(subject.getFrom()).isNotNull();
        assertThat(subject.getFrom().equals(from)).isTrue();
        assertThat(subject.getTo()).isNotNull();
        assertThat(subject.getTo().equals(to)).isTrue();
        assertThat(subject.isDirected()).isTrue();
        assertThat(subject.isLoop()).isTrue();
        assertThat(subject.getWeight()).isEqualTo(weight);
    }
}
