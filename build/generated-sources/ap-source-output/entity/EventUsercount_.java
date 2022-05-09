package entity;

import entity.Events;
import entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-04-28T20:47:47")
@StaticMetamodel(EventUsercount.class)
public class EventUsercount_ { 

    public static volatile SingularAttribute<EventUsercount, Events> eventid;
    public static volatile SingularAttribute<EventUsercount, Integer> eucId;
    public static volatile SingularAttribute<EventUsercount, User> userid;
    public static volatile SingularAttribute<EventUsercount, Boolean> isInterested;

}