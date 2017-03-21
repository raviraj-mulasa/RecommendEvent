package net.geekscore.ml.kaggle.rec.event.dao;

import net.geekscore.ml.kaggle.rec.event.MyBatisUtil;
import net.geekscore.ml.kaggle.rec.event.data.EventAttendeePair;
import net.geekscore.ml.kaggle.rec.event.mapper.EventAttendeesMapper;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import java.util.Collections;
import java.util.List;

/**
 * Created by ravirajmulasa on 3/16/17.
 */
public class EventAttendeesDAO {

    public List<Long> mayBeResponders(Long id) {
        List<Long> mayBeResponders = Collections.emptyList();
        final SqlSession session    = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            EventAttendeesMapper mapper = session.getMapper(EventAttendeesMapper.class);
            mayBeResponders             = mapper.mayBeResponders(id);
        } finally {
            session.close();
        }
        return mayBeResponders;
    }

    public List<Long> yesResponders(Long id) {
        List<Long> yesResponders    = Collections.emptyList();
        final SqlSession session    = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            EventAttendeesMapper mapper = session.getMapper(EventAttendeesMapper.class);
            yesResponders               = mapper.yesResponders(id);
        } finally {
            session.close();
        }
        return yesResponders;
    }


    public List<Long> noResponders(Long id) {
        List<Long> noResponders     = Collections.emptyList();
        final SqlSession session    = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            EventAttendeesMapper mapper = session.getMapper(EventAttendeesMapper.class);
            noResponders                = mapper.noResponders(id);
        } finally {
            session.close();
        }
        return noResponders;
    }

    public List<Long> invitees(Long id) {
        List<Long> invitees         = Collections.emptyList();
        final SqlSession session    = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            EventAttendeesMapper mapper = session.getMapper(EventAttendeesMapper.class);
            invitees                    = mapper.invitees(id);
        } finally {
            session.close();
        }
        return invitees;
    }

    public void insertAttendeeResponse(List<EventAttendeePair> eventAttendeePairs) {
        final SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession(ExecutorType.BATCH);
        try {
            EventAttendeesMapper mapper = session.getMapper(EventAttendeesMapper.class);
            for(EventAttendeePair eventAttendeePair: eventAttendeePairs) {
                final Long eventId = eventAttendeePair.getEventId();
                final Long userId  = eventAttendeePair.getUserId();
                switch (eventAttendeePair.getResponse()) {
                    case MAYBE:
                        mapper.insertMaybeResponder(eventId, userId, true);
                        break;
                    case YES:
                        mapper.insertYesResponder(eventId, userId, true);
                        break;
                    case NO:
                        mapper.insertNoResponder(eventId, userId, true);
                        break;
                    case INVITED:
                        mapper.insertInvitee(eventId, userId, true);
                        break;
                    default:
                        break;
                }
            }
            session.commit();
        } finally {
            session.close();
        }
    }
}
