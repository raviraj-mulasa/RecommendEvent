package net.geekscore.ml.kaggle.rec.event.feature;

import net.geekscore.ml.kaggle.rec.event.dao.EventDAO;
import net.geekscore.ml.kaggle.rec.event.data.Event;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ravirajmulasa on 3/19/17.
 */
public class TimeToEventInDaysTest {

    private EventDAO eventDAO;

    @Before
    public void setUpEventDAO(){
        if(null == eventDAO) {
            eventDAO = new EventDAO();
        }
    }

    @Test
    public void test(){
        final Event event = eventDAO.getEventById(26660986L);
        final TimeToEventInDays timeToEventInMin = new TimeToEventInDays();
        timeToEventInMin.calculate(event);

    }
}
