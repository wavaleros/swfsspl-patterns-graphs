package com.swfsspl.patterns.graphs.domain;

import com.swfsspl.patterns.graphs.domain.search.ISearch;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GraphUndirected {
    private String name;
    private Map<String, Node> nodes;
    private List<Arcs> arcs;
    private ISearch search;

    public void addNode(String name) {
        this.nodes.put(name, new Node(name));
    }

    public void addArc(String originNode, String destinationNode, int weight) {
        this.arcs.add(new Arcs(weight, nodes.get(originNode), nodes.get(destinationNode)));
    }


}
