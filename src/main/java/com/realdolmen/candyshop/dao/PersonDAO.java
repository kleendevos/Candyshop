package com.realdolmen.candyshop.dao;

import com.realdolmen.candyshop.entities.Person;

import java.util.List;

/**
 * Created by vdabcursist on 08/08/2017.
 */
public interface PersonDAO {

    Long createPerson (Person person);
    List<Person> findAllPeople();


}
