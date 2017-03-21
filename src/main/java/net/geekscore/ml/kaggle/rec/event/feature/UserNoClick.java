package net.geekscore.ml.kaggle.rec.event.feature;

/**
 * Created by ravirajmulasa on 3/18/17.
 */
public class UserNoClick extends BaseFeature<Boolean> {

    public UserNoClick() {
        this("user_no_click");
    }

    public UserNoClick(final String name) {
        this.name = name;
    }

    public void calculate(final int interested, final int noInterested){
        this.value = (interested == 0 && noInterested == 0);
    }
}
