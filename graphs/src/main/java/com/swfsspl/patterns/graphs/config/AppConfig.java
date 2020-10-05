package com.swfsspl.patterns.graphs.config;

import com.swfsspl.patterns.graphs.domain.enums.GraphType;
import com.swfsspl.patterns.graphs.domain.enums.SearchType;
import com.swfsspl.patterns.graphs.domain.enums.WeightType;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@ToString
public class AppConfig {

    private final GraphType graphType;
    private final WeightType weightType;
    private final SearchType searchType;

    public AppConfig(@Value("${graph.type}") GraphType graphType, @Value("${graph.weight}") WeightType weightType, @Value("${graph.search}") SearchType searchType) {
        this.graphType = graphType;
        this.weightType = weightType;
        this.searchType = searchType;
    }


}
