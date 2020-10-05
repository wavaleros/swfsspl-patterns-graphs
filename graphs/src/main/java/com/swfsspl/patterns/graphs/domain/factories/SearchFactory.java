package com.swfsspl.patterns.graphs.domain.factories;

import com.swfsspl.patterns.graphs.domain.search.ISearch;
import com.swfsspl.patterns.graphs.domain.search.SearchAlgorithms;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SearchFactory {
    private static final Map<SearchAlgorithms, ISearch> searchTypeMap = new HashMap<>();

    public static void register(SearchAlgorithms searchAlgorithms, ISearch search) {
        searchTypeMap.put(searchAlgorithms, search);
    }

    public ISearch getByType(SearchAlgorithms searchAlgorithms) {
        return searchTypeMap.get(searchAlgorithms);
    }
}
