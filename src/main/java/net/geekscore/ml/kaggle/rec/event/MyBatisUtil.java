package net.geekscore.ml.kaggle.rec.event;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ravirajmulasa on 3/16/17.
 */
public final class MyBatisUtil {

    private static final Logger logger  = LoggerFactory.getLogger(MyBatisUtil.class);
    private static SqlSessionFactory sqlSessionFactory;
    static {
        String resource = "mybatis-config.xml";
        InputStream inputStream;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
           logger.error(e.getMessage(), e);
        }
    }
    public static final SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
}
