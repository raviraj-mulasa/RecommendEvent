package net.geekscore.ml.kaggle.rec.event.feature;

/**
 * Created by ravirajmulasa on 3/17/17.
 */
public class EventCluster extends BaseFeature<Double> {

    public EventCluster() {
        this("event_cluster");
    }
    public EventCluster(final String name) {
        this.name = name;
    }
}
