package org.acme.graph.model;

import java.util.List;

public class Path {
    private List<Edge> edges;

    public Path(List<Edge> edges){
        this.edges = edges;
    }

    public double getLength(){
        double somme = 0;
        for(Edge edge : this.edges) {
            somme += edge.getCost();
        }
        return somme;
    }

    public List<Edge> getEdges(){
        return this.edges;
    }
}
