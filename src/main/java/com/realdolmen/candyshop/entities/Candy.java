package com.realdolmen.candyshop.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by vdabcursist on 08/08/2017.
 */
@Entity
public class Candy {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;

    @Enumerated(EnumType.STRING)
    private Candycolor candyColor;




    public Candy(String name, Candycolor candyColor, double price) {
        this.name = name;
        this.candyColor = candyColor;
        this.price = price;
    }

    public Candy() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Candycolor getCandyColor() {
        return candyColor;
    }

    public void setCandyColor(Candycolor candyColor) {
        this.candyColor = candyColor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Candy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", candyColor=" + candyColor +
                '}';
    }
}
