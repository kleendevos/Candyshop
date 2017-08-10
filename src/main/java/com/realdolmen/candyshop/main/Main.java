package com.realdolmen.candyshop.main;

import com.realdolmen.candyshop.entities.*;

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
        person.addCandyPreference(Candycolor.BLACK);
        em.persist(person);

        Order order = new Order(person,new Address("a","a","a","a"));
        em.persist(order);
        Candy candy = new Candy("Beertje", Candycolor.BLACK, 1);
        em.persist(candy);
        OrderLine orderLine1 = new OrderLine(10,candy);
        em.persist(orderLine1);
        order.addOrderlines(orderLine1);
        order.calculateTotal();
        tx.commit();



        List<Person> people = em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
        people.forEach(System.out::println);

        List<Order> orders = em.createQuery("SELECT o FROM Order o", Order.class).getResultList();
        orders.forEach(System.out::println);






        em.close();
        emf.close();

    }
}
