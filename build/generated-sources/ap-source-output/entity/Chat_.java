package entity;

import entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-04-28T20:47:47")
@StaticMetamodel(Chat.class)
public class Chat_ { 

    public static volatile SingularAttribute<Chat, Date> date;
    public static volatile SingularAttribute<Chat, User> senderid;
    public static volatile SingularAttribute<Chat, User> receiverid;
    public static volatile SingularAttribute<Chat, Integer> chatid;
    public static volatile SingularAttribute<Chat, Boolean> isDeleted;
    public static volatile SingularAttribute<Chat, Boolean> isDelevered;
    public static volatile SingularAttribute<Chat, Boolean> isRead;
    public static volatile SingularAttribute<Chat, Date> time;
    public static volatile SingularAttribute<Chat, String> message;

}