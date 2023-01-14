package org.acme.graph.routing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.acme.graph.model.Edge;
import org.acme.graph.model.Path;
import org.acme.graph.model.Vertex;

public class PathTree {
	private Map<Vertex,PathNode> nodes;

    public PathTree(Vertex origin){
        this.nodes = new HashMap<Vertex, PathNode>();

        PathNode pathNode = new PathNode();
		pathNode.setCost(0.0);
		pathNode.setReachingEdge(null);
		pathNode.setVisited(false);
		this.nodes.put(origin, pathNode);
        /*
		for (Vertex vertex : this.graph.getVertices()) {
			PathNode pathnode = new PathNode();
			pathnode.setCost(origin == vertex ? 0.0 : Double.POSITIVE_INFINITY);
			pathnode.setReachingEdge(null);
			pathnode.setVisited(false);
			this.nodes.put(vertex, pathnode);
		}
        */
    }

    public PathNode getNode(Vertex vertex){
		return this.nodes.get(vertex);
	}

    public PathNode getOrCreateNode(Vertex vertex){
        PathNode pathNode;
        if(this.nodes.containsKey(vertex)){
            pathNode =  this.nodes.get(vertex);
        } else {
            pathNode = new PathNode();
			this.nodes.put(vertex, pathNode);
        }
        return pathNode;
    }

    public Path getPath(Vertex destination){
        assert isReached(destination);
    
        List<Edge> result = new ArrayList<>();

		Edge current = this.getNode(destination).getReachingEdge();
		do {
			result.add(current);
			current = this.getNode(current.getSource()).getReachingEdge();
		} while (current != null);

		Collections.reverse(result);
		return new Path(result);
    }


    public Set<Vertex> getReachedVertices(){
        return this.nodes.keySet();
    }

    public boolean isReached(Vertex destination){
        return this.getOrCreateNode(destination).getReachingEdge() != null;
    }
}
