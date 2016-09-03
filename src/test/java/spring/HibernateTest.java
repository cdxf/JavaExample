package spring;

import org.hibernate.PersistentObjectException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import spring.Repository.Person;
import spring.Repository.Town;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Snoob on 9/3/2016.
 */
public class HibernateTest {
    SessionFactory localSessionFactory;
    Person mPerson = new Person();
    @Before
    public void setUp() throws Exception {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext("HibernateContext.xml");
        localSessionFactory = (SessionFactory) context.getBean("localSessionFactory");
        System.out.println(localSessionFactory.getProperties().keySet().toString());
        mPerson.setFirstName("hello");
        mPerson.setLastName("world");
    }
    @Test
    public void saveAndGetTest(){
        Session session = localSessionFactory.openSession();
        session.beginTransaction();
        Long id = (Long) session.save(mPerson);
        session.getTransaction().commit();
        session.close();

        Session session2 = localSessionFactory.openSession();
        session2.beginTransaction();
        Person person = session2.get(Person.class, id);
        session2.getTransaction().commit();
        session2.close();
        Assert.assertEquals(person, mPerson);
    }
    @Test
    public void RelationTest(){
        Person mPerson2 = new Person(); mPerson2.setFirstName("David");
        Person mPerson3 = new Person(); mPerson3.setFirstName("Levance");
        List<Person> people = Arrays.asList(mPerson,mPerson2,mPerson3);
        Town town = new Town();
        town.setPerson(people);
        mPerson2.setTown(town);
        mPerson3.setTown(town);
        mPerson.setTown(town);
        //
        Session session = localSessionFactory.openSession();
        session.beginTransaction();
        session.save(mPerson);session.save(mPerson2);session.save(mPerson3);
        Long id = (Long) session.save(town);
        session.getTransaction().commit();
        session.close();
        //
        Session session2 = localSessionFactory.openSession();
        session2.beginTransaction();
        Person person = session2.get(Person.class, 1L);
        session2.getTransaction().commit();
        Town town1 = person.getTown();
        for(Person p: town1.getPerson()){
            System.out.println(p.getFirstName());
        }
        session2.close();
    }
}
