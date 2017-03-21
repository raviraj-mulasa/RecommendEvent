package net.geekscore.ml.kaggle.rec.event.feature;

import net.geekscore.ml.kaggle.rec.event.dao.EventAttendeesDAO;
import net.geekscore.ml.kaggle.rec.event.data.Event;

/**
 * Created by ravirajmulasa on 3/17/17.
 */
public class NumYesResponders extends BaseFeature<Long> {

    private final EventAttendeesDAO eventAttendeesDAO;

    public NumYesResponders() {
        this("num_yes_responders");
    }
    public NumYesResponders(final String name) {
        this.name = name;
        this.eventAttendeesDAO = new EventAttendeesDAO();
    }

    public void calculate(final Event event){
        final Long eventId  = event.getId();
        this.value          = new Long(eventAttendeesDAO.mayBeResponders(eventId).size());
    }
}
