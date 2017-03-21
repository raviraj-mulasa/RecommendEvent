package net.geekscore.ml.kaggle.rec.event.io;

import org.junit.Test;

/**
 * Created by ravirajmulasa on 3/18/17.
 */
public class TrainReaderTest {

    @Test
    public void testReadingUerFriends(){
        TrainReader.readTrainData("/Users/ravirajmulasa/Documents/Certificate_in_MachineLearning/Advanced_Machine_Learning/RecommendationEngine/data/train.csv");
    }
}
