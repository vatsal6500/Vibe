package entity;

import entity.Groups;
import entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-04-28T20:47:47")
@StaticMetamodel(ActivityFeed.class)
public class ActivityFeed_ { 

    public static volatile SingularAttribute<ActivityFeed, User> senderid;
    public static volatile SingularAttribute<ActivityFeed, Date> activityDate;
    public static volatile SingularAttribute<ActivityFeed, User> receiverid;
    public static volatile SingularAttribute<ActivityFeed, Boolean> isDeleted;
    public static volatile SingularAttribute<ActivityFeed, String> sendermessage;
    public static volatile SingularAttribute<ActivityFeed, String> receivermessage;
    public static volatile SingularAttribute<ActivityFeed, Groups> groupid;
    public static volatile SingularAttribute<ActivityFeed, Boolean> isRead;
    public static volatile SingularAttribute<ActivityFeed, Integer> afId;
    public static volatile SingularAttribute<ActivityFeed, String> targetUrl;

}