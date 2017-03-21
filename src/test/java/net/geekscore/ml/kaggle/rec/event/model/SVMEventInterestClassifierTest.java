package net.geekscore.ml.kaggle.rec.event.model;

import net.geekscore.ml.kaggle.rec.event.Util;
import org.junit.Before;
import org.junit.Test;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.LibSVM;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ConverterUtils;

import java.io.File;
import java.util.Random;


/**
 * Created by ravirajmulasa on 3/19/17.
 */
public class SVMEventInterestClassifierTest {

    private static Classifier classifier;

    @Before
    public void setUpClassifier(){
        final File file = new File("/Users/ravirajmulasa/Documents/Certificate_in_MachineLearning/Advanced_Machine_Learning/RecommendationEngine/models/svm_classifier");
        if(file.exists()) {
            try {
                classifier = (LibSVM) SerializationHelper.read(file.getAbsolutePath().toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else{
            try {
                final SVMEventInterestClassifier svmEventInterestClassifier = new SVMEventInterestClassifier("/Users/ravirajmulasa/Documents/Certificate_in_MachineLearning/Advanced_Machine_Learning/RecommendationEngine/models/train_feature_final.arff");
                classifier = svmEventInterestClassifier.getSVMClassifier();
                SerializationHelper.write(file.getAbsolutePath().toString(), classifier);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void testBuildAndCrossValidate(){


        ConverterUtils.DataSource dataSource = null;
        Instances data = null;
        try {
            dataSource = new ConverterUtils.DataSource("/Users/ravirajmulasa/Documents/Certificate_in_MachineLearning/Advanced_Machine_Learning/RecommendationEngine/models/train_feature_final.arff");
            data = dataSource.getDataSet();
            data.randomize(new java.util.Random(0));
            if (data.classIndex() == -1) {
                data.setClassIndex(data.numAttributes() - 1);
            }

            Evaluation evaluation = new Evaluation(data);
            evaluation.crossValidateModel(classifier, data, 10, new Random(1));

            System.out.println(evaluation.toSummaryString("\nResults\n======\n", true));
            System.out.println(evaluation.toClassDetailsString());
            System.out.println("Results For Interested ");
            System.out.println("Precision=  " + evaluation.precision(0));
            System.out.println("Recall=  " + evaluation.recall(0));
            System.out.println("F-measure=  " + evaluation.fMeasure(0));

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    public void predictionsTestData() {

        ConverterUtils.DataSource dataSource = null;
        Instances data = null;
        try {
            dataSource = new ConverterUtils.DataSource("/Users/ravirajmulasa/Documents/Certificate_in_MachineLearning/Advanced_Machine_Learning/RecommendationEngine/models/test_feature_final.arff");
            data = dataSource.getDataSet();
            if (data.classIndex() == -1) {
                data.setClassIndex(data.numAttributes() - 1);
            }
            Evaluation evaluation = new Evaluation(data);
            evaluation.evaluateModel(classifier, data);
            System.out.println(Util.COMMA_JOINER.join(evaluation.predictions()));
            System.out.println(evaluation.toSummaryString("\nResults\n======\n", true));
            System.out.println(evaluation.toClassDetailsString());
            System.out.println("Results For Interested ");
            System.out.println("Precision=  " + evaluation.precision(0));
            System.out.println("Recall=  " + evaluation.recall(0));
            System.out.println("F-measure=  " + evaluation.fMeasure(0));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
