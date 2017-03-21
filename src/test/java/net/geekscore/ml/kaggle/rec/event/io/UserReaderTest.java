package net.geekscore.ml.kaggle.rec.event.io;

import net.geekscore.ml.kaggle.rec.event.io.UserReader;
import org.junit.Test;

/**
 * Created by ravirajmulasa on 3/18/17.
 */
public class UserReaderTest {

    @Test
    public void testReadingUerFriends(){
        UserReader.readUserFriends("/Users/ravirajmulasa/Documents/Certificate_in_MachineLearning/Advanced_Machine_Learning/RecommendationEngine/data/user_friends.csv");
    }
}
