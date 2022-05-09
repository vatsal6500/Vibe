package entity;

import entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-04-28T20:47:47")
@StaticMetamodel(UserEducation.class)
public class UserEducation_ { 

    public static volatile SingularAttribute<UserEducation, Date> endingdate;
    public static volatile SingularAttribute<UserEducation, String> instituteaddress;
    public static volatile SingularAttribute<UserEducation, Date> joiningdate;
    public static volatile SingularAttribute<UserEducation, Integer> ueId;
    public static volatile SingularAttribute<UserEducation, User> userid;
    public static volatile SingularAttribute<UserEducation, String> institutename;

}