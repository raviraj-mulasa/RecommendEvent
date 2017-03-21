package net.geekscore.ml.kaggle.rec.event.feature;

import net.geekscore.ml.kaggle.rec.event.dao.EventDAO;
import net.geekscore.ml.kaggle.rec.event.dao.UserDAO;
import net.geekscore.ml.kaggle.rec.event.data.Event;
import net.geekscore.ml.kaggle.rec.event.data.User;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ravirajmulasa on 3/19/17.
 */
public class UserAgeInDaysTest {

    private UserDAO userDAO;

    @Before
    public void setUpEventDAO(){
        if(null == userDAO) {
            userDAO = new UserDAO();
        }
    }

    @Test
    public void test(){
        final User user = userDAO.getUserById(851286067L);
        final UserAgeInDays userAgeInDays = new UserAgeInDays();
        userAgeInDays.calculate(user);

    }

}
