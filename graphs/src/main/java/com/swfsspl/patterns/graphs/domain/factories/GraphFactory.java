package com.swfsspl.patterns.graphs.domain.factories;

import com.swfsspl.patterns.graphs.config.AppConfig;
import com.swfsspl.patterns.graphs.domain.enums.GraphType;
import com.swfsspl.patterns.graphs.domain.enums.SearchType;
import com.swfsspl.patterns.graphs.domain.enums.WeightType;
import com.swfsspl.patterns.graphs.domain.graph.DirectedGraph;
import com.swfsspl.patterns.graphs.domain.graph.DirectedWeightedGraph;
import com.swfsspl.patterns.graphs.domain.graph.Graph;
import com.swfsspl.patterns.graphs.domain.graph.UndirectedGraph;
import com.swfsspl.patterns.graphs.domain.graph.UndirectedWeightedGraph;
import com.swfsspl.patterns.graphs.domain.search.SearchAlgorithms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GraphFactory {

    private final AppConfig appConfig;
    private final SearchFactory searchFactory;

    @Autowired
    public GraphFactory(AppConfig appConfig, SearchFactory searchFactory) {
        this.appConfig = appConfig;
        this.searchFactory = searchFactory;
    }

    public Graph getGraphWithName(String name) {
        Graph graph = null;
        if (GraphType.DIRECTED == this.appConfig.getGraphType()) {
            if (WeightType.WEIGHTED == this.appConfig.getWeightType()) {
                if (SearchType.BFS == this.appConfig.getSearchType()) {
                    graph = new DirectedWeightedGraph(name, searchFactory.getByType(SearchAlgorithms.BFSDirected));
                } else if (SearchType.DFS == this.appConfig.getSearchType()) {
                    graph = new DirectedWeightedGraph(name, searchFactory.getByType(SearchAlgorithms.DFSDirected));
                }
            } else if (WeightType.UNWEIGHTED == this.appConfig.getWeightType()) {
                if (SearchType.BFS == this.appConfig.getSearchType()) {
                    graph = new DirectedGraph(name, searchFactory.getByType(SearchAlgorithms.BFSDirected));
                } else if (SearchType.DFS == this.appConfig.getSearchType()) {
                    graph = new DirectedGraph(name, searchFactory.getByType(SearchAlgorithms.DFSDirected));
                }
            }
        } else if (GraphType.UNDIRECTED == this.appConfig.getGraphType()) {
            if (WeightType.WEIGHTED == this.appConfig.getWeightType()) {
                if (SearchType.BFS == this.appConfig.getSearchType()) {
                    graph = new UndirectedGraph(name, searchFactory.getByType(SearchAlgorithms.BFS));
                } else if (SearchType.DFS == this.appConfig.getSearchType()) {
                    graph = new UndirectedGraph(name, searchFactory.getByType(SearchAlgorithms.DFS));
                }
            } else if (WeightType.UNWEIGHTED == this.appConfig.getWeightType()) {
                if (SearchType.BFS == this.appConfig.getSearchType()) {
                    graph = new UndirectedWeightedGraph(name, searchFactory.getByType(SearchAlgorithms.BFS));
                } else if (SearchType.DFS == this.appConfig.getSearchType()) {
                    graph = new UndirectedWeightedGraph(name, searchFactory.getByType(SearchAlgorithms.DFS));
                }
            }
        }
        return graph;
    }
}
