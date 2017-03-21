package net.geekscore.ml.kaggle.rec.event.data;

import com.google.common.base.Objects;

import java.io.Serializable;

/**
 * Created by ravirajmulasa on 3/15/17.
 */
public final class Event implements Serializable {

    private Long id;

    private Long userId;

    private String startTime;

    private String city;

    private String state;

    private String zip;

    private String country;

    private Float latitude;

    private Float longitude;

    private int cluster = -1;

    private int c_1;
    private int c_2;
    private int c_3;
    private int c_4;
    private int c_5;
    private int c_6;
    private int c_7;
    private int c_8;
    private int c_9;
    private int c_10;
    private int c_11;
    private int c_12;
    private int c_13;
    private int c_14;
    private int c_15;
    private int c_16;
    private int c_17;
    private int c_18;
    private int c_19;
    private int c_20;
    private int c_21;
    private int c_22;
    private int c_23;
    private int c_24;
    private int c_25;
    private int c_26;
    private int c_27;
    private int c_28;
    private int c_29;
    private int c_30;
    private int c_31;
    private int c_32;
    private int c_33;
    private int c_34;
    private int c_35;
    private int c_36;
    private int c_37;
    private int c_38;
    private int c_39;
    private int c_40;
    private int c_41;
    private int c_42;
    private int c_43;
    private int c_44;
    private int c_45;
    private int c_46;
    private int c_47;
    private int c_48;
    private int c_49;
    private int c_50;
    private int c_51;
    private int c_52;
    private int c_53;
    private int c_54;
    private int c_55;
    private int c_56;
    private int c_57;
    private int c_58;
    private int c_59;
    private int c_60;
    private int c_61;
    private int c_62;
    private int c_63;
    private int c_64;
    private int c_65;
    private int c_66;
    private int c_67;
    private int c_68;
    private int c_69;
    private int c_70;
    private int c_71;
    private int c_72;
    private int c_73;
    private int c_74;
    private int c_75;
    private int c_76;
    private int c_77;
    private int c_78;
    private int c_79;
    private int c_80;
    private int c_81;
    private int c_82;
    private int c_83;
    private int c_84;
    private int c_85;
    private int c_86;
    private int c_87;
    private int c_88;
    private int c_89;
    private int c_90;
    private int c_91;
    private int c_92;
    private int c_93;
    private int c_94;
    private int c_95;
    private int c_96;
    private int c_97;
    private int c_98;
    private int c_99;
    private int c_100;
    private int c_other;


    public Event(){}


