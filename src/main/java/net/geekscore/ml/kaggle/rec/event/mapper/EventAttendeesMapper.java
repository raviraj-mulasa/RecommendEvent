package net.geekscore.ml.kaggle.rec.event.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by ravirajmulasa on 3/16/17.
 */
public interface EventAttendeesMapper {

    @Select("SELECT" +
                " user_id" +
            " FROM public.event_attendees" +
            " WHERE maybe" +
            "   AND event_id = #{id}"
    )
    List<Long> mayBeResponders(Long id);


    @Select("SELECT" +
            " user_id" +
            " FROM public.event_attendees" +
            " WHERE yes" +
            "   AND event_id = #{id}"
    )
    List<Long> yesResponders(Long id);


    @Select("SELECT" +
            " user_id" +
            " FROM public.event_attendees" +
            " WHERE no" +
            "   AND event_id = #{id}"
    )
    List<Long> noResponders(Long id);

    @Select("SELECT" +
            " user_id" +
            " FROM public.event_attendees" +
            " WHERE invited" +
            "   AND event_id = #{id}"
    )
    List<Long> invitees(Long id);


    @Insert("INSERT into public.event_attendees(event_id, user_id, invited) VALUES(#{event_id}, #{user_id}, #{invited})")
    void insertInvitee(@Param("event_id") Long event_id, @Param("user_id") Long user_id, @Param("invited") Boolean invited);

    @Insert("INSERT into public.event_attendees(event_id, user_id, yes) VALUES(#{event_id}, #{user_id}, #{yes})")
    void insertYesResponder(@Param("event_id") Long event_id, @Param("user_id") Long user_id, @Param("yes") Boolean yes);

    @Insert("INSERT into public.event_attendees(event_id, user_id, no) VALUES(#{event_id}, #{user_id}, #{no})")
    void insertNoResponder(@Param("event_id") Long event_id, @Param("user_id") Long user_id, @Param("no") Boolean no);

    @Insert("INSERT into public.event_attendees(event_id, user_id, maybe) VALUES(#{event_id}, #{user_id}, #{maybe})")
    void insertMaybeResponder(@Param("event_id") Long event_id, @Param("user_id") Long user_id, @Param("maybe") Boolean maybe);

}
