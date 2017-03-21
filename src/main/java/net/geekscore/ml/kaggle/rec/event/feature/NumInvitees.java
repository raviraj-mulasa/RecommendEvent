package net.geekscore.ml.kaggle.rec.event.feature;

import net.geekscore.ml.kaggle.rec.event.dao.EventAttendeesDAO;
import net.geekscore.ml.kaggle.rec.event.data.Event;

import java.util.List;

/**
 * Created by ravirajmulasa on 3/17/17.
 */
public class NumInvitees extends BaseFeature<Long> {

    private final EventAttendeesDAO eventAttendeesDAO;

    public NumInvitees() {
        this("num_invitees");
    }

    public NumInvitees(final String name) {
        this.name = name;
        this.eventAttendeesDAO = new EventAttendeesDAO();
    }

    public void calculate(final Event event){
        final Long eventId  = event.getId();
        this.value          = new Long(eventAttendeesDAO.invitees(eventId).size());
    }
}
