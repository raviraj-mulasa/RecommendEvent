package net.geekscore.ml.kaggle.rec.event.feature;

import net.geekscore.ml.kaggle.rec.event.Util;
import net.geekscore.ml.kaggle.rec.event.data.User;
import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 * Created by ravirajmulasa on 3/18/17.
 */
public class UserAgeInDays extends BaseFeature<Integer> {


    public UserAgeInDays() {
        this("user_age_in_days");
    }


    public UserAgeInDays(final String name) {
        this.name = name;
    }

    public void calculate(final User user){
        final DateTime userJoinedAtDateTime = new DateTime(user.getJoinedAt());
        this.value = Math.abs(Days.daysBetween(Util.TODAY, userJoinedAtDateTime).getDays());
    }

}
