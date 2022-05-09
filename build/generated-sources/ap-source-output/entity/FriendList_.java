package entity;

import entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-04-28T20:47:47")
@StaticMetamodel(FriendList.class)
public class FriendList_ { 

    public static volatile SingularAttribute<FriendList, Boolean> friendStatus;
    public static volatile SingularAttribute<FriendList, User> friendid;
    public static volatile SingularAttribute<FriendList, Date> acceptedDate;
    public static volatile SingularAttribute<FriendList, User> userid;
    public static volatile SingularAttribute<FriendList, Integer> flId;

}