package net.geekscore.ml.kaggle.rec.event.mapper;

import net.geekscore.ml.kaggle.rec.event.data.Event;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * Created by ravirajmulasa on 3/17/17.
 */
public interface EventMapper {

    @Results({
            @Result(property = "id", column = "event_id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "startTime", column = "start_time"),
            @Result(property = "city", column = "city"),
            @Result(property = "state", column = "state"),
            @Result(property = "zip", column = "zip"),
            @Result(property = "country", column = "country"),
            @Result(property = "latitude", column = "lat"),
            @Result(property = "longitude", column = "lng"),
            @Result(property = "c_1", column = "c_1"),
            @Result(property = "c_2", column = "c_2"),
            @Result(property = "c_3", column = "c_3"),
            @Result(property = "c_4", column = "c_4"),
            @Result(property = "c_5", column = "c_5"),
            @Result(property = "c_6", column = "c_6"),
            @Result(property = "c_7", column = "c_7"),
            @Result(property = "c_8", column = "c_8"),
            @Result(property = "c_9", column = "c_9"),
            @Result(property = "c_10", column = "c_10"),
            @Result(property = "c_11", column = "c_11"),
            @Result(property = "c_12", column = "c_12"),
            @Result(property = "c_13", column = "c_13"),
            @Result(property = "c_14", column = "c_14"),
            @Result(property = "c_15", column = "c_15"),
            @Result(property = "c_16", column = "c_16"),
            @Result(property = "c_17", column = "c_17"),
            @Result(property = "c_18", column = "c_18"),
            @Result(property = "c_19", column = "c_19"),
            @Result(property = "c_20", column = "c_20"),
            @Result(property = "c_21", column = "c_21"),
            @Result(property = "c_22", column = "c_22"),
            @Result(property = "c_23", column = "c_23"),
            @Result(property = "c_24", column = "c_24"),
            @Result(property = "c_25", column = "c_25"),
            @Result(property = "c_26", column = "c_26"),
            @Result(property = "c_27", column = "c_27"),
            @Result(property = "c_28", column = "c_28"),
            @Result(property = "c_29", column = "c_29"),
            @Result(property = "c_30", column = "c_30"),
            @Result(property = "c_31", column = "c_31"),
            @Result(property = "c_32", column = "c_32"),
            @Result(property = "c_33", column = "c_33"),
            @Result(property = "c_34", column = "c_34"),
            @Result(property = "c_35", column = "c_35"),
            @Result(property = "c_36", column = "c_36"),
            @Result(property = "c_37", column = "c_37"),
            @Result(property = "c_38", column = "c_38"),
            @Result(property = "c_39", column = "c_39"),
            @Result(property = "c_40", column = "c_40"),
            @Result(property = "c_41", column = "c_41"),
            @Result(property = "c_42", column = "c_42"),
            @Result(property = "c_43", column = "c_43"),
            @Result(property = "c_44", column = "c_44"),
            @Result(property = "c_45", column = "c_45"),
            @Result(property = "c_46", column = "c_46"),
            @Result(property = "c_47", column = "c_47"),
            @Result(property = "c_48", column = "c_48"),
            @Result(property = "c_49", column = "c_49"),
            @Result(property = "c_50", column = "c_50"),
            @Result(property = "c_51", column = "c_51"),
            @Result(property = "c_52", column = "c_52"),
            @Result(property = "c_53", column = "c_53"),
            @Result(property = "c_54", column = "c_54"),
            @Result(property = "c_55", column = "c_55"),
            @Result(property = "c_56", column = "c_56"),
            @Result(property = "c_57", column = "c_57"),
            @Result(property = "c_58", column = "c_58"),
            @Result(property = "c_59", column = "c_59"),
            @Result(property = "c_60", column = "c_60"),
            @Result(property = "c_61", column = "c_61"),
            @Result(property = "c_62", column = "c_62"),
            @Result(property = "c_63", column = "c_63"),
            @Result(property = "c_64", column = "c_64"),
            @Result(property = "c_65", column = "c_65"),
            @Result(property = "c_66", column = "c_66"),
            @Result(property = "c_67", column = "c_67"),
            @Result(property = "c_68", column = "c_68"),
            @Result(property = "c_69", column = "c_69"),
            @Result(property = "c_70", column = "c_70"),
            @Result(property = "c_71", column = "c_71"),
            @Result(property = "c_72", column = "c_72"),
            @Result(property = "c_73", column = "c_73"),
            @Result(property = "c_74", column = "c_74"),
            @Result(property = "c_75", column = "c_75"),
            @Result(property = "c_76", column = "c_76"),
            @Result(property = "c_77", column = "c_77"),
            @Result(property = "c_78", column = "c_78"),
            @Result(property = "c_79", column = "c_79"),
            @Result(property = "c_80", column = "c_80"),
            @Result(property = "c_81", column = "c_81"),
            @Result(property = "c_82", column = "c_82"),
            @Result(property = "c_83", column = "c_83"),
            @Result(property = "c_84", column = "c_84"),
            @Result(property = "c_85", column = "c_85"),
            @Result(property = "c_86", column = "c_86"),
            @Result(property = "c_87", column = "c_87"),
            @Result(property = "c_88", column = "c_88"),
            @Result(property = "c_89", column = "c_89"),
            @Result(property = "c_90", column = "c_90"),
            @Result(property = "c_91", column = "c_91"),
            @Result(property = "c_92", column = "c_92"),
            @Result(property = "c_93", column = "c_93"),
            @Result(property = "c_94", column = "c_94"),
            @Result(property = "c_95", column = "c_95"),
            @Result(property = "c_96", column = "c_96"),
            @Result(property = "c_97", column = "c_97"),
            @Result(property = "c_98", column = "c_98"),
            @Result(property = "c_99", column = "c_99"),
            @Result(property = "c_100", column = "c_100"),
            @Result(property = "c_other", column = "c_other"),
            @Result(property = "cluster", column = "cluster"),
    })
    @Select("SELECT " +
                "event_id" +
                ",user_id" +
                ",start_time" +
                ",city" +
                ",state" +
                ",zip" +
                ",country" +
                ",lat" +
                ",lat" +
                ",c_1" +
                ",c_2" +
                ",c_3" +
                ",c_4" +
                ",c_5" +
                ",c_6" +
                ",c_7" +
                ",c_8" +
                ",c_9" +
                ",c_10" +
                ",c_11" +
                ",c_12" +
                ",c_13" +
                ",c_14" +
                ",c_15" +
                ",c_16" +
                ",c_17" +
                ",c_18" +
                ",c_19" +
                ",c_20" +
                ",c_21" +
                ",c_22" +
                ",c_23" +
                ",c_24" +
                ",c_25" +
                ",c_26" +
                ",c_27" +
                ",c_28" +
                ",c_29" +
                ",c_30" +
                ",c_31" +
                ",c_32" +
                ",c_33" +
                ",c_34" +
                ",c_35" +
                ",c_36" +
                ",c_37" +
                ",c_38" +
                ",c_39" +
                ",c_40" +
                ",c_41" +
                ",c_42" +
                ",c_43" +
                ",c_44" +
                ",c_45" +
                ",c_46" +
                ",c_47" +
                ",c_48" +
                ",c_49" +
                ",c_50" +
                ",c_51" +
                ",c_52" +
                ",c_53" +
                ",c_54" +
                ",c_55" +
                ",c_56" +
                ",c_57" +
                ",c_58" +
                ",c_59" +
                ",c_60" +
                ",c_61" +
                ",c_62" +
                ",c_63" +
                ",c_64" +
                ",c_65" +
                ",c_66" +
                ",c_67" +
                ",c_68" +
                ",c_69" +
                ",c_70" +
                ",c_71" +
                ",c_72" +
                ",c_73" +
                ",c_74" +
                ",c_75" +
                ",c_76" +
                ",c_77" +
                ",c_78" +
                ",c_79" +
                ",c_80" +
                ",c_81" +
                ",c_82" +
                ",c_83" +
                ",c_84" +
                ",c_85" +
                ",c_86" +
                ",c_87" +
                ",c_88" +
                ",c_89" +
                ",c_90" +
                ",c_91" +
                ",c_92" +
                ",c_93" +
                ",c_94" +
                ",c_95" +
                ",c_96" +
                ",c_97" +
                ",c_98" +
                ",c_99" +
                ",c_100" +
                ",c_other" +
                ",cluster" +
            " FROM public.event WHERE event_id = #{id}")
    Event selectEvent(Long id);


    @Results({
            @Result(property = "id", column = "event_id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "startTime", column = "start_time"),
            @Result(property = "city", column = "city"),
            @Result(property = "state", column = "state"),
            @Result(property = "zip", column = "zip"),
            @Result(property = "country", column = "country"),
            @Result(property = "latitude", column = "lat"),
            @Result(property = "longitude", column = "lng"),
            @Result(property = "c_1", column = "c_1"),
            @Result(property = "c_2", column = "c_2"),
            @Result(property = "c_3", column = "c_3"),
            @Result(property = "c_4", column = "c_4"),
            @Result(property = "c_5", column = "c_5"),
            @Result(property = "c_6", column = "c_6"),
            @Result(property = "c_7", column = "c_7"),
            @Result(property = "c_8", column = "c_8"),
            @Result(property = "c_9", column = "c_9"),
            @Result(property = "c_10", column = "c_10"),
            @Result(property = "c_11", column = "c_11"),
            @Result(property = "c_12", column = "c_12"),
            @Result(property = "c_13", column = "c_13"),
            @Result(property = "c_14", column = "c_14"),
            @Result(property = "c_15", column = "c_15"),
            @Result(property = "c_16", column = "c_16"),
            @Result(property = "c_17", column = "c_17"),
            @Result(property = "c_18", column = "c_18"),
            @Result(property = "c_19", column = "c_19"),
            @Result(property = "c_20", column = "c_20"),
            @Result(property = "c_21", column = "c_21"),
            @Result(property = "c_22", column = "c_22"),
            @Result(property = "c_23", column = "c_23"),
            @Result(property = "c_24", column = "c_24"),
            @Result(property = "c_25", column = "c_25"),
            @Result(property = "c_26", column = "c_26"),
            @Result(property = "c_27", column = "c_27"),
            @Result(property = "c_28", column = "c_28"),
            @Result(property = "c_29", column = "c_29"),
            @Result(property = "c_30", column = "c_30"),
            @Result(property = "c_31", column = "c_31"),
            @Result(property = "c_32", column = "c_32"),
            @Result(property = "c_33", column = "c_33"),
            @Result(property = "c_34", column = "c_34"),
            @Result(property = "c_35", column = "c_35"),
            @Result(property = "c_36", column = "c_36"),
            @Result(property = "c_37", column = "c_37"),
            @Result(property = "c_38", column = "c_38"),
            @Result(property = "c_39", column = "c_39"),
            @Result(property = "c_40", column = "c_40"),
            @Result(property = "c_41", column = "c_41"),
            @Result(property = "c_42", column = "c_42"),
            @Result(property = "c_43", column = "c_43"),
            @Result(property = "c_44", column = "c_44"),
            @Result(property = "c_45", column = "c_45"),
            @Result(property = "c_46", column = "c_46"),
            @Result(property = "c_47", column = "c_47"),
            @Result(property = "c_48", column = "c_48"),
            @Result(property = "c_49", column = "c_49"),
            @Result(property = "c_50", column = "c_50"),
            @Result(property = "c_51", column = "c_51"),
            @Result(property = "c_52", column = "c_52"),
            @Result(property = "c_53", column = "c_53"),
            @Result(property = "c_54", column = "c_54"),
            @Result(property = "c_55", column = "c_55"),
            @Result(property = "c_56", column = "c_56"),
            @Result(property = "c_57", column = "c_57"),
            @Result(property = "c_58", column = "c_58"),
            @Result(property = "c_59", column = "c_59"),
            @Result(property = "c_60", column = "c_60"),
            @Result(property = "c_61", column = "c_61"),
            @Result(property = "c_62", column = "c_62"),
            @Result(property = "c_63", column = "c_63"),
            @Result(property = "c_64", column = "c_64"),
            @Result(property = "c_65", column = "c_65"),
            @Result(property = "c_66", column = "c_66"),
            @Result(property = "c_67", column = "c_67"),
            @Result(property = "c_68", column = "c_68"),
            @Result(property = "c_69", column = "c_69"),
            @Result(property = "c_70", column = "c_70"),
            @Result(property = "c_71", column = "c_71"),
            @Result(property = "c_72", column = "c_72"),
            @Result(property = "c_73", column = "c_73"),
            @Result(property = "c_74", column = "c_74"),
            @Result(property = "c_75", column = "c_75"),
            @Result(property = "c_76", column = "c_76"),
            @Result(property = "c_77", column = "c_77"),
            @Result(property = "c_78", column = "c_78"),
            @Result(property = "c_79", column = "c_79"),
            @Result(property = "c_80", column = "c_80"),
            @Result(property = "c_81", column = "c_81"),
            @Result(property = "c_82", column = "c_82"),
            @Result(property = "c_83", column = "c_83"),
            @Result(property = "c_84", column = "c_84"),
            @Result(property = "c_85", column = "c_85"),
            @Result(property = "c_86", column = "c_86"),
            @Result(property = "c_87", column = "c_87"),
            @Result(property = "c_88", column = "c_88"),
            @Result(property = "c_89", column = "c_89"),
            @Result(property = "c_90", column = "c_90"),
            @Result(property = "c_91", column = "c_91"),
            @Result(property = "c_92", column = "c_92"),
            @Result(property = "c_93", column = "c_93"),
            @Result(property = "c_94", column = "c_94"),
            @Result(property = "c_95", column = "c_95"),
            @Result(property = "c_96", column = "c_96"),
            @Result(property = "c_97", column = "c_97"),
            @Result(property = "c_98", column = "c_98"),
            @Result(property = "c_99", column = "c_99"),
            @Result(property = "c_100", column = "c_100"),
            @Result(property = "c_other", column = "c_other"),
            @Result(property = "cluster", column = "cluster"),
    })
    @Select("SELECT " +
            "event_id" +
            ",user_id" +
            ",start_time" +
            ",city" +
            ",state" +
            ",zip" +
            ",country" +
            ",lat" +
            ",lat" +
            ",c_1" +
            ",c_2" +
            ",c_3" +
            ",c_4" +
            ",c_5" +
            ",c_6" +
            ",c_7" +
            ",c_8" +
            ",c_9" +
            ",c_10" +
            ",c_11" +
            ",c_12" +
            ",c_13" +
            ",c_14" +
            ",c_15" +
            ",c_16" +
            ",c_17" +
            ",c_18" +
            ",c_19" +
            ",c_20" +
            ",c_21" +
            ",c_22" +
            ",c_23" +
            ",c_24" +
            ",c_25" +
            ",c_26" +
            ",c_27" +
            ",c_28" +
            ",c_29" +
            ",c_30" +
            ",c_31" +
            ",c_32" +
            ",c_33" +
            ",c_34" +
            ",c_35" +
            ",c_36" +
            ",c_37" +
            ",c_38" +
            ",c_39" +
            ",c_40" +
            ",c_41" +
            ",c_42" +
            ",c_43" +
            ",c_44" +
            ",c_45" +
            ",c_46" +
            ",c_47" +
            ",c_48" +
            ",c_49" +
            ",c_50" +
            ",c_51" +
            ",c_52" +
            ",c_53" +
            ",c_54" +
            ",c_55" +
            ",c_56" +
            ",c_57" +
            ",c_58" +
            ",c_59" +
            ",c_60" +
            ",c_61" +
            ",c_62" +
            ",c_63" +
            ",c_64" +
            ",c_65" +
            ",c_66" +
            ",c_67" +
            ",c_68" +
            ",c_69" +
            ",c_70" +
            ",c_71" +
            ",c_72" +
            ",c_73" +
            ",c_74" +
            ",c_75" +
            ",c_76" +
            ",c_77" +
            ",c_78" +
            ",c_79" +
            ",c_80" +
            ",c_81" +
            ",c_82" +
            ",c_83" +
            ",c_84" +
            ",c_85" +
            ",c_86" +
            ",c_87" +
            ",c_88" +
            ",c_89" +
            ",c_90" +
            ",c_91" +
            ",c_92" +
            ",c_93" +
            ",c_94" +
            ",c_95" +
            ",c_96" +
            ",c_97" +
            ",c_98" +
            ",c_99" +
            ",c_100" +
            ",c_other" +
            ",cluster" +
            " FROM public.event" +
            " ORDER BY event_id" +
            " LIMIT #{limit}" +
            " OFFSET #{offset}"
    )
    List<Event> selectEvents(@Param("limit") int limit,@Param("offset") int offset);


    @Update("UPDATE event SET cluster=#{cluster} WHERE event_id =#{id}")
    void updateEventCluster(Event event);


}
