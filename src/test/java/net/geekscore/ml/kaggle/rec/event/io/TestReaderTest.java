package net.geekscore.ml.kaggle.rec.event.io;

import org.junit.Test;

/**
 * Created by ravirajmulasa on 3/18/17.
 */
public class TestReaderTest {

    @Test
    public void testReadingUerFriends(){
        TestReader.readTestData("/Users/ravirajmulasa/Documents/Certificate_in_MachineLearning/Advanced_Machine_Learning/RecommendationEngine/data/test.csv");
    }
}
