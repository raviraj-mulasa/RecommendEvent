package net.geekscore.ml.kaggle.rec.event.io;

import net.geekscore.ml.kaggle.rec.event.io.EventReader;
import org.junit.Test;

/**
 * Created by ravirajmulasa on 3/18/17.
 */
public class EventReaderTest {

    @Test
    public void testReadEventAttendees(){
        EventReader.readEventAttendees("/Users/ravirajmulasa/Documents/Certificate_in_MachineLearning/Advanced_Machine_Learning/RecommendationEngine/data/event_attendees.csv");
    }
}
