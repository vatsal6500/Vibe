package entity;

import entity.Post;
import entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-04-28T20:47:47")
@StaticMetamodel(Comments.class)
public class Comments_ { 

    public static volatile SingularAttribute<Comments, User> senderid;
    public static volatile SingularAttribute<Comments, Boolean> isRemoved;
    public static volatile SingularAttribute<Comments, User> receiverid;
    public static volatile SingularAttribute<Comments, Date> commentDate;
    public static volatile SingularAttribute<Comments, Integer> commentid;
    public static volatile SingularAttribute<Comments, String> comment;
    public static volatile SingularAttribute<Comments, Post> postid;

}