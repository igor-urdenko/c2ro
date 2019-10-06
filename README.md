# C2RO
Interview Question implementation for C2RO

# Question
You should implement a service with two REST endpoints
[path: `/graphs`, method: POST] that receives a graph description.
The following steps need to be processed before storing the graph in MongoDB:
1. Validation to make sure the graph description has no error
2. Load the graph in known Python library (i.e. networkx)
3. Returns the id of the stored graph for retrieval purposes

[path: `/graphs/:id`, method: GET] that retrieves the graph with specified id and return a JSON version

Graph description contains:
Set of graph nodes
Set of graph edges.
  Each edge contains extendable list of meta data including:
    Weight
    Direction
    Loop
    etc
Example of description:
    Node_Name Node_Name Weight Direction
    [node1]   [node2]   1.6    [node1]-[node2]


For deployment, you can use docker compose for dockerized service and MongoDB instance. You can also implement other deployment approaches of your choice.
