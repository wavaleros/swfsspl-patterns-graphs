package com.swfsspl.patterns.graphs.domain.factories;

import com.swfsspl.patterns.graphs.domain.enums.SearchType;
import com.swfsspl.patterns.graphs.domain.search.ISearch;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SearchFactory {
    private static final Map<SearchType, ISearch> searchTypeMap = new HashMap<>();

    public static void register(SearchType searchType, ISearch search) {
        searchTypeMap.put(searchType, search);
    }

    public ISearch getByType(SearchType searchType) {
        return searchTypeMap.get(searchType);
    }
}
