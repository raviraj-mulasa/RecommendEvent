package net.geekscore.ml.kaggle;

import net.geekscore.ml.kaggle.rec.event.model.StemWordCountClusterer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import weka.core.EuclideanDistance;

/**
 * Created by ravirajmulasa on 2/4/17.
 */
public class Main {

    private static final Logger logger  = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {


//        UserReader.readUsers("/Users/ravirajmulasa/Documents/Certificate_in_MachineLearning/Advanced_Machine_Learning/RecommendationEngine/data/users.csv");
//        UserReader.readUserFriends("/Users/ravirajmulasa/Documents/Certificate_in_MachineLearning/Advanced_Machine_Learning/RecommendationEngine/data/user_friends.csv");
//        EventReader.readEvents("/Users/ravirajmulasa/Documents/Certificate_in_MachineLearning/Advanced_Machine_Learning/RecommendationEngine/data/events.csv");
//        EventReader.readEventAttendees("/Users/ravirajmulasa/Documents/Certificate_in_MachineLearning/Advanced_Machine_Learning/RecommendationEngine/data/event_attendees.csv");

//        UserDAO userDAO = new UserDAO();
//        User user = userDAO.getUserById(3429017717L);
//        logger.info(user.toString());
//        EventDAO eventDAO = new EventDAO();
//        Event event = eventDAO.getEventById(3928440935L);
//        logger.info(event.toString());
//        logger.info("{}", event.getCluster());
//        event.setCluster(10000);
//        eventDAO.updateEventCluster(event);
//        logger.info("{}", event.getCluster());
//
//        int pageNo = 1;
//        List<Event> eventList = Collections.emptyList();
//        while(true) {
//            eventList = eventDAO.selectByPage(pageNo, 10000);
//            logger.info("Displaying {} to {}", (pageNo - 1) * 10000, eventList.size());
//            for(Event event1: eventList) {
////                logger.info(event1.toString());
//            }
//            pageNo += 1;
//            if(eventList.size() < 10000){
//                break;
//            }
//        }

        StemWordCountClusterer stemWordCountClusterer = StemWordCountClusterer.getInstance(30, new EuclideanDistance());
        stemWordCountClusterer.buildCluster();



    }

}
