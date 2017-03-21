package net.geekscore.ml.kaggle.rec.event.data;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import net.geekscore.ml.kaggle.rec.event.Util;
import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by ravirajmulasa on 3/15/17.
 */
public final class User implements Serializable {

    private Long id;

    private String locale;

    private int birthYear;

    private String gender;

    private String joinedAt;

    private String location;

    private int tzOffSetInMins;

    public User(){}

    public User(Long id, String locale, int birthYear, String gender, String joinedAt, String location, int tzOffSetInMins) {
        this.id             = id;
        this.locale         = locale;
        this.birthYear      = birthYear;
        this.gender         = gender;
        this.joinedAt       = joinedAt;
        this.location       = location;
        this.tzOffSetInMins = tzOffSetInMins;
    }

    public Long getId() {
        return id;
    }

    public String getLocale() {
        return locale;
    }

    public int getBirthYear() {
        return birthYear;
    }



    public String getJoinedAt() {
        return joinedAt;
    }

    public String getLocation() {
        return location;
    }

    public int getTzOffSetInMins() {
        return tzOffSetInMins;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void setJoinedAt(String joinedAt) {
        this.joinedAt = joinedAt;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTzOffSetInMins(int tzOffSetInMins) {
        this.tzOffSetInMins = tzOffSetInMins;
    }

    public boolean isFemale() {
        return this.gender.equals("female");
    }

//    private Set<User> friends = Sets.newHashSet();
//
//    private Set<Event> createdEvents = Sets.newHashSet();
//
//
//    public void setFriends(Set<User> friends) {
//        this.friends = friends;
//    }
//
//    public void setCreatedEvents(Set<Event> createdEvents) {
//        this.createdEvents = createdEvents;
//    }
//
//    public final Set<User> friends(){
//        return this.friends;
//    }
//
//    public void addFriend(final User user){
//        this.friends.add(user);
//    }
//
//    public final boolean isFriend(final User user){
//        return this.friends.contains(user);
//    }
//
//    public final Set<Event> createdEvents(){
//        return this.createdEvents;
//    }
//
//    public void addCreatedEvent(final Event event){
//        this.createdEvents.add(event);
//    }
//
//    public final boolean isEventCreatedbyUser(final Event event){
//        return this.createdEvents.contains(event);
//    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return birthYear == user.birthYear &&
                gender == user.gender &&
                tzOffSetInMins == user.tzOffSetInMins &&
                Objects.equal(id, user.id) &&
                Objects.equal(locale, user.locale) &&
                Objects.equal(joinedAt, user.joinedAt) &&
                Objects.equal(location, user.location);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, locale, birthYear, gender, joinedAt, location, tzOffSetInMins);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", locale='" + locale + '\'' +
                ", birthYear=" + birthYear +
                ", gender=" + gender +
                ", joinedAt=" + joinedAt +
                ", location='" + location + '\'' +
                ", tzOffSetInMins=" + tzOffSetInMins +
                '}';
    }
}
