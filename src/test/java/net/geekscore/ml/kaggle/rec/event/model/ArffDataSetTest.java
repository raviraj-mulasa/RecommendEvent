package net.geekscore.ml.kaggle.rec.event.model;

import org.junit.Test;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Created by ravirajmulasa on 3/19/17.
 */
public class ArffDataSetTest {

    @Test
    public void testTrainData() {
        Instances filteredData = null;

        ConverterUtils.DataSource dataSource = null;
        Instances data = null;
        try {
            dataSource = new ConverterUtils.DataSource("/Users/ravirajmulasa/Documents/Certificate_in_MachineLearning/Advanced_Machine_Learning/RecommendationEngine/models/train_feature.arff");
            data = dataSource.getDataSet();
            Remove remove  = new Remove();
            remove.setAttributeIndices("1,2,16");
            remove.setInvertSelection(false);
            remove.setInputFormat(data);
            filteredData = Filter.useFilter(data, remove);
            filteredData.randomize(new java.util.Random(0));
            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/ravirajmulasa/Documents/Certificate_in_MachineLearning/Advanced_Machine_Learning/RecommendationEngine/models/train_feature_final.arff"));
            writer.write(filteredData.toString());
            writer.flush();
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testTestData() {
        Instances filteredData = null;

        ConverterUtils.DataSource dataSource = null;
        Instances data = null;
        try {
            dataSource = new ConverterUtils.DataSource("/Users/ravirajmulasa/Documents/Certificate_in_MachineLearning/Advanced_Machine_Learning/RecommendationEngine/models/test_feature.arff");
            data = dataSource.getDataSet();
            Remove remove  = new Remove();
            remove.setAttributeIndices("1,2");
            remove.setInvertSelection(false);
            remove.setInputFormat(data);
            filteredData = Filter.useFilter(data, remove);
            filteredData.randomize(new java.util.Random(0));
            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/ravirajmulasa/Documents/Certificate_in_MachineLearning/Advanced_Machine_Learning/RecommendationEngine/models/test_feature_final.arff"));
            writer.write(filteredData.toString());
            writer.flush();
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
