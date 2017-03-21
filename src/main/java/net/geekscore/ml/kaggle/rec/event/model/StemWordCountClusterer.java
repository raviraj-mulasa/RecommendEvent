package net.geekscore.ml.kaggle.rec.event.model;

import net.geekscore.ml.kaggle.rec.event.dao.EventDAO;
import net.geekscore.ml.kaggle.rec.event.data.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import weka.clusterers.SimpleKMeans;
import weka.core.*;

import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by ravirajmulasa on 3/17/17.
 */
public final class StemWordCountClusterer {


    private static final Logger logger                = LoggerFactory.getLogger(StemWordCountClusterer.class);
    private static StemWordCountClusterer _instance   = null;


    private final int MAX_PAGE_SIZE             = 25000;
    private final Integer randomPageNos[]       = {1, 10, 25, 36, 44, 52, 67, 78, 89, 93, 105, 117, 125};
    private final Set<Integer> randomPageNoSet  = new HashSet<>(Arrays.asList(randomPageNos));
    private final List<Attribute> attrList      = new ArrayList<Attribute>(103);

    private EventDAO eventDAO;
    private SimpleKMeans kMeansClusterer;
    private DistanceFunction distanceFunction;
    private int numClusters;


    public static final StemWordCountClusterer getInstance(final int numClusters, DistanceFunction distanceFunction) {
        if(null == _instance) {
            _instance = new StemWordCountClusterer(numClusters, distanceFunction);
        }
        return _instance;
    }

    public static final StemWordCountClusterer getInstance() {
        if(null == _instance) {
            _instance = new StemWordCountClusterer();
        }
        return _instance;
    }

    private StemWordCountClusterer(){this.eventDAO = new EventDAO();this.init();}

    private StemWordCountClusterer(final int numClusters, DistanceFunction distanceFunction){
        this.eventDAO        = new EventDAO();
        this.kMeansClusterer = new SimpleKMeans();
        this.distanceFunction= distanceFunction;
        this.numClusters     = numClusters;
        this.init();
    }

    public void buildCluster(){
        Instances data = null;
        try {
            this.kMeansClusterer.setDistanceFunction(this.distanceFunction);
            this.kMeansClusterer.setNumClusters(numClusters);
            this.kMeansClusterer.numberOfClusters();
            data = this.data2BuildCluster();
            this.kMeansClusterer.buildClusterer(data);
            logger.info("No of Clusters - {}", this.kMeansClusterer.numberOfClusters());
        } catch (Exception e) {
           logger.error(e.getMessage(), e);
        }
    }

    public void setSimpleKMeans(SimpleKMeans simpleKMeans) {
       this.kMeansClusterer = simpleKMeans;
    }

    public final SimpleKMeans getSimpleKMeans() {
        return this.kMeansClusterer;
    }


