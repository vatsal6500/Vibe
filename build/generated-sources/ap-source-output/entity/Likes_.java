package entity;

import entity.Post;
import entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-04-28T20:47:47")
@StaticMetamodel(Likes.class)
public class Likes_ { 

    public static volatile SingularAttribute<Likes, User> senderid;
    public static volatile SingularAttribute<Likes, Boolean> isRemoved;
    public static volatile SingularAttribute<Likes, User> receiverid;
    public static volatile SingularAttribute<Likes, Date> likeDate;
    public static volatile SingularAttribute<Likes, Integer> likeid;
    public static volatile SingularAttribute<Likes, Post> postid;

}