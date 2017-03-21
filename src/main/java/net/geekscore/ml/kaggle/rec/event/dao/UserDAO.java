package net.geekscore.ml.kaggle.rec.event.dao;

import net.geekscore.ml.kaggle.rec.event.MyBatisUtil;
import net.geekscore.ml.kaggle.rec.event.data.User;
import net.geekscore.ml.kaggle.rec.event.mapper.EventMapper;
import net.geekscore.ml.kaggle.rec.event.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by ravirajmulasa on 3/16/17.
 */
public class UserDAO {

    public User getUserById(Long id) {
        User user = null;
        final SqlSession session= MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            UserMapper mapper   = session.getMapper(UserMapper.class);
            user                = mapper.selectUser(id);
        } finally {
            session.close();
        }
        return user;
    }
}
