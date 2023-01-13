package org.acme.graph.routing;

import org.acme.graph.model.Edge;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PathNode {
    /**
	 * dijkstra - coût pour atteindre le sommet
	 */
	private double cost;
	/**
	 * dijkstra - arc entrant avec le meilleur coût
	 */
	private Edge reachingEdge;
	/**
	 * dijkstra - indique si le sommet est visité
	 */
	private boolean visited;

    public PathNode(){
        this.visited = false;
        this.cost = Double.POSITIVE_INFINITY;
    }
    
    @JsonIgnore
	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@JsonIgnore
	public Edge getReachingEdge() {
		return reachingEdge;
	}

	public void setReachingEdge(Edge reachingEdge) {
		this.reachingEdge = reachingEdge;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
}
