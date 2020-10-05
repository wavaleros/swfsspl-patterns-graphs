package com.swfsspl.patterns.graphs.domain.search;

import com.swfsspl.patterns.graphs.domain.factories.SearchFactory;
import com.swfsspl.patterns.graphs.domain.graph.Graph;
import org.springframework.stereotype.Component;

@Component
public class DFSDirected implements ISearch {

    public DFSDirected() {
        SearchFactory.register(SearchAlgorithms.DFSDirected, this);
    }

    @Override
    public boolean search(Graph graph) {
        System.out.println(String.format("%s search result", SearchAlgorithms.DFSDirected));
        return false;
    }
}

