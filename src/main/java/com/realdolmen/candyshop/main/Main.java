package com.realdolmen.candyshop.main;

import com.realdolmen.candyshop.entities.Candy;
import com.realdolmen.candyshop.entities.Candycolor;
import com.realdolmen.candyshop.entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by vdabcursist on 08/08/2017.
 */
public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("candyshop");
        EntityManager em = emf.createEntityManager();


        EntityTransaction tx = em.getTransaction();
        tx.begin();


        Person person = new Person("John", "Doe", "2011-01-01");
        em.persist(person);



        Candy candy = new Candy("Beertje", Candycolor.BLACK);
        em.persist(candy);
        tx.commit();


        List<Person> people = em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
        people.forEach(System.out::println);






        em.close();
        emf.close();

    }
}