    public final int assignCluster(Instance instance){
        int cluster = Integer.MIN_VALUE;
        try {
            Instances data = new Instances("K_Means_Word_Stem", (ArrayList<Attribute>) attrList, 0);
            instance.setDataset(data);
            cluster = this.kMeansClusterer.clusterInstance(instance);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return cluster;
    }


    public final Instance createInstance(final Event event){

        Instance instance = new SparseInstance(103);
        instance.setValue(attrList.get(0), event.getC_1());
        instance.setValue(attrList.get(1), event.getC_2());
        instance.setValue(attrList.get(2), event.getC_3());
        instance.setValue(attrList.get(3), event.getC_4());
        instance.setValue(attrList.get(4), event.getC_5());
        instance.setValue(attrList.get(5), event.getC_6());
        instance.setValue(attrList.get(6), event.getC_7());
        instance.setValue(attrList.get(7), event.getC_8());
        instance.setValue(attrList.get(8), event.getC_9());
        instance.setValue(attrList.get(9), event.getC_10());
        instance.setValue(attrList.get(10), event.getC_11());
        instance.setValue(attrList.get(11), event.getC_12());
        instance.setValue(attrList.get(12), event.getC_13());
        instance.setValue(attrList.get(13), event.getC_14());
        instance.setValue(attrList.get(14), event.getC_15());
        instance.setValue(attrList.get(15), event.getC_16());
        instance.setValue(attrList.get(16), event.getC_17());
        instance.setValue(attrList.get(17), event.getC_18());
        instance.setValue(attrList.get(18), event.getC_19());
        instance.setValue(attrList.get(19), event.getC_20());
        instance.setValue(attrList.get(20), event.getC_21());
        instance.setValue(attrList.get(21), event.getC_22());
        instance.setValue(attrList.get(22), event.getC_23());
        instance.setValue(attrList.get(23), event.getC_24());
        instance.setValue(attrList.get(24), event.getC_25());
        instance.setValue(attrList.get(25), event.getC_26());
        instance.setValue(attrList.get(26), event.getC_27());
        instance.setValue(attrList.get(27), event.getC_28());
        instance.setValue(attrList.get(28), event.getC_29());
        instance.setValue(attrList.get(29), event.getC_30());
        instance.setValue(attrList.get(30), event.getC_31());
        instance.setValue(attrList.get(31), event.getC_32());
        instance.setValue(attrList.get(32), event.getC_33());
        instance.setValue(attrList.get(33), event.getC_34());
        instance.setValue(attrList.get(34), event.getC_35());
        instance.setValue(attrList.get(35), event.getC_36());
        instance.setValue(attrList.get(36), event.getC_37());
        instance.setValue(attrList.get(37), event.getC_38());
        instance.setValue(attrList.get(38), event.getC_39());
        instance.setValue(attrList.get(39), event.getC_40());
        instance.setValue(attrList.get(40), event.getC_41());
        instance.setValue(attrList.get(41), event.getC_42());
        instance.setValue(attrList.get(42), event.getC_43());
        instance.setValue(attrList.get(43), event.getC_44());
        instance.setValue(attrList.get(44), event.getC_45());
        instance.setValue(attrList.get(45), event.getC_46());
        instance.setValue(attrList.get(46), event.getC_47());
        instance.setValue(attrList.get(47), event.getC_48());
        instance.setValue(attrList.get(48), event.getC_49());
        instance.setValue(attrList.get(49), event.getC_50());
        instance.setValue(attrList.get(50), event.getC_51());
        instance.setValue(attrList.get(51), event.getC_52());
        instance.setValue(attrList.get(52), event.getC_53());
        instance.setValue(attrList.get(53), event.getC_54());
        instance.setValue(attrList.get(54), event.getC_55());
        instance.setValue(attrList.get(55), event.getC_56());
        instance.setValue(attrList.get(56), event.getC_57());
        instance.setValue(attrList.get(57), event.getC_58());
        instance.setValue(attrList.get(58), event.getC_59());
        instance.setValue(attrList.get(59), event.getC_60());
        instance.setValue(attrList.get(60), event.getC_61());
        instance.setValue(attrList.get(61), event.getC_62());
        instance.setValue(attrList.get(62), event.getC_63());
        instance.setValue(attrList.get(63), event.getC_64());
        instance.setValue(attrList.get(64), event.getC_65());
        instance.setValue(attrList.get(65), event.getC_66());
        instance.setValue(attrList.get(66), event.getC_67());
        instance.setValue(attrList.get(67), event.getC_68());
        instance.setValue(attrList.get(68), event.getC_69());
        instance.setValue(attrList.get(69), event.getC_70());
        instance.setValue(attrList.get(70), event.getC_71());
        instance.setValue(attrList.get(71), event.getC_72());
        instance.setValue(attrList.get(72), event.getC_73());
        instance.setValue(attrList.get(73), event.getC_74());
        instance.setValue(attrList.get(74), event.getC_75());
        instance.setValue(attrList.get(75), event.getC_76());
        instance.setValue(attrList.get(76), event.getC_77());
        instance.setValue(attrList.get(77), event.getC_78());
        instance.setValue(attrList.get(78), event.getC_79());
        instance.setValue(attrList.get(79), event.getC_80());
        instance.setValue(attrList.get(80), event.getC_81());
        instance.setValue(attrList.get(81), event.getC_82());
        instance.setValue(attrList.get(82), event.getC_83());
        instance.setValue(attrList.get(83), event.getC_84());
        instance.setValue(attrList.get(84), event.getC_85());
        instance.setValue(attrList.get(85), event.getC_86());
        instance.setValue(attrList.get(86), event.getC_87());
        instance.setValue(attrList.get(87), event.getC_88());
        instance.setValue(attrList.get(88), event.getC_89());
        instance.setValue(attrList.get(89), event.getC_90());
        instance.setValue(attrList.get(90), event.getC_91());
        instance.setValue(attrList.get(91), event.getC_92());
        instance.setValue(attrList.get(92), event.getC_93());
        instance.setValue(attrList.get(93), event.getC_94());
        instance.setValue(attrList.get(94), event.getC_95());
        instance.setValue(attrList.get(95), event.getC_96());
        instance.setValue(attrList.get(96), event.getC_97());
        instance.setValue(attrList.get(97), event.getC_98());
        instance.setValue(attrList.get(98), event.getC_99());
        instance.setValue(attrList.get(99), event.getC_100());

        instance.setValue(attrList.get(100), event.getC_other());

        final Float latitude = event.getLatitude();
        instance.setValue(attrList.get(101), latitude == null ? 0.0f : latitude);
        final Float longitude = event.getLongitude();
        instance.setValue(attrList.get(102), longitude == null ? 0.0f : longitude);
        return instance;
    }



    private void init(){
        // Word Count
        Attribute attribute;
        for (int i = 1; i <= 100; i++) {
            attribute = new Attribute(String.format("c_%s", i));
            attrList.add(attribute);
        }
        attribute = new Attribute("c_other");
        attrList.add(attribute);

//        Lat and Long

        final Attribute latAttr =   new Attribute("ltd");
        final Attribute lngAttr =   new Attribute("lng");
        attrList.add(latAttr);
        attrList.add(lngAttr);

    }

    private Instances data2BuildCluster() throws Exception {
        List<Event> eventList = Collections.emptyList();
        Instance instance     = null;
        final Instances data = new Instances(
                "K_Means_Word_Stem"
                , (ArrayList<Attribute>) attrList
                , randomPageNos.length * MAX_PAGE_SIZE
        );
        for(Integer pageNo: randomPageNoSet) {
            eventList = eventDAO.selectByPage(pageNo, MAX_PAGE_SIZE);
            logger.info("Building cluster from {} to {}", (pageNo - 1) * MAX_PAGE_SIZE, (pageNo - 1) * MAX_PAGE_SIZE + eventList.size());
            for(Event event: eventList) {
                instance = this.createInstance(event);
                data.add(instance);
            }
        }
        return data;
    }






}
