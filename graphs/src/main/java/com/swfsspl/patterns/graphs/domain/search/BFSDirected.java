package com.swfsspl.patterns.graphs.domain.search;

import com.swfsspl.patterns.graphs.domain.enums.SearchType;
import com.swfsspl.patterns.graphs.domain.factories.SearchFactory;
import com.swfsspl.patterns.graphs.domain.graph.Graph;
import org.springframework.stereotype.Component;

@Component
public class BFSDirected implements ISearch {
    public BFSDirected() {
        SearchFactory.register(SearchAlgorithms.BFSDirected, this);
    }

    @Override
    public boolean search(Graph graph) {
        System.out.println(String.format("%s search result", SearchAlgorithms.BFSDirected));
        return false;
    }
}

