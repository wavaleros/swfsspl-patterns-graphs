package com.swfsspl.patterns.graphs.domain.graph;

import com.swfsspl.patterns.graphs.domain.Arcs;
import com.swfsspl.patterns.graphs.domain.Node;
import com.swfsspl.patterns.graphs.domain.search.ISearch;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Getter
@ToString
public abstract class Graph {
    protected String name;
    protected Map<String, Node> nodes;
    protected List<Arcs> arcs;
    protected ISearch search;

    public Graph(String name, ISearch search) {
        this.nodes = new HashMap<>();
        this.name = name;
        this.arcs = new ArrayList<>();
        this.search = search;
    }


    public void addNode(String name) {
        this.nodes.put(name, new Node(name));
    }

    public Node searchNodeByName(String name) {
        Node node = this.nodes.get(name);
        if (Objects.isNull(node)) {
            throw new RuntimeException("Node not found");
        }
        return node;
    }

    public List<Node> searchRoute(String origin, String destination) {
        System.out.println(String.format("Searching route for %s and %s", origin, destination));
        search.search(this);
        return null;
    }


    public void addArc(String originNode, String destinationNode) {
        System.out.println("Unsupported operation for nodes : " + originNode + " - " + destinationNode);
    }

    public void addArc(String originNode, String destinationNode, int weight) {
        System.out.println("Unsupported operation for nodes : " + originNode + " - " + destinationNode + "with weight: " + weight);
    }
}
