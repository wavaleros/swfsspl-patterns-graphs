package com.swfsspl.patterns.graphs.config;

import com.swfsspl.patterns.graphs.domain.factories.SearchFactory;
import com.swfsspl.patterns.graphs.domain.search.ISearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StartUp implements ApplicationListener<ApplicationReadyEvent> {
    private final AppConfig appConfig;
    private final SearchFactory searchFactory;

    @Autowired
    public StartUp(AppConfig appConfig1, SearchFactory searchFactory) {
        this.appConfig = appConfig1;
        this.searchFactory = searchFactory;
    }

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        System.out.println(this.appConfig.toString());
        ISearch search = this.searchFactory.getByType(this.appConfig.getSearchType());
        search.search(null);
    }
}
