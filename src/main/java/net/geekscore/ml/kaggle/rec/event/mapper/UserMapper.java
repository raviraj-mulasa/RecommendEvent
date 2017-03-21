package net.geekscore.ml.kaggle.rec.event.mapper;

import net.geekscore.ml.kaggle.rec.event.data.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * Created by ravirajmulasa on 3/16/17.
 */
public interface UserMapper {
    @Results({
            @Result(property = "id", column = "user_id"),
            @Result(property = "birthYear", column = "birthyear"),
            @Result(property = "locale", column = "locale"),
            @Result(property = "gender", column = "gender"),
            @Result(property = "location", column = "location"),
            @Result(property = "joinedAt", column = "joinedat"),
            @Result(property = "tzOffSetInMins", column = "timezone"),
    })
    @Select("SELECT " +
                "user_id" +
                ",birthyear" +
                ",locale" +
                ",gender" +
                ",location" +
                ",joinedat" +
                ",timezone" +
            " FROM public.user WHERE user_id = #{id}")
    User selectUser(Long id);



}
