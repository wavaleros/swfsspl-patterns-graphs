package com.swfsspl.patterns.graphs.domain.graph;

import com.swfsspl.patterns.graphs.domain.Arcs;
import com.swfsspl.patterns.graphs.domain.search.ISearch;

public class DirectedWeightedGraph extends Graph {

    public DirectedWeightedGraph(String name, ISearch search) {
        super(name, search);
    }

    @Override
    public void addArc(String originNode, String destinationNode) {
        throw new RuntimeException("Unsupported Operation");
    }

    @Override
    public void addArc(String originNode, String destinationNode, int weight) {
        this.arcs.add(new Arcs(weight, nodes.get(originNode), nodes.get(destinationNode)));
    }
}
