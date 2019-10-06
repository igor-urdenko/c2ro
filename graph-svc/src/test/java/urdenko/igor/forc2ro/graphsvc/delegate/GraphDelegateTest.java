package urdenko.igor.forc2ro.graphsvc.delegate;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import urdenko.igor.forc2ro.graphsvc.model.graph.Graph;
import urdenko.igor.forc2ro.graphsvc.service.GraphService;

import static org.mockito.Mockito.when;

//@RunWith(MockitoJUnitRunner.class)
public class GraphDelegateTest {
    @Mock
    private GraphService graphService;

    @InjectMocks
    private GraphDelegate subject;

    @Ignore
    public void generateGraphReturnsNotEmptyGraph() {
        when(graphService.generateGraph()).thenReturn(getSampleGraph());
    }

    /**  **/
    private Graph getSampleGraph() {
        Graph g = new Graph();

        g.addNode(1L, "Node1");
        g.addNode(2L, "Node2");
        g.addNode(3L, "Node3");
        g.addNode(4L, "Node4");

//        g.addEdge();

        return g;
    }
}
