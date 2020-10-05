package com.swfsspl.patterns.graphs.config;

import com.swfsspl.patterns.graphs.domain.factories.GraphFactory;
import com.swfsspl.patterns.graphs.domain.graph.Graph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StartUp implements ApplicationListener<ApplicationReadyEvent> {
    private final AppConfig appConfig;
    private final GraphFactory graphFactory;


    @Autowired
    public StartUp(AppConfig appConfig1, GraphFactory graphFactory) {
        this.appConfig = appConfig1;
        this.graphFactory = graphFactory;
    }

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        System.out.println("Loaded config : " + this.appConfig.toString());
        Graph g = this.graphFactory.getGraphWithName("Graph1");
        System.out.println("Adding Nodes....");
        g.addNode("A");
        g.addNode("B");
        g.addNode("C");
        System.out.println("Adding Arcs....");
        g.addArc("A", "B");
        g.addArc("B", "C", 2);
        System.out.println("\nNodes: " + g.getNodes());
        System.out.println("\nArcs" + g.getArcs());
        g.searchRoute("A", "B");
    }
}
