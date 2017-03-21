package net.geekscore.ml.kaggle.rec.event.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by ravirajmulasa on 3/16/17.
 */
public interface UserFriendsMapper {

    @Select("SELECT" +
                " friend_user_id" +
            " FROM public.user_friends" +
            " WHERE user_id = #{id}"
    )
    List<Long> friends(Long id);


    @Insert("INSERT into public.user_friends(user_id, friend_user_id) VALUES(#{user_id}, #{friend_user_id})")
    void insertUserFriend(@Param("user_id") Long user_id, @Param("friend_user_id") Long friend_user_id);

}
