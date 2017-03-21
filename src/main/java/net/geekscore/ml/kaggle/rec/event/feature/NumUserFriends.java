package net.geekscore.ml.kaggle.rec.event.feature;

import net.geekscore.ml.kaggle.rec.event.Util;
import net.geekscore.ml.kaggle.rec.event.dao.UserFriendsDAO;

/**
 * Created by ravirajmulasa on 3/17/17.
 */
public class NumUserFriends extends BaseFeature<Long> {

    private final UserFriendsDAO userFriendsDAO;

    public NumUserFriends() {
        this("num_friends");
    }
    public NumUserFriends(final String name) {
        this.name = name;
        this.userFriendsDAO = new UserFriendsDAO();
    }

    public void calculate(Long userId) {
        this.value = Util.USER_NUM_FRIENDS_CACHE.get(userId);
        if(null == this.value) {
            this.value = new Long(this.userFriendsDAO.friends(userId).size());
            Util.USER_NUM_FRIENDS_CACHE.put(userId, this.value);
        }
    }
}
