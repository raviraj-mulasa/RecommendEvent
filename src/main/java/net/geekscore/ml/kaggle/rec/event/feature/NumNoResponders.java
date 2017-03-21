package net.geekscore.ml.kaggle.rec.event.feature;

import net.geekscore.ml.kaggle.rec.event.dao.EventAttendeesDAO;
import net.geekscore.ml.kaggle.rec.event.data.Event;

/**
 * Created by ravirajmulasa on 3/17/17.
 */
public class NumNoResponders extends BaseFeature<Long> {

    private final EventAttendeesDAO eventAttendeesDAO;

    public NumNoResponders() {
        this("num_no_responders");
    }

    public NumNoResponders(final String name) {
        this.name = name;
        this.eventAttendeesDAO = new EventAttendeesDAO();
    }

    public void calculate(final Event event){
        final Long eventId  = event.getId();
        this.value          = new Long(eventAttendeesDAO.noResponders(eventId).size());
    }
}
