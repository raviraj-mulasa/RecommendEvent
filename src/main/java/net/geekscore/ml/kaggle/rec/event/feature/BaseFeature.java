package net.geekscore.ml.kaggle.rec.event.feature;

/**
 * Created by ravirajmulasa on 3/16/17.
 */
public abstract class BaseFeature<T> {

    protected String name;

    protected T value;

    public String getName() {
        return this.name;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }







}
