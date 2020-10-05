package com.swfsspl.patterns.graphs.domain.search;

import com.swfsspl.patterns.graphs.domain.Graph;
import com.swfsspl.patterns.graphs.domain.enums.SearchType;
import com.swfsspl.patterns.graphs.domain.factories.SearchFactory;
import org.springframework.stereotype.Component;

@Component
public class BFS implements ISearch {
    public BFS() {
        SearchFactory.register(SearchType.BFS, this);
    }

    @Override
    public boolean search(Graph graph) {
        System.out.println("BFS search result");
        return false;
    }
}

