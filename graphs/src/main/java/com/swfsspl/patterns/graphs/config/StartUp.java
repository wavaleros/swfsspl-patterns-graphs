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
        System.out.println(this.appConfig.toString());
        Graph g = this.graphFactory.getGraphWithName("Graph1");
        g.addNode("A");
        g.addNode("B");
        g.addNode("C");
        g.searchRoute("A", "B");
    }
}
