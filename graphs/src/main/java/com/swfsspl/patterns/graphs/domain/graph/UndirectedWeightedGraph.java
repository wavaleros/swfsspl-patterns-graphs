package com.swfsspl.patterns.graphs.domain.graph;

import com.swfsspl.patterns.graphs.domain.Arcs;
import com.swfsspl.patterns.graphs.domain.Node;
import com.swfsspl.patterns.graphs.domain.search.ISearch;

public class UndirectedWeightedGraph extends Graph {

    public UndirectedWeightedGraph(String name, ISearch search) {
        super(name, search);
    }


    @Override
    public void addArc(String originNode, String destinationNode, int weight) {
        final Node a = this.searchNodeByName(originNode);
        final Node b = this.searchNodeByName(destinationNode);
        this.arcs.add(new Arcs(weight, a, b));
        this.arcs.add(new Arcs(weight, b, a));
    }
}
