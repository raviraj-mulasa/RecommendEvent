package net.geekscore.ml.kaggle.rec.event.data;

import java.util.Map;

/**
 * Created by ravirajmulasa on 3/18/17.
 */
public final class UserFriendPair {

    private Long userId;

    private Long friendId;

    public UserFriendPair(Long userId, Long friendId) {
        this.userId = userId;
        this.friendId = friendId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getFriendId() {
        return friendId;
    }
}
