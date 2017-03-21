package net.geekscore.ml.kaggle.rec.event;

import com.google.common.base.Joiner;
import net.geekscore.ml.kaggle.rec.event.data.Event;
import net.geekscore.ml.kaggle.rec.event.data.User;
import org.joda.time.DateTime;
import org.joda.time.chrono.ISOChronology;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ravirajmulasa on 3/15/17.
 */
public final class Util {

    private static final Logger logger  = LoggerFactory.getLogger(Util.class);

    public static final Joiner SEMI_COLON_JOINER = Joiner.on(";").skipNulls();

    public static final Joiner COMMA_JOINER = Joiner.on(",").skipNulls();

    public static final DateTime TODAY = DateTime.now(ISOChronology.getInstance());

    public static final Map<Long, User> USER_CACHE = new HashMap<Long, User>();

    public static final Map<Long, Long> USER_NUM_FRIENDS_CACHE = new HashMap<Long, Long>();

    public static final Map<Long, Event> EVENT_CACHE = new HashMap<Long, Event>();

    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.######");

    public static final <T> T readValue(final String value, T defaultValue) {

        if (null == value || 0 == value.trim().length() || value.equalsIgnoreCase("None")) {
            return defaultValue;
        }
        T value2Return = defaultValue;
        try {
            if (defaultValue instanceof String) {
                value2Return = (T) value;
            } else if (defaultValue instanceof Integer) {
                value2Return = (T) Integer.valueOf(value);
            } else if (defaultValue instanceof Boolean) {
                value2Return = (T) Boolean.valueOf(value);
            } else if (defaultValue instanceof Double) {
                value2Return = (T) Double.valueOf(value);
            } else if (defaultValue instanceof Long) {
                value2Return = (T) Long.valueOf(value);
            } else if (defaultValue instanceof Float) {
                value2Return = (T) Float.valueOf(value);
            } else if (defaultValue instanceof DateTime) {
                value2Return = (T) new DateTime(value);
            }
        } catch (IllegalArgumentException ex) {
            logger.error(ex.getMessage(), ex);
        }

        return value2Return;

    }
}
