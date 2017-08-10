package com.realdolmen.candyshop.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vdabcursist on 10/08/2017.
 */
@Entity
@Table (name = "candy_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Person person;

    @Embedded
    private Address deliveryAddress;
    @OneToMany
    @JoinColumn (name = "order_fk")
    private List<OrderLine> orderLines = new ArrayList<>();


    public Order(Person person, Address deliveryAddress) {
        this.person = person;
        this.deliveryAddress = deliveryAddress;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public void addOrderlines (OrderLine candyOrder){
        this.orderLines.add(candyOrder);
    }

    public double calculateTotal(){
        int total = 0;
        for (OrderLine l : orderLines){
            total += l.calculateSubTotal();
        } return total;


    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", person=" + person +
                ", deliveryAddress=" + deliveryAddress +
                ", orderLines=" + orderLines +
                ", Total " + calculateTotal() +
                '}';
    }

}
