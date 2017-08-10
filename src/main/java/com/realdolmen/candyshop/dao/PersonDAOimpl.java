package com.realdolmen.candyshop.dao;

import com.realdolmen.candyshop.entities.Person;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by vdabcursist on 08/08/2017.
 */
public class PersonDAOimpl implements PersonDAO {

    EntityManager em;



    @Override
    public Long createPerson(Person person) {
        em.persist(person);
        return person.getId();
    }

    @Override
    public List<Person> findAllPeople() {

        return em.createQuery("SELECT p FROM Person p",Person.class).getResultList();
    }

    @Override
    public Person findPersonById(Long id) {
        return em.find(Person.class,id);
    }

    @Override
    public Person updatePerson(Person person) {
        return em.merge(person);
    }

    @Override
    public void deletePerson(Person person) {
        em.remove(em.merge(person));

    }

    @Override
    public long countAllPeople() {
        return em.createQuery("SELECT COUNT (p) FROM Person p", Long.class).getSingleResult();
    }

    @Override
    public List<Person> findByLastName(String lastName) {
        return em.createNamedQuery("FIND_BY_LAST_NAME", Person.class).setParameter("lname", lastName).getResultList();
    }
}