    public Event(Long id, Long userId, String startTime, String city, String state, String zip, String country, Float latitude, Float longitude) {
        this.id         = id;
        this.userId     = userId;
        this.startTime  = startTime;
        this.city       = city;
        this.state      = state;
        this.zip        = zip;
        this.country    = country;
        this.latitude   = latitude;
        this.longitude  = longitude;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public int getC_1() {
        return c_1;
    }

    public void setC_1(int c_1) {
        this.c_1 = c_1;
    }

    public int getC_2() {
        return c_2;
    }

    public void setC_2(int c_2) {
        this.c_2 = c_2;
    }

    public int getC_3() {
        return c_3;
    }

    public void setC_3(int c_3) {
        this.c_3 = c_3;
    }

    public int getC_4() {
        return c_4;
    }

    public void setC_4(int c_4) {
        this.c_4 = c_4;
    }

    public int getC_5() {
        return c_5;
    }

    public void setC_5(int c_5) {
        this.c_5 = c_5;
    }

    public int getC_6() {
        return c_6;
    }

    public void setC_6(int c_6) {
        this.c_6 = c_6;
    }

    public int getC_7() {
        return c_7;
    }

    public void setC_7(int c_7) {
        this.c_7 = c_7;
    }

    public int getC_8() {
        return c_8;
    }

    public void setC_8(int c_8) {
        this.c_8 = c_8;
    }

    public int getC_9() {
        return c_9;
    }

    public void setC_9(int c_9) {
        this.c_9 = c_9;
    }

    public int getC_10() {
        return c_10;
    }

    public void setC_10(int c_10) {
        this.c_10 = c_10;
    }

    public int getC_11() {
        return c_11;
    }

    public void setC_11(int c_11) {
        this.c_11 = c_11;
    }

    public int getC_12() {
        return c_12;
    }

    public void setC_12(int c_12) {
        this.c_12 = c_12;
    }

    public int getC_13() {
        return c_13;
    }

    public void setC_13(int c_13) {
        this.c_13 = c_13;
    }

    public int getC_14() {
        return c_14;
    }

    public void setC_14(int c_14) {
        this.c_14 = c_14;
    }

    public int getC_15() {
        return c_15;
    }

    public void setC_15(int c_15) {
        this.c_15 = c_15;
    }

    public int getC_16() {
        return c_16;
    }

    public void setC_16(int c_16) {
        this.c_16 = c_16;
    }

    public int getC_17() {
        return c_17;
    }

    public void setC_17(int c_17) {
        this.c_17 = c_17;
    }

    public int getC_18() {
        return c_18;
    }

    public void setC_18(int c_18) {
        this.c_18 = c_18;
    }

    public int getC_19() {
        return c_19;
    }

    public void setC_19(int c_19) {
        this.c_19 = c_19;
    }

    public int getC_20() {
        return c_20;
    }

    public void setC_20(int c_20) {
        this.c_20 = c_20;
    }

    public int getC_21() {
        return c_21;
    }

    public void setC_21(int c_21) {
        this.c_21 = c_21;
    }

    public int getC_22() {
        return c_22;
    }

    public void setC_22(int c_22) {
        this.c_22 = c_22;
    }

    public int getC_23() {
        return c_23;
    }

    public void setC_23(int c_23) {
        this.c_23 = c_23;
    }

    public int getC_24() {
        return c_24;
    }

    public void setC_24(int c_24) {
        this.c_24 = c_24;
    }

    public int getC_25() {
        return c_25;
    }

    public void setC_25(int c_25) {
        this.c_25 = c_25;
    }

    public int getC_26() {
        return c_26;
    }

    public void setC_26(int c_26) {
        this.c_26 = c_26;
    }

    public int getC_27() {
        return c_27;
    }

    public void setC_27(int c_27) {
        this.c_27 = c_27;
    }

    public int getC_28() {
        return c_28;
    }

    public void setC_28(int c_28) {
        this.c_28 = c_28;
    }

    public int getC_29() {
        return c_29;
    }

    public void setC_29(int c_29) {
        this.c_29 = c_29;
    }

    public int getC_30() {
        return c_30;
    }

    public void setC_30(int c_30) {
        this.c_30 = c_30;
    }

    public int getC_31() {
        return c_31;
    }

    public void setC_31(int c_31) {
        this.c_31 = c_31;
    }

    public int getC_32() {
        return c_32;
    }

    public void setC_32(int c_32) {
        this.c_32 = c_32;
    }

    public int getC_33() {
        return c_33;
    }

    public void setC_33(int c_33) {
        this.c_33 = c_33;
    }

    public int getC_34() {
        return c_34;
    }

    public void setC_34(int c_34) {
        this.c_34 = c_34;
    }

    public int getC_35() {
        return c_35;
    }

    public void setC_35(int c_35) {
        this.c_35 = c_35;
    }

    public int getC_36() {
        return c_36;
    }

    public void setC_36(int c_36) {
        this.c_36 = c_36;
    }

    public int getC_37() {
        return c_37;
    }

    public void setC_37(int c_37) {
        this.c_37 = c_37;
    }

    public int getC_38() {
        return c_38;
    }

    public void setC_38(int c_38) {
        this.c_38 = c_38;
    }

    public int getC_39() {
        return c_39;
    }

    public void setC_39(int c_39) {
        this.c_39 = c_39;
    }

    public int getC_40() {
        return c_40;
    }

    public void setC_40(int c_40) {
        this.c_40 = c_40;
    }

    public int getC_41() {
        return c_41;
    }

    public void setC_41(int c_41) {
        this.c_41 = c_41;
    }

    public int getC_42() {
        return c_42;
    }

    public void setC_42(int c_42) {
        this.c_42 = c_42;
    }

    public int getC_43() {
        return c_43;
    }

    public void setC_43(int c_43) {
        this.c_43 = c_43;
    }

    public int getC_44() {
        return c_44;
    }

    public void setC_44(int c_44) {
        this.c_44 = c_44;
    }

    public int getC_45() {
        return c_45;
    }

    public void setC_45(int c_45) {
        this.c_45 = c_45;
    }

    public int getC_46() {
        return c_46;
    }

    public void setC_46(int c_46) {
        this.c_46 = c_46;
    }

    public int getC_47() {
        return c_47;
    }

    public void setC_47(int c_47) {
        this.c_47 = c_47;
    }

    public int getC_48() {
        return c_48;
    }

    public void setC_48(int c_48) {
        this.c_48 = c_48;
    }

    public int getC_49() {
        return c_49;
    }

    public void setC_49(int c_49) {
        this.c_49 = c_49;
    }

    public int getC_50() {
        return c_50;
    }

    public void setC_50(int c_50) {
        this.c_50 = c_50;
    }

    public int getC_51() {
        return c_51;
    }

    public void setC_51(int c_51) {
        this.c_51 = c_51;
    }

    public int getC_52() {
        return c_52;
    }

    public void setC_52(int c_52) {
        this.c_52 = c_52;
    }

    public int getC_53() {
        return c_53;
    }

    public void setC_53(int c_53) {
        this.c_53 = c_53;
    }

    public int getC_54() {
        return c_54;
    }

    public void setC_54(int c_54) {
        this.c_54 = c_54;
    }

    public int getC_55() {
        return c_55;
    }

    public void setC_55(int c_55) {
        this.c_55 = c_55;
    }

    public int getC_56() {
        return c_56;
    }

    public void setC_56(int c_56) {
        this.c_56 = c_56;
    }

    public int getC_57() {
        return c_57;
    }

    public void setC_57(int c_57) {
        this.c_57 = c_57;
    }

    public int getC_58() {
        return c_58;
    }

    public void setC_58(int c_58) {
        this.c_58 = c_58;
    }

    public int getC_59() {
        return c_59;
    }

    public void setC_59(int c_59) {
        this.c_59 = c_59;
    }

    public int getC_60() {
        return c_60;
    }

    public void setC_60(int c_60) {
        this.c_60 = c_60;
    }

    public int getC_61() {
        return c_61;
    }

    public void setC_61(int c_61) {
        this.c_61 = c_61;
    }

    public int getC_62() {
        return c_62;
    }

    public void setC_62(int c_62) {
        this.c_62 = c_62;
    }

    public int getC_63() {
        return c_63;
    }

    public void setC_63(int c_63) {
        this.c_63 = c_63;
    }

    public int getC_64() {
        return c_64;
    }

    public void setC_64(int c_64) {
        this.c_64 = c_64;
    }

    public int getC_65() {
        return c_65;
    }

    public void setC_65(int c_65) {
        this.c_65 = c_65;
    }

    public int getC_66() {
        return c_66;
    }

    public void setC_66(int c_66) {
        this.c_66 = c_66;
    }

    public int getC_67() {
        return c_67;
    }

    public void setC_67(int c_67) {
        this.c_67 = c_67;
    }

    public int getC_68() {
        return c_68;
    }

    public void setC_68(int c_68) {
        this.c_68 = c_68;
    }

    public int getC_69() {
        return c_69;
    }

    public void setC_69(int c_69) {
        this.c_69 = c_69;
    }

    public int getC_70() {
        return c_70;
    }

    public void setC_70(int c_70) {
        this.c_70 = c_70;
    }

    public int getC_71() {
        return c_71;
    }

    public void setC_71(int c_71) {
        this.c_71 = c_71;
    }

    public int getC_72() {
        return c_72;
    }

    public void setC_72(int c_72) {
        this.c_72 = c_72;
    }

    public int getC_73() {
        return c_73;
    }

    public void setC_73(int c_73) {
        this.c_73 = c_73;
    }

    public int getC_74() {
        return c_74;
    }

    public void setC_74(int c_74) {
        this.c_74 = c_74;
    }

    public int getC_75() {
        return c_75;
    }

    public void setC_75(int c_75) {
        this.c_75 = c_75;
    }

    public int getC_76() {
        return c_76;
    }

    public void setC_76(int c_76) {
        this.c_76 = c_76;
    }

    public int getC_77() {
        return c_77;
    }

    public void setC_77(int c_77) {
        this.c_77 = c_77;
    }

    public int getC_78() {
        return c_78;
    }

    public void setC_78(int c_78) {
        this.c_78 = c_78;
    }

    public int getC_79() {
        return c_79;
    }

    public void setC_79(int c_79) {
        this.c_79 = c_79;
    }

    public int getC_80() {
        return c_80;
    }

    public void setC_80(int c_80) {
        this.c_80 = c_80;
    }

    public int getC_81() {
        return c_81;
    }

    public void setC_81(int c_81) {
        this.c_81 = c_81;
    }

    public int getC_82() {
        return c_82;
    }

    public void setC_82(int c_82) {
        this.c_82 = c_82;
    }

    public int getC_83() {
        return c_83;
    }

    public void setC_83(int c_83) {
        this.c_83 = c_83;
    }

    public int getC_84() {
        return c_84;
    }

    public void setC_84(int c_84) {
        this.c_84 = c_84;
    }

    public int getC_85() {
        return c_85;
    }

    public void setC_85(int c_85) {
        this.c_85 = c_85;
    }

    public int getC_86() {
        return c_86;
    }

    public void setC_86(int c_86) {
        this.c_86 = c_86;
    }

    public int getC_87() {
        return c_87;
    }

    public void setC_87(int c_87) {
        this.c_87 = c_87;
    }

    public int getC_88() {
        return c_88;
    }

    public void setC_88(int c_88) {
        this.c_88 = c_88;
    }

    public int getC_89() {
        return c_89;
    }

    public void setC_89(int c_89) {
        this.c_89 = c_89;
    }

    public int getC_90() {
        return c_90;
    }

    public void setC_90(int c_90) {
        this.c_90 = c_90;
    }

    public int getC_91() {
        return c_91;
    }

    public void setC_91(int c_91) {
        this.c_91 = c_91;
    }

    public int getC_92() {
        return c_92;
    }

    public void setC_92(int c_92) {
        this.c_92 = c_92;
    }

    public int getC_93() {
        return c_93;
    }

    public void setC_93(int c_93) {
        this.c_93 = c_93;
    }

    public int getC_94() {
        return c_94;
    }

    public void setC_94(int c_94) {
        this.c_94 = c_94;
    }

    public int getC_95() {
        return c_95;
    }

    public void setC_95(int c_95) {
        this.c_95 = c_95;
    }

    public int getC_96() {
        return c_96;
    }

    public void setC_96(int c_96) {
        this.c_96 = c_96;
    }

    public int getC_97() {
        return c_97;
    }

    public void setC_97(int c_97) {
        this.c_97 = c_97;
    }

    public int getC_98() {
        return c_98;
    }

    public void setC_98(int c_98) {
        this.c_98 = c_98;
    }

    public int getC_99() {
        return c_99;
    }

    public void setC_99(int c_99) {
        this.c_99 = c_99;
    }

    public int getC_100() {
        return c_100;
    }

    public void setC_100(int c_100) {
        this.c_100 = c_100;
    }

    public int getC_other() {
        return c_other;
    }

    public void setC_other(int c_other) {
        this.c_other = c_other;
    }

    public int getCluster() {
        return cluster;
    }

    public void setCluster(int cluster) {
        this.cluster = cluster;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equal(id, event.id) &&
                Objects.equal(userId, event.userId) &&
                Objects.equal(startTime, event.startTime) &&
                Objects.equal(city, event.city) &&
                Objects.equal(state, event.state) &&
                Objects.equal(zip, event.zip) &&
                Objects.equal(country, event.country) &&
                Objects.equal(latitude, event.latitude) &&
                Objects.equal(longitude, event.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, userId, startTime, city, state, zip, country, latitude, longitude);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", userId=" + userId +
                ", startTime=" + startTime +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", country='" + country + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

//    private final Set<User> yesResponders = Sets.newHashSet();;
//
//    private final Set<User> mayBeResponders = Sets.newHashSet();;
//
//    private final Set<User> noResponders = Sets.newHashSet();
//
//    private final Set<User> invitees = Sets.newHashSet();
//
//    public void addYesResponder(final User user) {
//        this.yesResponders.add(user);
//    }
//
//    public boolean isYesResponder(final User user) {
//        return this.yesResponders.contains(user);
//    }
//
//    public Set<User> getYesResponders() {
//        return this.yesResponders;
//    }
//
//    public void addMayBeResponder(final User user) {
//        this.mayBeResponders.add(user);
//    }
//
//    public boolean isMayBeResponder(final User user) {
//        return this.mayBeResponders.contains(user);
//    }
//
//    public Set<User> getMayBeResponders() {
//        return this.mayBeResponders;
//    }
//
//    public void addNoResponder(final User user) {
//        this.noResponders.add(user);
//    }
//
//    public boolean isNoResponder(final User user) {
//        return this.noResponders.contains(user);
//    }
//
//    public Set<User> getNoResponders() {
//        return this.noResponders;
//    }
//
//    public void addInvitee(final User user) {
//        this.invitees.add(user);
//    }
//
//    public boolean isInvitee(final User user) {
//        return this.invitees.contains(user);
//    }
//
//    public Set<User> getInvitees() {
//        return this.invitees;
//    }

}
