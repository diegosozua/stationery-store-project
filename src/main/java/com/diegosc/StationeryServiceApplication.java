package com.diegosc;

import com.diegosc.db.StationeryProductDao;
import com.diegosc.resources.StationeryProductResources;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.jdbi.v3.core.Jdbi;

public class StationeryServiceApplication extends Application<StationeryServiceConfiguration> {

    public static void main(final String[] args) throws Exception {
        new StationeryServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "StationeryService";
    }

    @Override
    public void initialize(final Bootstrap<StationeryServiceConfiguration> bootstrap) {
        bootstrap.addBundle(new MigrationsBundle<StationeryServiceConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(StationeryServiceConfiguration stationeryServiceConfiguration) {
                return stationeryServiceConfiguration.getDataSourceFactory();
            }
        });

        bootstrap.addBundle(new AssetsBundle("/assets/", "/", "index.html"));
    }

    @Override
    public void run(final StationeryServiceConfiguration configuration,
                    final Environment environment) {
        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "h2");
        StationeryProductDao stationeryProductDao = jdbi.onDemand(StationeryProductDao.class);

        StationeryProductResources stationeryProductResources = new StationeryProductResources(stationeryProductDao);
        environment.jersey().register(stationeryProductResources);
    }

}
