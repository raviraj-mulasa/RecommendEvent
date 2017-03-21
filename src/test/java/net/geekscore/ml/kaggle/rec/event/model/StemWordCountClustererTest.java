package net.geekscore.ml.kaggle.rec.event.model;

import net.geekscore.ml.kaggle.rec.event.dao.EventDAO;
import net.geekscore.ml.kaggle.rec.event.data.Event;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import weka.classifiers.functions.LibSVM;
import weka.clusterers.SimpleKMeans;
import weka.core.EuclideanDistance;
import weka.core.Instance;
import weka.core.SerializationHelper;

import java.io.File;

/**
 * Created by ravirajmulasa on 3/17/17.
 */
public class StemWordCountClustererTest {

    private static StemWordCountClusterer stemWordCountClusterer;

    private EventDAO eventDAO;

    @BeforeClass
    public static void setUpClusterer() {
        final File file = new File("/Users/ravirajmulasa/Documents/Certificate_in_MachineLearning/Advanced_Machine_Learning/RecommendationEngine/models/KMeans_50_Eucledian_c1_100_other_lat_lng");
        if(file.exists()) {
            try {
                final SimpleKMeans simpleKMeans = (SimpleKMeans) SerializationHelper.read(file.getAbsolutePath().toString());
                stemWordCountClusterer = StemWordCountClusterer.getInstance();
                stemWordCountClusterer.setSimpleKMeans(simpleKMeans);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else{
            try {
                stemWordCountClusterer = StemWordCountClusterer.getInstance(50, new EuclideanDistance());
                stemWordCountClusterer.buildCluster();
                SerializationHelper.write(file.getAbsolutePath().toString(), stemWordCountClusterer.getSimpleKMeans());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Before
    public void setUpEventDAO(){
        if(null == eventDAO) {
            eventDAO = new EventDAO();
        }
    }

    @Test
    public void test_1_Cluster_Assignment() {
        LibSVM sv = new LibSVM();
        Event event = eventDAO.getEventById(2688888297l);
        final Instance instance = stemWordCountClusterer.createInstance(event);
        final int cluster       = stemWordCountClusterer.assignCluster(instance);
        Assert.assertTrue(1000 != cluster && 0 <= cluster && 50 >= cluster);
    }

}
