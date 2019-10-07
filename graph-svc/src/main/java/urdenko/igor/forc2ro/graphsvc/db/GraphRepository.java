package urdenko.igor.forc2ro.graphsvc.db;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import urdenko.igor.forc2ro.graphsvc.model.graph.Graph;

/** Repository for the database operations. **/
@Repository
public interface GraphRepository extends MongoRepository<Graph, String> {
}
