package com.swfsspl.patterns.graphs.domain.search;

import com.swfsspl.patterns.graphs.domain.factories.SearchFactory;
import com.swfsspl.patterns.graphs.domain.graph.Graph;
import org.springframework.stereotype.Component;

@Component
public class BFS implements ISearch {
    public BFS() {
        SearchFactory.register(SearchAlgorithms.BFS, this);
    }

    @Override
    public boolean search(Graph graph) {
        System.out.println(String.format("%s search result", SearchAlgorithms.BFS));
        return false;
    }
}
