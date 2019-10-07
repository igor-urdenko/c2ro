# Graph Service
The suggested GitHub project is an implementation of the REST service
that allows Graph creation storing in and retrieving from Mongo DB instance.

## REST service endpoints
The Graph service is implemented as Spring Boot application and provides the following end points:
1. Store Graph: `/graphs/` -- accepts `POST` requests that expects a request body 
with Graph structure in JSON format. The end point returns the generated ID 
of the Graph stored in DB. The ID looks like UUID string. For example: `689d45a1-2aa4-4b95-9243-4e092fbaf8ab`
2. Get Graph: `/graphs/:id` -- accepts `GET` requests and returns Graph with given ID from
database in JSON format. The ID looks like UUID string. For example: `689d45a1-2aa4-4b95-9243-4e092fbaf8ab`
3. Generate Random Graph: `/graphs/random` -- accepts `GET` requests and returns a generated graph
with random number of nodes and edges in JSON format. 
4. Generate Graph: `/graphs/random/:nodes/:edges` -- accepts `GET` requests and returns 
a generated graph with given number of nodes and edges in JSON format.

## The JSON structure describing the Graph
All defined end points operate a Graph object in JSON format.
Example:
```json
{
    "id": "null",
    "nodes": [
        { "id": 1, "label": "Node-1" },
        { "id": 2, "label": "Node-2" },
        { "id": 3, "label": "Node-3" },
        { "id": 4, "label": "Node-4" },
        { "id": 5, "label": "Node-5" }
    ],
    "edges": [
        {
            "weight": 1.3608482,
            "from": { "id": 1, "label": "Node-1" },
            "to": { "id": 2, "label": "Node-2" },
            "directed": false,
            "loop": false
        },
        {
            "weight": 1.3608482,
            "from": { "id": 2, "label": "Node-2" },
            "to": { "id": 3, "label": "Node-3" },
            "directed": false,
            "loop": false
        },
        {
            "weight": 1.3608482,
            "from": { "id": 3, "label": "Node-3" },
            "to": { "id": 4, "label": "Node-4" },
            "directed": false,
            "loop": false
        },
        {
            "weight": 1.3608482,
            "from": { "id": 4, "label": "Node-4" },
            "to": { "id": 5, "label": "Node-5" },
            "directed": false,
            "loop": false
        },
        {
            "weight": 1.3608482,
            "from": { "id": 5, "label": "Node-5" },
            "to": { "id": 1, "label": "Node-1" },
            "directed": false,
            "loop": false
        }
    ]
}
```
The structure above defines the following graph:

![alt text](https://github.com/igor-urdenko/c2ro/blob/master/graph-svc/images/5-nodes.png "5 nodes graph")

## Deployment Instructions
The current implementation of the service does not allow to deploy both the service and Mongo DB instance in one step. There are few steps to perform.
1. Deploy the Mongo DB container in the docker:
```bash
docker run --name graph-mongo -d -p 17001:27017 mongo:4.2.0-bionic
```
2. Build the Spring Boot application:
```bash
mvn clean install -f ./graph-svc/pom.xml
```
3. Build a Docker image with Graph Service application:
```bash
docker build --tag graph-svc ./graph-svc
```
4. Deploy Graph Service container:
```bash
# The $HOST variable should be replaced with Docker host address where you have deployed the Mongo DB container
docker run -e spring.data.mongodb.host=$HOST -e spring.data.mongodb.port=17001 -d -p 17000:8080 --name my-graph-svc graph-svc
```

After the deployment, the service is ready to work and can be accessed with any REST client.
