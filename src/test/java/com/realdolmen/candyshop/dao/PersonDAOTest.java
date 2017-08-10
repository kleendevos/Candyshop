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
    @Test
    public void shouldFindPersonById(){
        Person person = dao.findPersonById(1L);
        assertNotNull(person);
        assertEquals(new Long(1L),person.getId());
        assertEquals("Jane", person.getFirstName());
    }

    @Test
    public void shouldUpdatePerson () {
        Person person = dao.findPersonById(1L);
        assertNotNull(person);
        person.setFirstName("Joe");
        assertEquals(new Long(1L), person.getId());
        assertEquals("Joe",person.getFirstName());

    }

    public void shouldcountallpeople (){

    }







    @After
    public void destroy (){
       tx.rollback();
       em.close();
    }


    @AfterClass
    public static void cleanup () {
        emf.close();
    }








}
