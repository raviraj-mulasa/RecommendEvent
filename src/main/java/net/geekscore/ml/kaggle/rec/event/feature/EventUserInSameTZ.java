package net.geekscore.ml.kaggle.rec.event.feature;

import net.geekscore.ml.kaggle.rec.event.data.Event;
import net.geekscore.ml.kaggle.rec.event.data.User;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;


/**
 * Created by ravirajmulasa on 3/16/17.
 */
public class EventUserInSameTZ extends BaseFeature<Boolean> {


    public EventUserInSameTZ() {
        this("event_user_at_same_tz");
    }

    public EventUserInSameTZ(final String name) {
        this.name = name;
    }

    public void calculate(final Event event, final User user){
        final DateTime eventStartDateTime = new DateTime(event.getStartTime(), DateTimeZone.UTC);
        final DateTime userJoinedDateTime = new DateTime(user.getJoinedAt(), DateTimeZone.UTC);

        final DateTimeZone eventStartDateTimeZone = eventStartDateTime.getZone();
        final DateTimeZone userJoinedDateTimeZone = userJoinedDateTime.getZone();

        this.value = eventStartDateTimeZone.getID().trim().equals(userJoinedDateTimeZone.getID().trim());
    }

}
