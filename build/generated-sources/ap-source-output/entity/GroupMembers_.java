package entity;

import entity.Groups;
import entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-04-28T20:47:47")
@StaticMetamodel(GroupMembers.class)
public class GroupMembers_ { 

    public static volatile SingularAttribute<GroupMembers, Integer> gmId;
    public static volatile SingularAttribute<GroupMembers, Groups> groupid;
    public static volatile SingularAttribute<GroupMembers, Boolean> isMember;
    public static volatile SingularAttribute<GroupMembers, User> memberid;

}