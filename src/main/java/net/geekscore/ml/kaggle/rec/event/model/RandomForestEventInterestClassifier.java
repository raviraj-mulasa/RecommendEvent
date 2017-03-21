package net.geekscore.ml.kaggle.rec.event.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import weka.classifiers.Classifier;
import weka.classifiers.trees.RandomForest;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

/**
 * Created by ravirajmulasa on 3/19/17.
 */
public class RandomForestEventInterestClassifier {

    private static final Logger logger  = LoggerFactory.getLogger(RandomForestEventInterestClassifier.class);

    private String trainingDataSourceLoc;

    private Classifier classifier;

    public RandomForestEventInterestClassifier(String trainingDataLoc, int maxDepth) {
        this.trainingDataSourceLoc = trainingDataLoc;
        this.classifier = new RandomForest();
        ((RandomForest)this.classifier).setMaxDepth(maxDepth);
        this.init();
    }

    public final Classifier getRFClassifier(){
        return this.classifier;
    }

    private void init() {
        buildModel();
    }


    private  void buildModel() {
        final Instances data = this.prepareData();
        if(null != data) {
            if (data.classIndex() == -1) {
                data.setClassIndex(data.numAttributes() - 1);
            }
            try {
                this.classifier.buildClassifier(data);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    private Instances prepareData(){
        ConverterUtils.DataSource dataSource = null;
        Instances data = null;
        try {
            dataSource = new ConverterUtils.DataSource(this.trainingDataSourceLoc);
            data = dataSource.getDataSet();
            data.randomize(new java.util.Random(0));

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return data;
    }
}
