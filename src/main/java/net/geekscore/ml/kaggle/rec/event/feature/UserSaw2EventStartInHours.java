package net.geekscore.ml.kaggle.rec.event.feature;

import net.geekscore.ml.kaggle.rec.event.data.Event;
import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by ravirajmulasa on 3/19/17.
 */
public class UserSaw2EventStartInHours extends BaseFeature<Integer> {

    private static final Logger logger  = LoggerFactory.getLogger(UserSaw2EventStartInHours.class);

    public UserSaw2EventStartInHours() {
        this("user_saw_2_event_start_in_days");
    }

    private static final DateTimeFormatter USER_SAW_DATE_TIME_FORMATTER =
            DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSSSSS+HH:mm");

    private static final DateTimeFormatter USER_SAW_DATE_TIME_FORMATTER_2 =
            DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss+HH:mm");

    public UserSaw2EventStartInHours(final String name) {
        this.name = name;
    }

    public void calculate(final String userSawTimeStamp, final Event event){
        DateTime userSawDateTime;
        try {
            userSawDateTime    = USER_SAW_DATE_TIME_FORMATTER.parseDateTime(userSawTimeStamp);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            userSawDateTime    = USER_SAW_DATE_TIME_FORMATTER_2.parseDateTime(userSawTimeStamp);
        }
        final DateTime eventStartDateTime = new DateTime(event.getStartTime());
        if(null != userSawDateTime){
            this.value = Math.abs(Hours.hoursBetween(eventStartDateTime, userSawDateTime).getHours());
        }else {
            this.value = Integer.MIN_VALUE;
        }

    }
}
