package net.geekscore.ml.kaggle.rec.event.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import weka.classifiers.Classifier;
import weka.classifiers.functions.LibSVM;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;


/**
 * Created by ravirajmulasa on 3/17/17.
 */
public final class SVMEventInterestClassifier {

    private static final Logger logger       = LoggerFactory.getLogger(SVMEventInterestClassifier.class);

    private String trainingDataSourceLoc;

    private Classifier classifier;

    public SVMEventInterestClassifier(String trainingDataLoc) {
        this.trainingDataSourceLoc = trainingDataLoc;
        this.classifier = new LibSVM();
        this.init();
    }

    public final Classifier getSVMClassifier(){
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
