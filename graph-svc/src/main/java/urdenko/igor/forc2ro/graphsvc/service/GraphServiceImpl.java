package urdenko.igor.forc2ro.graphsvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urdenko.igor.forc2ro.graphsvc.db.GraphRepository;
import urdenko.igor.forc2ro.graphsvc.model.graph.Graph;
import urdenko.igor.forc2ro.graphsvc.model.graph.Node;
import urdenko.igor.forc2ro.graphsvc.model.graph.exception.GraphException;

import java.util.Random;
import java.util.UUID;

@Service
public class GraphServiceImpl implements GraphService {
    private GraphRepository graphRepository;

    /** @see GraphService#generateGraph()  **/
    @Override
    public Graph generateGraph() {
        Random rnd = new Random();
        int minNodes = 5, maxNodes = 20;
        int minEdges = 10, maxEdges = 40;
        int nodesCount = rnd.nextInt(maxNodes - minNodes + 1) + minNodes;
        int edgesCount = rnd.nextInt(maxEdges - minEdges + 1) + minEdges;

        return generateGraph(nodesCount, edgesCount);
    }

    /** @see GraphService#generateGraph(int, int)   **/
    @Override
    public Graph generateGraph(int howManyNodes, int howManyEdges) {
        float minWeight = 1.0F;
        float maxWeight = 5.0F;
        Graph theGraph = new Graph();

        Random rnd = new Random();

        for (int i = 0; i < howManyNodes; ++i) {
            String label = "Node-" + (i + 1);
            theGraph.addNode((long)(i + 1), label);
        }

        for (int i = 0; i < howManyEdges; ++i) {
            long randomFrom = rnd.nextInt(howManyNodes) + 1;
            long randomTo = rnd.nextInt(howManyNodes) + 1;
            Node from = theGraph.getNode(randomFrom);
            Node to = theGraph.getNode(randomTo);
            float weight = rnd.nextFloat() * (maxWeight - minWeight) + minWeight;

            try {
                theGraph.addEdge(from, to, weight, false);
            } catch (GraphException ex) {
                /* Do nothing, just skip. */
            }
        }
        return theGraph;
    }

    /** @see GraphService#storeGraph(Graph)   **/
    @Override
    public String storeGraph(Graph theGraph) {
        String generatedId = UUID.randomUUID().toString();

        theGraph.setGraphId(generatedId);

        Graph insertedGraph = graphRepository.insert(theGraph);
        return insertedGraph.getGraphId();
    }

    /** @see GraphService#getGraphById(String) **/
    @Override
    public Graph getGraphById(String id) {
        return graphRepository.findById(id).orElse(null);
    }

    /* Autowired components. */

    @Autowired
    public void setGraphRepository(GraphRepository graphRepository) {
        this.graphRepository = graphRepository;
    }
}
