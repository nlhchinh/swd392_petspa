package org.petspa.petcaresystem.order.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import org.petspa.petcaresystem.appointment.model.Appointment;
import org.petspa.petcaresystem.customer.model.Customer;

@Entity
@Getter
@Setter
@Table(name = "Order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String order_id;

    @Column(name = "price")
    private float price;

    @Column(name = "order_date")
    private int order_date;

    @OneToOne(mappedBy = "appointment_id")
    private Appointment appointment_id;

    @ManyToOne
    private Customer customer_id;
}