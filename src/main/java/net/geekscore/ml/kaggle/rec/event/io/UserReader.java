package net.geekscore.ml.kaggle.rec.event.io;

import com.google.common.base.Splitter;
import net.geekscore.ml.kaggle.rec.event.Util;
import net.geekscore.ml.kaggle.rec.event.dao.UserFriendsDAO;
import net.geekscore.ml.kaggle.rec.event.data.User;
import net.geekscore.ml.kaggle.rec.event.data.UserFriendPair;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ravirajmulasa on 3/15/17.
 */
public final class UserReader {

    private enum UserHeaders {
        user_id, locale, birthyear, gender, joinedAt, location, timezone
    }

    private enum UserFriendsHeaders {
        user,friends
    }

    private static final Logger logger  = LoggerFactory.getLogger(UserReader.class);

    private static final Splitter FRIENDS_SPLITTER = Splitter.on(" ").omitEmptyStrings().trimResults();

    public static final void readUsers(String fileName) {
        try {
            final Reader in             = new FileReader(fileName);
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader(UserHeaders.class).withFirstRecordAsHeader().parse(in);
            User user                   = null;
            for (CSVRecord record : records) {
                Long id             = Util.readValue(record.get(UserHeaders.user_id).trim(), -1L);
                String locale       = Util.readValue(record.get(UserHeaders.locale).trim(),"en_US");
                int birthYear       = Util.readValue(record.get(UserHeaders.birthyear).trim(), 0);
                String gender       = Util.readValue(record.get(UserHeaders.gender).trim(), "male");
                String joinedAt     = Util.readValue(record.get(UserHeaders.joinedAt).trim(),"2012-11-16T16:01:55.620Z");
                String location     = Util.readValue(record.get(UserHeaders.location).trim(), "");
                int tzOffSetInMins  = Util.readValue(record.get(UserHeaders.timezone).trim(), 0);

                user = new User(id, locale, birthYear, gender, joinedAt, location, tzOffSetInMins);
                if(id.compareTo(-1L) != 0 && null != user) {
                    logger.trace(user.toString());
                }
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public static final void readUserFriends(String fileName) {
        try {
            final Reader in             = new FileReader(fileName);
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader(UserFriendsHeaders.class).withFirstRecordAsHeader().parse(in);
            for (CSVRecord record : records) {
                Long userId            = Util.readValue(record.get(UserFriendsHeaders.user).trim(), -1L);
                List<String> friendIds = FRIENDS_SPLITTER.splitToList(record.get(UserFriendsHeaders.friends).trim());
                Long friendId          = -1L;
                if(userId.compareTo(-1L) != 0 && !friendIds.isEmpty()) {
                    List<UserFriendPair> userFriendPairs    = new ArrayList<>(friendIds.size());
                    UserFriendPair userFriendPair           = null;

                    for (String friendIdStr: friendIds) {
                        friendId = Util.readValue(friendIdStr, -1L);
                        if(friendId.compareTo(-1L) != 0) {
                            userFriendPair = new UserFriendPair(userId, friendId);
                            userFriendPairs.add(userFriendPair);
                        }
                    }
                    if(!userFriendPairs.isEmpty()){
                        final UserFriendsDAO userFriendsDAO = new UserFriendsDAO();
                        userFriendsDAO.insertUserFriend(userFriendPairs);
                    }
                }
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
