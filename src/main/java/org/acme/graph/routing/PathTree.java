package org.acme.graph.routing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.acme.graph.model.Edge;
import org.acme.graph.model.Graph;
import org.acme.graph.model.Path;
import org.acme.graph.model.Vertex;

public class PathTree {
    private Graph graph;
	private Map<Vertex,PathNode> nodes;

    public PathTree(Graph graph, Vertex origin){
        this.graph = graph;
        this.nodes = new HashMap<Vertex, PathNode>();
    
		for (Vertex vertex : this.graph.getVertices()) {
			PathNode pathnode = new PathNode();
			pathnode.setCost(origin == vertex ? 0.0 : Double.POSITIVE_INFINITY);
			pathnode.setReachingEdge(null);
			pathnode.setVisited(false);
			this.nodes.put(vertex, pathnode);
		}
    }

    public PathNode getNode(Vertex vertex){
		return this.nodes.get(vertex);
	}

    public Path getPath(Vertex destination){
        List<Edge> result = new ArrayList<>();

		Edge current = this.getNode(destination).getReachingEdge();
		do {
			result.add(current);
			current = this.getNode(current.getSource()).getReachingEdge();
		} while (current != null);

		Collections.reverse(result);
		return new Path(result);
    }
}
