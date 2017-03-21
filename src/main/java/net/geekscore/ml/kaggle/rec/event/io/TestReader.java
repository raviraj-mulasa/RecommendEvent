package net.geekscore.ml.kaggle.rec.event.io;

import net.geekscore.ml.kaggle.rec.event.Util;
import net.geekscore.ml.kaggle.rec.event.dao.EventDAO;
import net.geekscore.ml.kaggle.rec.event.dao.UserDAO;
import net.geekscore.ml.kaggle.rec.event.data.Event;
import net.geekscore.ml.kaggle.rec.event.data.User;
import net.geekscore.ml.kaggle.rec.event.feature.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Created by ravirajmulasa on 3/15/17.
 */
public final class TestReader {

    private enum TestDataHeader {
        user,event,invited,timestamp
    }

    private static final Logger logger  = LoggerFactory.getLogger(TestReader.class);

    public static final void readTestData(String fileName) {

        final UserDAO userDAO   = new UserDAO();
        final EventDAO eventDAO = new EventDAO();
        try {
            final Reader in             = new FileReader(fileName);
            User user                   = null;
            Event event                 = null;
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader(FeatureHeader.class).withFirstRecordAsHeader().parse(in);

            CSVFormat csvFormat = CSVFormat.RFC4180;
            csvFormat.withHeader(FeatureHeader.class).withFirstRecordAsHeader();
            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/ravirajmulasa/Documents/Certificate_in_MachineLearning/Advanced_Machine_Learning/RecommendationEngine/models/test_feature.csv"));
            CSVPrinter printer = new CSVPrinter(writer, csvFormat);

            printer.print(FeatureHeader.user);
            printer.print(FeatureHeader.event);
            printer.print(FeatureHeader.user_invited);
            printer.print(FeatureHeader.num_invitees);
            printer.print(FeatureHeader.num_maybe);
            printer.print(FeatureHeader.num_no);
            printer.print(FeatureHeader.num_yes);
            printer.print(FeatureHeader.num_friends);
            printer.print(FeatureHeader.friends_invited_ratio);
            printer.print(FeatureHeader.friends_maybe_ratio);
            printer.print(FeatureHeader.friends_no_ratio);
            printer.print(FeatureHeader.friends_yes_ratio);
            printer.print(FeatureHeader.time_2_event_in_hours);
//            printer.print(TestFeatureHeader.user_age_in_days);
            printer.print(FeatureHeader.user_saw_2_event_start_in_days);
            printer.print("interested");
            printer.println();
            printer.flush();

            for (CSVRecord record : records) {

                Long userId         = Util.readValue(record.get(TestDataHeader.user).trim(), -1L);
                Long eventId        = Util.readValue(record.get(TestDataHeader.event).trim(),-1L);

                int invited         = Util.readValue(record.get(TestDataHeader.invited).trim(), 0);
                String timeUsrSaw   = Util.readValue(record.get(TestDataHeader.timestamp).trim(), "2012-11-16T16:01:55.620Z");

                if(userId.compareTo(-1L) != 0) {
                    user = Util.USER_CACHE.get(userId);
                    if(null == user) {
                        user = userDAO.getUserById(userId);
                        Util.USER_CACHE.put(userId, user);
                    }

                }
                if(userId.compareTo(-1L) != 0) {
                    event = Util.EVENT_CACHE.get(eventId);
                    if(null == event) {
                        event = eventDAO.getEventById(eventId);
                        Util.EVENT_CACHE.put(eventId, event);
                    }
                }


                if(null != user && null != event) {

                    IsUserInvited userInvited = new IsUserInvited();
                    userInvited.calculate(event, user);

                    NumUserFriends numUserFriends = new NumUserFriends();
                    numUserFriends.calculate(userId);

                    NumInvitees numInvitees  = new NumInvitees();
                    numInvitees.calculate(event);

                    NumMaybeResponders numMaybeResponders  = new NumMaybeResponders();
                    numMaybeResponders.calculate(event);

                    NumNoResponders numNoResponders  = new NumNoResponders();
                    numNoResponders.calculate(event);

                    NumYesResponders numYesResponders  = new NumYesResponders();
                    numYesResponders.calculate(event);


                    FriendsInvitedRatio friendsInvitedRatio  = new FriendsInvitedRatio();
                    friendsInvitedRatio.calculate(user, event);

                    FriendsRespondedMaybeRatio friendsRespondedMaybeRatio  = new FriendsRespondedMaybeRatio();
                    friendsRespondedMaybeRatio.calculate(user, event);

                    FriendsRespondedNoRatio friendsRespondedNoRatio  = new FriendsRespondedNoRatio();
                    friendsRespondedNoRatio.calculate(user, event);

                    FriendsRespondedYesRatio friendsRespondedYesRatio  = new FriendsRespondedYesRatio();
                    friendsRespondedYesRatio.calculate(user, event);

                    TimeToEventInDays timeToEventInDays = new TimeToEventInDays();
                    timeToEventInDays.calculate(event);

                    UserAgeInDays userAgeInDays = new UserAgeInDays();
                    userAgeInDays.calculate(user);

                    UserSaw2EventStartInHours userSaw2EventStartInHours = new UserSaw2EventStartInHours();
                    userSaw2EventStartInHours.calculate(timeUsrSaw, event);

                    printer.print(userId);
                    printer.print(eventId);
                    printer.print(invited);
//                    printer.print(userInvited.getValue().compareTo(false));
                    printer.print(numInvitees.getValue());
                    printer.print(numMaybeResponders.getValue());
                    printer.print(numNoResponders.getValue());
                    printer.print(numYesResponders.getValue());
                    printer.print(numUserFriends.getValue());
                    printer.print(String.format("%.6f",friendsInvitedRatio.getValue()));
                    printer.print(String.format("%.6f",friendsRespondedMaybeRatio.getValue()));
                    printer.print(String.format("%.6f",friendsRespondedNoRatio.getValue()));
                    printer.print(String.format("%.6f",friendsRespondedYesRatio.getValue()));
                    printer.print(timeToEventInDays.getValue());
//                    printer.print(userAgeInDays.getValue());
                    printer.print(userSaw2EventStartInHours.getValue());
                    printer.print("?");
                    printer.println();
                    printer.flush();

                }
            }
            printer.close();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
