package com.realdolmen.candyshop.entities;

import javax.persistence.*;

/**
 * Created by vdabcursist on 10/08/2017.
 */
@Entity
@Table(name = "orderline")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    @ManyToOne
    private Candy candy;

    public OrderLine(int quantity, Candy candy) {
        this.quantity = quantity;
        this.candy = candy;
    }

    public OrderLine() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Candy getCandy() {
        return candy;
    }

    public void setCandy(Candy candy) {
        this.candy = candy;
    }

    public double calculateSubTotal(){
        return quantity * candy.getPrice();
    }




    @Override
    public String toString() {
        return "OrderLine{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", candy=" + candy +
                '}';
    }
}
