package net.geekscore.ml.kaggle.rec.event.feature;

import net.geekscore.ml.kaggle.rec.event.Util;
import net.geekscore.ml.kaggle.rec.event.data.Event;
import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 * Created by ravirajmulasa on 3/17/17.
 */
public class TimeToEventInDays extends BaseFeature<Integer> {


    public TimeToEventInDays() {
        this("time_to_event_days");
    }



    public TimeToEventInDays(final String name) {
        this.name = name;
    }

    public void calculate(final Event event){
        final DateTime eventStartDateTime = new DateTime(event.getStartTime());
        this.value = Math.abs(Days.daysBetween(Util.TODAY, eventStartDateTime).getDays());
    }
}
