package entity;

import entity.Ads;
import entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-04-28T20:47:47")
@StaticMetamodel(AdsUser.class)
public class AdsUser_ { 

    public static volatile SingularAttribute<AdsUser, Integer> auId;
    public static volatile SingularAttribute<AdsUser, Boolean> isExpried;
    public static volatile SingularAttribute<AdsUser, Date> enddate;
    public static volatile SingularAttribute<AdsUser, Boolean> isRemoved;
    public static volatile SingularAttribute<AdsUser, String> adscontent;
    public static volatile SingularAttribute<AdsUser, String> link;
    public static volatile SingularAttribute<AdsUser, String> description;
    public static volatile SingularAttribute<AdsUser, Date> startdate;
    public static volatile SingularAttribute<AdsUser, Ads> adsid;
    public static volatile SingularAttribute<AdsUser, User> userid;

}