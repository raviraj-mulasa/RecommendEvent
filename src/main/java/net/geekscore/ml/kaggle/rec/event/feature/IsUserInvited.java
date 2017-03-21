package net.geekscore.ml.kaggle.rec.event.feature;

import net.geekscore.ml.kaggle.rec.event.dao.EventAttendeesDAO;
import net.geekscore.ml.kaggle.rec.event.data.Event;
import net.geekscore.ml.kaggle.rec.event.data.User;

import java.util.List;

/**
 * Created by ravirajmulasa on 3/17/17.
 */
public class IsUserInvited extends  BaseFeature<Boolean> {

    private final EventAttendeesDAO eventAttendeesDAO;

    public IsUserInvited() {
        this("is_user_invited");
    }

    public IsUserInvited(final String name) {
        this.eventAttendeesDAO  = new EventAttendeesDAO();
        this.name               = name;
    }

    public void calculate(final Event event, final User user){
        final Long eventId          = event.getId();
        final Long userId           = user.getId();
        final List<Long> invitees   = eventAttendeesDAO.invitees(eventId);
        this.value = invitees.contains(userId);
    }
}
