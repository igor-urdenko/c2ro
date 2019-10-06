package urdenko.igor.forc2ro.graphsvc.model.graph;

import org.junit.Test;
import urdenko.igor.forc2ro.graphsvc.model.graph.exception.GraphException;

import static org.assertj.core.api.Assertions.assertThat;

public class GraphTest {
    @Test
    public void oneTestToTestThemAll() {
        Graph subject = new Graph();

        assertThat(subject.getGraphId()).isNull();
        assertThat(subject.getNodesCount()).isEqualTo(0);
        assertThat(subject.getEdgesCount()).isEqualTo(0);
        assertThat(subject.getNode(1L)).isNull();
        assertThat(subject.hasNode(1L)).isFalse();

        subject.addNode(1L, "Label1");
        subject.addNode(2L, "Label2");
        subject.addNode(3L, "Label3");
        subject.addNode(4L, "Label4");

        assertThat(subject.getNodesCount()).isEqualTo(4);
        assertThat(subject.hasNode(1L)).isTrue();
        assertThat(subject.hasNode(2L)).isTrue();
        assertThat(subject.hasNode(3L)).isTrue();
        assertThat(subject.hasNode(4L)).isTrue();

        assertThat(subject.getNode(1L)).isNotNull();
        assertThat(subject.getNode(2L)).isNotNull();
        assertThat(subject.getNode(3L)).isNotNull();
        assertThat(subject.getNode(4L)).isNotNull();
    }
}
