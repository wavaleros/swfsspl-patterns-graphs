package com.swfsspl.patterns.graphs.domain.search;

import com.swfsspl.patterns.graphs.domain.Graph;
import com.swfsspl.patterns.graphs.domain.enums.SearchType;
import com.swfsspl.patterns.graphs.domain.factories.SearchFactory;
import org.springframework.stereotype.Component;

@Component
public class DFS implements ISearch {
    public DFS() {
        SearchFactory.register(SearchType.DFS, this);
    }

    @Override
    public boolean search(Graph graph) {
        System.out.println("DFS search result");
        return false;
    }
}
