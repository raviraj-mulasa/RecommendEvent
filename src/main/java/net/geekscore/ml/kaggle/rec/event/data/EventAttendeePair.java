package net.geekscore.ml.kaggle.rec.event.data;

/**
 * Created by ravirajmulasa on 3/18/17.
 */
public final class EventAttendeePair {

    private Long eventId;

    private Long userId;

    private UserResponse response;

    public EventAttendeePair(Long eventId, Long userId, UserResponse response) {
        this.eventId  = eventId;
        this.userId   = userId;
        this.response   = response;
    }

    public Long getEventId() {
        return eventId;
    }

    public Long getUserId() {
        return userId;
    }

    public UserResponse getResponse() {
        return response;
    }
}
