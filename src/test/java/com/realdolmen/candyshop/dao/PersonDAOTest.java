package com.realdolmen.candyshop.dao;

import com.realdolmen.candyshop.entities.Person;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by vdabcursist on 08/08/2017.
 */
public class PersonDAOTest {

    private static EntityManagerFactory emf;
    private static PersonDAOimpl dao;
    private EntityManager em;
    private EntityTransaction tx;

    @BeforeClass
    public static void setup () {
        emf = Persistence.createEntityManagerFactory("test");
        dao = new PersonDAOimpl();
    }

    @Before
    public void init () {
        em = emf.createEntityManager();
        dao.em = em;
        tx = em.getTransaction();
        tx.begin();
    }

    @Test
    public void shouldSavePerson(){
        Person p = new Person("Tim", "Test", "2000-01-01");
        Long id = dao.createPerson(p);
        assertNotNull(id);
        assertEquals(new Long(3L),id);
    }

    @Test
    public void shouldFindListOfPeople (){
        List<Person> people = dao.findAllPeople();
        people.forEach(System.out::println);
        assertNotNull(people);
        assertEquals(2, people.size());

    }

    @After
    public void destroy (){
        System.out.println("rollingback");
        tx.rollback();
        em.close();
    }


    @AfterClass
    public static void cleanup () {
        emf.close();
    }








}
