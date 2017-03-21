package net.geekscore.ml.kaggle.rec.event.dao;

import net.geekscore.ml.kaggle.rec.event.MyBatisUtil;
import net.geekscore.ml.kaggle.rec.event.data.Event;
import net.geekscore.ml.kaggle.rec.event.mapper.EventMapper;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by ravirajmulasa on 3/16/17.
 */
public class EventDAO {

    public Event getEventById(Long id) {
        Event event = null;
        final SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            EventMapper mapper  = session.getMapper(EventMapper.class);
            event               = mapper.selectEvent(id);
        } finally {
            session.close();
        }
        return event;
    }

    public void updateEventCluster(Event event){
        final SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            EventMapper mapper  = session.getMapper(EventMapper.class);
            mapper.updateEventCluster(event);
            session.commit();
            return;
        } finally {
            session.close();
        }
    }

    public List<Event> selectByPage(final int pageNo, final int pageSize){
        final SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            EventMapper mapper  = session.getMapper(EventMapper.class);
            return mapper.selectEvents(pageSize, (pageNo - 1) * pageSize);
        } finally {
            session.close();
        }
    }

//    public void updateBatch(Event event){
//        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
//        VillageMapper mapper = session.getMapper(VillageMapper.class);
//        mapper.updateVillage(village);
//        session.commit();
//        session.close();
//    }
}
