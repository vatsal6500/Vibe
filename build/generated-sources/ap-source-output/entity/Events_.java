package entity;

import entity.EventUsercount;
import entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-04-28T20:47:47")
@StaticMetamodel(Events.class)
public class Events_ { 

    public static volatile SingularAttribute<Events, String> eventinfo;
    public static volatile SingularAttribute<Events, Integer> eventid;
    public static volatile SingularAttribute<Events, String> venue;
    public static volatile SingularAttribute<Events, Integer> fees;
    public static volatile SingularAttribute<Events, Integer> guestcount;
    public static volatile SingularAttribute<Events, Date> regDate;
    public static volatile SingularAttribute<Events, User> hostid;
    public static volatile SingularAttribute<Events, Date> eventenddate;
    public static volatile CollectionAttribute<Events, EventUsercount> eventUsercountCollection;
    public static volatile SingularAttribute<Events, String> type;
    public static volatile SingularAttribute<Events, String> eventname;
    public static volatile SingularAttribute<Events, String> mode;
    public static volatile SingularAttribute<Events, Date> eventstartdate;
    public static volatile SingularAttribute<Events, Boolean> isRemoved;
    public static volatile SingularAttribute<Events, String> post;

}