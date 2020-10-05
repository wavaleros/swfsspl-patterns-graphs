package com.swfsspl.patterns.graphs.domain.graph;

import com.swfsspl.patterns.graphs.domain.Arcs;
import com.swfsspl.patterns.graphs.domain.search.ISearch;

public class DirectedGraph extends Graph {
    public DirectedGraph(String name, ISearch search) {
        super(name, search);
    }


    @Override
    public void addArc(String originNode, String destinationNode) {
        this.arcs.add(new Arcs(0, nodes.get(originNode), nodes.get(destinationNode)));
    }

    @Override
    public void addArc(String originNode, String destinationNode, int weight) {
        throw new RuntimeException("Unsupported Operation");
    }
}
