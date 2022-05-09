package entity;

import entity.AdsUser;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-04-28T20:47:47")
@StaticMetamodel(Ads.class)
public class Ads_ { 

    public static volatile SingularAttribute<Ads, Boolean> isRemoved;
    public static volatile CollectionAttribute<Ads, AdsUser> adsUserCollection;
    public static volatile SingularAttribute<Ads, String> adstype;
    public static volatile SingularAttribute<Ads, Integer> price;
    public static volatile SingularAttribute<Ads, String> description;
    public static volatile SingularAttribute<Ads, Integer> adsId;
    public static volatile SingularAttribute<Ads, Integer> timelimit;

}