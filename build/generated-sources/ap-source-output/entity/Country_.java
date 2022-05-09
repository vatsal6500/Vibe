package entity;

import entity.State;
import entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-04-28T20:47:47")
@StaticMetamodel(Country.class)
public class Country_ { 

    public static volatile SingularAttribute<Country, Boolean> isactive;
    public static volatile CollectionAttribute<Country, User> userCollection;
    public static volatile SingularAttribute<Country, String> countryname;
    public static volatile CollectionAttribute<Country, State> stateCollection;
    public static volatile SingularAttribute<Country, Integer> countryid;

}