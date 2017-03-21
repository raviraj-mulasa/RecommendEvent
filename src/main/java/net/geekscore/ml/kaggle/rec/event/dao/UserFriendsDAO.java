package net.geekscore.ml.kaggle.rec.event.dao;

import net.geekscore.ml.kaggle.rec.event.MyBatisUtil;
import net.geekscore.ml.kaggle.rec.event.data.Event;
import net.geekscore.ml.kaggle.rec.event.data.UserFriendPair;
import net.geekscore.ml.kaggle.rec.event.mapper.EventMapper;
import net.geekscore.ml.kaggle.rec.event.mapper.UserFriendsMapper;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import java.util.Collections;
import java.util.List;

/**
 * Created by ravirajmulasa on 3/16/17.
 */
public class UserFriendsDAO {


    public List<Long> friends(Long id) {
        List<Long> friends = Collections.emptyList();
        final SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            UserFriendsMapper mapper    = session.getMapper(UserFriendsMapper.class);
            friends                     = mapper.friends(id);
        } finally {
            session.close();
        }
        return friends;
    }


    public void insertUserFriend(List<UserFriendPair> userFriendPairs) {
        final SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession(ExecutorType.BATCH);
        try {
            UserFriendsMapper mapper    = session.getMapper(UserFriendsMapper.class);
            for(UserFriendPair userFriendPair: userFriendPairs) {
                mapper.insertUserFriend(userFriendPair.getUserId(), userFriendPair.getFriendId());
            }
            session.commit();
        } finally {
            session.close();
        }
    }

}
