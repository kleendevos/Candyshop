package com.realdolmen.candyshop.entities;

import com.realdolmen.candyshop.util.AgeCalculator;
import com.realdolmen.candyshop.util.Datebuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by vdabcursist on 08/08/2017.
 */

@Entity
public class Person {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false, length = 200)
    private String firstName;
    @Column (nullable = false, length = 200)
    private String lastName;
    @Temporal(TemporalType.DATE) @Column(nullable = false)
    private Date birthdate;
    @Transient
    private int age;
    @Embedded
    private Address address;






    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {
    }

    public Person(String firstName, String lastName, String birthdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = Datebuilder.createDate(birthdate);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate='" + Datebuilder.createString(birthdate) + '\'' +
                ", age='" + AgeCalculator.calculateAge(birthdate)+
                '}';
    }
}
