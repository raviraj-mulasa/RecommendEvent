package net.geekscore.ml.kaggle.rec.event.feature;

import net.geekscore.ml.kaggle.rec.event.Util;
import net.geekscore.ml.kaggle.rec.event.dao.EventAttendeesDAO;
import net.geekscore.ml.kaggle.rec.event.dao.UserFriendsDAO;
import net.geekscore.ml.kaggle.rec.event.data.Event;
import net.geekscore.ml.kaggle.rec.event.data.User;

import java.util.List;

/**
 * Created by ravirajmulasa on 3/19/17.
 */
public class FriendsRespondedMaybeRatio extends BaseFeature<Float> {

    private final EventAttendeesDAO eventAttendeesDAO;

    private final UserFriendsDAO userFriendsDAO;

    public FriendsRespondedMaybeRatio() {
        this("friends_responded_maybe_ratio");
    }

    public FriendsRespondedMaybeRatio(final String name) {
        this.name = name;
        this.eventAttendeesDAO  = new EventAttendeesDAO();
        this.userFriendsDAO     = new UserFriendsDAO();
    }

    public void calculate(final User user, final Event event){
        final Long eventId  = event.getId();
        final Long userId   = user.getId();
        final List<Long> friends        = this.userFriendsDAO.friends(userId);
        final int numFriends            = friends.size();
        final List<Long> mayBeResponders= this.eventAttendeesDAO.mayBeResponders(eventId);

        mayBeResponders.retainAll(friends);


        if(numFriends > 0 && mayBeResponders.size() > 0) {
            final Float ratio = mayBeResponders.size() / (numFriends+0.0f);
            this.value = Float.valueOf(Util.DECIMAL_FORMAT.format(ratio));
        }else {
            this.value = 0.0f;
        }
    }
}
