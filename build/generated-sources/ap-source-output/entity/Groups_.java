package entity;

import entity.ActivityFeed;
import entity.GroupMembers;
import entity.Post;
import entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-04-28T20:47:47")
@StaticMetamodel(Groups.class)
public class Groups_ { 

    public static volatile SingularAttribute<Groups, Integer> memberscount;
    public static volatile CollectionAttribute<Groups, Post> postCollection;
    public static volatile SingularAttribute<Groups, Boolean> isDeleted;
    public static volatile SingularAttribute<Groups, Integer> groupid;
    public static volatile CollectionAttribute<Groups, ActivityFeed> activityFeedCollection;
    public static volatile SingularAttribute<Groups, User> adminid;
    public static volatile SingularAttribute<Groups, String> description;
    public static volatile CollectionAttribute<Groups, GroupMembers> groupMembersCollection;
    public static volatile SingularAttribute<Groups, String> groupname;
    public static volatile SingularAttribute<Groups, Date> createDate;

}