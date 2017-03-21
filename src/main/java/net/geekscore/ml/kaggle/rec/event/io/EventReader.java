package net.geekscore.ml.kaggle.rec.event.io;

import com.google.common.base.Splitter;
import net.geekscore.ml.kaggle.rec.event.Util;
import net.geekscore.ml.kaggle.rec.event.dao.EventAttendeesDAO;
import net.geekscore.ml.kaggle.rec.event.data.Event;
import net.geekscore.ml.kaggle.rec.event.data.EventAttendeePair;
import net.geekscore.ml.kaggle.rec.event.data.User;
import net.geekscore.ml.kaggle.rec.event.data.UserResponse;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

/**
 * Created by ravirajmulasa on 3/15/17.
 */
public final class EventReader {

    private enum EventHeaders {
        event_id,user_id,start_time,city,state,zip,country,lat,lng,
        c_1,c_2,c_3,c_4,c_5,c_6,c_7,c_8,c_9,c_10,
        c_11,c_12,c_13,c_14,c_15,c_16,c_17,c_18,c_19,c_20,
        c_21,c_22,c_23,c_24,c_25,c_26,c_27,c_28,c_29,c_30,
        c_31,c_32,c_33,c_34,c_35,c_36,c_37,c_38,c_39,c_40,
        c_41,c_42,c_43,c_44,c_45,c_46,c_47,c_48,c_49,c_50,
        c_51,c_52,c_53,c_54,c_55,c_56,c_57,c_58,c_59,c_60,
        c_61,c_62,c_63,c_64,c_65,c_66,c_67,c_68,c_69,c_70,
        c_71,c_72,c_73,c_74,c_75,c_76,c_77,c_78,c_79,c_80,
        c_81,c_82,c_83,c_84,c_85,c_86,c_87,c_88,c_89,c_90,
        c_91,c_92,c_93,c_94,c_95,c_96,c_97,c_98,c_99,c_100,
        c_other

    }

    private enum EventAttendeesHeaders {
        event,yes,maybe,invited,no
    }

    private static final Logger logger  = LoggerFactory.getLogger(EventReader.class);

    private static final Splitter USERS_SPLITTER = Splitter.on(" ").omitEmptyStrings().trimResults();

    public static final void readEvents(String fileName) {
        try {
            final Reader in             = new FileReader(fileName);
            final CSVFormat csvFormat   = CSVFormat.DEFAULT.withQuote(null);
            Iterable<CSVRecord> records = csvFormat.withHeader(EventHeaders.class).withFirstRecordAsHeader().parse(in);
            Event event                 = null;

            for (CSVRecord record : records) {
                Long eventId        = Util.readValue(record.get(EventHeaders.event_id).trim(), -1L);
                Long userId         = Util.readValue(record.get(EventHeaders.user_id).trim(), -1L);
                String startTimeStr = Util.readValue(record.get(EventHeaders.start_time).trim(), "2012-11-16T16:01:55.620Z");
                String city         = Util.readValue(record.get(EventHeaders.city).trim(),"");
                String state        = Util.readValue(record.get(EventHeaders.state).trim(),"");
                String country      = Util.readValue(record.get(EventHeaders.country).trim(),"");
                String zipcode      = Util.readValue(record.get(EventHeaders.zip).trim(), "");
                Float lat           = Util.readValue(record.get(EventHeaders.lat).trim(), 0.0F);
                Float lng           = Util.readValue(record.get(EventHeaders.lng).trim(), 0.0F);


                if(userId.compareTo(-1L) != 0 && eventId.compareTo(-1L) != 0) {
                    event= new Event(eventId, userId, startTimeStr, city, state, zipcode, country, lat, lng);
                }
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public static final void readEventAttendees(String fileName) {
        try {
            final Reader in             = new FileReader(fileName);
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader(EventAttendeesHeaders.class).withFirstRecordAsHeader().parse(in);

            for (CSVRecord record : records) {

                Long eventId           = Util.readValue(record.get(EventAttendeesHeaders.event).trim(), -1L);
                if(eventId.compareTo(-1L) != 0) {

                    List<EventAttendeePair> eventAttendeePairList = new LinkedList<>();

                    List<String> userList  = USERS_SPLITTER.splitToList(record.get(EventAttendeesHeaders.maybe).trim());
                    eventAttendeePairList.addAll(addUserList2Event(userList, eventId, EventAttendeesHeaders.maybe));

                    userList  = USERS_SPLITTER.splitToList(record.get(EventAttendeesHeaders.yes).trim());
                    eventAttendeePairList.addAll(addUserList2Event(userList, eventId, EventAttendeesHeaders.yes));

                    userList  = USERS_SPLITTER.splitToList(record.get(EventAttendeesHeaders.no).trim());
                    eventAttendeePairList.addAll(addUserList2Event(userList, eventId, EventAttendeesHeaders.no));

                    userList  = USERS_SPLITTER.splitToList(record.get(EventAttendeesHeaders.invited).trim());
                    eventAttendeePairList.addAll(addUserList2Event(userList, eventId, EventAttendeesHeaders.invited));

                    final EventAttendeesDAO eventAttendeesDAO = new EventAttendeesDAO();
                    eventAttendeesDAO.insertAttendeeResponse(eventAttendeePairList);

                }
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    private static List<EventAttendeePair> addUserList2Event(final List<String> userList, final Long eventId, EventAttendeesHeaders attendeesHeaders) {

        Long userId                                   = -1L;
        List<EventAttendeePair> eventAttendeePairList = Collections.emptyList();

        if(!userList.isEmpty()) {
            eventAttendeePairList                   = new ArrayList<>(userList.size());
            EventAttendeePair eventAttendeePair     = null;

            for (String userIdStr: userList) {
                userId = Long.valueOf(userIdStr);
                switch (attendeesHeaders) {
                    case maybe:
                        eventAttendeePair = new EventAttendeePair(eventId, userId, UserResponse.MAYBE);
                        break;
                    case yes:
                        eventAttendeePair = new EventAttendeePair(eventId, userId, UserResponse.YES);
                        break;
                    case no:
                        eventAttendeePair = new EventAttendeePair(eventId, userId, UserResponse.NO);
                        break;
                    case invited:
                        eventAttendeePair = new EventAttendeePair(eventId, userId, UserResponse.INVITED);
                        break;
                    default:
                        break;
                }
                eventAttendeePairList.add(eventAttendeePair);
            }
        }
        return eventAttendeePairList;
    }
}
