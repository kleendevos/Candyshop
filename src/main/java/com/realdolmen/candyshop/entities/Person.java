package com.realdolmen.candyshop.entities;

import com.realdolmen.candyshop.util.AgeCalculator;
import com.realdolmen.candyshop.util.Datebuilder;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by vdabcursist on 08/08/2017.
 */

@Entity
@NamedQuery(name = "FIND_BY_LAST_NAME", query = "select p from Person p where p.lastName = :lname")

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

    @CollectionTable
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Candycolor> candyprefence = new ArrayList<>();

    @OneToMany (mappedBy = "person")
    private List<Order>orders = new ArrayList<>();

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

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

    public Person(String firstName, String lastName, List<Candycolor> candyprefence) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.candyprefence = candyprefence;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Candycolor> getCandyprefence() {
        return candyprefence;
    }

    public void setCandyprefence(List<Candycolor> candyprefence) {
        this.candyprefence = candyprefence;
    }

    public void addCandyPreference (Candycolor color){
        this.candyprefence.add(color);
    }

    public int agecalulation (){
        age = 0;
        setAge(AgeCalculator.calculateAge(birthdate));
        return age;
    }



    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate='" + Datebuilder.createString(birthdate) + '\'' +
                ", age='" + AgeCalculator.calculateAge(birthdate) +
                '}';
    }
}
