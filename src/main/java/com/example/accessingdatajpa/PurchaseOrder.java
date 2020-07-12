package com.example.accessingdatajpa;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Order Amount cannot be null")
    private BigDecimal orderAmount;

    @Valid
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "purchase_order_id")
    private List<OrderDetails> orderDetails = new ArrayList<>();

    public PurchaseOrder() {
    }

    public PurchaseOrder(BigDecimal orderAmount, List<OrderDetails> orderDetailsList) {
        this.orderAmount = orderAmount;
        this.orderDetails = orderDetailsList;
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "id=" + id +
                ", orderAmount=" + orderAmount +
                ", orderDetails=" + orderDetails +
                '}';
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }


    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

}
